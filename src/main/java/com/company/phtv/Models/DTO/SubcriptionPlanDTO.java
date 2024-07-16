package com.company.phtv.Models.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubcriptionPlanDTO {
    private int id;
    private  String name;
    private Float price;
    private int expiry;
    private Date start_date;
    private Date end_date;

    private List<SubcriptionPlanCompanyDTO> subcriptionPlanCompanies;
}


