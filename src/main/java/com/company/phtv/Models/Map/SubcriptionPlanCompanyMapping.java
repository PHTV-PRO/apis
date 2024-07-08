package com.company.phtv.Models.Map;

import com.company.phtv.Models.DTO.SubcriptionPlanCompanyDTO;
import com.company.phtv.Models.DTO.SubcriptionPlanDTO;
import com.company.phtv.Models.Entity.SubcriptionPlan;
import com.company.phtv.Models.Entity.SubcriptionPlanCompany;

public class SubcriptionPlanCompanyMapping {
    public static SubcriptionPlanCompanyDTO getSubcriptionPlanCompany(SubcriptionPlanCompany sc){
        SubcriptionPlanCompanyDTO subcriptionPlanCompanyDTO = new SubcriptionPlanCompanyDTO();
        subcriptionPlanCompanyDTO.setId(sc.getId());
        subcriptionPlanCompanyDTO.setStart_date(sc.getStart_date());
        subcriptionPlanCompanyDTO.setEnd_date(sc.getEnd_date());
        return subcriptionPlanCompanyDTO;
    }
}
