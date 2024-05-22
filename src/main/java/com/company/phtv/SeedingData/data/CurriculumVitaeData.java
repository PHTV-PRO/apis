package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.CurriculumVitae;
import com.company.phtv.Repository.AccountRepo;

import java.util.ArrayList;
import java.util.List;

public class CurriculumVitaeData {
    private final AccountRepo _AccountRepo;

    public CurriculumVitaeData(AccountRepo _AccountRepo) {
        this._AccountRepo = _AccountRepo;
    }

    public List<CurriculumVitae> Data() {
        List<CurriculumVitae> data = new ArrayList<>();
        data.add(new CurriculumVitae(1, "tranbao.exel", _AccountRepo.getAccountById(1)));
        data.add(new CurriculumVitae(2, "anhmai.exel", _AccountRepo.getAccountById(2)));
        data.add(new CurriculumVitae(3, "leanhxuan.exel", _AccountRepo.getAccountById(3)));

        return data;
    }
}
