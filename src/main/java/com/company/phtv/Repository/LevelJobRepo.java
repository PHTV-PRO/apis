package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Jobs;
import com.company.phtv.Models.Entity.Level;
import com.company.phtv.Models.Entity.LevelJob;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LevelJobRepo extends JpaRepository<LevelJob,Integer> {
    @Query("select j from LevelJob j Where j.jobs= :job and j.level = :level ")
    LevelJob findByJobAndLevel(@Param("job") Jobs getJob,@Param("level") Level l);
    @Query("select j from LevelJob j Where j.jobs= :job  ")
    List<LevelJob> findByJob(@Param("job") Jobs getJob);
}
