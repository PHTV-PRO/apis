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
        data.add(new FollowCompany(1, _CompanyRepo.getOne(3), _AccountRepo.getAccountById(1)));
        data.add(new FollowCompany(2, _CompanyRepo.getOne(2), _AccountRepo.getAccountById(2)));
        data.add(new FollowCompany(3, _CompanyRepo.getOne(1), _AccountRepo.getAccountById(3)));
        return data;
    }
}
