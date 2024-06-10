package com.company.phtv.Services.IServices;

import com.company.phtv.Models.DTO.JobDTO;
import com.company.phtv.Models.Request.RequestJob;

import java.util.List;

public interface IJobService {
    List<JobDTO> getAll();

    JobDTO create(RequestJob requestJob);

    JobDTO put(int id, RequestJob requestJob);

    JobDTO getById(int id);

    JobDTO delete(int id);
}
