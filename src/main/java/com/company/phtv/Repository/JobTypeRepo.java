package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobTypeRepo extends JpaRepository<JobType,Integer> {
    @Query("select j from JobType j Where id = ?1 ORDER BY v.created_at DESC")
    JobType findIdJobType(int id);

}
