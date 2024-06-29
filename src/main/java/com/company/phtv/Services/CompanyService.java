package com.company.phtv.Services;

import com.company.phtv.Models.DTO.CompanyDTO;
import com.company.phtv.Models.DTO.LocationDTO;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Models.Entity.FollowCompany;
import com.company.phtv.Models.Entity.Jobs;
import com.company.phtv.Models.Entity.Location;
import com.company.phtv.Models.Map.CompanyMapping;
import com.company.phtv.Models.Map.LocationMapping;
import com.company.phtv.Models.Request.RequestCompany;
import com.company.phtv.Models.Request.RequestFollowCompany;
import com.company.phtv.Repository.AccountRepo;
import com.company.phtv.Repository.CompanyRepo;
import com.company.phtv.Repository.FollowCompanyRepo;
import com.company.phtv.Services.IServices.ICompanyService;
import com.company.phtv.Utils.Variable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

@Service
public class CompanyService implements ICompanyService {
    @Autowired
    CompanyRepo _companyRepo;
    @Autowired
    AccountRepo _accountRepo;
    @Autowired
    CloudinaryService _cloudinaryService;
    @Autowired
    FollowCompanyRepo _followCompanyRepo;

    public Account getAccount() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Account account = (Account) auth.getPrincipal();
        return _accountRepo.findIdAccount(account.getId());
    }

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
        Account a = _accountRepo.findById(requestCompany.getAccount_id()).get();
        if (a == null || a.getDeleted_at() != null) {
            throw Variable.ACCOUNT_NOT_FOUND;
        }
        for (Company c : a.getCompanies()) {
            // check list company of account is deleted
            if (c.getDeleted_at() != null) {
                throw Variable.COMPANY_ACCOUNT_EXISTING;
            }
        }
        company.setAccount(a);
        if (requestCompany.UploadFileBackground != null) {
            try {
                // create image in cloudinary
                @SuppressWarnings("rawtypes")
                Map check = _cloudinaryService.uploadImage(requestCompany.UploadFileBackground,
                        company.getBackground_image());
                company.setBackground_image(Variable.PATH_IMAGE + check.get("public_id").toString());
            } catch (IOException e) {
                throw Variable.ADD_IMAGE_FAIL;
            }
        }
        if (requestCompany.UploadFileLogo != null) {
            try {
                // create image in cloudinary
                @SuppressWarnings("rawtypes")
                Map check = _cloudinaryService.uploadImage(requestCompany.UploadFileLogo, company.getLogo_image());
                company.setLogo_image(Variable.PATH_IMAGE + check.get("public_id").toString());
            } catch (IOException e) {
                throw Variable.ADD_IMAGE_FAIL;
            }
        }
        _companyRepo.save(company);
        return (CompanyDTO) CompanyMapping.CompanyDTO(company);
    }

    @Override
    public CompanyDTO put(int id, RequestCompany requestCompany) {
        Company getCompany = _companyRepo.findCompanyById(id);
        boolean checkCompanyNotFound = (getCompany != null && getCompany.getDeleted_at() == null) ? false : true;
        if (checkCompanyNotFound) {
            throw Variable.NOT_FOUND;
        }
        if (requestCompany.UploadFileBackground != null) {
            try {
                // create image in cloudinary
                @SuppressWarnings("rawtypes")
                Map check = _cloudinaryService.uploadImage(requestCompany.UploadFileBackground,
                        getCompany.getBackground_image());
                getCompany.setBackground_image(Variable.PATH_IMAGE + check.get("public_id").toString());
            } catch (IOException e) {
                throw Variable.ADD_IMAGE_FAIL;
            }
        }
        if (requestCompany.UploadFileLogo != null) {
            try {
                // create image in cloudinary
                @SuppressWarnings("rawtypes")
                Map check = _cloudinaryService.uploadImage(requestCompany.UploadFileLogo, getCompany.getLogo_image());
                getCompany.setLogo_image(Variable.PATH_IMAGE + check.get("public_id").toString());
            } catch (IOException e) {
                throw Variable.ADD_IMAGE_FAIL;
            }
        }
        Company company = CompanyMapping.CompanyPut(requestCompany, getCompany);
        if (requestCompany.getAccount_id() != 0) {
            company.setAccount(_accountRepo.getAccountById(requestCompany.getAccount_id()));
        }
        company.setId(id);
        _companyRepo.save(company);
        return (CompanyDTO) CompanyMapping.CompanyDTO(company);
    }

    @Override
    public CompanyDTO getById(int id) {
        Company company = _companyRepo.findCompanyById(id);
        boolean checkCompanyNotFound = (company != null && company.getDeleted_at() == null) ? false : true;
        if (checkCompanyNotFound) {
            throw Variable.NOT_FOUND;
        }
        CompanyDTO companyDTO = CompanyMapping.CompanyDTO(company);
        List<LocationDTO> locationDTO = new ArrayList<>();
        for (Location l : company.getLocations()) {
            locationDTO.add(LocationMapping.LocationDTO(l));
        }
        companyDTO.setLocations(locationDTO);
        return companyDTO;
    }

    @Override
    public CompanyDTO delete(int id) {
        Company company = _companyRepo.findCompanyById(id);
        boolean checkCompanyNotFound = (company != null && company.getDeleted_at() == null) ? false : true;
        if (checkCompanyNotFound) {
            throw Variable.NOT_FOUND;
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

    public List<CompanyDTO> companyApplicationMost() {
        List<Company> companies = _companyRepo.findAll();
        List<CompanyDTO> companyDTOS = new ArrayList<>();
        if (companies.size() > 5) {
            HashMap<Company, Integer> companiesWithCounts = new HashMap<Company, Integer>();
            for (int i = 0; i < companies.size(); i++) {
                int count = 0;
                boolean checkCompanyDeleted = companies.get(i).getDeleted_at() != null;
                if (!checkCompanyDeleted) {
                    for (Jobs job : companies.get(i).getJobs()) {
                        boolean checkJobDeleted = job.getDeleted_at() != null;
                        if (!checkJobDeleted) {
                            count += job.getApplications().size();
                        }
                    }
                    if (count != 0) {
                        companiesWithCounts.put(companies.get(i), count);
                    }
                }

            }
            if (companiesWithCounts.size() > 5) {
                PriorityQueue<Map.Entry<Company, Integer>> pq = new PriorityQueue<>(
                        (e1, e2) -> e2.getValue() - e1.getValue());
                pq.addAll(companiesWithCounts.entrySet());
                if (pq.size() > 5) {
                    pq.poll();
                }
                while (!pq.isEmpty() && companyDTOS.size() < 5) {
                    Map.Entry<Company, Integer> entry = pq.poll();
                    Company company = entry.getKey();
                    companyDTOS.add(CompanyMapping.CompanyDTO(company));
                }
                return companyDTOS;
            }
        }

        for (Company cpn : companies) {
            companyDTOS.add(CompanyMapping.CompanyDTO(cpn));
        }
        return companyDTOS;

    }

    public CompanyDTO followCompany(RequestFollowCompany requestCompany) {
        Account account = getAccount();
        Company company = _companyRepo.findCompanyById(Integer.parseInt(requestCompany.getCompany_id()));
        if (account == null || company == null) {
            throw Variable.ACTION_FAIL;
        }
        _followCompanyRepo.save(new FollowCompany(0, company, account));
        return new CompanyDTO();
    }
}
