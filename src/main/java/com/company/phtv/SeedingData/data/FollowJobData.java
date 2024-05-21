package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.*;

import java.util.ArrayList;
import java.util.List;

public class FollowJobData {
    public List<FollowJob> Data(){
        List<FollowJob> data = new ArrayList<>();
        data.add(new FollowJob(1,new Jobs(1),new Account(1)));
        data.add(new FollowJob(2,new Jobs(2),new Account(2)));
        data.add(new FollowJob(3,new Jobs(3),new Account(3)));

        return data;
    }
}
