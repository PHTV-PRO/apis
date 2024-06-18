package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepo extends JpaRepository<Company,Integer> {
    @Query("select c from Company c Where  c.id = ?1")
    Company findCompanyById(int id);
}
