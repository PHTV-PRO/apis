package com.company.phtv.Services.IServices;

import com.company.phtv.Models.DTO.CityProvinceDTO;
import com.company.phtv.Models.Request.RequestCityProvince;

import java.util.List;

public interface ICityProviceService {
    List<CityProvinceDTO> GetAll();
    CityProvinceDTO Create(RequestCityProvince requestCityProvince);
    CityProvinceDTO Put(int id, RequestCityProvince requestCityProvince);

    CityProvinceDTO Delete(int id);
    CityProvinceDTO GetById(int id);
}
