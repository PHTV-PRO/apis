package com.company.phtv.Services.IServices;

import com.company.phtv.Models.DTO.JobDTO;
import com.company.phtv.Models.Request.RequestApplication;
import com.company.phtv.Models.Request.RequestJob;

import java.util.List;

public interface IJobService {
    List<JobDTO> getAll();

    JobDTO create(RequestJob requestJob);

    JobDTO put(int id, RequestJob requestJob);

    JobDTO getById(int id);

    JobDTO delete(int id);

    List<JobDTO> getJobsNew();

    List<JobDTO> getJobsSave(String id);

    List<JobDTO> getJobsViewed(String id);

    List<JobDTO> getJobApplicationByAccount(int id);

    JobDTO CreatejobApplication(RequestApplication requestApplication);

}
