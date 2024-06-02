package com.company.phtv.Services;

import com.company.phtv.Models.DTO.IndustryDTO;
import com.company.phtv.Models.DTO.JobTypeDTO;
import com.company.phtv.Models.Entity.Industry;
import com.company.phtv.Models.Entity.JobType;
import com.company.phtv.Models.Map.IndustryMapping;
import com.company.phtv.Models.Map.JobTypeMapping;
import com.company.phtv.Models.Request.RequestJobType;
import com.company.phtv.Repository.IndustryRepo;
import com.company.phtv.Repository.JobRepo;
import com.company.phtv.Repository.JobTypeRepo;
import com.company.phtv.Services.IServices.IJobTypeService;
import com.company.phtv.Utils.HttpException;
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
    public List<JobTypeDTO> GetAll() {
        List<JobType> jobTypes = _jobTypeRepo.findAll();
        List<JobTypeDTO> jobTypeDTOS = new ArrayList<>();
        if (jobTypes.size() < 1) {
            throw new HttpException(404, "Not Found");
        }
        for (JobType j : jobTypes) {
            jobTypeDTOS.add(JobTypeMapping.jobTypeDTO(j));
        }
        return jobTypeDTOS;
    }

    @Override
    public JobTypeDTO Create(RequestJobType requestJobType) {
        JobType jobType = JobTypeMapping.JobType(requestJobType);
        _jobTypeRepo.save(jobType);
        return (JobTypeDTO) JobTypeMapping.jobTypeDTO(jobType);
    }

    @Override
    public JobTypeDTO Put(int id, RequestJobType requestJobType) {
        JobType getJobType = _jobTypeRepo.findIdJobType(id);
        JobType jobType = JobTypeMapping.JobTypePut(requestJobType, getJobType);
        jobType.setId(id);
        _jobTypeRepo.save(jobType);
        return (JobTypeDTO) JobTypeMapping.jobTypeDTO(jobType);
    }

    @Override
    public JobTypeDTO Delete(int id) {
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
    public JobTypeDTO GetById(int id) {
        JobType jobType = _jobTypeRepo.findIdJobType(id);
        JobTypeDTO jobTypeDTO = JobTypeMapping.jobTypeDTO(jobType);
        return jobTypeDTO;
    }
}
