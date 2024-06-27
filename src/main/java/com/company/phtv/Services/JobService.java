package com.company.phtv.Services;

import com.company.phtv.Models.DTO.JobDTO;
import com.company.phtv.Models.Entity.*;
import com.company.phtv.Models.Map.JobMapping;
import com.company.phtv.Models.Request.RequestApplication;
import com.company.phtv.Models.Request.RequestIntermediaryJob;
import com.company.phtv.Models.Request.RequestJob;
import com.company.phtv.Repository.*;
import com.company.phtv.Services.IServices.IJobService;
import com.company.phtv.Utils.Variable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Instant;
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
    @Autowired
    FollowJobRepo _followJobRepo;
    @Autowired
    ViewedJobRepo _ViewedJobRepo;
    @Autowired
    AccountRepo _accountRepo;
    @Autowired
    CVRepo _cvRepo;
    @Autowired
    ApplicationRepo _applicationRepo;
    @Autowired
    UserRepo _userRepo;
    @Autowired
    AuthenticationManager _authenticationManager;

    @Autowired
    JWTService _jwtservice;

    @Override
    public List<JobDTO> getAll() {
        List<Jobs> jobs = _jobRepo.findAll();
        List<JobDTO> jobDTOS = new ArrayList<>();
        for (int i = 0; i < jobs.size(); i++) {
            if (jobs.get(i).getDeleted_at() == null) {
                jobDTOS.add(JobMapping.getJob(jobs.get(i)));
            }
        }
        return jobDTOS;
    }

    @Override
    public JobDTO getById(int id) {
        Jobs job = _jobRepo.findJobId(id);
        boolean checkJobNotFound = (job != null && job.getDeleted_at() == null) ? false : true;
        if (checkJobNotFound) {
            throw Variable.NOT_FOUND;
        }
        JobDTO jobDTO = JobMapping.getJob(job);
        return jobDTO;
    }

    public List<JobDTO> getJobsNew() {
        List<Jobs> jobs = _jobRepo.findAllByStartDateBefore(Date.from(Instant.now()));
        List<JobDTO> jobDTOS = new ArrayList<>();
        for (int i = 0; i < jobs.size(); i++) {
            if (jobs.get(i).getDeleted_at() == null && (jobs.get(i).getEnd_date()).after(Date.from(Instant.now()))) {
                jobDTOS.add(JobMapping.getJob(jobs.get(i)));
            }
        }
        return jobDTOS;
    }

    public List<JobDTO> getJobsSave() {

        List<JobDTO> jobDTOS = new ArrayList<>();
        List<FollowJob> followJobs = _followJobRepo.findJobByAccount(getAccountByAuth());
        for (int i = 0; i < followJobs.size(); i++) {
            if (followJobs.get(i).getDeleted_at() == null
                    && (followJobs.get(i).getJobs().getEnd_date()).after(Date.from(Instant.now()))) {
                jobDTOS.add(JobMapping.getJob(followJobs.get(i).getJobs()));
            }
        }
        return jobDTOS;
    }

    public List<JobDTO> getJobsViewed() {
        List<ViewedJob> viewedJobs = _ViewedJobRepo.findJobByAccount(getAccountByAuth());
        List<JobDTO> jobDTOS = new ArrayList<>();
        for (int i = 0; i < viewedJobs.size(); i++) {
            boolean checkJobDeleted = viewedJobs.get(i).getDeleted_at() != null;
            if (!checkJobDeleted) {
                jobDTOS.add(JobMapping.getJob(viewedJobs.get(i).getJobs()));
            }
        }
        return jobDTOS;
    }

    @Override
    public List<JobDTO> getJobApplicationByAccount() {
        List<Application> application = _applicationRepo.findByAccount(getAccountByAuth());
        List<JobDTO> jobDTOs = new ArrayList<>();
        for (Application a : application) {
            JobDTO jobDTO = JobMapping.getJob(a.getJobs());
            jobDTOs.add(jobDTO);
        }
        return jobDTOs;
    }

    @Override
    public JobDTO create(RequestJob requestJob) {
        Jobs job = JobMapping.jobCreate(requestJob);
        Company c = _companyRepo.findCompanyById(requestJob.getCompany_id());
        job.setCompany(c);
        Location l = _locationRepo.findIdLocation(requestJob.getLocation_id());
        job.setLocation(l);
        JobType jt = _jobTypeRepo.findIdJobType(requestJob.getJob_type_id());
        job.setJobType(jt);
        _jobRepo.save(job);
        return (JobDTO) JobMapping.getJob(job);
    }

    @Override
    public JobDTO put(int id, RequestJob requestJob) {
        Jobs getJob = _jobRepo.findJobId(id);
        boolean checkJobNotFound = (getJob != null && getJob.getDeleted_at() == null) ? false : true;
        if (checkJobNotFound) {
            throw Variable.NOT_FOUND;
        }
        Jobs job = JobMapping.jobPut(requestJob, getJob);
        if (requestJob.getCompany_id() != 0) {
            Company c = _companyRepo.findCompanyById(requestJob.getCompany_id());
            job.setCompany(c);
        }
        if (requestJob.getLocation_id() != 0) {
            Location l = _locationRepo.findIdLocation(requestJob.getLocation_id());
            job.setLocation(l);
        }
        if (requestJob.getJob_type_id() != 0) {
            JobType jt = _jobTypeRepo.findIdJobType(requestJob.getJob_type_id());
            job.setJobType(jt);
        }
        job.setId(id);
        _jobRepo.save(job);
        return (JobDTO) JobMapping.getJob(job);
    }

    @Override
    public JobDTO delete(int id) {
        Jobs job = _jobRepo.findJobId(id);
        boolean checkJobNotFound = (job != null && job.getDeleted_at() == null) ? false : true;
        if (checkJobNotFound) {
            throw Variable.NOT_FOUND;
        }
        job.setDeleted_at(new Date());
        _jobRepo.save(job);
        return null;
    }

    public Boolean postJobsSave(RequestIntermediaryJob requestIntermediaryJob) {
        Account account = _accountRepo.getAccountById(Integer.parseInt(requestIntermediaryJob.account_id));
        Jobs job = _jobRepo.findJobId(Integer.parseInt(requestIntermediaryJob.job_id));
        if (account == null || job == null) {
            return false;
        }
        _followJobRepo.save(new FollowJob(0, job, account));
        return true;
    }

    public Boolean postJobsViewed(RequestIntermediaryJob requestIntermediaryJob) {
        Account account = _accountRepo.getAccountById(Integer.parseInt(requestIntermediaryJob.account_id));
        Jobs job = _jobRepo.findJobId(Integer.parseInt(requestIntermediaryJob.job_id));
        if (account == null || job == null) {
            return false;
        }
        _ViewedJobRepo.save(new ViewedJob(0, job, account));
        return true;
    }

    public JobDTO CreatejobApplication(RequestApplication requestApplication) {
        Account account = _accountRepo.getAccountById(Integer.parseInt(requestApplication.getAccount_id()));
        Jobs job = _jobRepo.findJobId(Integer.parseInt(requestApplication.getJob_id()));
        CurriculumVitae Cv = _cvRepo.findById(Integer.parseInt(requestApplication.getCv_id())).get();
        if (account == null || job == null || Cv == null) {
            throw Variable.ACTION_FAIL;
        }
        for (int i = 0; i < account.getApplications().size(); i++) {
            boolean checkApplicated = account.getApplications().get(i).getAccount() == account
                    && account.getApplications().get(i).getJobs() == job;
            if (checkApplicated) {
                throw Variable.ACTION_FAIL;
            }
        }
        _applicationRepo.save(new Application(0, requestApplication.getNote(), account, job, Cv));
        return new JobDTO();
    }

    public Account getAccountByAuth() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (Account) auth.getPrincipal();
    }

}
