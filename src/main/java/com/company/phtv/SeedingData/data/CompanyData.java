package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Repository.AccountRepo;

import java.util.ArrayList;
import java.util.List;

public class CompanyData {

        private final AccountRepo _AccountRepo;

        public CompanyData(AccountRepo _AccountRepo) {
                this._AccountRepo = _AccountRepo;
        }

        @SuppressWarnings("deprecation")
        public List<Company> Data() {
                List<Company> data = new ArrayList<>();
                data.add(new Company(1,
                                "NGÂN HÀNG THƯƠNG MẠI CỔ PHẦN BƯU ĐIỆN LIÊN VIỆT",
                                "Ngân hàng Thương mại Cổ phần Bưu điện Liên Việt (LPBank) tiền thân là Ngân hàng Thương mại Cổ phần Liên Việt (LienVietBank) được thành lập theo Giấy phép thành lập và hoạt động số 91/GP-NHNN ngày 28/03/2008 của Thống đốc Ngân hàng Nhà nước Việt Nam.\n"
                                                +
                                                "\n" +
                                                "Năm 2011, với việc Tổng Công ty Bưu chính Việt Nam góp vốn vào LienVietBank bằng giá trị Công ty Dịch vụ Tiết kiệm Bưu điện (VPSC) và bằng tiền mặt. Ngân hàng Liên Việt đã được Thủ tướng Chính phủ và Thống đốc Ngân hàng Nhà nước Việt Nam cho phép đổi tên thành Ngân hàng Thương mại Cổ phần Bưu điện Liên Việt. Cùng với việc đổi tên này, Tổng Công ty Bưu chính Việt Nam chính thức trở thành cổ đông lớn nhất của LPBank\n"
                                                +
                                                "\n" +
                                                "Sau 15 năm thành lập và hoạt động, LPBank đã phát triển thành 1 trong top 10 NHTMCP lớn nhất Việt Nam với tổng tài sản trên 327.000 tỷ đồng, vốn điều lệ đạt 17.241 tỷ đồng. Hiện LPBank cũng là một trong những NH có mạng lưới rộng nhất trong hệ thống NH với 561 chi nhánh, phòng giao dịch và hơn 10.000 điểm cung cấp dịch vụ. Tổng số nhân sự của LPBank đã lên tới hơn 12.000 người.",
                                "Thưởng các Ngày lễ, Tết theo chính sách ngân hàng từng thời kỳ (Từ 16-18 tháng lương/ năm)\n"
                                                +
                                                "Đầy đủ các chế độ, quyền lợi của cán bộ nhân viên Ngân hàng.\n" +
                                                "Môi trường năng động, thân thiện, gần gũi. Có nhiều cơ hội học đào tạo, học hỏi và phát triển.\n"
                                                +
                                                "Chính sách review lương hàng năm\n" +
                                                "Cung cấp thiết bị làm việc\n" +
                                                "Du lịch/team building hằng năm\n" +
                                                "Tham gia đầy đủ bảo hiểm (BHXH/BHYT)\n" +
                                                "12 ngày phép năm\n" +
                                                "Làm việc từ 08h00 đến 17h00, từ Thứ 2 đến Thứ 6 hàng tuần. Từ 08h00 đến 12h00 sáng Thứ 7",
                                "Middle, Senior",
                                "10000",
                                "19000",
                                "https://jobs.lpbank.com.vn/vi",
                                "Việt Nam",
                                null,
                                null,
                                0,
                                0,
                                _AccountRepo.getOne(1)));
                data.add(new Company(2,
                                "CÔNG TY TNHH SPRAYWAY-TPR",
                                "Giới thiệu về công ty Sprayway-TPR\n" +
                                                "• Công ty Sprayway-TPR là một trong những chi nhánh trực thuộc Công ty Sprayway Singapore có văn phòng chính tại Singapore, và chi nhánh ở các nước Mỹ, Trung Quốc, Ấn Độ, Campuchia và Việt Nam.\n"
                                                +
                                                "• Công ty chúng tôi chuyên cung cấp, hỗ trợ và phân phối sản phẩm nhãn hiệu Sprayway và TPR tại các quốc gia như Mỹ, Châu Phi, Châu Á , Châu Âu và Trung Đông. Hơn 70 năm tại Mỹ, Sprayway cung cấp các bình xịt chất lượng cao trong 18 ngành nghề như công nghiệp may-thêu-in ấn, ngành gia dụng, ngành công nghiệp ô tô.... Bằng công nghệ tiên tiến hàng đầu, chúng tôi đảm bảo khách hàng sẽ nhận được các sản phẩm cao cấp trong điều kiện đóng gói hoàn hảo.\n"
                                                +
                                                "• Vui lòng truy các trang web của chúng tôi để biết thêm chi tiết:\n" +
                                                "www.spraywayvietnam.com; www.sprayway-tpr.com",
                                null,
                                "Nhân Viên",
                                "25",
                                "99",
                                "http://www.sprayway-tpr.com/vn/",
                                "Việt Nam",
                                null,
                                null,
                                0,
                                0,
                                _AccountRepo.getOne(2)));
                data.add(new Company(3,
                                "CÔNG TY TNHH LIKELION",
                                "Tài trợ 100% bởi Chính phủ Hàn Quốc, đây là dự án đầu tiên thực hiện kết nối việc làm  cho sinh viên Việt Nam với các Doanh nghiệp Start-up Hàn Quốc. Các bạn sẽ trải qua đào tạo thực chiến và được trải nghiệm sinh sống và làm việc tại các thành phố lớn của Hàn Quốc.",
                                "Hỗ trợ cơm trưa cho các lớp fulltime\n" +
                                                "Cho mượn trang thiết bị học tập trong quá trình đào tạo\n" +
                                                "Hỗ trợ thông dịch khi phỏng vấn cùng Doanh nghiệp\n" +
                                                "Hỗ trợ tư vấn chuẩn bị hồ sơ xin VISA (sau khi đậu tuyển dụng)\n" +
                                                "Ứng viên được đào tạo miễn phí 5 tháng\n" +
                                                "Kết nối việc làm tại các công ty Start-up tại Hàn Quốc\n" +
                                                "Được hỗ trợ xin VISA E-7 trong khuôn khổ dự án",
                                "Fresher, Intern, All Levels",
                                null,
                                null,
                                "https://www.likelion.edu.vn/",
                                "South-Korea",
                                null,
                                null,
                                0, 0,
                                _AccountRepo.getOne(3)));

                return data;
        }
}
