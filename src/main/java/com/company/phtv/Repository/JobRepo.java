package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Models.Entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobRepo extends JpaRepository<Jobs,Integer> {
    @Query("select j from Jobs j Where  id = ?1")
    Jobs findJobId(int id);
}
