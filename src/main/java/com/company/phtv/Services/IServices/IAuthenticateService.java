package com.company.phtv.Services.IServices;

import com.company.phtv.Models.DTO.AccountDTO;
import com.company.phtv.Models.DTO.TokenUser;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Request.RequestLogin;

public interface IAuthenticateService {
    TokenUser login(RequestLogin requestLogin);

    Account register(RequestLogin requestLogin);

    AccountDTO checkToken(String token);
    AccountDTO checkTokenWeb(String token);



}
