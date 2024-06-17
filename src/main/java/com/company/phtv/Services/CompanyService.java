package com.company.phtv.Services;

import com.company.phtv.Models.DTO.CompanyDTO;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Models.Map.CompanyMapping;
import com.company.phtv.Models.Request.RequestCompany;
import com.company.phtv.Repository.AccountRepo;
import com.company.phtv.Repository.CompanyRepo;
import com.company.phtv.Services.IServices.ICompanyService;
import com.company.phtv.Utils.Variable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CompanyService implements ICompanyService {
    @Autowired
    CompanyRepo _companyRepo;
    @Autowired
    AccountRepo _AccountRepo;

    @Override
    public List<CompanyDTO> getAll() {
        List<Company> companies = _companyRepo.findAll();
        List<CompanyDTO> companyDTOS = new ArrayList<>();
        for (int i = 0; i < companies.size(); i++) {
            if (companies.get(i).getDeleted_at() == null) {
                companyDTOS.add(CompanyMapping.CompanyDTO(companies.get(i)));
            }
        }
        return companyDTOS;
    }

    @Override
    public CompanyDTO create(RequestCompany requestCompany) {
        Company company = CompanyMapping.Company(requestCompany);
        Account a = _AccountRepo.findById(requestCompany.getAccount_id()).get();
        if (a == null) {
            throw Variable.AccountNotFound;
        }
        for (Company c : a.getCompanies()) {
            // check list company of account is deleted
            if (c.getDeleted_at() != null) {
                throw Variable.CompanyOfAccountIsExist;
            }
        }
        company.setAccount(a);
        _companyRepo.save(company);
        return (CompanyDTO) CompanyMapping.CompanyDTO(company);
    }

    @Override
    public CompanyDTO put(int id, RequestCompany requestCompany) {
        return null;
    }

    @Override
    public CompanyDTO getById(int id) {
        Company company = _companyRepo.findCompanyById(id);
        boolean checkCompanyNotFound = (company != null && company.getDeleted_at() == null) ? false : true;
        if (checkCompanyNotFound) {
            throw Variable.notFound;
        }
        CompanyDTO companyDTO = CompanyMapping.CompanyDTO(company);
        return companyDTO;
    }

    @Override
    public CompanyDTO delete(int id) {
        Company company = _companyRepo.findCompanyById(id);
        boolean checkCompanyNotFound = (company != null && company.getDeleted_at() == null) ? false : true;
        if (checkCompanyNotFound) {
            throw Variable.notFound;
        }
        company.setDeleted_at(new Date());
        _companyRepo.save(company);
        return null;
    }

    @Override
    public List<CompanyDTO> companyContractAll() {
        List<Company> companies = _companyRepo.findAll();
        List<CompanyDTO> companyDTOS = new ArrayList<>();
        for (int i = 0; i < companies.size(); i++) {
            boolean checkDeleted = companies.get(i).getDeleted_at() != null;
            boolean checkContract = companies.get(i).getContract() == 1;
            if (!checkDeleted && checkContract) {
                companyDTOS.add(CompanyMapping.CompanyDTO(companies.get(i)));
            }
        }
        return companyDTOS;
    }
}
