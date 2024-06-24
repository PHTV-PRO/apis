package com.company.phtv.Controllers;

import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.CVDTO;
import com.company.phtv.Models.Request.RequestCV;
import com.company.phtv.Services.CVService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/general/cv")
public class CVController {
    @Autowired
    CVService _cvService;
    BaseController<CVDTO> _baseController = new BaseController<CVDTO>();
    BaseController<List<CVDTO>> _baseControllers = new BaseController<List<CVDTO>>();

    @GetMapping("/{id}")
    public ResponseEntity<?> getByid(@PathVariable int id) {
        try {
            return _baseController.success(_cvService.getById(id));
        } catch (HttpException e) {
            return _baseControllers.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseControllers.error(null, 500, e.getMessage());
        }
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<?> getByAccount(@PathVariable int id) {
        try {
            return _baseControllers.success(_cvService.getByAccount(id));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    @PostMapping(value = "", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> post(@ModelAttribute RequestCV requestCV) {
        try {
            return _baseController.success(_cvService.create(requestCV));
        } catch (HttpException e) {
            return _baseControllers.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseControllers.error(null, 500, e.getMessage());
        }
    }

}
