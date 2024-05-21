package com.company.phtv.Models.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "industry")
public class Industry {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",nullable = false)
    private String name;

    @OneToMany(mappedBy = "industry", cascade = CascadeType.ALL)
    private Set<Skill> skills;

    public Industry(int id,String name) {
        this.id = id;
        this.name = name;
    }
    public Industry(int id) {
        this.id = id;
    }
}
