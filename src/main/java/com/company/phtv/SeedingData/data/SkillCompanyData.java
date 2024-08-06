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
        data.add(new SkillCompany(11,_SkillRepo.getOne(15),_company.getOne(3)));
        data.add(new SkillCompany(12,_SkillRepo.getOne(17),_company.getOne(3)));
        data.add(new SkillCompany(13,_SkillRepo.getOne(4),_company.getOne(4)));
        data.add(new SkillCompany(14,_SkillRepo.getOne(14),_company.getOne(4)));
        data.add(new SkillCompany(15,_SkillRepo.getOne(19),_company.getOne(5)));
        data.add(new SkillCompany(16,_SkillRepo.getOne(2),_company.getOne(5)));
        data.add(new SkillCompany(17,_SkillRepo.getOne(12),_company.getOne(6)));
        data.add(new SkillCompany(18,_SkillRepo.getOne(14),_company.getOne(6)));
        data.add(new SkillCompany(19,_SkillRepo.getOne(16),_company.getOne(7)));
        data.add(new SkillCompany(20,_SkillRepo.getOne(3),_company.getOne(7)));
        data.add(new SkillCompany(21,_SkillRepo.getOne(22),_company.getOne(8)));
        data.add(new SkillCompany(22,_SkillRepo.getOne(23),_company.getOne(8)));
        data.add(new SkillCompany(23,_SkillRepo.getOne(24),_company.getOne(9)));
        data.add(new SkillCompany(24,_SkillRepo.getOne(25),_company.getOne(9)));
        data.add(new SkillCompany(25,_SkillRepo.getOne(26),_company.getOne(10)));
        data.add(new SkillCompany(26,_SkillRepo.getOne(27),_company.getOne(10)));
        data.add(new SkillCompany(27,_SkillRepo.getOne(28),_company.getOne(10)));



        return data;
    }
}
