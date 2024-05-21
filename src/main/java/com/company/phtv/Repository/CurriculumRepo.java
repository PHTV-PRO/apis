package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.CurriculumVitae;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculumRepo extends JpaRepository<CurriculumVitae,Integer> {
}
