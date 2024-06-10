package com.company.phtv.Controllers.Controller;

import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.CityProvinceDTO;
import com.company.phtv.Models.Request.RequestCityProvince;
import com.company.phtv.Services.CityProvinceService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cityProvince")
public class CityProvinceController {
    @Autowired
    CityProvinceService _cityProvinceService;
    BaseController<CityProvinceDTO> _baseController = new BaseController<CityProvinceDTO>();
    BaseController<List<CityProvinceDTO>> _baseControllers = new BaseController<List<CityProvinceDTO>>();

    @GetMapping()
    public ResponseEntity<?> get() {
        try {
            return _baseControllers.success(_cityProvinceService.getAll());
        } catch (HttpException e) {
            return _baseControllers.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseControllers.error(null, 500, e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> post(@ModelAttribute RequestCityProvince rqCityProvince) {
        try {
            return _baseController.success(_cityProvinceService.create(rqCityProvince));
        } catch (HttpException e) {
            return _baseControllers.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseControllers.error(null, 500, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        try {
            return _baseController.success(_cityProvinceService.getById(id));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable int id, @ModelAttribute RequestCityProvince rqCityProvince) {
        try {
            return _baseController.success(_cityProvinceService.put(id, rqCityProvince));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            return _baseController.success(_cityProvinceService.delete(id));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }
}
