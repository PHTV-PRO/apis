package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Industry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface IndustryRepo extends JpaRepository<Industry,Integer> {
    @Query("select i from Industry i Where id = ?1")
    Industry findIdIndustry(int id);
}
