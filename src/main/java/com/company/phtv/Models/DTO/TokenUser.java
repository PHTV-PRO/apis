package com.company.phtv.Models.DTO;


import com.company.phtv.Models.Entity.Account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenUser {
    private String token;
    private Account account;
}
