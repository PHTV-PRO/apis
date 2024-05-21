package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.*;

import java.util.ArrayList;
import java.util.List;

public class FollowCompanyData {
    public List<FollowCompany> Data(){
        List<FollowCompany> data = new ArrayList<>();
        data.add(new FollowCompany(1,new Company(3),new Account(2)));
        data.add(new FollowCompany(2,new Company(2),new Account(1)));
        data.add(new FollowCompany(3,new Company(1),new Account(3)));
        return data;
    }
}
