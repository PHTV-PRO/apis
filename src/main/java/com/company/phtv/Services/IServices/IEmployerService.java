package com.company.phtv.Services.IServices;

import com.company.phtv.Models.DTO.EmployerDTO;
import com.company.phtv.Models.Request.RequestEmployer;

import java.util.List;

public interface IEmployerService {
    List<EmployerDTO> getAll();

    EmployerDTO create(RequestEmployer requestEmployer);

    EmployerDTO put(int id, RequestEmployer requestEmployer);

    EmployerDTO delete(int id);

    EmployerDTO getById(int id);
}
