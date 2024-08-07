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
//        còn hạn sử dụng
        data.add(new SubcriptionPlanCompany(1,new Date("08/07/2024"),new Date("11/18/2024"),_CompanyRepo.getOne(1),_SubcriptionPlanRepo.getOne(3)));


        data.add(new SubcriptionPlanCompany(2,new Date("08/07/2024"),new Date("08/07/2025"),_CompanyRepo.getOne(2),_SubcriptionPlanRepo.getOne(4)));
        data.add(new SubcriptionPlanCompany(3,new Date("08/07/2024"),new Date("11/18/2024"),_CompanyRepo.getOne(3),_SubcriptionPlanRepo.getOne(3)));

        data.add(new SubcriptionPlanCompany(4,new Date("08/07/2024"),new Date("09/07/2024"),_CompanyRepo.getOne(4),_SubcriptionPlanRepo.getOne(1)));
        data.add(new SubcriptionPlanCompany(5,new Date("08/07/2024"),new Date("09/07/2024"),_CompanyRepo.getOne(5),_SubcriptionPlanRepo.getOne(1)));
        data.add(new SubcriptionPlanCompany(6,new Date("08/07/2024"),new Date("09/07/2024"),_CompanyRepo.getOne(6),_SubcriptionPlanRepo.getOne(1)));
        data.add(new SubcriptionPlanCompany(7,new Date("08/07/2024"),new Date("09/07/2024"),_CompanyRepo.getOne(7),_SubcriptionPlanRepo.getOne(1)));
        data.add(new SubcriptionPlanCompany(8,new Date("08/07/2024"),new Date("09/07/2024"),_CompanyRepo.getOne(8),_SubcriptionPlanRepo.getOne(1)));
        data.add(new SubcriptionPlanCompany(9,new Date("08/07/2024"),new Date("09/07/2024"),_CompanyRepo.getOne(9),_SubcriptionPlanRepo.getOne(1)));
        data.add(new SubcriptionPlanCompany(10,new Date("08/07/2024"),new Date("09/07/2024"),_CompanyRepo.getOne(10),_SubcriptionPlanRepo.getOne(1)));

// qua hạn sử dụng
        data.add(new SubcriptionPlanCompany(11,new Date("03/07/2024"),new Date("06/18/2024"),_CompanyRepo.getOne(1),_SubcriptionPlanRepo.getOne(3)));


        data.add(new SubcriptionPlanCompany(12,new Date("03/07/2023"),new Date("06/07/2024"),_CompanyRepo.getOne(2),_SubcriptionPlanRepo.getOne(4)));
        data.add(new SubcriptionPlanCompany(13,new Date("03/07/2023"),new Date("06/18/2024"),_CompanyRepo.getOne(3),_SubcriptionPlanRepo.getOne(3)));

        data.add(new SubcriptionPlanCompany(14,new Date("03/07/2024"),new Date("06/07/2024"),_CompanyRepo.getOne(4),_SubcriptionPlanRepo.getOne(1)));
        data.add(new SubcriptionPlanCompany(15,new Date("03/07/2024"),new Date("06/07/2024"),_CompanyRepo.getOne(5),_SubcriptionPlanRepo.getOne(1)));
        data.add(new SubcriptionPlanCompany(16,new Date("03/07/2024"),new Date("06/07/2024"),_CompanyRepo.getOne(6),_SubcriptionPlanRepo.getOne(1)));
        data.add(new SubcriptionPlanCompany(17,new Date("03/07/2024"),new Date("06/07/2024"),_CompanyRepo.getOne(7),_SubcriptionPlanRepo.getOne(1)));
        data.add(new SubcriptionPlanCompany(18,new Date("03/07/2024"),new Date("06/07/2024"),_CompanyRepo.getOne(8),_SubcriptionPlanRepo.getOne(1)));
        data.add(new SubcriptionPlanCompany(19,new Date("03/07/2024"),new Date("06/07/2024"),_CompanyRepo.getOne(9),_SubcriptionPlanRepo.getOne(1)));
        data.add(new SubcriptionPlanCompany(20,new Date("03/07/2024"),new Date("06/07/2024"),_CompanyRepo.getOne(10),_SubcriptionPlanRepo.getOne(1)));
        return data;
    }
}
