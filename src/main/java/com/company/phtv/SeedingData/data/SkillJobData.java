package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.Industry;
import com.company.phtv.Models.Entity.Jobs;
import com.company.phtv.Models.Entity.Skill;
import com.company.phtv.Models.Entity.SkillJob;

import java.util.ArrayList;
import java.util.List;

public class SkillJobData {
    public List<SkillJob> Data(){
        List<SkillJob> data = new ArrayList<>();
        data.add(new SkillJob(1, new Skill(4),new Jobs(1)));
        data.add(new SkillJob(2, new Skill(5),new Jobs(1)));
        data.add(new SkillJob(3, new Skill(6),new Jobs(1)));
        data.add(new SkillJob(4, new Skill(8),new Jobs(1)));
        data.add(new SkillJob(5, new Skill(3),new Jobs(2)));
        data.add(new SkillJob(6, new Skill(21),new Jobs(2)));
        data.add(new SkillJob(7, new Skill(13),new Jobs(2)));
        data.add(new SkillJob(8, new Skill(1),new Jobs(2)));
        data.add(new SkillJob(9, new Skill(1),new Jobs(2)));
        data.add(new SkillJob(10, new Skill(1),new Jobs(2)));

        return data;
    }
}
