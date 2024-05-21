package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company,Integer> {
}
