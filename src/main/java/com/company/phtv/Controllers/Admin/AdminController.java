package com.company.phtv.Controllers.Admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.phtv.Controllers.BaseController;
import com.company.phtv.Models.DTO.ChartForAdmin;
import com.company.phtv.Models.DTO.ChartForEmployer;
import com.company.phtv.Models.DTO.CompanyDTO;
import com.company.phtv.Models.DTO.SearchAll;
import com.company.phtv.Services.AdminService;
import com.company.phtv.Services.CompanyService;
import com.company.phtv.Utils.HttpException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/admin")
public class AdminController {
    BaseController<SearchAll> _baseControllers = new BaseController<SearchAll>();
    BaseController<ChartForAdmin> _baseController = new BaseController<ChartForAdmin>();
    BaseController<ChartForEmployer> _baseController_employer_chart = new BaseController<ChartForEmployer>();
    BaseController<String> _baseControllers_string = new BaseController<String>();
    BaseController<List<CompanyDTO>> _baseControllers_companies = new BaseController<List<CompanyDTO>>();


    @Autowired
    AdminService _adminService;
    @Autowired
    CompanyService _companyService;

    @GetMapping("/search/{search}")
    public ResponseEntity<?> getMethodName(@PathVariable String search) {
        try {
            return _baseControllers.success(_adminService.searchByNameForAdmin(search));
        } catch (HttpException e) {
            return _baseControllers.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseControllers.error(null, 500, e.getMessage());
        }
    }

    @GetMapping("/chart")
    public ResponseEntity<?> getCompanyChart() {
        try {
            return _baseController.success(_adminService.getChart());
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    @GetMapping("/employer_chart/{id}")
    public ResponseEntity<?> getChartByCompany(@PathVariable int id) {
        try {
            return _baseController_employer_chart.success(_companyService.chartByCompany(id));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    @PostMapping("/approve_company/{id}")
    public ResponseEntity<?> approveCompany(@PathVariable int id) {
        try {
            return _baseControllers_string.success(_companyService.approveCompany(id));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    @PostMapping("/reject_company/{id}")
    public ResponseEntity<?> rejectCompany(@PathVariable int id) {
        try {
            return _baseControllers_string.success(_companyService.rejectCompany(id));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }
    @GetMapping("/get_company_pending")
    public ResponseEntity<?> getComapanyPending() {
        try {
            return _baseControllers_companies.success(_companyService.getCompanyPending());
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }
}
