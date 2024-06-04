package com.company.phtv.Models.Map;

import java.util.HashSet;
import java.util.Set;

import com.company.phtv.Models.DTO.IndustryDTO;
import com.company.phtv.Models.DTO.SkillDTO;
import com.company.phtv.Models.Entity.Industry;
import com.company.phtv.Models.Entity.Skill;
import com.company.phtv.Models.Request.RequestIndustry;

public class IndustryMapping {
    public static IndustryDTO industryDTO(Industry i) {
        IndustryDTO industryDTO = new IndustryDTO();
        industryDTO.setId(i.getId());
        industryDTO.setName(i.getName());
        Set<SkillDTO> skill = new HashSet<>();
        for (Skill s : i.getSkills()) {
            if (s.getDeleted_at() == null) {
                skill.add(new SkillDTO(s.getId(), s.getName()));
            }
        }
        industryDTO.setSkills(skill);
        return industryDTO;
    }

    public static Industry Industry(RequestIndustry i) {
        Industry industry = new Industry();
        industry.setName(i.getName());
        return industry;
    }

    public static Industry IndustryPut(RequestIndustry ri, Industry i) {
        if (ri.getName() != null) {
            i.setName(ri.getName());
        }
        return i;
    }

}
