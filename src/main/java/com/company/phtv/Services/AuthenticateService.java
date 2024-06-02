package com.company.phtv.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.company.phtv.Enums.Role;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Request.RequestLogin;
import com.company.phtv.Repository.UserRepo;
import com.company.phtv.Services.IServices.IAuthenticateService;
import com.company.phtv.Utils.HttpException;
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

    @Override
    public String login(RequestLogin requestLogin) {
        var user = _userRepo.findByEmail(requestLogin.getEmail());
        if (user == null) {
            throw Variable.emailOrPasswordIncorrect;
        }
        try {
            _authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestLogin.getEmail(),
                            requestLogin.getPassword()));
        } catch (Exception e) {
            throw Variable.emailOrPasswordIncorrect;
        }

        var token = _jwtservice.generateToken(user);
        return token;
    }

    @Override
    public Account register(RequestLogin requestLogin) {
        Account user = new Account();
        user.setEmail(requestLogin.getEmail());
        user.setRole(Role.CANDIDATE);
        user.setPassword(_passwordEncoder.encode(requestLogin.getPassword()));
        return _userRepo.save(user);
    }

    @Override
    public Account checkToken(String token) {
        String email = _jwtservice.extractEmail(token);
        if (email == null || email.trim().equals("")) {
            throw Variable.tokenError;
        }
        Account user = _userRepo.getAccountByEmail(email);
        if (user.getDeleted_at() != null) {
            throw Variable.notFound;
        }
        return user;
    }
}
