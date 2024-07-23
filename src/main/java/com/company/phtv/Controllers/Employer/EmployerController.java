package com.company.phtv.Controllers.Employer;

import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.ChartForEmployer;
import com.company.phtv.Services.CompanyService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employer/chart")
public class EmployerController {
    @Autowired
    CompanyService _companyService;
    BaseController<ChartForEmployer> _baseController = new BaseController<ChartForEmployer>();

    @GetMapping("")
    public ResponseEntity<?> getCompanyChart() {
        try {
            return _baseController.success(_companyService.companyChart());
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

}
