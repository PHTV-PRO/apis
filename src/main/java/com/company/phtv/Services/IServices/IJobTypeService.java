package com.company.phtv.Services.IServices;

import com.company.phtv.Models.DTO.JobTypeDTO;
import com.company.phtv.Models.Request.RequestJobType;

import java.util.List;

public interface IJobTypeService {
    List<JobTypeDTO> getAll();

    JobTypeDTO create(RequestJobType requestJobType);

    JobTypeDTO put(int id, RequestJobType requestJobType);

    JobTypeDTO delete(int id);

    JobTypeDTO getById(int id);
}
