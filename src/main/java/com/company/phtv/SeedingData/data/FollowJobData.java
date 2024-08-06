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
        data.add(new FollowJob(1, _JobRepo.getOne(5), _AccountRepo.getAccountById(12)));
        data.add(new FollowJob(2, _JobRepo.getOne(6), _AccountRepo.getAccountById(13)));
        data.add(new FollowJob(3, _JobRepo.getOne(7), _AccountRepo.getAccountById(14)));
        data.add(new FollowJob(4, _JobRepo.getOne(8), _AccountRepo.getAccountById(15)));
        data.add(new FollowJob(5, _JobRepo.getOne(9), _AccountRepo.getAccountById(16)));
        data.add(new FollowJob(6, _JobRepo.getOne(10), _AccountRepo.getAccountById(17)));
        data.add(new FollowJob(7, _JobRepo.getOne(1), _AccountRepo.getAccountById(18)));
        data.add(new FollowJob(8, _JobRepo.getOne(2), _AccountRepo.getAccountById(19)));
        data.add(new FollowJob(9, _JobRepo.getOne(3), _AccountRepo.getAccountById(20)));
        data.add(new FollowJob(10, _JobRepo.getOne(4), _AccountRepo.getAccountById(21)));

        data.add(new FollowJob(11, _JobRepo.getOne(11), _AccountRepo.getAccountById(12)));
        data.add(new FollowJob(12, _JobRepo.getOne(12), _AccountRepo.getAccountById(13)));
        data.add(new FollowJob(13, _JobRepo.getOne(13), _AccountRepo.getAccountById(14)));
        data.add(new FollowJob(14, _JobRepo.getOne(14), _AccountRepo.getAccountById(15)));
        data.add(new FollowJob(15, _JobRepo.getOne(15), _AccountRepo.getAccountById(16)));
        data.add(new FollowJob(16, _JobRepo.getOne(16), _AccountRepo.getAccountById(17)));
        data.add(new FollowJob(17, _JobRepo.getOne(17), _AccountRepo.getAccountById(18)));
        data.add(new FollowJob(18, _JobRepo.getOne(18), _AccountRepo.getAccountById(19)));
        data.add(new FollowJob(19, _JobRepo.getOne(19), _AccountRepo.getAccountById(20)));
        data.add(new FollowJob(20, _JobRepo.getOne(20), _AccountRepo.getAccountById(21)));


        data.add(new FollowJob(21, _JobRepo.getOne(21), _AccountRepo.getAccountById(12)));
        data.add(new FollowJob(22, _JobRepo.getOne(22), _AccountRepo.getAccountById(13)));
        data.add(new FollowJob(23, _JobRepo.getOne(23), _AccountRepo.getAccountById(14)));
        data.add(new FollowJob(24, _JobRepo.getOne(24), _AccountRepo.getAccountById(15)));
        data.add(new FollowJob(25, _JobRepo.getOne(25), _AccountRepo.getAccountById(16)));
        data.add(new FollowJob(26, _JobRepo.getOne(26), _AccountRepo.getAccountById(17)));
        data.add(new FollowJob(27, _JobRepo.getOne(27), _AccountRepo.getAccountById(18)));
        data.add(new FollowJob(28, _JobRepo.getOne(28), _AccountRepo.getAccountById(19)));
        data.add(new FollowJob(29, _JobRepo.getOne(29), _AccountRepo.getAccountById(20)));
        data.add(new FollowJob(30, _JobRepo.getOne(30), _AccountRepo.getAccountById(21)));

        return data;
    }
}
