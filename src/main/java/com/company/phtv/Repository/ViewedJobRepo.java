package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.ViewedJob;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ViewedJobRepo extends JpaRepository<ViewedJob, Integer> {
    @Query("select v from ViewedJob v Where  account = :account ORDER BY v.created_at DESC")
    List<ViewedJob> findJobByAccount(@Param("account") Account acc);
}
