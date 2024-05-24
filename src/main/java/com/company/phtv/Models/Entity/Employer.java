package com.company.phtv.Models.Entity;

import com.company.phtv.Enums.Role;
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
    @Column(name = "name",nullable = false)
    private String name="";
    @Column(name = "email",nullable = false)
    private String email="";
    @Column(name = "password",nullable = false)
    private String password="";
    @Column(name = "address",nullable = false)
    private String address="";
    @Column(name = "role")
    private Role role;

    @OneToOne(mappedBy = "employer")
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