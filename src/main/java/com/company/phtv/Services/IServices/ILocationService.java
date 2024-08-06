package com.company.phtv.Services.IServices;

import com.company.phtv.Models.DTO.LocationDTO;
import com.company.phtv.Models.Request.RequestLocation;

import java.util.List;

public interface ILocationService {
    List<LocationDTO> getAll();

    LocationDTO create(RequestLocation requestLocation);

    LocationDTO put(int id, RequestLocation requestLocation);

    LocationDTO getById(int id);

    String delete(int id);
}
