package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepo extends JpaRepository<Jobs,Integer> {
}
