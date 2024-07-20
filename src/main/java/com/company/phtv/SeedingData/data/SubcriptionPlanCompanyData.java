package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.SubcriptionPlanCompany;
import com.company.phtv.Repository.CompanyRepo;
import com.company.phtv.Repository.SubcriptionPlanRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubcriptionPlanCompanyData {
    private final CompanyRepo _CompanyRepo;
    private final SubcriptionPlanRepo _SubcriptionPlanRepo;
    public SubcriptionPlanCompanyData(CompanyRepo _CompanyRepo, SubcriptionPlanRepo _SubcriptionPlanRepo) {
        this._CompanyRepo = _CompanyRepo;
        this._SubcriptionPlanRepo = _SubcriptionPlanRepo;
    }
    @SuppressWarnings("deprecation")
    public List<SubcriptionPlanCompany> Data(){
        List<SubcriptionPlanCompany> data = new ArrayList<>();
        data.add(new SubcriptionPlanCompany(1,new Date("30/6/2024"),new Date("31/7/2024"),_CompanyRepo.getOne(1),_SubcriptionPlanRepo.getOne(3)));


        data.add(new SubcriptionPlanCompany(2,new Date("2/6/2024"),new Date("2/6/2025"),_CompanyRepo.getOne(2),_SubcriptionPlanRepo.getOne(4)));
        data.add(new SubcriptionPlanCompany(3,new Date("2/6/2024"),new Date("12/8/2024"),_CompanyRepo.getOne(3),_SubcriptionPlanRepo.getOne(3)));

        data.add(new SubcriptionPlanCompany(4,new Date("30/6/2024"),new Date("31/7/2024"),_CompanyRepo.getOne(4),_SubcriptionPlanRepo.getOne(1)));
        data.add(new SubcriptionPlanCompany(5,new Date("30/6/2024"),new Date("31/7/2024"),_CompanyRepo.getOne(5),_SubcriptionPlanRepo.getOne(1)));
        data.add(new SubcriptionPlanCompany(6,new Date("30/6/2024"),new Date("31/7/2024"),_CompanyRepo.getOne(6),_SubcriptionPlanRepo.getOne(1)));
        data.add(new SubcriptionPlanCompany(7,new Date("30/6/2024"),new Date("31/7/2024"),_CompanyRepo.getOne(7),_SubcriptionPlanRepo.getOne(1)));
        data.add(new SubcriptionPlanCompany(8,new Date("30/6/2024"),new Date("31/7/2024"),_CompanyRepo.getOne(8),_SubcriptionPlanRepo.getOne(1)));
        data.add(new SubcriptionPlanCompany(9,new Date("30/6/2024"),new Date("31/7/2024"),_CompanyRepo.getOne(9),_SubcriptionPlanRepo.getOne(1)));
        data.add(new SubcriptionPlanCompany(10,new Date("30/6/2024"),new Date("31/7/2024"),_CompanyRepo.getOne(10),_SubcriptionPlanRepo.getOne(1)));


        data.add(new SubcriptionPlanCompany(11,new Date("30/6/2024"),new Date("31/7/2024"),_CompanyRepo.getOne(1),_SubcriptionPlanRepo.getOne(1)));
        data.add(new SubcriptionPlanCompany(12,new Date("30/6/2024"),new Date("31/7/2024"),_CompanyRepo.getOne(1),_SubcriptionPlanRepo.getOne(2)));
        return data;
    }
}
