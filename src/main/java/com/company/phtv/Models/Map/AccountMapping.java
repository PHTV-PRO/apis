package com.company.phtv.Models.Map;

import com.company.phtv.Models.DTO.AccountDTO;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Request.RequestAccount;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AccountMapping {
    PasswordEncoder _passwordEncoder;
    public AccountMapping(PasswordEncoder _passwordEncoder){
        this._passwordEncoder = _passwordEncoder;
    }
    public static AccountDTO accountDTO(Account a){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(a.getId());
        accountDTO.setName(a.getName());
        accountDTO.setEmail(a.getEmail());
        accountDTO.setPassword(a.getPassword());
        accountDTO.setGender(a.getGender());
        accountDTO.setAddress(a.getAddress());
        accountDTO.setImage(a.getImage());
        accountDTO.setRole(a.getRole());
        return accountDTO;
    }

    public static Account account(RequestAccount a){
        Account account = new Account();
        account.setName(a.getName());
        account.setEmail(a.getEmail());
        account.setPassword(a.getPassword());
        account.setGender(a.getGender());
        account.setAddress(a.getAddress());
        account.setImage(a.getImage());
        account.setRole(a.getRole());
        return account;
    }

    public static  Account AccountPut(RequestAccount re,Account a){
        if(re.getName() != null){
            a.setName(re.getName());
        }
        if(re.getEmail() != null){
            a.setEmail(re.getEmail());
        }

        if(re.getPassword() != null){
            a.setPassword(re.getPassword());
        }
        if(re.getGender() != 0){
            a.setGender(re.getGender());
        }
        if(re.getAddress() != null){
            a.setAddress(re.getAddress());
        }
        if(re.getImage() != null){
            a.setImage(re.getImage());
        }
        if(re.getRole() != null){
            a.setRole(re.getRole());
        }
        return  a;
    }
}
