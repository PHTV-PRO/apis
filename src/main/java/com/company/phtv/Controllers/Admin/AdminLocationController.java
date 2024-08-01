package com.company.phtv.Controllers.Admin;

import com.company.phtv.Controllers.BaseController;
import com.company.phtv.Models.DTO.LocationDTO;
import com.company.phtv.Models.Request.RequestLocation;
import com.company.phtv.Services.LocationService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/location")
public class AdminLocationController {
    @Autowired
    LocationService _locationService;
    BaseController<LocationDTO> _baseController = new BaseController<LocationDTO>();
    BaseController<List<LocationDTO>> _baseControllers = new BaseController<List<LocationDTO>>();


    @PostMapping()
    public ResponseEntity<?> post(@ModelAttribute RequestLocation requestLocation) {
        try {
            return _baseController.success(_locationService.create(requestLocation));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            return _baseController.success(_locationService.delete(id));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> Put(@PathVariable int id, @ModelAttribute RequestLocation location) {
        try {
            return _baseController.success(_locationService.put(id, location));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }
}
