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
        data.add(new FollowJob(1, _JobRepo.getOne(5), _AccountRepo.getAccountById(1)));
        data.add(new FollowJob(2, _JobRepo.getOne(6), _AccountRepo.getAccountById(2)));
        data.add(new FollowJob(3, _JobRepo.getOne(7), _AccountRepo.getAccountById(3)));
        data.add(new FollowJob(4, _JobRepo.getOne(8), _AccountRepo.getAccountById(4)));
        data.add(new FollowJob(5, _JobRepo.getOne(9), _AccountRepo.getAccountById(5)));
        data.add(new FollowJob(6, _JobRepo.getOne(10), _AccountRepo.getAccountById(6)));
        data.add(new FollowJob(7, _JobRepo.getOne(5), _AccountRepo.getAccountById(7)));
        data.add(new FollowJob(8, _JobRepo.getOne(6), _AccountRepo.getAccountById(8)));
        data.add(new FollowJob(9, _JobRepo.getOne(7), _AccountRepo.getAccountById(9)));
        data.add(new FollowJob(10, _JobRepo.getOne(8), _AccountRepo.getAccountById(10)));

        return data;
    }
}
