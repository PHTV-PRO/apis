package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Models.Entity.FollowCompany;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FollowCompanyRepo extends JpaRepository<FollowCompany,Integer> {

    @Query("select v from FollowCompany v Where  account = :account and company = :company ORDER BY v.created_at DESC")
    FollowCompany findByAccountAndCompany(Account account, Company company);

    @Query("select v from FollowCompany v Where  account = :account  ORDER BY v.created_at DESC")
    List<FollowCompany> findByAccount(Account account);
}
