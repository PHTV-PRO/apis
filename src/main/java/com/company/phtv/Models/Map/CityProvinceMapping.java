package com.company.phtv.Models.Map;

import com.company.phtv.Models.DTO.CityProvinceDTO;
import com.company.phtv.Models.Entity.CityProvince;
import com.company.phtv.Models.Request.RequestCityProvince;

public class CityProvinceMapping {

    public static CityProvinceDTO cityProvinceDTO(CityProvince ci){
        CityProvinceDTO cityProvinceDTO = new CityProvinceDTO();
        cityProvinceDTO.setId(ci.getId());
        cityProvinceDTO.setName(ci.getName());
        return cityProvinceDTO;
    }

    public static CityProvince cityProvince(RequestCityProvince rq){
        CityProvince cityProvince = new CityProvince();
        cityProvince.setName(rq.getName());
        return cityProvince;
    }

    public static  CityProvince CityProvincePut(RequestCityProvince rq,CityProvince ci){
        if(rq.getName() != null){
            ci.setName(rq.getName());
        }
        return  ci;
    }
}
