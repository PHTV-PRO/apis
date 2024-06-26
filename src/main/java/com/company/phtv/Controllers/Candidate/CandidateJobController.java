package com.company.phtv.Controllers.Candidate;

import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.JobDTO;
import com.company.phtv.Models.Request.RequestApplication;
import com.company.phtv.Models.Request.RequestIntermediaryJob;
import com.company.phtv.Services.JobService;
import com.company.phtv.Utils.HttpException;
import com.company.phtv.Utils.Variable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate/job")
public class CandidateJobController {
    @Autowired
    JobService _jobService;
    BaseController<JobDTO> _baseController = new BaseController<JobDTO>();
    BaseController<List<JobDTO>> _baseControllers = new BaseController<List<JobDTO>>();

    @PostMapping("/application")
    public ResponseEntity<?> postJobsApplication(@RequestBody RequestApplication requestApplication) {
        try {
            return _baseController.success(_jobService.CreatejobApplication(requestApplication));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    @GetMapping("/application")
    public ResponseEntity<?> get() {
        try {
            return _baseControllers.success(_jobService.getJobApplicationByAccount());
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    @GetMapping("/save")
    public ResponseEntity<?> getJobsSave() {
        try {
            return _baseControllers.success(_jobService.getJobsSave());
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

    @GetMapping("/viewed")
    public ResponseEntity<?> getJobsViewd() {
        try {
            return _baseControllers.success(_jobService.getJobsViewed());
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    @PostMapping("/viewed")
    public ResponseEntity<?> postJobsViewed(@RequestBody RequestIntermediaryJob requestIntermediaryJob) {
        try {
            boolean success = _jobService.postJobsViewed(requestIntermediaryJob);
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
}
