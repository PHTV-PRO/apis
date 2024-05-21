package com.company.phtv.Models.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "subcription_plan_company")
public class SubcriptionPlanCompany extends BaseModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "start_date")
    private Date start_date;
    @Column(name = "end_date")
    private Date end_date;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription_plan_id")
    private SubcriptionPlan subscription_plan;

    public SubcriptionPlanCompany(int id, Date start_date, Date end_date, Company company, SubcriptionPlan subscription_plan) {
        this.id = id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.company = company;
        this.subscription_plan = subscription_plan;
    }
}
