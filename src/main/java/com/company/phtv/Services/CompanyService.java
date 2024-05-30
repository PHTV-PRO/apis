package com.company.phtv.Services;

import com.company.phtv.Models.DTO.CompanyDTO;
import com.company.phtv.Models.DTO.EmployerDTO;
import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Models.Entity.Employer;
import com.company.phtv.Models.Map.CompanyMapping;
import com.company.phtv.Models.Request.RequestCompany;
import com.company.phtv.Repository.CompanyRepo;
import com.company.phtv.Repository.EmployerRepo;
import com.company.phtv.Services.IServices.ICompanyService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService implements ICompanyService {
    @Autowired
    CompanyRepo _companyRepo;
    @Autowired
    EmployerRepo _employerRepo;
    @Override
    public List<CompanyDTO> GetAll() {
        List<Company> companies = _companyRepo.findAll();
        List<CompanyDTO> companyDTOS = new ArrayList<>();
        if (companies.size() < 1) {
            throw new HttpException(404,"Not Found");
        }
        for (Company c : companies) {
            companyDTOS.add(CompanyMapping.CompanyDTO(c));
        }
        return companyDTOS;
    }

    @Override
    public CompanyDTO Create(RequestCompany requestCompany) {
        Company company = CompanyMapping.Company(requestCompany);
        Employer e = _employerRepo.getOne(requestCompany.getEmployer_id());
        company.setEmployer(e);
        _companyRepo.save(company);
        return (CompanyDTO) CompanyMapping.CompanyDTO(company);
    }

    @Override
    public CompanyDTO Put(int id, RequestCompany requestCompany) {
        return null;
    }

    @Override
    public CompanyDTO GetById(int id) {
        Company company = _companyRepo.findCompanyById(id);
        CompanyDTO companyDTO = CompanyMapping.CompanyDTO(company);
        return companyDTO;
    }

    @Override
    public CompanyDTO Delete(int id) {
        _companyRepo.deleteById(id);
        return null;
    }
}
