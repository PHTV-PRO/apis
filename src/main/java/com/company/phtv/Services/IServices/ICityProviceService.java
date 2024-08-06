package com.company.phtv.Services.IServices;

import com.company.phtv.Models.DTO.CityProvinceDTO;
import com.company.phtv.Models.Request.RequestCityProvince;

import java.util.List;

public interface ICityProviceService {
    List<CityProvinceDTO> getAll();

    CityProvinceDTO create(RequestCityProvince requestCityProvince);

    CityProvinceDTO put(int id, RequestCityProvince requestCityProvince);

    String delete(int id);

    CityProvinceDTO getById(int id);
}
