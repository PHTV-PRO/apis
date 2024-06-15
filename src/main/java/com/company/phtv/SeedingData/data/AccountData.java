package com.company.phtv.SeedingData.data;

import com.company.phtv.Enums.Role;
import com.company.phtv.Models.Entity.Account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

public class AccountData {
        private final PasswordEncoder _passwordEncoder;

        public AccountData(PasswordEncoder _passwordEncoder) {
                this._passwordEncoder = _passwordEncoder;
        }

        public List<Account> Data() {

                List<Account> data = new ArrayList<>();
                data.add(new Account(1, "Trần Anh Bảo", "tranbao@gmail.com",
                                _passwordEncoder.encode("tranbao"), 1, "TPHCM", null,
                                Role.EMPLOYER));
                data.add(new Account(2, "Trần Ánh Mai", "anhmai@gmail.com",
                                _passwordEncoder.encode("anhmai"), 2, "ĐN", null,
                                Role.EMPLOYER));
                data.add(new Account(3, "Lê Anh Xuân", "leanhxuan@gmail.com",
                                _passwordEncoder.encode("leanhxuan"), 2, "HN", null,
                                Role.EMPLOYER));
                data.add(new Account(4, "Admin", "admin@gmail.com",
                                _passwordEncoder.encode("admin"), 1, "TPHCM", null,
                                Role.ADMIN));
                data.add(new Account(5, "Lê Anh Xuân", "candidate@gmail.com",
                                _passwordEncoder.encode("candidate"), 2, "LD", null,
                                Role.CANDIDATE));
                return data;
        }
}
