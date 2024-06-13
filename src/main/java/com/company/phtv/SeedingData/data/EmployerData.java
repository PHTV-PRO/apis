package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.Employer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

import static com.company.phtv.Enums.Role.EMPLOYER;

public class EmployerData {
        private final PasswordEncoder _passwordEncoder;

        public EmployerData(PasswordEncoder _passwordEncoder) {
                this._passwordEncoder = _passwordEncoder;
        }

        public List<Employer> Data() {
                List<Employer> data = new ArrayList<>();
                data.add(new Employer(1,
                                "LP Bank Admin",
                                "lp_bank@gmail.com",
                                _passwordEncoder.encode("123"),
                                "Tòa nhà LPB, số 210 Trần Quang Khải, Phường Tràng Tiền, Quận Hoàn Kiếm, Thành phố Hà Nội",
                                EMPLOYER));
                data.add(new Employer(2,
                                "Sprayway Admin",
                                "sprayway@gmail.com",
                                _passwordEncoder.encode("123"),
                                "Số 5 Lê Trung Nghĩa, Phường 12, Quận Tân Bình, TP Hồ Chí Minh",
                                EMPLOYER));
                data.add(new Employer(3,
                                "LIKELION Admin",
                                "likelion@gmail.com",
                                _passwordEncoder.encode("123"),
                                "Tầng 25, Tòa nhà Lim Tower, 9 - 11 Tôn Đức Thắng, Phường Bến Nghé, Quận 1, Thành phố Hồ Chí Minh",
                                EMPLOYER));

                return data;
        }
}
