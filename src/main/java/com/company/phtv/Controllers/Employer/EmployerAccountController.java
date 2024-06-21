package com.company.phtv.Controllers.Employer;

import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.AccountDTO;
import com.company.phtv.Models.Request.RequestAccount;
import com.company.phtv.Services.AccountService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employer/account")
public class EmployerAccountController {
    @Autowired
    AccountService _accountService;
    BaseController<AccountDTO> _baseController = new BaseController<AccountDTO>();
    BaseController<List<AccountDTO>> _baseControllers = new BaseController<List<AccountDTO>>();


    @GetMapping("/{id}")
    public ResponseEntity<?> getByIdTest(@PathVariable int id) {
        try {
            return _baseController.success(_accountService.getAccountCompanyJob(id));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }


}
