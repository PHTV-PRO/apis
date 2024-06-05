package com.company.phtv.Services;

import com.company.phtv.Models.DTO.AccountDTO;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Map.AccountMapping;
import com.company.phtv.Models.Request.RequestAccount;
import com.company.phtv.Repository.AccountRepo;
import com.company.phtv.Services.IServices.IAccountService;
import com.company.phtv.Utils.Regex;
import com.company.phtv.Utils.Variable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    AccountRepo _accountRepo;

    @Autowired
    PasswordEncoder _passwordEncoder;

    public AccountService(PasswordEncoder _passwordEncoder) {
        this._passwordEncoder = _passwordEncoder;
    }

    @Override
    public List<AccountDTO> GetAll() {
        List<Account> accounts = _accountRepo.findAll();
        List<AccountDTO> accountDTOS = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getDeleted_at() == null) {
                accountDTOS.add(AccountMapping.accountDTO(accounts.get(i)));
            }
        }
        return accountDTOS;
    }

    @Override
    public AccountDTO Create(RequestAccount requestAccount) {
        boolean checkEmail = Regex.regexEmail(requestAccount.getEmail());
        if (!checkEmail) {
            throw Variable.EmailInvalid;
        }
        boolean checkPassword = Regex.regexPassword(requestAccount.getPassword());
        if (!checkPassword) {
            throw Variable.PasswordInvalid;
        }
        requestAccount.setPassword(_passwordEncoder.encode(requestAccount.getPassword()));
        Account account = AccountMapping.account(requestAccount);
        _accountRepo.save(account);
        return (AccountDTO) AccountMapping.accountDTO(account);
    }

    @Override
    public AccountDTO Put(int id, RequestAccount r) {
        boolean checkEmailValid = Regex.regexEmail(r.getEmail());
        if (!checkEmailValid) {
            throw Variable.EmailInvalid;
        }
        boolean checkPasswordValid = Regex.regexPassword(r.getPassword());
        if (!checkPasswordValid) {
            throw Variable.PasswordInvalid;
        }
        Account getAccount = _accountRepo.findIdAccount(id);
        boolean checkAccountNotFound = (getAccount != null && getAccount.getDeleted_at() == null) ? false : true;
        if (checkAccountNotFound) {
            throw Variable.notFound;
        }
        r.setPassword(_passwordEncoder.encode(r.getPassword()));
        Account account = AccountMapping.AccountPut(r, getAccount);
        account.setId(id);
        _accountRepo.save(account);
        return (AccountDTO) AccountMapping.accountDTO(account);
    }

    @Override
    public AccountDTO Delete(int id) {
        Account account = _accountRepo.findIdAccount(id);
        boolean checkAccountNotFound = (account != null && account.getDeleted_at() == null) ? false : true;
        if (checkAccountNotFound) {
            throw Variable.notFound;
        }
        account.setDeleted_at(new Date());
        _accountRepo.save(account);
        return AccountMapping.accountDTO(account);
    }

    @Override
    public AccountDTO GetById(int id) {
        Account account = _accountRepo.findIdAccount(id);
        boolean checkAccountNotFound = (account != null && account.getDeleted_at() == null) ? false : true;
        if (checkAccountNotFound) {
            throw Variable.notFound;
        }
        AccountDTO accountDTO = AccountMapping.accountDTO(account);
        return accountDTO;
    }
}
