package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepo extends JpaRepository<Application,Integer> {
}
