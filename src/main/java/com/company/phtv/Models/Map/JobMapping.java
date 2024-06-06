package com.company.phtv.Models.Map;

import com.company.phtv.Models.DTO.*;
import com.company.phtv.Models.Entity.Jobs;
import com.company.phtv.Models.Request.RequestJob;

public class JobMapping {
    public static JobDTO getJob(Jobs jobs) {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(jobs.getId());
        jobDTO.setTitle(jobs.getTitle());
        jobDTO.setDescription(jobs.getDescription());
        jobDTO.setReponsibility(jobs.getReponsibility());
        jobDTO.setSkill_required(jobs.getSkill_required());
        jobDTO.setBenefit(jobs.getBenefit());
        jobDTO.setInterview_steps(jobs.getInterview_steps());
        jobDTO.setAmount(jobs.getAmount());
        jobDTO.setExperience_required(jobs.getExperience_required());
        jobDTO.setSalary_max(jobs.getSalary_max());
        jobDTO.setSalary_min(jobs.getSalary_min());
        jobDTO.setStart_date(jobs.getStart_date());
        jobDTO.setEnd_date(jobs.getEnd_date());
        jobDTO.set_active(jobs.is_active());
        jobDTO.setGender(jobs.getGender());
        jobDTO.setCompany(
                new CompanyDTO(jobs.getCompany().getId(), jobs.getCompany().getName()
                        , jobs.getCompany().getIntroduction(),jobs.getCompany().getBenefit()
                        ,jobs.getCompany().getProfession(),jobs.getCompany().getSize_min()
                        ,jobs.getCompany().getSize_max(),jobs.getCompany().getSkill()
                        , jobs.getCompany().getLink_website()
                        , jobs.getCompany().getNationnality(),jobs.getCompany().getLogo_image()
                        ,jobs.getCompany().getBackground_image()
                        ,jobs.getCompany().getEnable(),null));
        jobDTO.setLocation(
                new LocationDTO(jobs.getLocation().getId(),jobs.getLocation().getName(),null,null));
        jobDTO.setJobType(
                new JobTypeDTO(jobs.getJobType().getId(),jobs.getJobType().getName()));
        return jobDTO;
    }

    public static Jobs jobCreate(RequestJob j) {
        Jobs jobs = new Jobs();
        jobs.setTitle(j.getTitle());
        jobs.setDescription(j.getDescription());
        jobs.setReponsibility(j.getReponsibility());
        jobs.setSkill_required(j.getSkill_required());
        jobs.setBenefit(j.getBenefit());
        jobs.setInterview_steps(j.getInterview_steps());
        jobs.setAmount(j.getAmount());
        jobs.setExperience_required(j.getExperience_required());
        jobs.setSalary_max(j.getSalary_max());
        jobs.setSalary_min(j.getSalary_min());
        jobs.setStart_date(j.getStart_date());
        jobs.setEnd_date(j.getEnd_date());
        jobs.set_active(j.is_active());
        jobs.setGender(j.getGender());
        return jobs;
    }

    public static Jobs jobPut(RequestJob rj, Jobs j) {
        if (rj.getTitle() != null) {
            j.setTitle(rj.getTitle());
        }
        if (rj.getDescription() != null) {
            j.setDescription(rj.getDescription());
        }
        if (rj.getReponsibility() != null) {
            j.setReponsibility(rj.getReponsibility());
        }
        if (rj.getBenefit() != null) {
            j.setSkill_required(rj.getBenefit());
        }
        if (rj.getTitle() != null) {
            j.setBenefit(rj.getTitle());
        }
        if (rj.getInterview_steps() != null) {
            j.setInterview_steps(rj.getInterview_steps());
        }
        if (rj.getAmount() != 0) {
            j.setAmount(rj.getAmount());
        }
        if (rj.getExperience_required() != null) {
            j.setExperience_required(rj.getExperience_required());
        }
        if (rj.getSalary_max() != null) {
            j.setSalary_max(rj.getSalary_max());
        }
        if (rj.getSalary_min() != null) {
            j.setSalary_min(rj.getSalary_min());
        }
        if (rj.getStart_date() != null) {
            j.setStart_date(rj.getStart_date());
        }
        if (rj.getEnd_date() != null) {
            j.setEnd_date(rj.getEnd_date());
        }
        if (rj.is_active != false) {
            j.set_active(rj.is_active());
        }
        if (rj.getGender() != 0) {
            j.setGender(rj.getGender());
        }
        return j;
    }
}