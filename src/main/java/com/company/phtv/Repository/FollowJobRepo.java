package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.FollowJob;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FollowJobRepo extends JpaRepository<FollowJob, Integer> {
     @Query("select v from FollowJob v Where  account = :account ORDER BY v.created_at DESC")
    List<FollowJob> findJobByAccount(@Param("account") Account acc);
}
