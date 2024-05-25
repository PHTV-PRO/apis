package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface LevelRepo extends JpaRepository<Level,Integer> {
    @Query("select l from Level l Where id = ?1")
    Level findIdByLevel(int id);
}
