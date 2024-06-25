package com.company.phtv.Services;

import com.company.phtv.Models.DTO.LocationDTO;
import com.company.phtv.Models.Entity.CityProvince;
import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Models.Entity.Location;
import com.company.phtv.Models.Map.LocationMapping;
import com.company.phtv.Models.Request.RequestLocation;
import com.company.phtv.Repository.CityProvinceRepo;
import com.company.phtv.Repository.CompanyRepo;
import com.company.phtv.Repository.LocationRepo;
import com.company.phtv.Services.IServices.ILocationService;
import com.company.phtv.Utils.Variable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LocationService implements ILocationService {
    @Autowired
    LocationRepo _locationRepo;
    @Autowired
    CityProvinceRepo _cityProvinceRepo;
    @Autowired
    CompanyRepo _companyRepo;

    @Override
    public List<LocationDTO> getAll() {
        List<Location> locations = _locationRepo.findAll();
        List<LocationDTO> locationDTOS = new ArrayList<>();
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getDeleted_at() == null) {
                locationDTOS.add(LocationMapping.LocationDTO(locations.get(i)));
            }
        }
        return locationDTOS;
    }

    @Override
    public LocationDTO create(RequestLocation requestLocation) {
        Location location = LocationMapping.LocationPost(requestLocation);
        CityProvince c = _cityProvinceRepo.findById(requestLocation.getCity_provence_id()).get();
        Company cm = _companyRepo.findById(requestLocation.getCompany_id()).get();
        boolean checkCityProvenceNotFound = c == null || c.getDeleted_at() != null;
        if (checkCityProvenceNotFound) {
            throw Variable.notFound;
        }
        location.setCity_provence(c);
        boolean checkCompanyNotFound = cm == null || cm.getDeleted_at() != null;
        if (checkCompanyNotFound) {
            throw Variable.notFound;
        }
        location.setCompany(cm);
        _locationRepo.save(location);
        return (LocationDTO) LocationMapping.LocationDTO(location);
    }

    @Override
    public LocationDTO put(int id, RequestLocation requestLocation) {
        Location getLocation = _locationRepo.findIdLocation(id);
        boolean checkLocationNotFound = (getLocation != null && getLocation.getDeleted_at() == null) ? false : true;
        if (checkLocationNotFound) {
            throw Variable.notFound;
        }
        Location location = LocationMapping.LocationPut(requestLocation, getLocation);
        if (requestLocation.getCity_provence_id() != 0) {
            location.setCity_provence(_cityProvinceRepo.getLocationById(requestLocation.getCity_provence_id()));
        }
        location.setId(id);
        if (requestLocation.getCompany_id() != 0) {
            location.setCompany(_companyRepo.getCompanyById(requestLocation.getCompany_id()));
        }
        location.setId(id);
        _locationRepo.save(location);
        return (LocationDTO) LocationMapping.LocationDTO(location);
    }

    @Override
    public LocationDTO getById(int id) {
        Location location = _locationRepo.findIdLocation(id);
        boolean checkLocationNotFound = (location != null && location.getDeleted_at() == null) ? false : true;
        if (checkLocationNotFound) {
            throw Variable.notFound;
        }
        LocationDTO locationDTO = LocationMapping.LocationDTO(location);
        return locationDTO;
    }

    @Override
    public LocationDTO delete(int id) {
        Location location = _locationRepo.findIdLocation(id);
        boolean checkLocationNotFound = (location != null && location.getDeleted_at() == null) ? false : true;
        if (checkLocationNotFound) {
            throw Variable.notFound;
        }
        location.setDeleted_at(new Date());
        _locationRepo.save(location);
        return null;
    }
}
