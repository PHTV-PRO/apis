package com.company.phtv.Controllers.Controller;


import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.AccountDTO;
import com.company.phtv.Models.Request.RequestAccount;
import com.company.phtv.Services.AccountService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService _accountService;
    BaseController<AccountDTO> _baseController = new BaseController<AccountDTO>();
    BaseController<List<AccountDTO>> _baseControllers = new BaseController<List<AccountDTO>>();

    @GetMapping()
    public ResponseEntity<?> get(){
        try {
            return _baseControllers.Ok(_accountService.GetAll());
        }catch (HttpException e){
            return _baseControllers.Error(null,e.StatusCode, e.message);
        }catch (Exception e){
            return  _baseControllers.Error(null,500,e.getMessage());
        }
    }

    @PostMapping()
    public  ResponseEntity<?> post(@ModelAttribute RequestAccount account){
        try {
            return _baseController.Ok(_accountService.Create(account));
        }catch (HttpException e){
            return _baseControllers.Error(null,e.StatusCode, e.message);
        }catch (Exception e){
            return  _baseControllers.Error(null,500,e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        try {
            return _baseController.Ok(_accountService.GetById(id));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> Put(@PathVariable int id, @ModelAttribute RequestAccount requestAccount) {
        try {
            return _baseController.Ok(_accountService.Put(id, requestAccount));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> Delete(@PathVariable int id) {
        try {
            return _baseController.Ok(_accountService.Delete(id));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }
}
