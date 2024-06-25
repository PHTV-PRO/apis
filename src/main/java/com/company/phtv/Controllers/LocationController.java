package com.company.phtv.Controllers;

import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.LocationDTO;
import com.company.phtv.Services.LocationService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/general/location")
public class LocationController {
    @Autowired
    LocationService _locationService;
    BaseController<LocationDTO> _baseController = new BaseController<LocationDTO>();
    BaseController<List<LocationDTO>> _baseControllers = new BaseController<List<LocationDTO>>();

    @GetMapping()
    public ResponseEntity<?> get() {
        try {
            return _baseControllers.success(_locationService.getAll());
        } catch (HttpException e) {
            return _baseControllers.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseControllers.error(null, 500, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        try {
            return _baseController.success(_locationService.getById(id));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }
}
