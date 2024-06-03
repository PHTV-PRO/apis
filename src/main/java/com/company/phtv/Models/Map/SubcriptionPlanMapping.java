package com.company.phtv.Models.Map;

import com.company.phtv.Models.DTO.SubcriptionPlanDTO;
import com.company.phtv.Models.Entity.SubcriptionPlan;
import com.company.phtv.Models.Request.RequestSubcriptionPlan;

public class SubcriptionPlanMapping {
    public static SubcriptionPlanDTO subcriptionPlanDTO(SubcriptionPlan s){
        SubcriptionPlanDTO subcriptionPlanDTO = new SubcriptionPlanDTO();
        subcriptionPlanDTO.setId(s.getId());
        subcriptionPlanDTO.setName(s.getName());
        subcriptionPlanDTO.setPrice(s.getPrice());
        subcriptionPlanDTO.setExpiry(s.getExpiry());
        return subcriptionPlanDTO;
    }

    public static SubcriptionPlan SubcriptionPlan(RequestSubcriptionPlan rp){
        SubcriptionPlan subcriptionPlan = new SubcriptionPlan();
        subcriptionPlan.setName(rp.getName());
        subcriptionPlan.setPrice(rp.getPrice());
        subcriptionPlan.setExpiry(rp.getExpiry());

        return subcriptionPlan;
    }

    public static  SubcriptionPlan SubcriptionPlanPut(RequestSubcriptionPlan rsp,SubcriptionPlan sp){
        if(rsp.getName() != null){
            sp.setName(rsp.getName());
            sp.setPrice(rsp.getPrice());
            sp.setExpiry(rsp.getExpiry());
        }
        return  sp;
    }
}
