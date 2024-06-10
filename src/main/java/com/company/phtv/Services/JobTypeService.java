package com.company.phtv.Services;

import com.company.phtv.Models.DTO.JobTypeDTO;
import com.company.phtv.Models.Entity.JobType;
import com.company.phtv.Models.Map.JobTypeMapping;
import com.company.phtv.Models.Request.RequestJobType;
import com.company.phtv.Repository.JobTypeRepo;
import com.company.phtv.Services.IServices.IJobTypeService;
import com.company.phtv.Utils.Variable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class JobTypeService implements IJobTypeService {
    @Autowired
    JobTypeRepo _jobTypeRepo;

    @Override
    public List<JobTypeDTO> getAll() {
        List<JobType> jobTypes = _jobTypeRepo.findAll();
        List<JobTypeDTO> jobTypeDTOS = new ArrayList<>();
        for (int i = 0; i < jobTypes.size(); i++) {
            if (jobTypes.get(i).getDeleted_at() == null) {
                jobTypeDTOS.add(JobTypeMapping.jobTypeDTO(jobTypes.get(i)));
            }
        }
        return jobTypeDTOS;
    }

    @Override
    public JobTypeDTO create(RequestJobType requestJobType) {
        JobType jobType = JobTypeMapping.JobType(requestJobType);
        _jobTypeRepo.save(jobType);
        return (JobTypeDTO) JobTypeMapping.jobTypeDTO(jobType);
    }

    @Override
    public JobTypeDTO put(int id, RequestJobType requestJobType) {
        JobType getJobType = _jobTypeRepo.findIdJobType(id);
        boolean checkJobTypeNotFound = (getJobType != null && getJobType.getDeleted_at() == null) ? false : true;
        if (checkJobTypeNotFound) {
            throw Variable.notFound;
        }
        JobType jobType = JobTypeMapping.JobTypePut(requestJobType, getJobType);
        jobType.setId(id);
        _jobTypeRepo.save(jobType);
        return (JobTypeDTO) JobTypeMapping.jobTypeDTO(jobType);
    }

    @Override
    public JobTypeDTO delete(int id) {
        JobType jobType = _jobTypeRepo.findIdJobType(id);
        boolean checkJobTypeNotFound = (jobType != null && jobType.getDeleted_at() == null) ? false : true;
        if (checkJobTypeNotFound) {
            throw Variable.notFound;
        }
        jobType.setDeleted_at(new Date());
        _jobTypeRepo.save(jobType);
        return null;
    }

    @Override
    public JobTypeDTO getById(int id) {
        JobType jobType = _jobTypeRepo.findIdJobType(id);
        boolean checkJobTypeNotFound = (jobType != null && jobType.getDeleted_at() == null) ? false : true;
        if (checkJobTypeNotFound) {
            throw Variable.notFound;
        }
        JobTypeDTO jobTypeDTO = JobTypeMapping.jobTypeDTO(jobType);
        return jobTypeDTO;
    }
}
