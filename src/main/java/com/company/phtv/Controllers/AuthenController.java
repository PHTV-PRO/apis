package com.company.phtv.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Request.RequestLogin;
import com.company.phtv.Services.AuthenticateService;
import com.company.phtv.Utils.HttpException;
import com.company.phtv.Utils.Token;


@RestController
@RequestMapping("")
public class AuthenController {
    @Autowired
    AuthenticateService _iauthenRepo;

    BaseController<Token> _baseController = new BaseController<Token>();
    BaseController<Account> _baseControllerUser = new BaseController<Account>();

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RequestLogin requestLogin) {
        try {
            String token = _iauthenRepo.login(requestLogin);
            return _baseController.Ok(new Token(token));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RequestLogin requestLogin) {
        try {
            Account user = _iauthenRepo.register(requestLogin);
            return _baseControllerUser.Ok(user);
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

    @PostMapping("/getinfo")
    public ResponseEntity<?> postToken(@RequestBody String token) {
        try {
            Account user = _iauthenRepo.checkToken(token);
            return _baseControllerUser.Ok(user);
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }
    
}
