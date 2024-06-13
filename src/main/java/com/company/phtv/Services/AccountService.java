package com.company.phtv.Services;

import com.company.phtv.Models.DTO.AccountDTO;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Map.AccountMapping;
import com.company.phtv.Models.Request.RequestAccount;
import com.company.phtv.Repository.AccountRepo;
import com.company.phtv.Services.IServices.IAccountService;
import com.company.phtv.Utils.HttpException;
import com.company.phtv.Utils.Regex;
import com.company.phtv.Utils.Variable;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
            throw Variable.emailInvalid;
        }
        // boolean checkPassword = Regex.regexPassword(requestAccount.getPassword());
        // if (!checkPassword) {
        // throw Variable.PasswordInvalid;
        // }
        requestAccount.setPassword(_passwordEncoder.encode(requestAccount.getPassword()));
        // Path uploadPath = Paths.get("src/main/resources/Uploads/Images/Accounts/");
        // if (!Files.exists(uploadPath)) {
        // try {
        // Files.createDirectory(uploadPath);
        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        // }

        // String fileCode = RandomStringUtils.randomAlphanumeric(8);
        // String fileName;
        // try (InputStream inputStream =
        // requestAccount.getUploadFile().getInputStream()) {
        // fileName = fileCode + "_" +
        // requestAccount.getUploadFile().getOriginalFilename();
        // Path filePath = uploadPath.resolve(fileName);
        // Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        // } catch (Exception e) {
        // throw new HttpException(500, e.getMessage());
        // }
        Account account = AccountMapping.account(requestAccount, "");
        try {
            @SuppressWarnings("rawtypes")
            Map check = _cloudinaryService.uploadFile(requestAccount.UploadFile, account.getImage());
            account.setImage(check.get("public_id").toString());
        } catch (IOException e) {
            throw Variable.AddImageFail;
        }

        _accountRepo.save(account);
        return (AccountDTO) AccountMapping.accountDTO(account);
    }

    @Override
    public AccountDTO put(int id, RequestAccount r) {
        boolean checkEmailValid = Regex.regexEmail(r.getEmail());
        if (!checkEmailValid) {
            throw Variable.emailInvalid;
        }
        // boolean checkPasswordValid = Regex.regexPassword(r.getPassword());
        // if (!checkPasswordValid) {
        // throw Variable.PasswordInvalid;
        // }
        Account getAccount = _accountRepo.findIdAccount(id);
        boolean checkAccountNotFound = (getAccount != null && getAccount.getDeleted_at() == null) ? false : true;
        if (checkAccountNotFound) {
            throw Variable.notFound;
        }
        r.setPassword(_passwordEncoder.encode(r.getPassword()));
        Path uploadPath = Paths.get("src/main/resources/Uploads/Images/Accounts/");
        if (!Files.exists(uploadPath)) {
            try {
                Files.createDirectory(uploadPath);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        String fileCode = RandomStringUtils.randomAlphanumeric(8);
        String fileName;
        try (InputStream inputStream = r.getUploadFile().getInputStream()) {
            fileName = fileCode + "_" + r.getUploadFile().getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new HttpException(500, e.getMessage());
        }
        Account account = AccountMapping.AccountPut(r, getAccount, fileName);
        account.setId(id);
        _accountRepo.save(account);
        return (AccountDTO) AccountMapping.accountDTO(account);
    }

    @Override
    public AccountDTO delete(int id) {
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
    public AccountDTO getById(int id) {
        Account account = _accountRepo.findIdAccount(id);
        boolean checkAccountNotFound = (account != null && account.getDeleted_at() == null) ? false : true;
        if (checkAccountNotFound) {
            throw Variable.notFound;
        }
        AccountDTO accountDTO = AccountMapping.accountDTO(account);
        return accountDTO;
    }
}
