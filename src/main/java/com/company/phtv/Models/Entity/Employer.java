package com.company.phtv.Models.Entity;

import com.company.phtv.Enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employer")
public class Employer extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",nullable = true)
    private String name="";
    @Column(name = "email",nullable = true)
    private String email="";
    @Column(name = "password",nullable = true)
    private String password="";
    @Column(name = "address",nullable = true)
    private String address="";
    @Column(name = "role")
    private Role role;

    @OneToOne(mappedBy = "employer")
    @JsonIgnore
    private Company company;

    public Employer(int id) {
        this.id = id;
    }

    public Employer(int id, String name, String email, String password, String address, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.role = role;

    }
}
