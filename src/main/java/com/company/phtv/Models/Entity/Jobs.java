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
@Table(name = "jobs")
public class Jobs extends BaseModel{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "reponsibility")
    private String reponsibility;
    @Column(name = "skill_required")
    private String skill_required;
    @Column(name = "benefit")
    private String benefit;
    @Column(name = "interview_steps")
    private String interview_steps;
    @Column(name = "amount")
    private int amount;
    @Column(name = "experience_required")
    private String experience_required;
    @Column(name = "salary_max")
    private String salary_max;
    @Column(name = "salary_min")
    private String salary_min;
    @Column(name = "start_date")
    private String start_date;
    @Column(name = "end_date")
    private String end_date;
    @Column(name = "is_active",nullable = false)
    private boolean is_active;
    @Column(name = "gender")
    private boolean gender;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "job_type_id")
    private JobType jobType;

    @OneToMany(mappedBy = "jobs", cascade = CascadeType.ALL)
    private List<Application> applications;

    @OneToMany(mappedBy = "jobs", cascade = CascadeType.ALL)
    private List<LevelJob> levelJobs;

    @OneToMany(mappedBy = "jobs", cascade = CascadeType.ALL)
    private List<FollowJob> followJobs;

    @OneToMany(mappedBy = "jobs", cascade = CascadeType.ALL)
    private List<SkillJob> skillJobs;

}
