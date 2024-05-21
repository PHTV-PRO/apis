package com.company.phtv.Services.IServices;

import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Request.RequestLogin;

public interface IAuthenticateService {
    String login(RequestLogin requestLogin);
    Account register(RequestLogin requestLogin);
    Account checkToken(String token);

}
 