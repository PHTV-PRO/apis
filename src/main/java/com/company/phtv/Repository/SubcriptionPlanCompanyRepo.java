package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.SubcriptionPlan;
import com.company.phtv.Models.Entity.SubcriptionPlanCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubcriptionPlanCompanyRepo extends JpaRepository<SubcriptionPlanCompany,Integer> {
    @Query("select sc from SubcriptionPlanCompany sc Where sc.id = ?1 ORDER BY sc.created_at DESC")
    SubcriptionPlanCompany findIdBySubcriptionPlanCompany(int id);
}
