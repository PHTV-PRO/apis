package com.company.phtv.SeedingData.data;

import com.company.phtv.Enums.Role;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.JobType;

import java.util.ArrayList;
import java.util.List;

public class AccountData {
    public List<Account> Data(){
        List<Account> data = new ArrayList<>();
        data.add(new Account(1,"Trần Anh Bảo","tranbao@gmail.com","123",1,"TPHCM",null, Role.CANDIDATE));
        data.add(new Account(2,"Trần Ánh Mai","anhmai@gmail.com","123",2,"ĐN",null, Role.CANDIDATE));
        data.add(new Account(3,"Lê Anh Xuân","leanhxuan@gmail.com","123",2,"HN",null, Role.CANDIDATE));
        data.add(new Account(4,"Admin","admin@gmail.com","123",1,"TPHCM",null, Role.ADMIN));
        return data;
    }
}
