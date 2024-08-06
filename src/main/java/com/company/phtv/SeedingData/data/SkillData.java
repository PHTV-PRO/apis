package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.Skill;
import com.company.phtv.Repository.IndustryRepo;

import java.util.ArrayList;
import java.util.List;

public class SkillData {
        private final IndustryRepo _IndustryRepo;

        public SkillData(IndustryRepo _IndustryRepo) {
                this._IndustryRepo = _IndustryRepo;
        }

        @SuppressWarnings("deprecation")
        public List<Skill> Data() {
                List<Skill> data = new ArrayList<>();
                data.add(new Skill(1, "HTML,CSS",
                                _IndustryRepo.getOne(1)));
                data.add(new Skill(2, "JavaScript",
                                _IndustryRepo.getOne(1)));
                data.add(new Skill(3, "React JS",
                                _IndustryRepo.getOne(1)));
                data.add(new Skill(4, "UI-UX",
                                _IndustryRepo.getOne(1)));
                data.add(new Skill(5, "Designer",
                                _IndustryRepo.getOne(1)));
                data.add(new Skill(6, "Photoshop",
                                _IndustryRepo.getOne(1)));
                data.add(new Skill(7, "FireBase",
                                _IndustryRepo.getOne(1)));
                data.add(new Skill(8, "UI-UX Design",
                                _IndustryRepo.getOne(2)));
                data.add(new Skill(9, "Product Design",
                                _IndustryRepo.getOne(2)));
                data.add(new Skill(10, "Game Design",
                                _IndustryRepo.getOne(2)));
                data.add(new Skill(11, "Illustrator",
                                _IndustryRepo.getOne(2)));
                data.add(new Skill(12, "Web/Mobile",
                                _IndustryRepo.getOne(2)));
                data.add(new Skill(13, "Unity",
                                _IndustryRepo.getOne(1)));
                data.add(new Skill(14, "Java",
                                _IndustryRepo.getOne(3)));
                data.add(new Skill(15, "C#",
                                _IndustryRepo.getOne(3)));
                data.add(new Skill(16, "NodeJS",
                                _IndustryRepo.getOne(3)));
                data.add(new Skill(17, "ASP.Net",
                                _IndustryRepo.getOne(3)));
                data.add(new Skill(18, "Laravel",
                                _IndustryRepo.getOne(3)));
                data.add(new Skill(19, "SQL Server",
                                _IndustryRepo.getOne(3)));
                data.add(new Skill(20, "Oracle",
                                _IndustryRepo.getOne(3)));
                data.add(new Skill(21, "Database",
                                _IndustryRepo.getOne(3)));
                data.add(new Skill(22, "Kotlin",
                        _IndustryRepo.getOne(12)));
                data.add(new Skill(23, "Android",
                        _IndustryRepo.getOne(12)));
                data.add(new Skill(24, "English",
                        _IndustryRepo.getOne(17)));
                data.add(new Skill(25, "Technology Support",
                        _IndustryRepo.getOne(17)));
                data.add(new Skill(26, "IT Support",
                        _IndustryRepo.getOne(14)));
                data.add(new Skill(27, "IT Operations",
                        _IndustryRepo.getOne(14)));
                data.add(new Skill(28, "Software Development",
                        _IndustryRepo.getOne(14)));
                return data;
        }
}
