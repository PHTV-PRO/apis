package com.company.phtv.Services.IServices;

import com.company.phtv.Models.DTO.CompanyDTO;
import com.company.phtv.Models.DTO.JobDTO;
import com.company.phtv.Models.Request.RequestCompany;
import com.company.phtv.Models.Request.RequestJob;

import java.util.List;

public interface IJobService {
    List<JobDTO> GetAll();
    JobDTO Create(RequestJob requestJob);
    JobDTO Put(int id,RequestJob requestJob);
    JobDTO GetById(int id);
    JobDTO Delete(int id);
}
