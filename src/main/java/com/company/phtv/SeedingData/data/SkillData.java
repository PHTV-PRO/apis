package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.Industry;
import com.company.phtv.Models.Entity.Skill;

import java.util.ArrayList;
import java.util.List;

public class SkillData {
    public List<Skill> Data(){
        List<Skill> data = new ArrayList<>();
        data.add(new Skill(1,"HTML,CSS"
                ,new Industry(1)));
        data.add(new Skill(2,"JavaScript",
                new Industry(1)));
        data.add(new Skill(3,"React JS",
                new Industry(1)));
        data.add(new Skill(4,"UI-UX",
                new Industry(1)));
        data.add(new Skill(5,"Designer",
                new Industry(1)));
        data.add(new Skill(6,"Photoshop",
                new Industry(1)));
        data.add(new Skill(7,"FireBase",
                new Industry(1)));
        data.add(new Skill(8,"UI-UX Design",
                new Industry(2)));
        data.add(new Skill(9,"Product Design",
                new Industry(2)));
        data.add(new Skill(10,"Game Design",
                new Industry(2)));
        data.add(new Skill(11,"Illustrator",
                new Industry(2)));
        data.add(new Skill(12,"Web/Mobile",
                new Industry(2)));
        data.add(new Skill(13,"Unity",
                new Industry(1)));
        data.add(new Skill(13,"Java",
                new Industry(3)));
        data.add(new Skill(13,"C#",
                new Industry(3)));
        data.add(new Skill(16,"NodeJS",
                new Industry(3)));
        data.add(new Skill(17,"ASP.Net",
                new Industry(3)));
        data.add(new Skill(18,"Laravel",
                new Industry(3)));
        data.add(new Skill(19,"SQL Server",
                new Industry(3)));
        data.add(new Skill(20,"Oracle",
                new Industry(3)));
        data.add(new Skill(20,"Database",
                new Industry(3)));
        return data;
    }
}
