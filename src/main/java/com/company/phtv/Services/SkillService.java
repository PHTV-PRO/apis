package com.company.phtv.Services;

import com.company.phtv.Models.DTO.SkillDTO;
import com.company.phtv.Models.Entity.*;
import com.company.phtv.Models.Map.SkillMapping;
import com.company.phtv.Models.Request.RequestSkill;
import com.company.phtv.Repository.*;
import com.company.phtv.Services.IServices.ISkillService;
import com.company.phtv.Utils.Variable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class SkillService implements ISkillService {
    @Autowired
    SkillRepo _skillRepo;
    @Autowired
    IndustryRepo _industryRepo;

    @Override
    public List<SkillDTO> getAll() {
        List<Skill> skills = _skillRepo.findAll();
        List<SkillDTO> skillDTOS = new ArrayList<>();
        for (int i = 0; i < skills.size(); i++) {
            if (skills.get(i).getDeleted_at() == null) {
                skillDTOS.add(SkillMapping.getSkill(skills.get(i)));
            }
        }
        return skillDTOS;
    }

    @Override
    public SkillDTO create(RequestSkill requestSkill) {
        Skill skill = SkillMapping.SkillPost(requestSkill);
        Industry i = _industryRepo.findById(requestSkill.getIndustry_id()).get();
        boolean checkIndustryNotFound = i == null || i.getDeleted_at() != null;
        if (checkIndustryNotFound) {
            throw Variable.NOT_FOUND;
        }
        skill.setIndustry(i);
//        boolean checkCompanyNotFound = cm == null || cm.getDeleted_at() != null;
//        if (checkCompanyNotFound) {
//            throw Variable.notFound;
//        }
//        location.setCompany(cm);
        _skillRepo.save(skill);
        return (SkillDTO) SkillMapping.getSkill(skill);
    }

    @Override
    public SkillDTO put(int id, RequestSkill requestSkill) {
        Skill getSkill = _skillRepo.findIdSkill(id);
        boolean checkSkillNotFound = (getSkill != null && getSkill.getDeleted_at() == null) ? false : true;
        if (checkSkillNotFound) {
            throw Variable.NOT_FOUND;
        }
        Skill skill = SkillMapping.SkillPut(requestSkill, getSkill);
        if (requestSkill.getIndustry_id() != 0) {
            skill.setIndustry(_industryRepo.getIndustriesById(requestSkill.getIndustry_id()));
        }
        skill.setId(id);
//        if (requestLocation.getCompany_id() != 0) {
//            location.setCompany(_companyRepo.getCompanyById(requestLocation.getCompany_id()));
//        }
//        location.setId(id);
        _skillRepo.save(skill);
        return (SkillDTO) SkillMapping.getSkill(skill);
    }

    @Override
    public SkillDTO getById(int id) {
        Skill skill = _skillRepo.findIdSkill(id);
        boolean checkSkillNotFound = (skill != null && skill.getDeleted_at() == null) ? false : true;
        if (checkSkillNotFound) {
            throw Variable.NOT_FOUND;
        }
        SkillDTO skillDTO = SkillMapping.getSkill(skill);
        return skillDTO;
    }

    @Override
    public SkillDTO delete(int id) {
        Skill skill = _skillRepo.findIdSkill(id);
        boolean checkLSkillNotFound = (skill != null && skill.getDeleted_at() == null) ? false : true;
        if (checkLSkillNotFound) {
            throw Variable.NOT_FOUND;
        }
        skill.setDeleted_at(new Date());
        _skillRepo.save(skill);
        return null;
    }
}
