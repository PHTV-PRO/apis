package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.CityProvince;

import java.util.ArrayList;
import java.util.List;

public class CityProvinceData {
    public List<CityProvince> Data() {
        List<CityProvince> data = new ArrayList<>();
        data.add(new CityProvince(1, "Hồ Chí Minh"));
        data.add(new CityProvince(2, "Hà Nội"));
        data.add(new CityProvince(3, "Hà Giang"));
        data.add(new CityProvince(4, "Lạng Sơn"));
        data.add(new CityProvince(5, "Vũng Tàu"));
        data.add(new CityProvince(6, "Lâm Đồng"));
        data.add(new CityProvince(7, "Cà Mau"));
        data.add(new CityProvince(8, "Cần Thơ"));
        data.add(new CityProvince(9, "Phú Quốc"));
        data.add(new CityProvince(10, "Hải Phòng"));
        return data;
    }
}
