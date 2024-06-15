package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.ViewedJob;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewedJobRepo extends JpaRepository<ViewedJob, Integer> {
}
