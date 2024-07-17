package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Jobs;
import com.company.phtv.Models.Entity.Skill;
import com.company.phtv.Models.Entity.SkillJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SkillJobRepo extends JpaRepository<SkillJob,Integer> {
    @Query("select j from SkillJob j Where j.jobs= :job and j.skills = :skill ")
    SkillJob findByJobAndSkill(@Param("job")Jobs job,@Param("skill") Skill skill);
}
