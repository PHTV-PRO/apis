package com.company.phtv.Controllers.Employer;

import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.SubcriptionPlanDTO;
import com.company.phtv.Models.DTO.SubcriptionPlanForEmployer;
import com.company.phtv.Services.SubcriptionPlanService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employer/subcription_plan")

public class EmployerSubcriptionPlanController {
    @Autowired
    SubcriptionPlanService _subcriptionPlanService;
    BaseController<SubcriptionPlanForEmployer> _baseController = new BaseController<SubcriptionPlanForEmployer>();
    BaseController<List<SubcriptionPlanDTO>> _baseControllers = new BaseController<List<SubcriptionPlanDTO>>();

    @GetMapping()
    public ResponseEntity<?> getByAccount() {
        //auto
        try {
            return _baseController.success(_subcriptionPlanService.getByAccountAuto());
        } catch (HttpException e) {
            return _baseControllers.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseControllers.error(null, 500, e.getMessage());
        }
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<?> getById(@PathVariable int id) {
    //     try {
    //         return _baseController.success(_subcriptionPlanService.getById(id));
    //     } catch (HttpException e) {
    //         return _baseController.error(null, e.StatusCode, e.message);
    //     } catch (Exception e) {
    //         return _baseController.error(null, 500, e.getMessage());
    //     }
    // }

}
