package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.JobType;

import java.util.ArrayList;
import java.util.List;

public class JobTypeData {
    public List<JobType> Data(){
        List<JobType> data = new ArrayList<>();
        data.add(new JobType(1,"Thiết Kế Đồ Hoạ"));
        data.add(new JobType(2,"Thực Tập Sinh React"));
        data.add(new JobType(3,".Net Developer"));
        return data;
    }
}
