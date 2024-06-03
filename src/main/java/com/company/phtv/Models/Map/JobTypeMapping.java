package com.company.phtv.Models.Map;

import com.company.phtv.Models.DTO.JobTypeDTO;
import com.company.phtv.Models.Entity.JobType;
import com.company.phtv.Models.Request.RequestJobType;

public class JobTypeMapping {
    public static JobTypeDTO jobTypeDTO(JobType j){
        JobTypeDTO jobTypeDTO = new JobTypeDTO();
        jobTypeDTO.setId(j.getId());
        jobTypeDTO.setName(j.getName());
        return jobTypeDTO;
    }

    public static JobType JobType(RequestJobType rq){
        JobType jobType = new JobType();
        jobType.setName(rq.getName());
        return jobType;
    }

    public static  JobType JobTypePut(RequestJobType ri,JobType jobType){
        if(ri.getName() != null){
            jobType.setName(ri.getName());
        }
        return  jobType;
    }
}
