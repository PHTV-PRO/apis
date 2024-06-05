package com.company.phtv.Controllers.Controller;


import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.JobTypeDTO;
import com.company.phtv.Models.Request.RequestJobType;
import com.company.phtv.Services.JobTypeService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobType")
public class JobTypeController {
    @Autowired
    JobTypeService _jobTypeService;
    BaseController<JobTypeDTO> _baseController = new BaseController<JobTypeDTO>();
    BaseController<List<JobTypeDTO>> _baseControllers = new BaseController<List<JobTypeDTO>>();

    @GetMapping()
    public ResponseEntity<?> get(){
        try {
            return _baseControllers.Ok(_jobTypeService.GetAll());
        }catch (HttpException e){
            return _baseControllers.Error(null,e.StatusCode, e.message);
        }catch (Exception e){
            return  _baseControllers.Error(null,500,e.getMessage());
        }
    }

    @PostMapping()
    public  ResponseEntity<?> post(@ModelAttribute RequestJobType requestJobType){
        try {
            return _baseController.Ok(_jobTypeService.Create(requestJobType));
        }catch (HttpException e){
            return _baseControllers.Error(null,e.StatusCode, e.message);
        }catch (Exception e){
            return  _baseControllers.Error(null,500,e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        try {
            return _baseController.Ok(_jobTypeService.GetById(id));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable int id, @ModelAttribute RequestJobType requestJobType) {
        try {
            return _baseController.Ok(_jobTypeService.Put(id, requestJobType));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            return _baseController.Ok(_jobTypeService.Delete(id));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

}
