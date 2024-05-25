package com.company.phtv.Controllers.Controller;

import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.IndustryDTO;
import com.company.phtv.Models.DTO.SubcriptionPlanDTO;
import com.company.phtv.Models.Request.RequestIndustry;
import com.company.phtv.Models.Request.RequestSubcriptionPlan;
import com.company.phtv.Services.IndustryService;
import com.company.phtv.Services.SubcriptionPlanService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subcriptionPlan")

public class SubcriptionPlanController {
    @Autowired
    SubcriptionPlanService _subcriptionPlanService;
    BaseController<SubcriptionPlanDTO> _baseController = new BaseController<SubcriptionPlanDTO>();
    BaseController<List<SubcriptionPlanDTO>> _baseControllers = new BaseController<List<SubcriptionPlanDTO>>();

    @GetMapping()
    public ResponseEntity<?> Get(){
        try {
            return _baseControllers.Ok(_subcriptionPlanService.GetAll());
        }catch (HttpException e){
            return _baseControllers.Error(null,e.StatusCode, e.message);
        }catch (Exception e){
            return  _baseControllers.Error(null,500,e.getMessage());
        }
    }

    @PostMapping()
    public  ResponseEntity<?> Post(@RequestBody RequestSubcriptionPlan requestSubcriptionPlan){
        try {
            return _baseController.Ok(_subcriptionPlanService.Create(requestSubcriptionPlan));
        }catch (HttpException e){
            return _baseControllers.Error(null,e.StatusCode, e.message);
        }catch (Exception e){
            return  _baseControllers.Error(null,500,e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> GetById(@PathVariable int id) {
        try {
            return _baseController.Ok(_subcriptionPlanService.GetById(id));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> Put(@PathVariable int id, @RequestBody RequestSubcriptionPlan subcriptionPlan) {
        try {
            return _baseController.Ok(_subcriptionPlanService.Put(id, subcriptionPlan));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> Delete(@PathVariable int id) {
        try {
            return _baseController.Ok(_subcriptionPlanService.Delete(id));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }



}
