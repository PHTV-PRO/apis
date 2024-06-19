package com.company.phtv.Controllers.Employer;

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
@RequestMapping("/employer/job")
public class EmployerJobController {
    @Autowired
    JobService _jobService;
    BaseController<JobDTO> _baseController = new BaseController<JobDTO>();
    BaseController<List<JobDTO>> _baseControllers = new BaseController<List<JobDTO>>();

    @GetMapping()
    // public ResponseEntity<?> get() {
    //     try {
    //         return _baseControllers.success(_jobService.getAll());
    //     } catch (HttpException e) {
    //         return _baseControllers.error(null, e.StatusCode, e.message);
    //     } catch (Exception e) {
    //         return _baseControllers.error(null, 500, e.getMessage());
    //     }
    // }

    @PostMapping()
    public ResponseEntity<?> post(@RequestBody RequestJob requestJob) {
        try {
            return _baseController.success(_jobService.create(requestJob));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<?> get(@PathVariable int id) {
    //     try {
    //         return _baseController.success(_jobService.getById(id));
    //     } catch (HttpException e) {
    //         return _baseController.error(null, e.StatusCode, e.message);
    //     } catch (Exception e) {
    //         return _baseController.error(null, 500, e.getMessage());
    //     }
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            return _baseController.success(_jobService.delete(id));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable int id, @RequestBody RequestJob requestJob) {
        try {
            return _baseController.success(_jobService.put(id, requestJob));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

}
