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
@Table(name = "subscription_plan")
public class SubcriptionPlan extends BaseModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",nullable = false)
    private String name="";
    @Column(name = "price")
    private Float price;
    @Column(name = "expiry")
    private int expiry;

    @OneToMany(mappedBy = "subscription_plan", cascade = CascadeType.ALL)
    private List<SubcriptionPlanCompany> subcritionPlanCompanies;

    public SubcriptionPlan(int id) {
        this.id = id;
    }

    public SubcriptionPlan(int id, String name, Float price, int expiry) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expiry = expiry;
    }
}
