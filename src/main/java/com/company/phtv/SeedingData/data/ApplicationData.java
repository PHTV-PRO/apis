package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.*;
import com.company.phtv.Repository.AccountRepo;
import com.company.phtv.Repository.CurriculumRepo;
import com.company.phtv.Repository.JobRepo;

import java.util.ArrayList;
import java.util.List;

public class ApplicationData {

    private final AccountRepo _AccountRepo;
    private final JobRepo _JobRepo;
    private final CurriculumRepo _CurriculumRepo;

    public ApplicationData(AccountRepo _AccountRepo, JobRepo _JobRepo, CurriculumRepo _CurriculumRepo) {
        this._AccountRepo = _AccountRepo;
        this._JobRepo = _JobRepo;
        this._CurriculumRepo = _CurriculumRepo;
    }

    @SuppressWarnings("deprecation")
    public List<Application> Data() {
        List<Application> data = new ArrayList<>();
        data.add(new Application(1, "Hello", _AccountRepo.getAccountById(1), _JobRepo.getOne(1),
                _CurriculumRepo.getOne(1)));
        data.add(new Application(2, "Hi", _AccountRepo.getAccountById(2), _JobRepo.getOne(2),
                _CurriculumRepo.getOne(2)));
        data.add(new Application(3, "Say Hi", _AccountRepo.getAccountById(3), _JobRepo.getOne(3),
                _CurriculumRepo.getOne(3)));
        return data;
    }
}
