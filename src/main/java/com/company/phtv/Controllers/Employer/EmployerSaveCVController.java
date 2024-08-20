package com.company.phtv.Controllers.Employer;

import com.company.phtv.Controllers.BaseController;
import com.company.phtv.Models.DTO.SaveCVDTO;
import com.company.phtv.Models.DTO.SubcriptionPlanDTO;
import com.company.phtv.Models.DTO.SubcriptionPlanForEmployer;
import com.company.phtv.Services.SaveCvService;
import com.company.phtv.Services.SubcriptionPlanService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employer/cv_save")

public class EmployerSaveCVController {
    @Autowired
    SaveCvService _saveCvService;
    BaseController<String> _baseController = new BaseController<String>();
    BaseController<List<SaveCVDTO>> _baseControllers = new BaseController<List<SaveCVDTO>>();

    @GetMapping()
    public ResponseEntity<?> get(@RequestParam int size, @RequestParam int page) {
        //auto
        try {
            return _baseControllers.success(_saveCvService.getAllSaveCV(size,page));
        } catch (HttpException e) {
            return _baseControllers.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseControllers.error(null, 500, e.getMessage());
        }
    }

    @PostMapping("/{application_id}")
    public ResponseEntity<?> getById(@PathVariable int application_id) {
        try {
            return _baseController.success(_saveCvService.saveOrUnsaveCV(application_id));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

}
