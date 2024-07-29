package com.company.phtv.Controllers.Employer;

import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.ApplicationDTO;
import com.company.phtv.Models.DTO.ChartForEmployer;
import com.company.phtv.Services.ApplicationService;
import com.company.phtv.Services.CompanyService;
import com.company.phtv.Utils.HttpException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employer")
public class EmployerController {
    @Autowired
    CompanyService _companyService;
    @Autowired
    ApplicationService _appplicationService;
    BaseController<ChartForEmployer> _baseController = new BaseController<ChartForEmployer>();
    BaseController<List<ApplicationDTO>> _baseControllers = new BaseController<List<ApplicationDTO>>();

    @GetMapping("/chart")
    public ResponseEntity<?> getCompanyChart() {
        try {
            return _baseController.success(_companyService.companyChart());
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    @GetMapping("/application_by_job")
    public ResponseEntity<?> getApplicationByJob(@RequestParam int job_id, @RequestParam int size,
            @RequestParam int page) {
        try {
            return _baseControllers.success(_appplicationService.getByJob(job_id, size, page));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

}
