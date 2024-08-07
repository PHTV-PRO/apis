package com.company.phtv.Models.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {
    private int id;
    private String name;
    private String introduction;
    private String benefit;
    private String profession;
    private String size;
        // private String skill;
    private String link_website;
    private String nationnality;
    private String logo_image;
    private String background_image;
    private String list_image;
    private List<String> list_image_mobile ;
    private int enable;
    private int contract;
    private  boolean company_is_save =false;


    private int opening_jobs;

    private AccountDTO account;
    private SubcriptionPlanDTO subcriptionPlan;

    private String location;
    private List<JobDTO> jobs;
    private CityProvinceDTO city_provence;
    private List<SkillDTO> skills;

}
