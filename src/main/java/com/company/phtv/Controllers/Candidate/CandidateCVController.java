package com.company.phtv.Controllers.Candidate;

import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.CVDTO;
import com.company.phtv.Services.CVService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/candidate/cv")
public class CandidateCVController {
    @Autowired
    CVService _cvService;
    BaseController<CVDTO> _baseController = new BaseController<CVDTO>();
    BaseController<List<CVDTO>> _baseControllers = new BaseController<List<CVDTO>>();

    @GetMapping("/account")
    public ResponseEntity<?> getByAccount() {
        try {
            return _baseControllers.success(_cvService.getByAccount());
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    @PostMapping(value = "", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> post(@RequestParam("file") MultipartFile file) {
        try {
            return _baseController.success(_cvService.create(file));
        } catch (HttpException e) {
            return _baseControllers.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseControllers.error(null, 500, e.getMessage());
        }
    }

}
