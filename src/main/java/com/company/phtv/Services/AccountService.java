package com.company.phtv.Services;

import com.company.phtv.Models.DTO.AccountDTO;
import com.company.phtv.Models.DTO.EmployerDTO;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.Employer;
import com.company.phtv.Models.Map.AccountMapping;
import com.company.phtv.Models.Request.RequestAccount;
import com.company.phtv.Repository.AccountRepo;
import com.company.phtv.Services.IServices.IAccountService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    AccountRepo _accountRepo;
    @Override
    public List<AccountDTO> GetAll() {
        List<Account> accounts = _accountRepo.findAll();
        List<AccountDTO> accountDTOS = new ArrayList<>();
        if(accounts.size() < 1){
            throw new HttpException(404,"Not Found");
        }
        for(Account ac : accounts){
            accountDTOS.add(AccountMapping.accountDTO(ac));
        }
        return accountDTOS;
    }

    @Override
    public AccountDTO Create(RequestAccount requestAccount) {
        Account account = AccountMapping.account(requestAccount);
        _accountRepo.save(account);
        return (AccountDTO) AccountMapping.accountDTO(account);
    }

    @Override
    public AccountDTO Put(int id, RequestAccount r) {
        Account getAccount = _accountRepo.findIdAccount(id);
        Account account = AccountMapping.AccountPut(r,getAccount);
        account.setId(id);
        _accountRepo.save(account);
        return (AccountDTO) AccountMapping.accountDTO(account);
    }

    @Override
    public AccountDTO Delete(int id) {
        _accountRepo.deleteById(id);
        return null;
    }

    @Override
    public AccountDTO GetById(int id) {
        Account account = _accountRepo.findIdAccount(id);
        AccountDTO accountDTO = AccountMapping.accountDTO(account);
        return accountDTO;
    }
}
