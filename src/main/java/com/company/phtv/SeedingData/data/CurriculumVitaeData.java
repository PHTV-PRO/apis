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
        data.add(new CurriculumVitae(1, "leminhman.exel","Fresher", _AccountRepo.getAccountById(1)));
        data.add(new CurriculumVitae(2, "leminhminh.exel","Senior", _AccountRepo.getAccountById(2)));
        data.add(new CurriculumVitae(3, "trandainghia.exel","intern", _AccountRepo.getAccountById(1)));
        data.add(new CurriculumVitae(4, "nguyenngoctram.exel","mycv", _AccountRepo.getAccountById(8)));
        data.add(new CurriculumVitae(5, "lediemmy.exel","cv for tomorrow", _AccountRepo.getAccountById(9)));
        data.add(new CurriculumVitae(6, "lethanhdat.exel","CV", _AccountRepo.getAccountById(10)));
        return data;
    }
}
