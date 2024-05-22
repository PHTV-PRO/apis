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
        data.add(new SubcriptionPlanCompany(1,new Date(2024-5-21),new Date(2024-9-31),_CompanyRepo.getOne(1),_SubcriptionPlanRepo.getOne(3)));
        data.add(new SubcriptionPlanCompany(2,new Date(2024-5-30),new Date(2025-2-5),_CompanyRepo.getOne(2),_SubcriptionPlanRepo.getOne(4)));
        data.add(new SubcriptionPlanCompany(3,new Date(2024-5-21),new Date(2024-4-21),_CompanyRepo.getOne(3),_SubcriptionPlanRepo.getOne(3)));

        return data;
    }
}
