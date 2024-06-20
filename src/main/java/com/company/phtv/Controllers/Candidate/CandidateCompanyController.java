package com.company.phtv.Controllers.Candidate;

import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.CompanyDTO;
import com.company.phtv.Services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate/company")
public class CandidateCompanyController {
    @Autowired
    CompanyService _companyService;
    BaseController<CompanyDTO> _baseController = new BaseController<CompanyDTO>();
    BaseController<List<CompanyDTO>> _baseControllers = new BaseController<List<CompanyDTO>>();

    // @GetMapping()
    // public ResponseEntity<?> get() {
    //     try {
    //         return _baseControllers.success(_companyService.getAll());
    //     } catch (HttpException e) {
    //         return _baseControllers.error(null, e.StatusCode, e.message);
    //     } catch (Exception e) {
    //         return _baseControllers.error(null, 500, e.getMessage());
    //     }
    // }

    // @GetMapping("/{id}")
    // public ResponseEntity<?> get(@PathVariable int id) {
    //     try {
    //         return _baseController.success(_companyService.getById(id));
    //     } catch (HttpException e) {
    //         return _baseController.error(null, e.StatusCode, e.message);
    //     } catch (Exception e) {
    //         return _baseController.error(null, 500, e.getMessage());
    //     }
    // }

    // @GetMapping("/contract")
    // public ResponseEntity<?> companyContract() {
    //     try {
    //         return _baseControllers.success(_companyService.companyContractAll());
    //     } catch (HttpException e) {
    //         return _baseControllers.error(null, e.StatusCode, e.message);
    //     } catch (Exception e) {
    //         return _baseControllers.error(null, 500, e.getMessage());
    //     }
    // }

}