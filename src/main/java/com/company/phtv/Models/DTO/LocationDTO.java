package com.company.phtv.Models.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTO {
    private int id;
    private  String name;
    private CompanyDTO company;
    private CityProvinceDTO cityProvince;
}
