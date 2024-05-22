package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.*;
import com.company.phtv.Repository.CompanyRepo;
import com.company.phtv.Repository.JobTypeRepo;
import com.company.phtv.Repository.LocationRepo;

import java.util.ArrayList;
import java.util.List;

public class JobData {

        private final CompanyRepo _CompanyRepo;
        private final LocationRepo _LocationRepo;
        private final JobTypeRepo _JobTypeRepo;

        public JobData(CompanyRepo _CompanyRepo, LocationRepo _LocationRepo, JobTypeRepo _JobTypeRepo) {
                this._CompanyRepo = _CompanyRepo;
                this._LocationRepo = _LocationRepo;
                this._JobTypeRepo = _JobTypeRepo;
        }

        @SuppressWarnings("deprecation")
        public List<Jobs> Data() {
                List<Jobs> data = new ArrayList<>();
                data.add(new Jobs(
                                1,
                                "Nhân Viên Thiết Kế - Lương 12 - 18 Triệu (Có Kinh Nghiệm)",
                                "- Tiếp nhận yêu cầu thiết kế ; sản phẩm giường, tủ, bàn ghế...(hàng tháo rời)\n" +
                                                "\n" +
                                                "- Thiết kế 3D; bóc tách bản vẽ, lên AI\n" +
                                                "\n" +
                                                "- Phối hợp với xưởng sản xuất, hỗ trợ tư vấn về vật liệu, phương thức sản xuất...",
                                null,
                                "- Tốt nghiệp chuyên ngành thiết kế hoặc tương đương.\n" +
                                                "\n" +
                                                "- Thiết kế thành thạo AutoCAD, 2D, 3D\n" +
                                                "\n" +
                                                "- Kinh nghiệm thiết kế giường, tủ, bàn ghế từ 5 năm trở lên",
                                "Lương thỏa thuận ( 12-18tr) ( thỏa thuận theo năng lực tùy vào ứng viên )\n" +
                                                "\n" +
                                                "Đóng BHXH, BHYT theo quy định, thưởng tết, cơm trưa,...\n" +
                                                "\n" +
                                                "Có lương tháng 13, thưởng thâm niên, thưởng dương lịch, âm lịch,...\n"
                                                +
                                                "\n" +
                                                "Phép năm, ngày lễ, tết,... đầy đủ chế độ hiện hành.\n" +
                                                "\n" +
                                                "Đóng bảo hiểm sau khi làm việc chính thức.",
                                null,
                                1,
                                "5 năm",
                                "18 triệu",
                                "12 triệu",
                                "20/05/2024",
                                "20/10/2024",
                                true,
                                0,
                                _CompanyRepo.getOne(2),
                                _LocationRepo.getOne(1),
                                _JobTypeRepo.getOne(1)));
                data.add(new Jobs(
                                2,
                                "CƠ HỘI ĐÀO TẠO MIỄN PHÍ VÀ LÀM VIỆC TẠI HÀN QUỐC CHO CÁC BẠN FRESHER (5 tháng đào tạo + cấp visa Kỹ sư E-7)",
                                "Tài trợ 100% bởi Chính phủ Hàn Quốc, đây là dự án đầu tiên thực hiện kết nối việc làm  cho sinh viên Việt Nam với các Doanh nghiệp Start-up Hàn Quốc. Các bạn sẽ trải qua đào tạo thực chiến và được trải nghiệm sinh sống và làm việc tại các thành phố lớn của Hàn Quốc.",
                                "Nội dung đào tạo:\n" +
                                                "\n" +
                                                "05 tháng đào tạo (full-time) với các nội dung sau:\n" +
                                                "\n" +
                                                "Front-end hoặc Back-end\n" +
                                                "Cách phỏng vấn với các doanh nghiệp Hàn Quốc\n" +
                                                "Văn hóa làm việc của các công ty Hàn Quốc\n" +
                                                "Tiếng Hàn cơ bản\n" +
                                                "Cấp visa E-7 làm việc tại Hàn Quốc\n" +
                                                "Đào tạo theo hướng thực chiến dự án thực tế\n" +
                                                "Thời gian nhận hồ sơ đến 23h00, ngày 23/05/2024\n" +
                                                "Thời gian đào tạo: tháng 6 ~ 11/2024",
                                "Sắp tốt nghiệp Đại học các chuyên ngành liên quan IT\n" +
                                                "Đã tốt nghiệp các chuyên ngành khác nhưng có ý định học và trở thành Dev\n"
                                                +
                                                "Biết tiếng Hàn là điểm cộng",
                                "Hỗ trợ cơm trưa cho các lớp fulltime\n" +
                                                "Cho mượn trang thiết bị học tập trong quá trình đào tạo\n" +
                                                "Hỗ trợ thông dịch khi phỏng vấn cùng Doanh nghiệp\n" +
                                                "Hỗ trợ tư vấn chuẩn bị hồ sơ xin VISA (sau khi đậu tuyển dụng)\n" +
                                                "Ứng viên được đào tạo miễn phí 5 tháng\n" +
                                                "Kết nối việc làm tại các công ty Start-up tại Hàn Quốc\n" +
                                                "Được hỗ trợ xin VISA E-7 trong khuôn khổ dự án",
                                "Vòng 1: Thời gian nhận hồ sơ đến 23h00, ngày 23/05/2024\n" +
                                                "Vòng 2: Thời gian xét tuyển và xếp lớp: đến 31/05/2024\n" +
                                                "Vòng 3: Thời gian đào tạo: tháng 6 ~ 11/2024",
                                0,
                                "Không yêu cầu",
                                null,
                                null,
                                "tháng 6 / 2024",
                                "tháng 11 / 2024",
                                true,
                                0,
                                _CompanyRepo.getOne(3),
                                _LocationRepo.getOne(2),
                                _JobTypeRepo.getOne(2)));
                data.add(new Jobs(
                                3,
                                ".NET Developer",
                                null,
                                "Thực hiện xây dựng, phát triển, nâng cấp, sửa lỗi sản phẩm trên hệ thống quản trị doanh nghiệp thực hiện theo yêu cầu của Khối phòng nghiệp vụ.\\n\" +\n"
                                                +
                                                "                        \"Lập trình phát triển ứng dụng, xây dựng tài liệu, phục vụ công tác quản lý và kinh doanh đã được Ban Giám Đốc Khối hoặc cấp tương đương phê duyệt.\\n\" +\n"
                                                +
                                                "                        \"Tự nghiên cứu và góp ý, xây dựng các ý kiến về tài liệu nghiệp vụ, hỗ trợ cho lãnh đạo phòng những sáng kiến phục vụ công việc.\\n\" +\n"
                                                +
                                                "                        \"Phối hợp hỗ trợ, kiểm tra hệ thống hệ thống đã xây dựng và triển khai.\\n\" +\n"
                                                +
                                                "                        \"Quản lý, rà soát, đối chiếu code trước khi đưa lên môi trường UAT, LIVE.\\n\" +\n"
                                                +
                                                "                        \"Quản lý mã nguồn của các ứng dụng liên quan.",
                                "Sắp tốt nghiệp Đại học các chuyên ngành liên quan IT\n" +
                                                "Đã tốt nghiệp các chuyên ngành khác nhưng có ý định học và trở thành Dev\n"
                                                +
                                                "Biết tiếng Hàn là điểm cộng",
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
                                "Vòng 1: 01 vòng duy nhất (trực tiếp/ trực tuyến)",
                                0,
                                "Từ 2 năm kinh nghiệm \n" +
                                                "Thành thạo code web trên nền .NET\n" +
                                                "Thành thạo Database Oracle\n" +
                                                "Ưu tiên ứng viên đã biết nghiệp vụ bank: kết nối thanh toán, tra soát đối soát, kpi, xếp hạng tín dụng...",
                                null,
                                "Thương Lượng",
                                "20/5/2024",
                                null,
                                true,
                                0,
                                _CompanyRepo.getOne(1),
                                _LocationRepo.getOne(3),
                                _JobTypeRepo.getOne(3)));
                return data;
        }
}
