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
                                _passwordEncoder.encode("tranbao"), 1, "TPHCM", "https://res.cloudinary.com/delgfr7a0/image/upload/v1723992848/driver1_vvnhtk.png",
                                Role.EMPLOYER));
                data.add(new Account(3, "Trần Ánh Mai", "anhmai@gmail.com",
                                _passwordEncoder.encode("anhmai"), 2, "ĐN", "https://res.cloudinary.com/delgfr7a0/image/upload/v1723992849/driver2_qguwrw.png",
                                Role.EMPLOYER));
                data.add(new Account(4, "Lê Anh Xuân", "leanhxuan@gmail.com",
                                _passwordEncoder.encode("leanhxuan"), 2, "HN", "https://res.cloudinary.com/delgfr7a0/image/upload/v1723992847/driver3_ld3nf4.png",
                                Role.EMPLOYER));
                data.add(new Account(5, "Trần Đình Phát", "trandinhphat@gmail.com",
                        _passwordEncoder.encode("dinhphat"), 1, "BT", "https://res.cloudinary.com/delgfr7a0/image/upload/v1723992846/driver4_yjauyl.png",
                        Role.EMPLOYER));
                data.add(new Account(6, "Lê Trọng Hoàng", "letronghoang@gmail.com",
                        _passwordEncoder.encode("tronghoang"), 1, "TH", "https://res.cloudinary.com/delgfr7a0/image/upload/v1723992849/driver5_cssstl.png",
                        Role.EMPLOYER));
                data.add(new Account(7, "Võ Bát Giáp", "vobatgiap@gmail.com",
                        _passwordEncoder.encode("batgiap"), 1, "BĐ", "https://res.cloudinary.com/delgfr7a0/image/upload/v1723992847/driver6_jh1bwr.png",
                        Role.EMPLOYER));
                data.add(new Account(8, "Trần Hồng Hoa", "tranhoanghoa@gmail.com",
                        _passwordEncoder.encode("honghoa"), 2, "BT", "https://res.cloudinary.com/delgfr7a0/image/upload/v1723992848/driver7_i37ri3.png",
                        Role.EMPLOYER));
                data.add(new Account(9, "Nguyễn Trần Phú", "nguyentranphu@gmail.com",
                        _passwordEncoder.encode("tranphu"), 1, "LĐ", "https://res.cloudinary.com/delgfr7a0/image/upload/v1723992848/driver8_nw4jk4.png",
                        Role.EMPLOYER));
                data.add(new Account(10, "Nguyễn Trần Minh Hoà", "nguyentranminhhoa@gmail.com",
                        _passwordEncoder.encode("minhhoa"), 1, "TPHCM", "https://res.cloudinary.com/delgfr7a0/image/upload/v1723992848/driver9_j3kftz.png",
                        Role.EMPLOYER));
                data.add(new Account(11, "Lê Thành Đạt", "lethanhdat@gmail.com",
                        _passwordEncoder.encode("thanhdat"), 1, "CM", "https://res.cloudinary.com/delgfr7a0/image/upload/v1723992847/driver10_alizdw.png",
                        Role.EMPLOYER));

                // Candidate
                data.add(new Account(12, "Lê Minh Mẫn", "leminhman@gmail.com",
                                _passwordEncoder.encode("minhman"), 1, "502/2 Hà Nội , Phường Đông Anh Quận Hoàn Kiếm", "https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg",
                                Role.CANDIDATE));
                data.add(new Account(13, "Trần Minh Minh", "tranminhminh@gmail.com",
                        _passwordEncoder.encode("minhmimh"), 1, "62 Hồ Xuân Hương", "https://toplist.vn/images/800px/hieu-anh-hoang-dung-318154.jpg",
                        Role.CANDIDATE));
                data.add(new Account(14, "Trần Đại Nghĩa", "trandainghia@gmail.com",
                        _passwordEncoder.encode("dainghia"), 1, "4/7 Bình Đức P15 Q 8 ,TPHCM", "https://toigingiuvedep.vn/wp-content/uploads/2021/07/mau-anh-the-dep-lam-the-can-cuoc.jpg",
                        Role.CANDIDATE));
                data.add(new Account(15, "Nguyễn Ngọc Trâm", "nguyengoctram@gmail.com",
                        _passwordEncoder.encode("ngoctram"), 2, "48 Hoà Bình , Tỉnh Điện Biên Hà Giang", "https://toplist.vn/images/800px/hieu-anh-hoang-dung-318155.jpg",
                        Role.CANDIDATE));
                data.add(new Account(16, "Lê Diễm My", "lediemmy@gmail.com",
                        _passwordEncoder.encode("diemmy"), 2, "12 Châu Thành , Xã Tam Phước ,  Bến Tre", "https://tse2.mm.bing.net/th?id=OIP.LkAaJ6W6oiKJpXoJ063k6QAAAA&pid=Api&P=0&h=220",
                        Role.CANDIDATE));
                data.add(new Account(17, "Trinh Xuan Thanh", "trinhxuanthan@gmail.com",
                        _passwordEncoder.encode("xuanthanh"), 1, "40 Bắc Giang", "https://toplist.vn/images/800px/studio-hong-ngoc-318809.jpg",
                        Role.CANDIDATE));
                data.add(new Account(18, "Lê Thành ", "lethanh@gmail.com",
                        _passwordEncoder.encode("lethanh"), 1, "41/1 Đất Mũi , Phường An Khánh , Tỉnh Cà Mau", "https://img2.thuthuatphanmem.vn/uploads/2019/05/06/anh-the-nam-dep-nhat_100828554.jpg",
                        Role.CANDIDATE));
                data.add(new Account(19, "Phạm Phúc Hậu", "phamphuchau@gmail.com",
                        _passwordEncoder.encode("phuchau"), 1, "49 Điện Biên , Phường Hoà Bình , Điện Biên Phủ", "https://www.uit.edu.vn/sites/vi/files/uploads/images/thumbs/202111/hoang.png",
                        Role.CANDIDATE));
                data.add(new Account(20, "Lê Văn Luyện", "binhnhi05102000@gmail.com",
                        _passwordEncoder.encode("vanluyen"), 1, "21A Bến Tre Tỉnh Châu Thành , Huyện Ba Tri ", "https://img2.thuthuatphanmem.vn/uploads/2019/05/06/anh-the-nam-sinh-dep_100828613.jpg",
                        Role.CANDIDATE));
                data.add(new Account(21, "Nguyễn Lệ Nhi", "trantoan1682016@gmail.com",
                        _passwordEncoder.encode("lenhi"), 2, "Đài Bắc , Trung Hoa", "https://haycafe.vn/wp-content/uploads/2021/12/mau-anh-the-dep-nu-toc-dai-den-chup-phong-nen-xanh.jpg",
                        Role.CANDIDATE));
//                data.add(new Account(22, "Trần Gia Toàn", "trantoan1682016@gmail.com",
//                        _passwordEncoder.encode("trantoan"), 1, "Bến Tre", null,
//                        Role.CANDIDATE));
                return data;
        }
}
