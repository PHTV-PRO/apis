package com.company.phtv.Models.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestLogin {
    private String full_name;
    private String email;
    private String password;
}
