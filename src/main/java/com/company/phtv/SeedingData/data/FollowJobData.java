package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.*;
import com.company.phtv.Repository.AccountRepo;
import com.company.phtv.Repository.JobRepo;

import java.util.ArrayList;
import java.util.List;

public class FollowJobData {
    private final AccountRepo _AccountRepo;
    private final JobRepo _JobRepo;

    public FollowJobData(AccountRepo _AccountRepo, JobRepo _JobRepo) {
        this._AccountRepo = _AccountRepo;
        this._JobRepo = _JobRepo;
    }

    @SuppressWarnings("deprecation")
    public List<FollowJob> Data() {
        List<FollowJob> data = new ArrayList<>();
        data.add(new FollowJob(1, _JobRepo.getOne(1), _AccountRepo.getAccountById(1)));
        data.add(new FollowJob(2, _JobRepo.getOne(2), _AccountRepo.getAccountById(2)));
        data.add(new FollowJob(3, _JobRepo.getOne(3), _AccountRepo.getAccountById(3)));

        return data;
    }
}
