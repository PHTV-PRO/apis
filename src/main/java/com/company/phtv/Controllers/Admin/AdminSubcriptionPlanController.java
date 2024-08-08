package com.company.phtv.Controllers.Admin;

import com.company.phtv.Controllers.BaseController;
import com.company.phtv.Models.DTO.SubcriptionPlanDTO;
import com.company.phtv.Models.DTO.SubcriptionPlanForEmployer;
import com.company.phtv.Models.Request.RequestSubcriptionPlan;
import com.company.phtv.Services.SubcriptionPlanService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/subcription_plan")

public class AdminSubcriptionPlanController {
    @Autowired
    SubcriptionPlanService _subcriptionPlanService;
    BaseController<String> _baseController_string = new BaseController<String>();
    BaseController<SubcriptionPlanDTO> _baseController = new BaseController<SubcriptionPlanDTO>();
    BaseController<List<SubcriptionPlanDTO>> _baseControllers = new BaseController<List<SubcriptionPlanDTO>>();
    BaseController<SubcriptionPlanForEmployer> _baseController_employer = new BaseController<SubcriptionPlanForEmployer>();

    @GetMapping("/employer/{id}")
    public ResponseEntity<?> getByEmployer(@PathVariable int id) {
        // auto
        try {
            return _baseController_employer.success(_subcriptionPlanService.getByAccount(id));
        } catch (HttpException e) {
            return _baseControllers.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseControllers.error(null, 500, e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> post(@ModelAttribute RequestSubcriptionPlan requestSubcriptionPlan) {
        try {
            return _baseController.success(_subcriptionPlanService.create(requestSubcriptionPlan));
        } catch (HttpException e) {
            return _baseControllers.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseControllers.error(null, 500, e.getMessage());
        }
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<?> getById(@PathVariable int id) {
    // try {
    // return _baseController.success(_subcriptionPlanService.getById(id));
    // } catch (HttpException e) {
    // return _baseController.error(null, e.StatusCode, e.message);
    // } catch (Exception e) {
    // return _baseController.error(null, 500, e.getMessage());
    // }
    // }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable int id, @ModelAttribute RequestSubcriptionPlan subcriptionPlan) {
        try {
            return _baseController.success(_subcriptionPlanService.put(id, subcriptionPlan));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            return _baseController_string.success(_subcriptionPlanService.delete(id));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

}
