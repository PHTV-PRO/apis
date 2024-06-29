package com.company.phtv.Services.IServices;

import com.company.phtv.Models.DTO.AccountDTO;
import com.company.phtv.Models.Request.RequestAccount;

import java.util.List;

public interface IAccountService {
    List<AccountDTO> getAll();

    AccountDTO create(RequestAccount requestAccount);

    AccountDTO put(int id, RequestAccount r);

    AccountDTO delete(int id);

    AccountDTO getById(int id);
    AccountDTO getAccountCompanyJob();

}
