package com.company.phtv.Services.IServices;

import com.company.phtv.Models.DTO.CompanyDTO;
import com.company.phtv.Models.Request.RequestCompany;

import java.util.List;

public interface ICompanyService {
    List<CompanyDTO> getAll();

    CompanyDTO create(RequestCompany requestCompany);

    CompanyDTO put(int id, RequestCompany requestCompany);

    CompanyDTO getById(int id);

    CompanyDTO delete(int id);
}
