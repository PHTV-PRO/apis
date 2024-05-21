package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Models.Entity.CurriculumVitae;
import com.company.phtv.Models.Entity.FollowCompany;

import java.util.ArrayList;
import java.util.List;

public class CurriculumVitaeData {
    public List<CurriculumVitae> Data(){
        List<CurriculumVitae> data = new ArrayList<>();
        data.add(new CurriculumVitae(1,"tranbao.exel",new Account(1)));
        data.add(new CurriculumVitae(2,"anhmai.exel",new Account(2)));
        data.add(new CurriculumVitae(3,"leanhxuan.exel",new Account(3)));

        return data;
    }
}
