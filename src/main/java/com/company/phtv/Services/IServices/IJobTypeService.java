package com.company.phtv.Services.IServices;


import com.company.phtv.Models.DTO.JobTypeDTO;
import com.company.phtv.Models.Request.RequestJobType;

import java.util.List;

public interface IJobTypeService {
    List<JobTypeDTO> GetAll();
    JobTypeDTO Create(RequestJobType requestJobType);
    JobTypeDTO Put(int id, RequestJobType requestJobType);

    JobTypeDTO Delete(int id);
    JobTypeDTO GetById(int id);
}
