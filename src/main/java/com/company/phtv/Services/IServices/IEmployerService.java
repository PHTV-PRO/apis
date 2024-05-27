package com.company.phtv.Services.IServices;

import com.company.phtv.Models.DTO.EmployerDTO;
import com.company.phtv.Models.Request.RequestEmployer;

import java.util.List;

public interface IEmployerService {
    List<EmployerDTO> GetAll();
    EmployerDTO Create(RequestEmployer requestEmployer);
    EmployerDTO Put(int id, RequestEmployer requestEmployer);
    EmployerDTO Delete(int id);
    EmployerDTO GetById(int id);
}
