package com.company.phtv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.phtv.Models.Entity.CompanyPendingApproval;

public interface CompanyPendingApprovalRepo extends JpaRepository<CompanyPendingApproval, Integer> {

}
