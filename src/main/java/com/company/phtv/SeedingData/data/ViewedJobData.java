package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.*;
import com.company.phtv.Repository.AccountRepo;
import com.company.phtv.Repository.JobRepo;

import java.util.ArrayList;
import java.util.List;

public class ViewedJobData {
    private final AccountRepo _AccountRepo;
    private final JobRepo _JobRepo;

    public ViewedJobData(AccountRepo _AccountRepo, JobRepo _JobRepo) {
        this._AccountRepo = _AccountRepo;
        this._JobRepo = _JobRepo;
    }

    @SuppressWarnings("deprecation")
    public List<ViewedJob> Data() {
        List<ViewedJob> data = new ArrayList<>();
        data.add(new ViewedJob(1, _JobRepo.getOne(1), _AccountRepo.getAccountById(1)));
        data.add(new ViewedJob(2, _JobRepo.getOne(2), _AccountRepo.getAccountById(2)));
        data.add(new ViewedJob(3, _JobRepo.getOne(3), _AccountRepo.getAccountById(3)));
        data.add(new ViewedJob(4, _JobRepo.getOne(3), _AccountRepo.getAccountById(1)));

        return data;
    }
}
