package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.*;
import com.company.phtv.Repository.AccountRepo;
import com.company.phtv.Repository.CompanyRepo;

import java.util.ArrayList;
import java.util.List;

public class FollowCompanyData {
    private final AccountRepo _AccountRepo;
    private final CompanyRepo _CompanyRepo;

    public FollowCompanyData(AccountRepo _AccountRepo, CompanyRepo _CompanyRepo) {
        this._AccountRepo = _AccountRepo;
        this._CompanyRepo = _CompanyRepo;
    }

    @SuppressWarnings("deprecation")
    public List<FollowCompany> Data() {
        List<FollowCompany> data = new ArrayList<>();
        // Company 1
        data.add(new FollowCompany(1, _CompanyRepo.getOne(1), _AccountRepo.getAccountById(13)));
        data.add(new FollowCompany(2, _CompanyRepo.getOne(1), _AccountRepo.getAccountById(16)));
        data.add(new FollowCompany(3, _CompanyRepo.getOne(1), _AccountRepo.getAccountById(21)));
        data.add(new FollowCompany(4, _CompanyRepo.getOne(1), _AccountRepo.getAccountById(20)));
        data.add(new FollowCompany(5, _CompanyRepo.getOne(1), _AccountRepo.getAccountById(19)));
        data.add(new FollowCompany(6, _CompanyRepo.getOne(1), _AccountRepo.getAccountById(18)));

        return data;
    }
}
