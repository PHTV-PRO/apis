package com.company.phtv.Controllers;

import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.SubcriptionPlanDTO;
import com.company.phtv.Services.SubcriptionPlanService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/general/subcription_plan")

public class SubcriptionPlanController {
    @Autowired
    SubcriptionPlanService _subcriptionPlanService;
    BaseController<SubcriptionPlanDTO> _baseController = new BaseController<SubcriptionPlanDTO>();
    BaseController<List<SubcriptionPlanDTO>> _baseControllers = new BaseController<List<SubcriptionPlanDTO>>();

    @GetMapping()
    public ResponseEntity<?> get() {
        try {
            return _baseControllers.success(_subcriptionPlanService.getAll());
        } catch (HttpException e) {
            return _baseControllers.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseControllers.error(null, 500, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        try {
            return _baseController.success(_subcriptionPlanService.getById(id));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

}
