package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.JobType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTypeRepo extends JpaRepository<JobType,Integer> {
}
