package com.company.phtv.Controllers.Controller;

import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.IndustryDTO;
import com.company.phtv.Models.Request.RequestIndustry;
import com.company.phtv.Services.IndustryService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/industry")
public class IndustryController {
    @Autowired
    IndustryService _industryService;
    BaseController<IndustryDTO> _baseController = new BaseController<IndustryDTO>();
    BaseController<List<IndustryDTO>> _baseControllers = new BaseController<List<IndustryDTO>>();

    @GetMapping()
    public ResponseEntity<?>Get(){
        try {
            return _baseControllers.Ok(_industryService.GetAll());
        }catch (HttpException e){
            return _baseControllers.Error(null,e.StatusCode, e.message);
        }catch (Exception e){
            return  _baseControllers.Error(null,500,e.getMessage());
        }
    }

    @PostMapping()
    public  ResponseEntity<?> Post(@RequestBody RequestIndustry industry){
        try {
            return _baseController.Ok(_industryService.Create(industry));
        }catch (HttpException e){
            return _baseControllers.Error(null,e.StatusCode, e.message);
        }catch (Exception e){
            return  _baseControllers.Error(null,500,e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> GetById(@PathVariable int id) {
        try {
            return _baseController.Ok(_industryService.GetById(id));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> Put(@PathVariable int id, @RequestBody RequestIndustry industry) {
        try {
            return _baseController.Ok(_industryService.Put(id, industry));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> Delete(@PathVariable int id) {
        try {
            return _baseController.Ok(_industryService.Delete(id));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

}
