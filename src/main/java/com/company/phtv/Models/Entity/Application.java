package com.company.phtv.Models.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "application")
public class Application extends BaseModel{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "note")
    private String note;



    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id")
    private Jobs jobs;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cv_id")
    private CurriculumVitae curriculumVitae;

    public Application(int id, String note, Account account, Jobs jobs, CurriculumVitae curriculumVitae) {
        this.id = id;
        this.note = note;
        this.account = account;
        this.jobs = jobs;
        this.curriculumVitae = curriculumVitae;
    }
}
