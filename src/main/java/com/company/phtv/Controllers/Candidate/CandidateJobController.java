package com.company.phtv.Controllers.Candidate;

import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.JobDTO;
import com.company.phtv.Models.Request.RequestApplication;
import com.company.phtv.Services.JobService;
import com.company.phtv.Utils.HttpException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate/job")
public class CandidateJobController {
    @Autowired
    JobService _jobService;
    BaseController<JobDTO> _baseController = new BaseController<JobDTO>();

    @PostMapping("/application")
    public ResponseEntity<?> postJobsSave(@RequestBody RequestApplication requestApplication) {
        try {
            return _baseController.success(_jobService.jobApplication(requestApplication));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

}
