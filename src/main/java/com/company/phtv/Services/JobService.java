package com.company.phtv.Services;

import com.company.phtv.Models.DTO.JobDTO;
import com.company.phtv.Models.Entity.*;
import com.company.phtv.Models.Map.JobMapping;
import com.company.phtv.Models.Request.RequestJob;
import com.company.phtv.Repository.*;
import com.company.phtv.Services.IServices.IJobService;
import com.company.phtv.Utils.HttpException;
import com.company.phtv.Utils.Variable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class JobService implements IJobService {
    @Autowired
    JobRepo _jobRepo;
    @Autowired
    CompanyRepo _companyRepo;
    @Autowired
    LocationRepo _locationRepo;
    @Autowired
    JobTypeRepo _jobTypeRepo;

    @Override
    public List<JobDTO> getAll() {
        List<Jobs> jobs = _jobRepo.findAll();
        List<JobDTO> jobDTOS = new ArrayList<>();
        if (jobs.size() < 1) {
            throw new HttpException(404, "Not Found");
        }
        for (int i = 0; i < jobs.size(); i++) {
            if (jobs.get(i).getDeleted_at() == null) {
                jobDTOS.add(JobMapping.getJob(jobs.get(i)));
            }
        }
        return jobDTOS;
    }

    @Override
    public JobDTO create(RequestJob requestJob) {
        Jobs job = JobMapping.jobCreate(requestJob);
        Company c = _companyRepo.findCompanyById(requestJob.getCompany_id());
        job.setCompany(c);
        @SuppressWarnings("deprecation")
        Location l = _locationRepo.getOne(requestJob.getLocation_id());
        job.setLocation(l);
        JobType jt = _jobTypeRepo.findIdJobType(requestJob.getJobType_id());
        job.setJobType(jt);
        _jobRepo.save(job);
        return (JobDTO) JobMapping.getJob(job);
    }

    @Override
    public JobDTO put(int id, RequestJob requestJob) {
        Jobs getJob = _jobRepo.findJobId(id);
        boolean checkJobNotFound = (getJob != null && getJob.getDeleted_at() == null) ? false : true;
        if (checkJobNotFound) {
            throw Variable.notFound;
        }
        Jobs job = JobMapping.jobPut(requestJob, getJob);
        if (requestJob.getCompany_id() != 0) {
            Company c = _companyRepo.findCompanyById(requestJob.getCompany_id());
            job.setCompany(c);
        }
        if (requestJob.getLocation_id() != 0) {
            @SuppressWarnings("deprecation")
            Location l = _locationRepo.getOne(requestJob.getLocation_id());
            job.setLocation(l);
        }
        if (requestJob.getJobType_id() != 0) {
            JobType jt = _jobTypeRepo.findIdJobType(requestJob.getJobType_id());
            job.setJobType(jt);
        }
        job.setId(id);
        _jobRepo.save(job);
        return (JobDTO) JobMapping.getJob(job);
    }

    @Override
    public JobDTO getById(int id) {
        Jobs job = _jobRepo.findJobId(id);
        boolean checkJobNotFound = (job != null && job.getDeleted_at() == null) ? false : true;
        if (checkJobNotFound) {
            throw Variable.notFound;
        }
        JobDTO jobDTO = JobMapping.getJob(job);
        return jobDTO;
    }

    @Override
    public JobDTO delete(int id) {
        Jobs job = _jobRepo.findJobId(id);
        boolean checkJobNotFound = (job != null && job.getDeleted_at() == null) ? false : true;
        if (checkJobNotFound) {
            throw Variable.notFound;
        }
        job.setDeleted_at(new Date());
        _jobRepo.save(job);
        return null;
    }
}
