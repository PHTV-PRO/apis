package com.company.phtv.Services.IServices;

import com.company.phtv.Models.DTO.SkillDTO;
import com.company.phtv.Models.Request.RequestSkill;

import java.util.List;

public interface ISkillService {
    List<SkillDTO> getAll();

    SkillDTO create(RequestSkill requestSkill);

    SkillDTO put(int id, RequestSkill requestSkill);

    SkillDTO getById(int id);

    SkillDTO delete(int id);
}
