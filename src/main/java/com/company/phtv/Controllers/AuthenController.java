package com.company.phtv.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.AccountDTO;
import com.company.phtv.Models.DTO.TokenUser;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Request.RequestLogin;
import com.company.phtv.Models.Request.RequestToken;
import com.company.phtv.Services.AuthenticateService;
import com.company.phtv.Utils.HttpException;

@RestController
@RequestMapping("/general")
public class AuthenController {
    @Autowired
    AuthenticateService _iauthenRepo;

    BaseController<TokenUser> _baseController = new BaseController<TokenUser>();
    BaseController<Account> _baseControllerAccount = new BaseController<Account>();
    BaseController<AccountDTO> _baseControllerInfo = new BaseController<AccountDTO>();

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RequestLogin requestLogin) {
        try {
            TokenUser tokenUser = _iauthenRepo.login(requestLogin);
            return _baseController.success(tokenUser);
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

    @PostMapping("/check_token")
    public ResponseEntity<?> postToken(@RequestBody RequestToken requestToken) {
        try {
            return _baseControllerInfo.success(_iauthenRepo.checkToken(requestToken.getToken()));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }
    @PostMapping("/check_token_web")
    public ResponseEntity<?> postTokenWeb(@RequestBody String token) {
        try {
            return _baseControllerInfo.success(_iauthenRepo.checkTokenWeb(token));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

}
