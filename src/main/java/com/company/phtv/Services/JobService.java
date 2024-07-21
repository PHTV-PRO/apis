package com.company.phtv.Services;

import com.company.phtv.Models.DTO.JobDTO;
import com.company.phtv.Models.DTO.LevelDTO;
import com.company.phtv.Models.DTO.SkillDTO;
import com.company.phtv.Models.Entity.*;
import com.company.phtv.Models.Map.JobMapping;
import com.company.phtv.Models.Map.LevelMapping;
import com.company.phtv.Models.Map.SkillMapping;
import com.company.phtv.Models.Request.RequestApplication;
import com.company.phtv.Models.Request.RequestIntermediaryJob;
import com.company.phtv.Models.Request.RequestJob;
import com.company.phtv.Repository.*;
import com.company.phtv.Services.IServices.IJobService;
import com.company.phtv.Utils.CurrentAccount;
import com.company.phtv.Utils.Variable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    SkillRepo _skillRepo;
    @Autowired
    SkillJobRepo _skillJobRepo;
    @Autowired
    LevelRepo _levelRepo;
    @Autowired
    LevelJobRepo _levelJobRepo;
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
    CurrentAccount _currentAccount;

    @Autowired
    JWTService _jwtservice;

    @Override
    public List<JobDTO> getAll(Long lotId, Long indId) {
        List<Jobs> jobs = _jobRepo.getAllJob(lotId, indId);
        List<JobDTO> jobDTOS = new ArrayList<>();
        for (int i = 0; i < jobs.size(); i++) {
            if (jobs.get(i).getDeleted_at() == null) {
                JobDTO jobDTO = JobMapping.getJob(jobs.get(i));
                jobDTO = setAppliedAndSaved(jobs.get(i), jobDTO);
                jobDTO = setSkill_level(jobs.get(i), jobDTO);
                jobDTOS.add(jobDTO);

            }
        }
        return jobDTOS;
    }

    @Override
    public JobDTO getById(int id) {
        Jobs job = _jobRepo.findJobId(id);
        boolean checkJobNotFound = (job != null || job.getDeleted_at() == null) ? false : true;
        if (checkJobNotFound) {
            throw Variable.NOT_FOUND;
        }
        JobDTO jobDTO = JobMapping.getJob(job);
        jobDTO = setAppliedAndSaved(job, jobDTO);
        jobDTO = setSkill_level(job, jobDTO);
        return jobDTO;
    }

    public List<JobDTO> getJobsNew() {
        Account account = _currentAccount.getAccount();
        if (account != null) {
            List<Jobs> jobs = _jobRepo.findAllByStartDateBefore(Date.from(Instant.now()));
            List<JobDTO> jobDTOS = new ArrayList<>();
            for (int i = 0; i < jobs.size(); i++) {
                if (jobs.get(i).getDeleted_at() == null
                        && (jobs.get(i).getEnd_date()).after(Date.from(Instant.now()))) {
                    JobDTO jobDTO = JobMapping.getJob(jobs.get(i));
                    jobDTO = setAppliedAndSaved(jobs.get(i), jobDTO);
                    jobDTO = setSkill_level(jobs.get(i), jobDTO);
                    jobDTOS.add(jobDTO);

                }
            }
            return jobDTOS;
        }

        List<Jobs> jobs = _jobRepo.findAllByStartDateBefore(Date.from(Instant.now()));
        List<JobDTO> jobDTOS = new ArrayList<>();
        for (int i = 0; i < jobs.size(); i++) {
            if (jobs.get(i).getDeleted_at() == null && (jobs.get(i).getEnd_date()).after(Date.from(Instant.now()))) {
                JobDTO jobDTO = JobMapping.getJob(jobs.get(i));
                jobDTO = setSkill_level(jobs.get(i), jobDTO);
                jobDTOS.add(jobDTO);
            }

        }
        return jobDTOS;
    }

    public List<JobDTO> getJobsHot() {
        List<JobDTO> jobDTOs = new ArrayList<>();
        Account account = _currentAccount.getAccount();
        if (account == null) {
            // not sign in
            List<Jobs> jobs = _jobRepo.findAllByStartDateBefore(Date.from(Instant.now()));
            List<Jobs> job = (List<Jobs>) jobs.stream().limit(5).collect(Collectors.toList());
            for (Jobs j : job) {
                JobDTO jobDTO = JobMapping.getJob(j);
                jobDTO = setSkill_level(j, jobDTO);
                jobDTOs.add(jobDTO);
            }
            return jobDTOs;
        }
        ViewedJob viewedJobs = _ViewedJobRepo.findJobByAccount(_currentAccount.getAccount()).get(0);
        List<Skill> skills = new ArrayList<>();
        for (SkillJob skillJob : viewedJobs.getJobs().getSkillJobs()) {
            // get list skill job nearest viewed
            if (!skills.contains(skillJob.getSkills())) {
                skills.add(skillJob.getSkills());
            }
        }
        List<Jobs> listJob = new ArrayList<>();
        for (Skill s : skills) {
            for (SkillJob sj : s.getSkillJobs()) {
                // add job
                Jobs j = sj.getJobs();
                listJob.add(j);
            }
        }
        for (Jobs j : listJob) {
            // map dto and check saved, aplication,
            JobDTO jobDTO = JobMapping.getJob(j);
            jobDTO = setAppliedAndSaved(j, jobDTO);
            boolean checkDate = (j.getStart_date()).before(Date.from(Instant.now()))
                    && (j.getEnd_date()).after(Date.from(Instant.now()));
            boolean checkSizeJob = jobDTOs.size() <= 30;
            if (!checkSizeJob) {
                break;
            }
            if (checkDate && checkSizeJob) {
                // add skill and level detail job
                jobDTO = setSkill_level(j, jobDTO);
                jobDTOs.add(jobDTO);
            }
        }

        return jobDTOs;
    }

    public List<JobDTO> getJobsSave() {
        Account account = _currentAccount.getAccount();
        if (account == null) {
            throw Variable.ACTION_FAIL;
        }
        List<JobDTO> jobDTOS = new ArrayList<>();
        List<FollowJob> followJobs = _followJobRepo.findJobByAccount(account);
        int sizeJob = followJobs.size() > 6 ? 6 : followJobs.size();
        for (int i = 0; i < sizeJob; i++) {
            if (followJobs.get(i).getDeleted_at() == null) {
                JobDTO jobDTO = JobMapping.getJob(followJobs.get(i).getJobs());
                jobDTO = setAppliedAndSaved(followJobs.get(i).getJobs(), jobDTO);
                jobDTO = setSkill_level(followJobs.get(i).getJobs(), jobDTO);
                jobDTOS.add(jobDTO);
            }
        }
        return jobDTOS;
    }

    public List<JobDTO> getJobsViewed() {
        Account account = _currentAccount.getAccount();
        if (account == null) {
            throw Variable.ACTION_FAIL;
        }
        List<ViewedJob> viewedJobs = _ViewedJobRepo.findJobByAccount(_currentAccount.getAccount());
        List<JobDTO> jobDTOS = new ArrayList<>();
        for (int i = 0; i < viewedJobs.size(); i++) {
            boolean checkJobDeleted = viewedJobs.get(i).getDeleted_at() != null;
            if (!checkJobDeleted) {
                JobDTO jobDTO = JobMapping.getJob(viewedJobs.get(i).getJobs());
                jobDTO = setAppliedAndSaved(viewedJobs.get(i).getJobs(), jobDTO);
                jobDTO = setSkill_level(viewedJobs.get(i).getJobs(), jobDTO);
                jobDTOS.add(jobDTO);
            }
        }
        return jobDTOS;
    }

    @Override
    public List<JobDTO> getJobApplicationByAccount() {
        Account account = _currentAccount.getAccount();
        if (account == null) {
            throw Variable.ACTION_FAIL;
        }
        List<Application> application = _applicationRepo.findByAccount(account);
        List<JobDTO> jobDTOs = new ArrayList<>();
        for (Application a : application) {
            JobDTO jobDTO = JobMapping.getJob(a.getJobs());
            jobDTO = setAppliedAndSaved(a.getJobs(), jobDTO);
            jobDTO = setSkill_level(a.getJobs(), jobDTO);
            jobDTOs.add(jobDTO);
        }
        return jobDTOs;
    }

    @Override
    public JobDTO create(RequestJob requestJob) {

        Jobs job = JobMapping.jobCreate(requestJob);

        Company c = _companyRepo.findCompanyById(requestJob.getCompany_id());
        boolean checkSubcritionplanExist = false;
        for (SubcriptionPlanCompany sp : c.getSubcritionPlanCompanies()) {
            if (sp.getDeleted_at() != null) {
                continue;
            }
            boolean checkDate = sp.getStart_date().before(new Date()) && sp.getEnd_date().after(new Date());
            if (!checkDate) {
                continue;
            }
            if (checkDate) {
                checkSubcritionplanExist = true;
            }
            boolean checkCountJob = sp.getSubscription_plan().getExpiry() <= c.getCount_job();
            if (checkCountJob) {
                throw Variable.LIMIT_JOB;
            }
        }
        if (checkSubcritionplanExist == false) {
            throw Variable.SUBCRIPTION_PLAN_NOT_FOUND;
        }

        job.setCompany(c);
        Location location = new Location();
        for (Location l : c.getLocations()) {
            if (l.getDeleted_at() == null) {
                location = l;
            }
        }
        job.setLocation(location);
        JobType jt = _jobTypeRepo.findIdJobType(requestJob.getJob_type_id());
        job.setJobType(jt);
        _jobRepo.save(job);
        if (requestJob.getSkill_id() != "") {
            String[] skillId = requestJob.getSkill_id().split(",");
            for (String i : skillId) {
                Skill s = _skillRepo.findById(Integer.parseInt(i)).get();
                SkillJob skillJob = new SkillJob(s, job);
                _skillJobRepo.save(skillJob);
            }
        }
        if (requestJob.getLevel_id() != "") {
            String[] levelId = requestJob.getLevel_id().split(",");
            for (String i : levelId) {
                Level l = _levelRepo.findById(Integer.parseInt(i)).get();
                LevelJob levelJob = new LevelJob(l, job);
                _levelJobRepo.save(levelJob);
            }
        }
        c.setCount_job(c.getCount_job() + 1);
        _companyRepo.save(c);
        return (JobDTO) JobMapping.getJob(job);
    }

    @Override
    public JobDTO put(int id, RequestJob requestJob) {
        Jobs getJob = _jobRepo.findJobId(id);
        boolean checkJobNotFound = (getJob != null && getJob.getDeleted_at() == null) ? false : true;
        if (checkJobNotFound) {
            throw Variable.NOT_FOUND;
        }

        if (requestJob.getLevel_id() != null) {
            if (requestJob.getLevel_id() != "") {
                String[] levelId = requestJob.getLevel_id().split(",");
                for (String i : levelId) {
                    int idLevel = Integer.parseInt(i);
                    Level l = _levelRepo.findById(idLevel).get();
                    boolean checkExist = _levelJobRepo.findByJobAndLevel(getJob, l) != null;
                    if (checkExist) {
                        continue;
                    }
                    LevelJob levelJob = new LevelJob(l, getJob);
                    _levelJobRepo.save(levelJob);
                }
            }
        }
        if (requestJob.getSkill_id() != null) {
            if (requestJob.getSkill_id() != "") {
                String[] skillId = requestJob.getSkill_id().split(",");
                for (String i : skillId) {
                    int idLevel = Integer.parseInt(i);
                    Skill s = _skillRepo.findById(idLevel).get();
                    boolean checkExist = _skillJobRepo.findByJobAndSkill(getJob, s) != null;
                    if (checkExist) {
                        continue;
                    }
                    SkillJob skillJob = new SkillJob(s, getJob);
                    _skillJobRepo.save(skillJob);
                }
            }
        }

        Jobs job = JobMapping.jobPut(requestJob, getJob);
        if (requestJob.getCompany_id() != 0) {
            Company c = _companyRepo.findCompanyById(requestJob.getCompany_id());
            job.setCompany(c);
            for (Location l : c.getLocations()) {
                if (l.getDeleted_at() == null) {
                    job.setLocation(l);
                }
            }

            if (requestJob.getJob_type_id() != 0) {
                JobType jt = _jobTypeRepo.findIdJobType(requestJob.getJob_type_id());
                job.setJobType(jt);
            }
            job.setId(id);
            _jobRepo.save(job);
        }
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
        Account account = _currentAccount.getAccount();
        Jobs job = _jobRepo.findJobId(Integer.parseInt(requestIntermediaryJob.job_id));
        if (account == null || job == null) {
            return false;
        }
        FollowJob followJob = _followJobRepo.findByAccountAndJobs(account, job);
        if (followJob != null) {
            _followJobRepo.delete(followJob);
            return true;
        }
        _followJobRepo.save(new FollowJob(0, job, account));
        return true;
    }

    public Boolean postJobsViewed(RequestIntermediaryJob requestIntermediaryJob) {
        Account account = _currentAccount.getAccount();
        Jobs job = _jobRepo.findJobId(Integer.parseInt(requestIntermediaryJob.job_id));
        if (account == null || job == null) {
            return false;
        }
        _ViewedJobRepo.save(new ViewedJob(0, job, account));
        return true;
    }

    public JobDTO CreatejobApplication(RequestApplication requestApplication) {
        Account account = _currentAccount.getAccount();
        Jobs job = _jobRepo.findJobId(Integer.parseInt(requestApplication.getJob_id()));
        CurriculumVitae Cv = _cvRepo.findById(Integer.parseInt(requestApplication.getCv_id())).get();
        if (account == null || job == null || Cv == null) {
            throw Variable.ACTION_FAIL;
        }
        for (int i = 0; i < account.getApplications().size(); i++) {
            boolean checkApplicated = account.getApplications().get(i).getAccount() == account
                    && account.getApplications().get(i).getJobs() == job;
            if (checkApplicated) {
                throw Variable.CONFLIG;
            }
        }
        _applicationRepo.save(new Application(0, requestApplication.getNote(), account, job, Cv));
        return null;
    }

    public boolean deleteJobsSave(RequestIntermediaryJob requestIntermediaryJob) {
        Account account = _currentAccount.getAccount();
        Jobs job = _jobRepo.findJobId(Integer.parseInt(requestIntermediaryJob.getJob_id()));
        if (account == null && job == null) {
            return false;
        }
        FollowJob followJob = _followJobRepo.findByAccountAndJobs(account, job);
        if (followJob == null) {
            return false;
        }
        _followJobRepo.deleteById(followJob.getId());
        return true;

    }

    JobDTO setSkill_level(Jobs job, JobDTO jobDTO) {
        // sai chung
        List<SkillDTO> skillDTOs = new ArrayList<>();
        for (SkillJob s : job.getSkillJobs()) {
            if (s.getDeleted_at() == null) {
                skillDTOs.add(SkillMapping.getSkill(s.getSkills()));
            }
        }
        jobDTO.setSkills(skillDTOs);
        List<LevelDTO> levelDTOs = new ArrayList<>();
        for (LevelJob s : job.getLevelJobs()) {
            if (s.getDeleted_at() == null) {
                levelDTOs.add(LevelMapping.levelDTO(s.getLevel()));
            }
        }
        jobDTO.setLevels(levelDTOs);
        return jobDTO;
    }

    JobDTO setAppliedAndSaved(Jobs job, JobDTO jobDTO) {
        // sai chung
        Account account = _currentAccount.getAccount();
        if (account != null) {
            boolean applied = _applicationRepo.findByAccountAndJobs(account, job) != null;
            if (applied) {
                jobDTO.setJob_is_apply(true);
            }
            boolean saved = _followJobRepo.findByAccountAndJobs(account, job) != null;
            if (saved) {
                jobDTO.setJob_is_save(true);
            }
        }
        return jobDTO;
    }

}
