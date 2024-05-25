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
    public ResponseEntity<?> Get(){
        try {
            return _baseControllers.Ok(_cityProvinceService.GetAll());
        }catch (HttpException e){
            return _baseControllers.Error(null,e.StatusCode, e.message);
        }catch (Exception e){
            return  _baseControllers.Error(null,500,e.getMessage());
        }
    }

    @PostMapping()
    public  ResponseEntity<?> Post(@RequestBody RequestCityProvince rqCityProvince){
        try {
            return _baseController.Ok(_cityProvinceService.Create(rqCityProvince));
        }catch (HttpException e){
            return _baseControllers.Error(null,e.StatusCode, e.message);
        }catch (Exception e){
            return  _baseControllers.Error(null,500,e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> GetById(@PathVariable int id) {
        try {
            return _baseController.Ok(_cityProvinceService.GetById(id));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> Put(@PathVariable int id, @RequestBody RequestCityProvince rqCityProvince) {
        try {
            return _baseController.Ok(_cityProvinceService.Put(id, rqCityProvince));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> Delete(@PathVariable int id) {
        try {
            return _baseController.Ok(_cityProvinceService.Delete(id));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }
}
