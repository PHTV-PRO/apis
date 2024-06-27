package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SkillRepo extends JpaRepository<Skill,Integer> {
    @Query("select s from Skill s Where s.id = ?1 ORDER BY v.created_at DESC")
    Skill findIdSkill(int id);
}
