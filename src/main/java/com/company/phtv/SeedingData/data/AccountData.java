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
                data.add(new Account(1, "Admin", "admin@gmail.com",
                        _passwordEncoder.encode("admin"), 1, "HP", null,
                        Role.ADMIN));
//                Employer
                data.add(new Account(2, "Trần Anh Bảo", "tranbao@gmail.com",
                                _passwordEncoder.encode("tranbao"), 1, "TPHCM", null,
                                Role.EMPLOYER));
                data.add(new Account(3, "Trần Ánh Mai", "anhmai@gmail.com",
                                _passwordEncoder.encode("anhmai"), 2, "ĐN", null,
                                Role.EMPLOYER));
                data.add(new Account(4, "Lê Anh Xuân", "leanhxuan@gmail.com",
                                _passwordEncoder.encode("leanhxuan"), 2, "HN", null,
                                Role.EMPLOYER));
                data.add(new Account(5, "Trần Đình Phát", "trandinhphat@gmail.com",
                        _passwordEncoder.encode("dinhphat"), 1, "BT", null,
                        Role.EMPLOYER));
                data.add(new Account(6, "Lê Trọng Hoàng", "letronghoang@gmail.com",
                        _passwordEncoder.encode("tronghoang"), 1, "TH", null,
                        Role.EMPLOYER));
                data.add(new Account(7, "Võ Bát Giáp", "vobatgiap@gmail.com",
                        _passwordEncoder.encode("batgiap"), 1, "BĐ", null,
                        Role.EMPLOYER));
                data.add(new Account(8, "Trần Hồng Hoa", "tranhoanghoa@gmail.com",
                        _passwordEncoder.encode("honghoa"), 2, "BT", null,
                        Role.EMPLOYER));
                data.add(new Account(9, "Nguyễn Trần Phú", "nguyentranphu@gmail.com",
                        _passwordEncoder.encode("tranphu"), 1, "LĐ", null,
                        Role.EMPLOYER));
                data.add(new Account(10, "Nguyễn Trần Minh Hoà", "nguyentranminhhoa@gmail.com",
                        _passwordEncoder.encode("minhhoa"), 1, "TPHCM", null,
                        Role.EMPLOYER));
                data.add(new Account(11, "Lê Thành Đạt", "lethanhdat@gmail.com",
                        _passwordEncoder.encode("thanhdat"), 1, "CM", null,
                        Role.EMPLOYER));

                // Candidate
                data.add(new Account(12, "Lê Minh Mẫn", "leminhman@gmail.com",
                                _passwordEncoder.encode("minhman"), 1, "502/2 Hà Nội , Phường Đông Anh Quận Hoàn Kiếm", null,
                                Role.CANDIDATE));
                data.add(new Account(13, "Trần Minh Minh", "tranminhminh@gmail.com",
                        _passwordEncoder.encode("minhmimh"), 2, "62 Hồ Xuân Hương", null,
                        Role.CANDIDATE));
                data.add(new Account(14, "Trần Đại Nghĩa", "trandainghia@gmail.com",
                        _passwordEncoder.encode("dainghia"), 1, "4/7 Bình Đức P15 Q 8 ,TPHCM", null,
                        Role.CANDIDATE));
                data.add(new Account(15, "Nguyễn Ngọc Trâm", "nguyengoctram@gmail.com",
                        _passwordEncoder.encode("ngoctram"), 2, "48 Hoà Bình , Tỉnh Điện Biên Hà Giang", null,
                        Role.CANDIDATE));
                data.add(new Account(16, "Lê Diễm My", "lediemmy@gmail.com",
                        _passwordEncoder.encode("diemmy"), 2, "12 Châu Thành , Xã Tam Phước ,  Bến Tre", null,
                        Role.CANDIDATE));
                data.add(new Account(17, "Trinh Xuan Thanh", "trinhxuanthan@gmail.com",
                        _passwordEncoder.encode("xuanthanh"), 1, "40 Bắc Giang", null,
                        Role.CANDIDATE));
                data.add(new Account(18, "Lê Thành ", "lethanh@gmail.com",
                        _passwordEncoder.encode("lethanh"), 1, "41/1 Đất Mũi , Phường An Khánh , Tỉnh Cà Mau", null,
                        Role.CANDIDATE));
                data.add(new Account(19, "Phạm Phúc Hậu", "phamphuchau@gmail.com",
                        _passwordEncoder.encode("phuchau"), 1, "49 Điện Biên , Phường Hoà Bình , Đin Biên Phủ", null,
                        Role.CANDIDATE));
                data.add(new Account(20, "Lê Văn Luyện", "levanluyen@gmail.com",
                        _passwordEncoder.encode("vanluyen"), 1, "21A Bến Tre Tỉnh Châu Thành , Huyện Ba Tri ", null,
                        Role.CANDIDATE));
                data.add(new Account(21, "Nguyễn Lệ Nhi", "nguyenlenhi@gmail.com",
                        _passwordEncoder.encode("lenhi"), 2, "Đài Bắc , Trung Hoa", null,
                        Role.CANDIDATE));


                return data;
        }
}
