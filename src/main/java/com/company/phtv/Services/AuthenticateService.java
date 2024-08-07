package com.company.phtv.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.company.phtv.Enums.Role;
import com.company.phtv.Models.DTO.AccountDTO;
import com.company.phtv.Models.DTO.TokenUser;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Map.AccountMapping;
import com.company.phtv.Models.Request.RequestLogin;
import com.company.phtv.Repository.UserRepo;
import com.company.phtv.Services.IServices.IAuthenticateService;
import com.company.phtv.Utils.Regex;
import com.company.phtv.Utils.Variable;

@Service
public class AuthenticateService implements IAuthenticateService {
    @Autowired
    UserRepo _userRepo;
    @Autowired
    AuthenticationManager _authenticationManager;

    @Autowired
    JWTService _jwtservice;

    @Autowired
    PasswordEncoder _passwordEncoder;

    // login and register for admin and candidate
    @Override
    public TokenUser login(RequestLogin requestLogin) {
        // STEP 1: check data input from client
        boolean checkEmail = Regex.regexEmail(requestLogin.getEmail());
        if (!checkEmail) {
            throw Variable.EMAIL_INVALID;
        }
        boolean checkPassword = Regex.regexPassword(requestLogin.getPassword());
        if (!checkPassword) {
            throw Variable.PASSWORD_INVALID;
        }
        // STEP 2: get account by email
        var user = _userRepo.findByEmail(requestLogin.getEmail());
        if (user == null) {
            // data not found
            throw Variable.EMAIL_OR_PASSWORD_INCORRECT;
        }
        try {
            // STEP 3: check password
            _authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestLogin.getEmail(),
                            requestLogin.getPassword()));
        } catch (Exception e) {
            throw Variable.EMAIL_OR_PASSWORD_INCORRECT;
        }
        // STEP 4: create token
        var token = _jwtservice.generateToken(user);
        return new TokenUser(token, AccountMapping.accountDTO(_userRepo.getAccountByEmail(requestLogin.getEmail())));
    }

    @Override
    public Account register(RequestLogin requestLogin) {
        boolean checkEmail = Regex.regexEmail(requestLogin.getEmail());
        if (!checkEmail) {
            throw Variable.EMAIL_INVALID;
        }
        boolean checkPassword = Regex.regexPassword(requestLogin.getPassword());
        if (!checkPassword) {
            throw Variable.PASSWORD_INVALID;
        }
        Account account = _userRepo.getAccountByEmail(requestLogin.getEmail());
        if (account != null) {
            throw Variable.EMAIL_EXISTING;
        }
        Account user = new Account();
        user.setEmail(requestLogin.getEmail());
        user.setRole(Role.CANDIDATE);
        user.setPassword(_passwordEncoder.encode(requestLogin.getPassword()));
        return _userRepo.save(user);
    }

    @Override
    public AccountDTO checkToken(String token) {
        try {
            // STEP 1: get email by token (=JWT)
            String email = _jwtservice.extractEmail(token);
            if (email == null || email.trim().equals("")) {
                // token fail
                throw Variable.TOKEN_ERROR;
            }
            // STEP 2: get account by email find = token
            Account account = _userRepo.getAccountByEmail(email);
            if (account == null || account.getDeleted_at() != null) {
                throw Variable.TOKEN_ERROR;
            }
            return AccountMapping.accountDTO(account);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public AccountDTO checkTokenWeb(String token) {
        String email = _jwtservice.extractEmail(token);
        if (email == null || email.trim().equals("")) {
            throw Variable.TOKEN_ERROR;
        }
        Account account = _userRepo.getAccountByEmail(email);
        if (account != null && account.getDeleted_at() == null) {
            return AccountMapping.accountDTO(account);
        }
        throw Variable.NOT_FOUND;
    }
}
