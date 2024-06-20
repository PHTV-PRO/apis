package com.company.phtv.Controllers;

import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.JobDTO;
import com.company.phtv.Models.Request.RequestIntermediaryJob;
import com.company.phtv.Services.JobService;
import com.company.phtv.Utils.HttpException;
import com.company.phtv.Utils.Variable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/general/job")
public class JobController {
    @Autowired
    JobService _jobService;
    BaseController<JobDTO> _baseController = new BaseController<JobDTO>();
    BaseController<List<JobDTO>> _baseControllers = new BaseController<List<JobDTO>>();

    @GetMapping()
    public ResponseEntity<?> get() {
        try {
            return _baseControllers.success(_jobService.getAll());
        } catch (HttpException e) {
            return _baseControllers.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseControllers.error(null, 500, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        try {
            return _baseController.success(_jobService.getById(id));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }
      @GetMapping("/new")
    public ResponseEntity<?> getJobsNew() {
        try {
            return _baseControllers.success(_jobService.getJobsNew());
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    @GetMapping("/save/{id}")
    public ResponseEntity<?> getJobsSave(@PathVariable String id) {
        try {
            return _baseControllers.success(_jobService.getJobsSave(id));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> postJobsSave(@RequestBody RequestIntermediaryJob requestIntermediaryJob) {
        try {
            boolean success = _jobService.postJobsSave(requestIntermediaryJob);
            if (success) {
                return _baseControllers.success(null);
            }
            throw Variable.Fail;
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    @GetMapping("/viewed/{id}")
    public ResponseEntity<?> getJobsViewd(@PathVariable String id) {
        try {
            return _baseControllers.success(_jobService.getJobsViewed(id));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

}