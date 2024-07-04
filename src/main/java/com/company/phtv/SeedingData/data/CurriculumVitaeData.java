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
        data.add(new CurriculumVitae(1, "leminhman.exel", _AccountRepo.getAccountById(5)));
        data.add(new CurriculumVitae(2, "leminhminh.exel", _AccountRepo.getAccountById(6)));
        data.add(new CurriculumVitae(3, "trandainghia.exel", _AccountRepo.getAccountById(7)));
        data.add(new CurriculumVitae(4, "nguyenngoctram.exel", _AccountRepo.getAccountById(8)));
        data.add(new CurriculumVitae(5, "lediemmy.exel", _AccountRepo.getAccountById(9)));
        data.add(new CurriculumVitae(6, "lethanhdat.exel", _AccountRepo.getAccountById(10)));
        return data;
    }
}
