package com.company.phtv.Models.Map;

import com.company.phtv.Models.DTO.IndustryDTO;
import com.company.phtv.Models.DTO.SkillDTO;
import com.company.phtv.Models.Entity.Industry;
import com.company.phtv.Models.Entity.Skill;
import com.company.phtv.Models.Request.RequestIndustry;

public class IndustryMapping {
    public static IndustryDTO industryDTO(Industry i){
        IndustryDTO industryDTO = new IndustryDTO();
        industryDTO.setId(i.getId());
        industryDTO.setName(i.getName());
        industryDTO.setSkills(i.getSkills());
        return industryDTO;
    }

    public static Industry Industry(RequestIndustry i){
        Industry industry = new Industry();
        industry.setName(i.getName());
        return industry;
    }

    public static  Industry IndustryPut(RequestIndustry ri,Industry i){
        if(ri.getName() != null){
            i.setName(ri.getName());
        }
        return  i;
    }


}
