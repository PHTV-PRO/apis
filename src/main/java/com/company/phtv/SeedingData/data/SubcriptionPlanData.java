package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.SubcriptionPlan;

import java.util.ArrayList;
import java.util.List;

public class SubcriptionPlanData {
    public List<SubcriptionPlan> Data(){
        List<SubcriptionPlan> data = new ArrayList<>();
        data.add(new SubcriptionPlan(1,"COMBO 30",2.160f ,30));
        data.add(new SubcriptionPlan(2,"COMBO 50",3.330f ,50));
        data.add(new SubcriptionPlan(3,"COMBO 100",6.300f ,100));
        data.add(new SubcriptionPlan(4,"COMBO 300",18.000f ,300));
        return data;
    }
}
