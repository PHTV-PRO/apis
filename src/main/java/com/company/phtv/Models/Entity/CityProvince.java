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
@Table(name = "city_province")
public class CityProvince extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "city_provence", cascade = CascadeType.ALL)
    private List<Location> location;

    public CityProvince(int id) {
        this.id = id;
    }

    public CityProvince(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
