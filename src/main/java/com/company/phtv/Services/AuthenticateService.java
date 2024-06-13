package com.company.phtv.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.company.phtv.Enums.Role;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.Employer;
import com.company.phtv.Models.Request.RequestLogin;
import com.company.phtv.Repository.EmployerRepo;
import com.company.phtv.Repository.UserRepo;
import com.company.phtv.Services.IServices.IAuthenticateService;
import com.company.phtv.Utils.Regex;
import com.company.phtv.Utils.Variable;

@Service
public class AuthenticateService implements IAuthenticateService {
    @Autowired
    UserRepo _userRepo;
    @Autowired
    EmployerRepo _employerRepo;
    @Autowired
    AuthenticationManager _authenticationManager;

    @Autowired
    JWTService _jwtservice;

    @Autowired
    PasswordEncoder _passwordEncoder;

    // login and register for admin and candidate
    @Override
    public String login(RequestLogin requestLogin) {
        var user = _userRepo.findByEmail(requestLogin.getEmail());
        boolean checkEmail = Regex.regexEmail(requestLogin.getEmail());
        if (!checkEmail) {
            throw Variable.emailInvalid;
        }
        // boolean checkPassword= Regex.regexPassword(requestLogin.getPassword());
        // if(!checkPassword){
        // throw Variable.PasswordInvalid;
        // }
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
        boolean checkEmail = Regex.regexEmail(requestLogin.getEmail());
        if (!checkEmail) {
            throw Variable.emailInvalid;
        }
        // boolean checkPassword= Regex.regexPassword(requestLogin.getPassword());
        // if(!checkPassword){
        // throw Variable.passwordInvalid;
        // }
        Account user = new Account();
        user.setEmail(requestLogin.getEmail());
        user.setRole(Role.CANDIDATE);
        user.setPassword(_passwordEncoder.encode(requestLogin.getPassword()));
        return _userRepo.save(user);
    }

    @Override
    public UserDetails checkToken(String token) {
        String email = _jwtservice.extractEmail(token);
        if (email == null || email.trim().equals("")) {
            throw Variable.tokenError;
        }
        // get Account
        Account account = _userRepo.getAccountByEmail(email);
        Employer employer = _employerRepo.getEmployerByEmail(email);
        if (account != null && account.getDeleted_at() == null) {
            return account;
        }
        if (employer != null && employer.getDeleted_at() == null) {
            return employer;
        }
        throw Variable.notFound;
    }

    // login and register for Employer
    @Override
    public String loginEmployer(RequestLogin requestLogin) {
        boolean checkEmail = Regex.regexEmail(requestLogin.getEmail());
        if (!checkEmail) {
            throw Variable.emailInvalid;
        }
        var employer = _employerRepo.findByEmail(requestLogin.getEmail());
        // boolean checkPassword= Regex.regexPassword(requestLogin.getPassword());
        // if(!checkPassword){
        // throw Variable.PasswordInvalid;
        // }
        if (employer == null) {
            throw Variable.emailOrPasswordIncorrect;
        }
        boolean checkPass = _passwordEncoder.matches(requestLogin.getPassword(), employer.getPassword());
        if (checkPass == false) {
            throw Variable.emailOrPasswordIncorrect;

        }

        var token = _jwtservice.generateToken(employer);
        return token;
    }

    @Override
    public Employer registerEmployer(RequestLogin requestLogin) {
        boolean checkEmail = Regex.regexEmail(requestLogin.getEmail());
        if (!checkEmail) {
            throw Variable.emailInvalid;
        }
        // boolean checkPassword= Regex.regexPassword(requestLogin.getPassword());
        // if(!checkPassword){
        // throw Variable.passwordInvalid;
        // }
        Employer employer = new Employer();
        employer.setEmail(requestLogin.getEmail());
        employer.setRole(Role.CANDIDATE);
        employer.setPassword(_passwordEncoder.encode(requestLogin.getPassword()));
        return _employerRepo.save(employer);
    }
}
