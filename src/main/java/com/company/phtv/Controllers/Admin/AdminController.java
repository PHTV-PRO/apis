package com.company.phtv.Controllers.Admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.SearchAll;
import com.company.phtv.Services.AdminService;
import com.company.phtv.Utils.HttpException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/admin")
public class AdminController {
    BaseController<SearchAll> _baseControllers = new BaseController<SearchAll>();

    @Autowired
    AdminService _adminService;
    @GetMapping("/search/{search}")
    public ResponseEntity<?> getMethodName(@PathVariable String search) {
        try {
            return _baseControllers.success(_adminService.searchByName(search));
        } catch (HttpException e) {
            return _baseControllers.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseControllers.error(null, 500, e.getMessage());
        }
    }

}
