package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.JobType;
import com.company.phtv.Models.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LocationRepo extends JpaRepository<Location,Integer> {
    @Query("select l from Location l Where id = ?1")
    Location findIdLocation(int id);


}
