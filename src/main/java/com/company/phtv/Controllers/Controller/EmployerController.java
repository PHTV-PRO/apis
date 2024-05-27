package com.company.phtv.Controllers.Controller;


import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.EmployerDTO;
import com.company.phtv.Models.DTO.IndustryDTO;
import com.company.phtv.Models.Request.RequestEmployer;
import com.company.phtv.Models.Request.RequestIndustry;
import com.company.phtv.Services.EmployerService;
import com.company.phtv.Services.IndustryService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employer")
public class EmployerController {
    @Autowired
    EmployerService _employerService;
    BaseController<EmployerDTO> _baseController = new BaseController<EmployerDTO>();
    BaseController<List<EmployerDTO>> _baseControllers = new BaseController<List<EmployerDTO>>();

    @GetMapping()
    public ResponseEntity<?> Get(){
        try {
            return _baseControllers.Ok(_employerService.GetAll());
        }catch (HttpException e){
            return _baseControllers.Error(null,e.StatusCode, e.message);
        }catch (Exception e){
            return  _baseControllers.Error(null,500,e.getMessage());
        }
    }

    @PostMapping()
    public  ResponseEntity<?> Post(@RequestBody RequestEmployer employer){
        try {
            return _baseController.Ok(_employerService.Create(employer));
        }catch (HttpException e){
            return _baseControllers.Error(null,e.StatusCode, e.message);
        }catch (Exception e){
            return  _baseControllers.Error(null,500,e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> GetById(@PathVariable int id) {
        try {
            return _baseController.Ok(_employerService.GetById(id));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> Put(@PathVariable int id, @RequestBody RequestEmployer requestEmployer) {
        try {
            return _baseController.Ok(_employerService.Put(id, requestEmployer));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> Delete(@PathVariable int id) {
        try {
            return _baseController.Ok(_employerService.Delete(id));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

}
