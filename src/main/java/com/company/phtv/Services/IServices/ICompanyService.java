package com.company.phtv.Services.IServices;

import com.company.phtv.Models.DTO.CompanyDTO;
import com.company.phtv.Models.Request.RequestCompany;
import com.company.phtv.Models.Request.RequestSearchCompany;

import java.util.List;

public interface ICompanyService {
    List<CompanyDTO> getAll(int size, int page);

    CompanyDTO create(RequestCompany requestCompany);

    CompanyDTO put(int id, RequestCompany requestCompany);

    CompanyDTO getById(int id);

    CompanyDTO delete(int id);

    List<CompanyDTO> companyContractAll(int size, int page);
    List<CompanyDTO> CompanyByProvenceAndIndustry(RequestSearchCompany requestSearchCompany,int size, int page);

}
