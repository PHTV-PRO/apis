package com.company.phtv.Services.IServices;

import com.company.phtv.Models.DTO.CompanyDTO;
import com.company.phtv.Models.Request.RequestCompany;

import java.util.List;

public interface ICompanyService {
    List<CompanyDTO> GetAll();
    CompanyDTO Create(RequestCompany requestCompany);
    CompanyDTO Put(int id,RequestCompany requestCompany);
    CompanyDTO GetById(int id);
    CompanyDTO Delete(int id);
}
