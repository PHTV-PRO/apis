package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.SkillCompany;
import com.company.phtv.Repository.CompanyRepo;
import com.company.phtv.Repository.SkillRepo;

import java.util.ArrayList;
import java.util.List;

public class SkillCompanyData {
    private final CompanyRepo _company;
    private final SkillRepo _SkillRepo;
    public SkillCompanyData(CompanyRepo _company, SkillRepo _SkillRepo) {
        this._company = _company;
        this._SkillRepo = _SkillRepo;
    }
    @SuppressWarnings("deprecation")
    public List<SkillCompany> Data(){
        List<SkillCompany> data = new ArrayList<>();
        data.add(new SkillCompany(1,_SkillRepo.getOne(4),_company.getOne(1)));
        data.add(new SkillCompany(2,_SkillRepo.getOne(5),_company.getOne(1)));
        data.add(new SkillCompany(3,_SkillRepo.getOne(6),_company.getOne(1)));
        data.add(new SkillCompany(4,_SkillRepo.getOne(8),_company.getOne(1)));
        data.add(new SkillCompany(5,_SkillRepo.getOne(3),_company.getOne(2)));
        data.add(new SkillCompany(6,_SkillRepo.getOne(21),_company.getOne(2)));
        data.add(new SkillCompany(7,_SkillRepo.getOne(13),_company.getOne(2)));
        data.add(new SkillCompany(8,_SkillRepo.getOne(1),_company.getOne(2)));
        data.add(new SkillCompany(9,_SkillRepo.getOne(1),_company.getOne(2)));
        data.add(new SkillCompany(10,_SkillRepo.getOne(1),_company.getOne(2)));

        return data;
    }
}
