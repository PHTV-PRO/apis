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
    private String size_min;
    private String size_max;
    // private String skill;
    private String link_website;
    private String nationnality;
    private String logo_image;
    private String background_image;
    private int enable;
    private int contract;

    private int opening_jobs;

    private AccountDTO account;
    private List<LocationDTO> locations;
    private List<JobDTO> jobs;
    private List<SkillDTO> skills;

}
