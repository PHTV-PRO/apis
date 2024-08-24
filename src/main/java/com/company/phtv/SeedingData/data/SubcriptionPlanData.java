package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.SubcriptionPlan;

import java.util.ArrayList;
import java.util.List;

public class SubcriptionPlanData {
    public List<SubcriptionPlan> Data(){
        List<SubcriptionPlan> data = new ArrayList<>();
        data.add(new SubcriptionPlan(1,"COMBO 30","Only 2.16$ can post 30 jobs within 30 days",2.160f ,30));
        data.add(new SubcriptionPlan(2,"COMBO 50","Only 3.30$ can post 50 jobs within 50 days",3.330f ,50));
        data.add(new SubcriptionPlan(3,"COMBO 100","Only 6.30$ can post 100 jobs within 100 days",6.300f ,100));
        data.add(new SubcriptionPlan(4,"COMBO 365","Only 18.00$ can post 300 jobs within 365 days",18.000f ,300));
        return data;
    }
}
