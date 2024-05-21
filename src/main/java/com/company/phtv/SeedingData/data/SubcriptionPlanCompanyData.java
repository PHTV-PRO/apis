package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Models.Entity.SubcriptionPlan;
import com.company.phtv.Models.Entity.SubcriptionPlanCompany;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubcriptionPlanCompanyData {
    public List<SubcriptionPlanCompany> Data(){
        List<SubcriptionPlanCompany> data = new ArrayList<>();
        data.add(new SubcriptionPlanCompany(1,new Date(2024-5-21),new Date(2024-9-31),new Company(1),new SubcriptionPlan(3)));
        data.add(new SubcriptionPlanCompany(2,new Date(2024-5-30),new Date(2025-2-5),new Company(2),new SubcriptionPlan(4)));
        data.add(new SubcriptionPlanCompany(3,new Date(2024-5-21),new Date(2024-4-21),new Company(3),new SubcriptionPlan(3)));

        return data;
    }
}
