package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.CityProvince;

import java.util.ArrayList;
import java.util.List;

public class CityProvinceData {
    public List<CityProvince> Data() {
        List<CityProvince> data = new ArrayList<>();
        data.add(new CityProvince(1, "Thành Phố Hồ Chí Minh"));
        data.add(new CityProvince(2, "Hà Nội"));

        return data;
    }
}
