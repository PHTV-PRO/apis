package com.company.phtv.Services;

import com.company.phtv.Models.DTO.CityProvinceDTO;
import com.company.phtv.Models.Entity.CityProvince;
import com.company.phtv.Models.Map.CityProvinceMapping;
import com.company.phtv.Models.Request.RequestCityProvince;
import com.company.phtv.Repository.CityProvinceRepo;
import com.company.phtv.Services.IServices.ICityProviceService;
import com.company.phtv.Utils.Variable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CityProvinceService implements ICityProviceService {
    @Autowired
    CityProvinceRepo _cityProvinceRepo;

    @Override
    public List<CityProvinceDTO> getAll() {
        List<CityProvince> cityProvinces = _cityProvinceRepo.findAll();
        List<CityProvinceDTO> cityProvinceDTOS = new ArrayList<>();
        for (int i = 0; i < cityProvinces.size(); i++) {
            if (cityProvinces.get(i).getDeleted_at() == null) {
                cityProvinceDTOS.add(CityProvinceMapping.cityProvinceDTO(cityProvinces.get(i)));
            }
        }
        return cityProvinceDTOS;
    }

    @Override
    public CityProvinceDTO create(RequestCityProvince requestCityProvince) {
        CityProvince cityProvince = CityProvinceMapping.cityProvince(requestCityProvince);
        _cityProvinceRepo.save(cityProvince);
        return (CityProvinceDTO) CityProvinceMapping.cityProvinceDTO(cityProvince);
    }

    @Override
    public CityProvinceDTO put(int id, RequestCityProvince RequestCityProvince) {
        CityProvince getCityProvince = _cityProvinceRepo.findIdCityProvince(id);
        boolean checkCityProvinceNotFound = (getCityProvince != null && getCityProvince.getDeleted_at() == null) ? false
                : true;
        if (checkCityProvinceNotFound) {
            throw Variable.notFound;
        }
        CityProvince cityProvince = CityProvinceMapping.CityProvincePut(RequestCityProvince, getCityProvince);
        cityProvince.setId(id);
        _cityProvinceRepo.save(cityProvince);
        return (CityProvinceDTO) CityProvinceMapping.cityProvinceDTO(cityProvince);
    }

    @Override
    public CityProvinceDTO delete(int id) {
        CityProvince cityProvince = _cityProvinceRepo.findIdCityProvince(id);
        boolean checkCityProvinceNotFound = (cityProvince != null && cityProvince.getDeleted_at() == null) ? false
                : true;
        if (checkCityProvinceNotFound) {
            throw Variable.notFound;
        }
        cityProvince.setDeleted_at(new Date());
        _cityProvinceRepo.save(cityProvince);
        return null;
    }

    @Override
    public CityProvinceDTO getById(int id) {
        CityProvince cityProvince = _cityProvinceRepo.findIdCityProvince(id);
        boolean checkCityProvinceNotFound = (cityProvince != null && cityProvince.getDeleted_at() == null) ? false
                : true;
        if (checkCityProvinceNotFound) {
            throw Variable.notFound;
        }
        CityProvinceDTO cityProvinceDTO = CityProvinceMapping.cityProvinceDTO(cityProvince);
        return cityProvinceDTO;
    }
}
