package com.company.phtv.Models.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company")
public class Company extends BaseModel{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "introduction")
    private String introduction;
    @Column(name = "benefit")
    private String benefit;
    @Column(name="profession")
    private String profession;
    @Column(name="size_min")
    private String size_min;
    @Column(name="size_max")
    private String size_max;
    @Column(name="skill")
    private String skill;
    @Column(name="link_website")
    private String link_website;
    @Column(name="nationnality")
    private String nationnality;
    @Column(name = "logo_image")
    private String logo_image;
    @Column(name = "background_image")
    private String background_image;
    @Column(name = "enable")
    private int enable;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<ImageCompany> imageCompany;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<FollowCompany> followCompany;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Jobs> jobs;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Location> locations;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<SkillCompany> skillCompanies;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<SubcriptionPlanCompany> subcritionPlanCompanies;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Notification> notifications;

    public Company(int id) {
        this.id = id;
    }
}
