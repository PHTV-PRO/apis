package com.company.phtv.SeedingData.data;

import com.company.phtv.Enums.Role;
import com.company.phtv.Models.Entity.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountData {
    public List<Account> Data() {
        List<Account> data = new ArrayList<>();
        data.add(new Account(1, "Trần Anh Bảo", "tranbao@gmail.com",
                "$2a$10$Ed1SDqjkl22u.oI.GhL52OPMFX.NzCeLt8Dee.sP/OC5ofBG1Qcce", 1, "TPHCM", null, Role.CANDIDATE));//pass:candidate
        data.add(new Account(2, "Trần Ánh Mai", "anhmai@gmail.com",
                "$2a$10$Ed1SDqjkl22u.oI.GhL52OPMFX.NzCeLt8Dee.sP/OC5ofBG1Qcce", 2, "ĐN", null, Role.CANDIDATE));
        data.add(new Account(3, "Lê Anh Xuân", "leanhxuan@gmail.com",
                "$2a$10$Ed1SDqjkl22u.oI.GhL52OPMFX.NzCeLt8Dee.sP/OC5ofBG1Qcce", 2, "HN", null, Role.CANDIDATE));
        data.add(new Account(4, "Admin", "admin@gmail.com",
                "$2a$10$toormj83AOYV/3pTYVl0/OW29meD0/5nKwZ1dm9dGVUU7E5vJusgq", 1, "TPHCM", null, Role.ADMIN));//pass:admin
        return data;
    }
}
