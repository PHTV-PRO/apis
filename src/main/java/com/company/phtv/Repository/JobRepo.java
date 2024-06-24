package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Jobs;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JobRepo extends JpaRepository<Jobs,Integer> {
    @Query("select j from Jobs j Where  id = ?1")
    Jobs findJobId(int id);
    @Query("SELECT j FROM Jobs j WHERE j.start_date < :currentDate ORDER BY j.start_date DESC")
    List<Jobs> findAllByStartDateBefore(@Param("currentDate") Date currentDate);

    List<Jobs> findJobByTitleContaining(String title);
}
