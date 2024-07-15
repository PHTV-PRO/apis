package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Models.Entity.CurriculumVitae;
import com.company.phtv.Models.Entity.ImageCompany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CompanyImageRepo extends JpaRepository<ImageCompany,Integer> {
    @Query("select j from ImageCompany j  Where j.company =:company ORDER BY j.created_at DESC")
    List<ImageCompany> findByCompany(@Param("company") Company company);
}
