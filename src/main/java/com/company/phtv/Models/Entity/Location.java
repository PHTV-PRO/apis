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
@Table(name = "location")
public class Location extends BaseModel{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",nullable = false)
    private String name="";

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_provence_id")
    private CityProvince city_provence;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Jobs> jobs;

    public Location(int id) {
        this.id = id;
    }

    public Location(int id, String name, Company company, CityProvince city_provence) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.city_provence = city_provence;
    }



}
