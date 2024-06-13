package com.company.phtv.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.Token;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Request.RequestLogin;
import com.company.phtv.Services.AuthenticateService;
import com.company.phtv.Utils.HttpException;


@RestController
@RequestMapping("")
public class AuthenController {
    @Autowired
    AuthenticateService _iauthenRepo;

    BaseController<Token> _baseController = new BaseController<Token>();
    BaseController<Account> _baseControllerAccount = new BaseController<Account>();
    BaseController<UserDetails> _baseControllerInfo = new BaseController<UserDetails>();

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RequestLogin requestLogin) {
        try {
            String token = _iauthenRepo.login(requestLogin);
            return _baseController.success(new Token(token));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RequestLogin requestLogin) {
        try {
            Account account = _iauthenRepo.register(requestLogin);
            return _baseControllerAccount.success(account);
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    @PostMapping("/getinfo")
    public ResponseEntity<?> postToken(@RequestBody String token) {
        try {
            UserDetails user = _iauthenRepo.checkToken(token);
            return _baseControllerInfo.success(user);
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    @PostMapping("/loginEmployer")
    public ResponseEntity<?> loginEmployer(@RequestBody RequestLogin requestLogin) {
        try {
            String token = _iauthenRepo.loginEmployer(requestLogin);
            return _baseController.success(new Token(token));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    // @PostMapping("/registerEMployer")
    // public ResponseEntity<?> registerEmployer(@RequestBody RequestLogin requestLogin) {
    //     try {
    //         // Account account = _iauthenRepo.registerEmployer(requestLogin);
    //         return _baseControllerAccount.success(account);
    //     } catch (HttpException e) {
    //         return _baseController.error(null, e.StatusCode, e.message);
    //     } catch (Exception e) {
    //         return _baseController.error(null, 500, e.getMessage());
    //     }
    // }


}
