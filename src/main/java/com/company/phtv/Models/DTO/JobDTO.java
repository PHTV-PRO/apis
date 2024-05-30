package com.company.phtv.Models.DTO;

import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Models.Entity.JobType;
import com.company.phtv.Models.Entity.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobDTO {
    private int id;
    private  String title;
    private  String description;
    private  String reponsibility;
    private  String skill_required;
    private  String benefit;
    private  String interview_steps;
    private  int amount;
    private  String experience_required;
    private  String salary_max;
    private  String salary_min;
    private  String start_date;
    private  String end_date;
    private  boolean is_active;
    private  int gender;

    private CompanyDTO company;
    private LocationDTO location;
    private JobTypeDTO jobType;
}
