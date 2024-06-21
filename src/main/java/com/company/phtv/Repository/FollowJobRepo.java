package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.FollowJob;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FollowJobRepo extends JpaRepository<FollowJob, Integer> {
    @Query("select j from FollowJob j Where  j.account = :account_id ORDER BY j.created_at DESC")
    List<FollowJob> findJobByUserId(@Param("account_id") Account acc);
}
