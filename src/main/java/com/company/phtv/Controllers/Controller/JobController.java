package com.company.phtv.Controllers.Controller;

import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.JobDTO;
import com.company.phtv.Models.Request.RequestJob;
import com.company.phtv.Services.JobService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    JobService _jobService;
    BaseController<JobDTO> _baseController = new BaseController<JobDTO>();
    BaseController<List<JobDTO>> _baseControllers = new BaseController<List<JobDTO>>();

    @GetMapping()
    public ResponseEntity<?> get(){
        try {
            return _baseControllers.Ok(_jobService.GetAll());
        }catch (HttpException e){
            return _baseControllers.Error(null,e.StatusCode, e.message);
        }catch (Exception e){
            return  _baseControllers.Error(null,500,e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> post(@RequestBody RequestJob requestJob) {
        try {
            return _baseController.Ok(_jobService.Create(requestJob));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        try {
            return _baseController.Ok(_jobService.GetById(id));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            return _baseController.Ok(_jobService.Delete(id));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable int id, @RequestBody RequestJob requestJob) {
        try {
            return _baseController.Ok(_jobService.Put(id, requestJob));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }
}
