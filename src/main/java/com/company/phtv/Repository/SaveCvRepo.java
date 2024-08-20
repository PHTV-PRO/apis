package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Application;
import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Models.Entity.SaveCV;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface SaveCvRepo extends JpaRepository<SaveCV, Integer> {
    @Query("select j from SaveCV j  Where j.company =:company and j.application =:application ORDER BY j.created_at DESC")
    SaveCV findByCompanyAndCv(@Param("company") Company company, @Param("application") Application application);

    @Query("select j from SaveCV j  Where j.company =:company ORDER BY j.created_at DESC")
    List<SaveCV> findAllByCompany(Company company);
}
