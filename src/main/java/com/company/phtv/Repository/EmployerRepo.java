package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepo extends JpaRepository<Employer,Integer> {
}
