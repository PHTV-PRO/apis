package com.company.phtv.Models.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "curriculum_vitae")
public class CurriculumVitae extends BaseModel{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "file_name")
    private String file_name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToOne(mappedBy = "curriculumVitae")
    private Application application;

    public CurriculumVitae(int id) {
        this.id = id;
    }

    public CurriculumVitae(int id, String file_name, Account account ) {
        this.id = id;
        this.file_name = file_name;
        this.account = account;

    }
}
