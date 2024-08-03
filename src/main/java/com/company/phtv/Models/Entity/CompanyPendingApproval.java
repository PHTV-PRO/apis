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
@AllArgsConstructor
@Table(name = "company_pending_approval")
public class CompanyPendingApproval extends BaseModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    // need
    private String name = "";
    @Column(name = "introduction", columnDefinition = "TEXT")
    private String introduction;
    @Column(name = "benefit", columnDefinition = "TEXT")
    private String benefit;
    @Column(name = "profession", columnDefinition = "TEXT")
    private String profession;
    @Column(name = "size")
    private String size;
    @Column(name = "link_website")
    private String link_website;
    @Column(name = "nationnality")
    // need
    private String nationnality;
    @Column(name = "logo_image")
    // need
    private String logo_image;
    @Column(name = "background_image")
    private String background_image;
    @Column(name = "list_image", columnDefinition = "TEXT")
    private String list_image;
    @Column(name = "enable")
    private int enable;

    @Column(name = "account_id")
    private int account_id;

}
