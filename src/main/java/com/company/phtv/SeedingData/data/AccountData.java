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
                                _passwordEncoder.encode("admin"), 1, "HP", null,
                                Role.ADMIN));
                data.add(new Account(5, "Lê Minh Mẫn", "leminhman@gmail.com",
                                _passwordEncoder.encode("minhman"), 1, "HN", null,
                                Role.CANDIDATE));
                data.add(new Account(6, "Trần Minh Minh", "tranminhminh@gmail.com",
                        _passwordEncoder.encode("minhmimh"), 2, "ĐL", null,
                        Role.CANDIDATE));
                data.add(new Account(7, "Trần Đại Nghĩa", "trandainghia@gmail.com",
                        _passwordEncoder.encode("dainghia"), 1, "TPHCM", null,
                        Role.CANDIDATE));
                data.add(new Account(8, "Nguyễn Ngọc Trâm", "nguyengoctram@gmail.com",
                        _passwordEncoder.encode("ngoctram"), 2, "HG", null,
                        Role.CANDIDATE));
                data.add(new Account(9, "Lê Diễm My", "lediemmy@gmail.com",
                        _passwordEncoder.encode("diemmy"), 2, "BT", null,
                        Role.CANDIDATE));
                data.add(new Account(10, "Lê Thành Đạt", "lethanhdat@gmail.com",
                        _passwordEncoder.encode("thanhdat"), 1, "CM", null,
                        Role.CANDIDATE));
                data.add(new Account(11, "Trần Đình Phát", "trandinhpaht@gmail.com",
                        _passwordEncoder.encode("dinhphat"), 1, "BT", null,
                        Role.EMPLOYER));
                data.add(new Account(12, "Lê Trọng Hoàng", "letronghoang@gmail.com",
                        _passwordEncoder.encode("tronghoang"), 1, "TH", null,
                        Role.EMPLOYER));
                data.add(new Account(13, "Võ Bát Giáp", "vobatgiap@gmail.com",
                        _passwordEncoder.encode("batgiap"), 1, "BĐ", null,
                        Role.EMPLOYER));
                data.add(new Account(14, "Trần Hồng Hoa", "tranhoanghoa@gmail.com",
                        _passwordEncoder.encode("honghoa"), 2, "BT", null,
                        Role.EMPLOYER));
                data.add(new Account(15, "Nguyễn Trần Phú", "nguyentranphu@gmail.com",
                        _passwordEncoder.encode("tranphu"), 1, "LĐ", null,
                        Role.EMPLOYER));
                data.add(new Account(16, "Nguyễn Trần Minh Hoà", "nguyentranminhhoa@gmail.com",
                        _passwordEncoder.encode("minhhoa"), 1, "TPHCM", null,
                        Role.EMPLOYER));
                data.add(new Account(17, "Lê Thành Đạt", "lethanhdat@gmail.com",
                        _passwordEncoder.encode("thanhdat"), 1, "CM", null,
                        Role.EMPLOYER));
                return data;
        }
}
