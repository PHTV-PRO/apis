package com.company.phtv.Services.IServices;

import com.company.phtv.Models.DTO.AccountDTO;
import com.company.phtv.Models.Request.RequestAccount;

import java.util.List;

public interface IAccountService {
    List<AccountDTO> GetAll();
    AccountDTO Create(RequestAccount requestAccount);
    AccountDTO Put(int id, RequestAccount r);
    AccountDTO Delete(int id);
    AccountDTO GetById(int id);

}
