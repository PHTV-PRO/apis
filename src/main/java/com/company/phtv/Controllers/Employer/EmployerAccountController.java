package com.company.phtv.Controllers.Employer;

import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.AccountDTO;
import com.company.phtv.Models.DTO.AccountDTOForEmployer;
import com.company.phtv.Services.AccountService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employer/account")
public class EmployerAccountController {
    @Autowired
    AccountService _accountService;
    BaseController<AccountDTOForEmployer> _baseController = new BaseController<AccountDTOForEmployer>();
    BaseController<List<AccountDTO>> _baseControllers = new BaseController<List<AccountDTO>>();


    @GetMapping("")
    public ResponseEntity<?> get() {
        try {
            return _baseController.success(_accountService.getAccountCompanyJob());
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }


}
