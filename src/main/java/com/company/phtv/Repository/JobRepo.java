package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Jobs;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.company.phtv.Models.Entity.FollowJob;


public interface JobRepo extends JpaRepository<Jobs,Integer> {

    @Query("SELECT j FROM Jobs j WHERE (:lotId is null or j.location.id = :lotId ) and (:indId is null or j.jobType.id = :indId ) ORDER BY j.start_date")
    List<Jobs> getAllJob(@Param("lotId") Long lotId, @Param("indId") Long indId);
    @Query("select j from Jobs j Where  j.id = ?1 ORDER BY j.created_at")
    Jobs findJobId(int id);
    @Query("SELECT j FROM Jobs j WHERE j.start_date < :currentDate ORDER BY j.start_date DESC")
    List<Jobs> findAllByStartDateBefore(@Param("currentDate") Date currentDate);

    List<Jobs> findJobByTitleContaining(String title);
    List<Jobs> findByFollowJobs(List<FollowJob> followJobs);
}
