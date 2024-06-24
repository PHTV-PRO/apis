package com.company.phtv.Models.DTO;

import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.Application;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CVDTO {
    private int id;
    private String file_name;

    private Account account;

    private Application application;

}
