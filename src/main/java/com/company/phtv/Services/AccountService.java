package com.company.phtv.Services;

import com.company.phtv.Models.DTO.AccountDTO;
import com.company.phtv.Models.DTO.CVDTO;
import com.company.phtv.Models.DTO.CompanyDTO;
import com.company.phtv.Models.DTO.JobDTO;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Models.Entity.CurriculumVitae;
import com.company.phtv.Models.Entity.Jobs;
import com.company.phtv.Models.Map.AccountMapping;
import com.company.phtv.Models.Map.CVMapping;
import com.company.phtv.Models.Map.CompanyMapping;
import com.company.phtv.Models.Map.JobMapping;
import com.company.phtv.Models.Request.RequestAccount;
import com.company.phtv.Repository.AccountRepo;
import com.company.phtv.Repository.CompanyRepo;
import com.company.phtv.Services.IServices.IAccountService;
import com.company.phtv.Utils.CurrentAccount;
import com.company.phtv.Utils.Regex;
import com.company.phtv.Utils.Variable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AccountService implements IAccountService {
    @Autowired
    AccountRepo _accountRepo;

    @Autowired
    PasswordEncoder _passwordEncoder;

    @Autowired
    CloudinaryService _cloudinaryService;

    @Autowired
    CompanyRepo _companyRepo;

     @Autowired
    CurrentAccount _currentAccount;


    public AccountService(PasswordEncoder _passwordEncoder) {
        this._passwordEncoder = _passwordEncoder;
    }


    @Override
    public List<AccountDTO> getAll() {
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
    public AccountDTO create(RequestAccount requestAccount) {
        boolean checkEmail = Regex.regexEmail(requestAccount.getEmail());
        if (!checkEmail) {
            throw Variable.EMAIL_INVALID;
        }
        boolean checkPassword = Regex.regexPassword(requestAccount.getPassword());
        if (!checkPassword) {
            throw Variable.PASSWORD_INVALID;
        }
        requestAccount.setPassword(_passwordEncoder.encode(requestAccount.getPassword()));
        Account account = AccountMapping.account(requestAccount);
        if (requestAccount.UploadFile != null) {
            try {
                // create image in cloudinary
                @SuppressWarnings("rawtypes")
                Map check = _cloudinaryService.uploadImage(requestAccount.UploadFile, account.getImage());
                account.setImage(Variable.PATH_IMAGE + check.get("public_id").toString());
            } catch (IOException e) {
                throw Variable.ADD_IMAGE_FAIL;
            }
        }
        _accountRepo.save(account);
        return (AccountDTO) AccountMapping.accountDTO(account);
    }

    @Override
    public AccountDTO put(int id, RequestAccount r) {
        boolean checkEmailValid = Regex.regexEmail(r.getEmail());
        if (!checkEmailValid) {
            throw Variable.EMAIL_INVALID;
        }
        boolean checkPasswordValid = Regex.regexPassword(r.getPassword());
        if (!checkPasswordValid) {
            throw Variable.PASSWORD_INVALID;
        }
        Account getAccount = _accountRepo.findIdAccount(id);
        boolean checkAccountNotFound = (getAccount != null && getAccount.getDeleted_at() == null) ? false : true;

        if (checkAccountNotFound) {
            throw Variable.NOT_FOUND;
        }
        r.setPassword(_passwordEncoder.encode(r.getPassword()));
        if (r.UploadFile != null) {
            try {
                // create image in cloudinary
                @SuppressWarnings("rawtypes")
                Map check = _cloudinaryService.uploadImage(r.UploadFile, getAccount.getImage());
                getAccount.setImage(Variable.PATH_IMAGE + check.get("public_id").toString());
            } catch (IOException e) {
                throw Variable.ADD_IMAGE_FAIL;
            }
        }
        Account account = AccountMapping.AccountPut(r, getAccount);
        account.setId(id);
        _accountRepo.save(account);
        return (AccountDTO) AccountMapping.accountDTO(account);
    }

    @Override
    public AccountDTO delete(int id) {
        Account account = _accountRepo.findIdAccount(id);
        boolean checkAccountNotFound = (account != null && account.getDeleted_at() == null) ? false : true;
        if (checkAccountNotFound) {
            throw Variable.NOT_FOUND;
        }
        account.setDeleted_at(new Date());
        _accountRepo.save(account);
        return AccountMapping.accountDTO(account);
    }

    @Override
    public AccountDTO getById(int id) {
        Account account = _accountRepo.findIdAccount(id);
        boolean checkAccountNotFound = (account != null && account.getDeleted_at() == null) ? false : true;
        if (checkAccountNotFound) {
            throw Variable.NOT_FOUND;
        }
        AccountDTO accountDTO = AccountMapping.accountDTO(account);
        // accountDTO.setCompany(acc);
        return accountDTO;
    }

    @Override
    public AccountDTO updateProfileByAccount(RequestAccount r) {
        Account getAccount = _currentAccount.getAccount();
        if (getAccount == null) {
            throw Variable.NOT_FOUND;
        }
        boolean checkEmailValid = Regex.regexEmail(r.getEmail());
        if (!checkEmailValid) {
            throw Variable.EMAIL_INVALID;
        }
        boolean checkPasswordValid = Regex.regexPassword(r.getPassword());
        if (!checkPasswordValid) {
            throw Variable.PASSWORD_INVALID;
        }
        boolean checkAccountNotFound = (getAccount != null && getAccount.getDeleted_at() == null) ? false : true;

        if (checkAccountNotFound) {
            throw Variable.NOT_FOUND;
        }
        r.setPassword(_passwordEncoder.encode(r.getPassword()));
        if (r.UploadFile != null) {
            try {
                // create image in cloudinary
                @SuppressWarnings("rawtypes")
                Map check = _cloudinaryService.uploadImage(r.UploadFile, getAccount.getImage());
                getAccount.setImage(Variable.PATH_IMAGE + check.get("public_id").toString());
            } catch (IOException e) {
                throw Variable.ADD_IMAGE_FAIL;
            }
        }
        Account account = AccountMapping.AccountPut(r, getAccount);
//        account.setId(id);
        _accountRepo.save(account);
        return (AccountDTO) AccountMapping.accountDTO(account);
    }

    @Override
    public AccountDTO getAccountCompanyJob() {
        Account account = _currentAccount.getAccount();
        AccountDTO accountDTO = new AccountDTO();
        accountDTO = AccountMapping.accountDTO(account);
        boolean checkAccountNotFound = (account != null && account.getDeleted_at() == null) ? false : true;
        if (checkAccountNotFound) {
            throw Variable.NOT_FOUND;
        }
        Company company = _companyRepo.findOneCompanyWithAccount(account);
        boolean checkCompanyExisting = company != null;
        if (checkCompanyExisting) {
            CompanyDTO companyDTO = CompanyMapping.CompanyDTO(company);
            if (company.getJobs().size() > 0) {
                List<JobDTO> jobDTOs = new ArrayList<>();
                for (Jobs job : company.getJobs()) {
                    jobDTOs.add(JobMapping.getJob(job));
                }
                companyDTO.setJobs(jobDTOs);
            }
            accountDTO.setCompany(companyDTO);
        }
        return accountDTO;
    }
}
