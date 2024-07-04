package com.company.phtv.Models.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.Text;

import java.nio.CharBuffer;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company")
public class Company extends BaseModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private String name = "";
    @Column(name = "introduction", columnDefinition = "TEXT")
    private String introduction;
    @Column(name = "benefit", columnDefinition = "TEXT")
    private String benefit;
    @Column(name = "profession", columnDefinition = "TEXT")
    private String profession;
    @Column(name = "size_min")
    private String size_min;
    @Column(name = "size_max")
    private String size_max;
    // @Column(name = "skill")
    // private String skill;
    @Column(name = "link_website")
    private String link_website;
    @Column(name = "nationnality")
    private String nationnality;
    @Column(name = "logo_image")
    private String logo_image;
    @Column(name = "background_image")
    private String background_image;
    @Column(name = "enable")
    private int enable;
    @Column(name = "contract")
    private int contract;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<ImageCompany> imageCompany;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<FollowCompany> followCompany;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Jobs> jobs;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Location> locations;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<SubcriptionPlanCompany> subcritionPlanCompanies;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Notification> notifications;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<SkillCompany> skillCompanies;

    public Company(int id) {
        this.id = id;
    }

    public Company(int id, String name, String introduction, String benefit, String profession, String size_min,
            String size_max,  String link_website, String nationnality, String logo_image,
            String background_image, int enable, int contract, Account account) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.benefit = benefit;
        this.profession = profession;
        this.size_min = size_min;
        this.size_max = size_max;
        // this.skill = skill;
        this.link_website = link_website;
        this.nationnality = nationnality;
        this.logo_image = logo_image;
        this.background_image = background_image;
        this.enable = enable;
        this.contract = contract;
        this.account = account;
    }
}
