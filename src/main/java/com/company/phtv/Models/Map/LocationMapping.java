package com.company.phtv.Models.Map;

import com.company.phtv.Models.DTO.CompanyDTO;
import com.company.phtv.Models.DTO.LocationDTO;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.CityProvince;
import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Models.Entity.Location;
import com.company.phtv.Models.Request.RequestCompany;
import com.company.phtv.Models.Request.RequestLocation;

public class LocationMapping {
    public static LocationDTO LocationDTO(Location l) {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(l.getId());
        locationDTO.setName(l.getName());
        locationDTO.setCityProvince(CityProvinceMapping.cityProvinceDTO(l.getCity_provence()));
        locationDTO.setCompany(CompanyMapping.CompanyDTO(l.getCompany()));
        return locationDTO;
    }

    public static Location LocationPost(RequestLocation l) {
        Location location = new Location();
        location.setName(l.getName());
        return location;
    }

    public static Location LocationPut(RequestLocation rl, Location l) {
        if (rl.getName() != null) {
            l.setName(rl.getName());
        }
        if (rl.getCompany_id() != 0) {
            l.setCompany(new Company(0));
        }
        if (rl.getCity_provence_id() != 0) {
            l.setCity_provence(new CityProvince(0));
        }
        return l;
    }
}
