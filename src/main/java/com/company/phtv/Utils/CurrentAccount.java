package com.company.phtv.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Repository.AccountRepo;

/**
 * CurrentAccount
 */
@Service
public class CurrentAccount {
    @Autowired
    AccountRepo _accountRepo;

    public Account getAccount() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Account account = (Account) auth.getPrincipal();
        return _accountRepo.findIdAccount(account.getId());
    }
}