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
        // 1 combo 30 , 2 combo 50 , 3 combo 100 , 4 combo 360
        data.add(new SubcriptionPlanCompany(1,new Date("08/24/2024"),new Date("11/04/2024"),_CompanyRepo.getOne(1),_SubcriptionPlanRepo.getOne(3),new Date("08/24/2024")));
        // data.add(new SubcriptionPlanCompany(2,new Date("08/24/2024"),new Date("08/24/2025"),_CompanyRepo.getOne(2),_SubcriptionPlanRepo.getOne(4),new Date("08/24/2024")));
        data.add(new SubcriptionPlanCompany(3,new Date("08/01/2024"),new Date("11/11/2024"),_CompanyRepo.getOne(3),_SubcriptionPlanRepo.getOne(3),new Date("08/01/2024")));
        data.add(new SubcriptionPlanCompany(4,new Date("08/07/2024"),new Date("09/07/2024"),_CompanyRepo.getOne(4),_SubcriptionPlanRepo.getOne(1),new Date("08/07/2024")));
        data.add(new SubcriptionPlanCompany(5,new Date("08/07/2024"),new Date("09/07/2024"),_CompanyRepo.getOne(5),_SubcriptionPlanRepo.getOne(1),new Date("08/07/2024")));
        data.add(new SubcriptionPlanCompany(6,new Date("08/01/2024"),new Date("10/20/2024"),_CompanyRepo.getOne(6),_SubcriptionPlanRepo.getOne(2),new Date("08/01/2024")));
        data.add(new SubcriptionPlanCompany(7,new Date("08/01/2024"),new Date("08/01/2025"),_CompanyRepo.getOne(7),_SubcriptionPlanRepo.getOne(4),new Date("08/01/2024")));
        data.add(new SubcriptionPlanCompany(8,new Date("08/01/2024"),new Date("10/20/2024"),_CompanyRepo.getOne(8),_SubcriptionPlanRepo.getOne(2),new Date("08/01/2024")));
        data.add(new SubcriptionPlanCompany(9,new Date("08/01/2024"),new Date("10/20/2024"),_CompanyRepo.getOne(9),_SubcriptionPlanRepo.getOne(2),new Date("08/01/2024")));
        data.add(new SubcriptionPlanCompany(10,new Date("08/07/2024"),new Date("11/17/2024"),_CompanyRepo.getOne(10),_SubcriptionPlanRepo.getOne(3),new Date("08/07/2024")));
