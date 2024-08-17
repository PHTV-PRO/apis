package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Models.Entity.SkillCompany;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SkillCompanyRepo extends JpaRepository<SkillCompany,Integer> {
    @Query("select j from SkillCompany j Where j.company= :company ")
    List<SkillCompany> findByCompany(@Param("company")Company company);
}
