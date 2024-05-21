package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location,Integer> {
}