// qua hạn sử dụng
        data.add(new SubcriptionPlanCompany(11,new Date("03/07/2024"),new Date("06/18/2024"),_CompanyRepo.getOne(1),_SubcriptionPlanRepo.getOne(3),new Date("03/07/2024")));
        data.add(new SubcriptionPlanCompany(12,new Date("03/07/2023"),new Date("07/03/2024"),_CompanyRepo.getOne(2),_SubcriptionPlanRepo.getOne(4),new Date("03/07/2023")));
        data.add(new SubcriptionPlanCompany(13,new Date("03/07/2023"),new Date("06/18/2023"),_CompanyRepo.getOne(3),_SubcriptionPlanRepo.getOne(3),new Date("03/07/2023")));
        data.add(new SubcriptionPlanCompany(14,new Date("03/07/2024"),new Date("04/07/2024"),_CompanyRepo.getOne(4),_SubcriptionPlanRepo.getOne(1),new Date("03/07/2024")));
        data.add(new SubcriptionPlanCompany(15,new Date("03/07/2024"),new Date("04/07/2024"),_CompanyRepo.getOne(5),_SubcriptionPlanRepo.getOne(1),new Date("03/07/2024")));
        data.add(new SubcriptionPlanCompany(16,new Date("03/07/2024"),new Date("04/07/2024"),_CompanyRepo.getOne(6),_SubcriptionPlanRepo.getOne(1),new Date("03/07/2024")));
        data.add(new SubcriptionPlanCompany(17,new Date("03/07/2024"),new Date("04/07/2024"),_CompanyRepo.getOne(7),_SubcriptionPlanRepo.getOne(1),new Date("03/07/2024")));
        data.add(new SubcriptionPlanCompany(18,new Date("03/07/2024"),new Date("04/07/2024"),_CompanyRepo.getOne(8),_SubcriptionPlanRepo.getOne(1),new Date("03/07/2024")));
        data.add(new SubcriptionPlanCompany(19,new Date("03/07/2024"),new Date("04/07/2024"),_CompanyRepo.getOne(9),_SubcriptionPlanRepo.getOne(1),new Date("03/07/2024")));
        data.add(new SubcriptionPlanCompany(20,new Date("03/07/2024"),new Date("04/07/2024"),_CompanyRepo.getOne(10),_SubcriptionPlanRepo.getOne(1),new Date("03/07/2024")));

        data.add(new SubcriptionPlanCompany(21,new Date("04/07/2024"),new Date("07/18/2024"),_CompanyRepo.getOne(1),_SubcriptionPlanRepo.getOne(3),new Date("04/07/2024")));
        data.add(new SubcriptionPlanCompany(22,new Date("04/07/2023"),new Date("07/07/2024"),_CompanyRepo.getOne(2),_SubcriptionPlanRepo.getOne(4),new Date("04/07/2023")));
        data.add(new SubcriptionPlanCompany(23,new Date("02/07/2023"),new Date("05/18/2024"),_CompanyRepo.getOne(3),_SubcriptionPlanRepo.getOne(3),new Date("02/07/2023")));
        data.add(new SubcriptionPlanCompany(24,new Date("04/07/2022"),new Date("04/07/2023"),_CompanyRepo.getOne(4),_SubcriptionPlanRepo.getOne(4),new Date("04/07/2022")));
        data.add(new SubcriptionPlanCompany(25,new Date("02/07/2024"),new Date("04/17/2024"),_CompanyRepo.getOne(5),_SubcriptionPlanRepo.getOne(2),new Date("02/07/2024")));
        data.add(new SubcriptionPlanCompany(26,new Date("02/07/2024"),new Date("05/17/2024"),_CompanyRepo.getOne(6),_SubcriptionPlanRepo.getOne(3),new Date("02/07/2024")));
        data.add(new SubcriptionPlanCompany(27,new Date("02/07/2024"),new Date("04/27/2024"),_CompanyRepo.getOne(7),_SubcriptionPlanRepo.getOne(2),new Date("02/07/2024")));
        data.add(new SubcriptionPlanCompany(28,new Date("01/07/2024"),new Date("02/07/2024"),_CompanyRepo.getOne(8),_SubcriptionPlanRepo.getOne(1),new Date("01/07/2024")));
        data.add(new SubcriptionPlanCompany(29,new Date("03/07/2024"),new Date("02/07/2024"),_CompanyRepo.getOne(9),_SubcriptionPlanRepo.getOne(1),new Date("03/07/2024")));
        data.add(new SubcriptionPlanCompany(30,new Date("05/07/2024"),new Date("06/07/2024"),_CompanyRepo.getOne(10),_SubcriptionPlanRepo.getOne(1),new Date("05/07/2024")));

        data.add(new SubcriptionPlanCompany(31,new Date("01/24/2024"),new Date("4/24/2024"),_CompanyRepo.getOne(1),_SubcriptionPlanRepo.getOne(3),new Date("01/24/2024")));
        data.add(new SubcriptionPlanCompany(32,new Date("01/24/2023"),new Date("01/24/2024"),_CompanyRepo.getOne(2),_SubcriptionPlanRepo.getOne(4),new Date("01/24/2023")));
        data.add(new SubcriptionPlanCompany(33,new Date("02/01/2024"),new Date("06/11/2024"),_CompanyRepo.getOne(3),_SubcriptionPlanRepo.getOne(3),new Date("02/01/2024")));
        data.add(new SubcriptionPlanCompany(34,new Date("01/07/2024"),new Date("02/07/2024"),_CompanyRepo.getOne(4),_SubcriptionPlanRepo.getOne(1),new Date("01/07/2024")));
        data.add(new SubcriptionPlanCompany(35,new Date("02/07/2024"),new Date("03/07/2024"),_CompanyRepo.getOne(5),_SubcriptionPlanRepo.getOne(1),new Date("02/07/2024")));
        data.add(new SubcriptionPlanCompany(36,new Date("02/01/2024"),new Date("04/20/2024"),_CompanyRepo.getOne(6),_SubcriptionPlanRepo.getOne(2),new Date("02/01/2024")));
        data.add(new SubcriptionPlanCompany(37,new Date("02/01/2023"),new Date("02/01/2024"),_CompanyRepo.getOne(7),_SubcriptionPlanRepo.getOne(4),new Date("02/01/2023")));
        data.add(new SubcriptionPlanCompany(38,new Date("01/01/2024"),new Date("03/20/2024"),_CompanyRepo.getOne(8),_SubcriptionPlanRepo.getOne(2),new Date("01/01/2024")));
        data.add(new SubcriptionPlanCompany(39,new Date("01/01/2024"),new Date("03/20/2024"),_CompanyRepo.getOne(9),_SubcriptionPlanRepo.getOne(2),new Date("01/01/2024")));
        data.add(new SubcriptionPlanCompany(40,new Date("03/07/2024"),new Date("06/17/2024"),_CompanyRepo.getOne(10),_SubcriptionPlanRepo.getOne(3),new Date("03/07/2024")));

        data.add(new SubcriptionPlanCompany(41,new Date("01/24/2023"),new Date("4/24/2023"),_CompanyRepo.getOne(10),_SubcriptionPlanRepo.getOne(3),new Date("01/24/2023")));
        data.add(new SubcriptionPlanCompany(42,new Date("01/24/2022"),new Date("01/24/2023"),_CompanyRepo.getOne(9),_SubcriptionPlanRepo.getOne(4),new Date("01/24/2022")));
        data.add(new SubcriptionPlanCompany(43,new Date("02/01/2023"),new Date("06/11/2023"),_CompanyRepo.getOne(8),_SubcriptionPlanRepo.getOne(3),new Date("02/01/2023")));
        data.add(new SubcriptionPlanCompany(44,new Date("01/07/2023"),new Date("02/07/2023"),_CompanyRepo.getOne(7),_SubcriptionPlanRepo.getOne(1),new Date("01/07/2023")));
        data.add(new SubcriptionPlanCompany(45,new Date("02/07/2023"),new Date("03/07/2023"),_CompanyRepo.getOne(6),_SubcriptionPlanRepo.getOne(1),new Date("02/07/2023")));
        data.add(new SubcriptionPlanCompany(46,new Date("02/01/2023"),new Date("04/20/2023"),_CompanyRepo.getOne(5),_SubcriptionPlanRepo.getOne(2),new Date("02/01/2023")));
        data.add(new SubcriptionPlanCompany(47,new Date("02/01/2023"),new Date("02/01/2023"),_CompanyRepo.getOne(4),_SubcriptionPlanRepo.getOne(4),new Date("02/01/2023")));
        data.add(new SubcriptionPlanCompany(48,new Date("01/01/2023"),new Date("03/20/2023"),_CompanyRepo.getOne(3),_SubcriptionPlanRepo.getOne(2),new Date("01/01/2023")));
        data.add(new SubcriptionPlanCompany(49,new Date("01/01/2023"),new Date("03/20/2023"),_CompanyRepo.getOne(2),_SubcriptionPlanRepo.getOne(2),new Date("01/01/2023")));
        data.add(new SubcriptionPlanCompany(50,new Date("01/07/2023"),new Date("02/07/2023"),_CompanyRepo.getOne(1),_SubcriptionPlanRepo.getOne(1),new Date("03/07/2023")));

        data.add(new SubcriptionPlanCompany(51,new Date("04/07/2024"),new Date("03/07/2024"),_CompanyRepo.getOne(1),_SubcriptionPlanRepo.getOne(1),new Date("04/07/2024")));
        data.add(new SubcriptionPlanCompany(52,new Date("05/07/2024"),new Date("04/07/2024"),_CompanyRepo.getOne(1),_SubcriptionPlanRepo.getOne(1),new Date("05/07/2024")));
        data.add(new SubcriptionPlanCompany(53,new Date("06/07/2024"),new Date("05/07/2024"),_CompanyRepo.getOne(1),_SubcriptionPlanRepo.getOne(1),new Date("06/07/2024")));
        data.add(new SubcriptionPlanCompany(54,new Date("02/07/2024"),new Date("03/07/2024"),_CompanyRepo.getOne(1),_SubcriptionPlanRepo.getOne(1),new Date("02/07/2024")));
        data.add(new SubcriptionPlanCompany(55,new Date("07/07/2024"),new Date("08/07/2024"),_CompanyRepo.getOne(1),_SubcriptionPlanRepo.getOne(1),new Date("07/07/2024")));


        return data;
    }
}
