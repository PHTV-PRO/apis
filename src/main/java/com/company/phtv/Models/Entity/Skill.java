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
@Table(name = "skill")
public class Skill extends BaseModel{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "industry_id")
    private Industry industry;

    @OneToMany(mappedBy = "skills", cascade = CascadeType.ALL)
    private List<SkillJob> skillJobs;

    @OneToMany(mappedBy = "skills", cascade = CascadeType.ALL)
    private List<SkillCompany> skillCompanies;
}
