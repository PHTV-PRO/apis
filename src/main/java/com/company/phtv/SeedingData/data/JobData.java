package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.*;
import com.company.phtv.Repository.CompanyRepo;
import com.company.phtv.Repository.JobTypeRepo;
import com.company.phtv.Repository.LocationRepo;

import java.util.ArrayList;
import java.util.Date;
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
                                "Không Yêu Cầu",
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
                                "K có",
                                1,
                                "5 năm",
                                "18 triệu",
                                "12 triệu",
                                new Date("2/6/2024"),
                                new Date("21/6/2024"),
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
                                new Date("1/6/2024"),
                                new Date("2/7/2024"),
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
                        new Date("2/5/2024"),
                        new Date("6/7/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(1),
                        _LocationRepo.getOne(3),
                        _JobTypeRepo.getOne(3)));

                data.add(new Jobs(
                        4,
                        "Chuyên viên nghiên cứu công nghệ - Mã vị trí CN04 (Số lượng: 02)",
                        null,
                        "Tham gia nghiên cứu, xác định các công nghệ mới, đánh giá tính khả thi, các tác động và đề xuất việc ứng dụng công nghệ mới trong hoạt động CNTT tại BIDV.\n" +
                                "Tổ chức quản lý, giám sát công tác tổ chức nghiên cứu công nghệ mới trong lĩnh vực CNTT. \n" +
                                "Nghiên cứu quản lý tri thức CNTT tại BIDV. \n" +
                                "Xây dựng các quy trình, quy định, chính sách về nghiên cứu công nghệ, quản lý tri thức CNTT.\n" +
                                "Thực hiện nghiên cứu, cập nhật các xu hướng công nghệ mới trong lĩnh vực CNTT.\n" +
                                "Thực hiện công tác đào tạo về công nghệ mới trong lĩnh vực CNTT.\n" +
                                "Thực hiện các công việc khác theo phân công."
                        ,"1. Tiêu chuẩn chung: \n" +
                        "\n" +
                        "Là công dân Việt Nam, có hộ khẩu thường trú tại Việt Nam. Tuổi đời không quá 35 tuổi đối với Chuyên viên, 45 tuổi đối với Trưởng nhóm/Chuyên gia.\n" +
                        "Có sức khoẻ để đảm nhiệm công tác.\n" +
                        "Có phẩm chất đạo đức tốt, không có tiền án, tiền sự; không trong thời gian bị truy cứu trách nhiệm hình sự, chấp hành án phạt tù, án treo, cải tạo không giam giữ, quản chế, đang chịu biện pháp giáo dục tại địa phương, đang chữa bệnh, cai nghiện…\n" +
                        "2. Tiêu chuẩn cụ thể:\n" +
                        "\n" +
                        "2.1. Trình độ chuyên môn\n" +
                        "\n" +
                        "Tốt nghiệp Đại học trở lên, hệ chính quy (bao gồm đại học văn bằng 2, không bao gồm hình thức học liên thông lên đại học) tại các trường Đại học trong nước hoặc tốt nghiệp Đại học trở lên tại các trường Đại học nước ngoài, Đại học liên kết.\n" +
                        "Chuyên ngành: Tốt nghiệp một trong các chuyên ngành Công nghệ thông tin, An toàn thông tin, Khoa học máy tính, Kỹ thuật phần mềm, Hệ thống thông tin, Kỹ thuật máy tính, Quản lý hệ thống thông tin, Điện tử Viễn thông, Điện tử truyền thông, Toán – Tin hoặc tương đương.\n" +
                        "2.2 Ngoại ngữ: \n" +
                        "\n" +
                        "Ứng viên đạt 1 trong các chứng chỉ sau: TOEIC đạt 600/990, Toefl PBT/IPT đạt 500/677, Toefl CBT đạt 173/300, Toefl iBT đạt 61/120, Ielts đạt 5.5/9.0, Cambridge Exam đạt First (FCE), B2 Khung Châu Âu, 4/6 Khung năng lực ngoại ngữ 6 bậc dùng cho Việt Nam. Chấp nhận ứng viên bổ sung chứng chỉ tiếng Anh trong thời gian 24 tháng kể từ ngày được tuyển dụng.\n" +
                        "2.3. Kiến thức, kỹ năng, kinh nghiệm:\n" +
                        "\n" +
                        "Có kinh nghiệm nghiên cứu ít nhất một trong các lĩnh vực Trí tuệ nhân tạo/ Dữ liệu lớn/ IoT, Cloud,... \n" +
                        "Có khả năng nghiên cứu chuyên sâu, nắm bắt nhanh các xu hướng công nghệ mới.\n" +
                        "Có khả năng lập trình một trong những ngôn ngữ (Python, Perl, Java, .Net, …)\n" +
                        "Có khả năng sử dụng các công cụ BI hiện đại (Tableau, Power BI,…)\n" +
                        "Có khả năng tham gia ý kiến xây dựng quy chế, chính sách, quy trình, hướng dẫn nghiệp vụ.\n" +
                        "Có khả năng tự học hỏi nhằm nâng cao năng lực chuyên môn.\n" +
                        "Có kiến thức, hiểu biết về CNTT và ứng dụng CNTT trong hoạt động ngân hàng.\n" +
                        "Có kiến thức, hiểu biết về các hệ thống, giải pháp phần mềm/ứng dụng CNTT.\n" +
                        "Có kỹ năng giải quyết vấn đề.\n" +
                        "Có kỹ năng lập kế hoạch và viết các báo cáo đề xuất.\n" +
                        "Ưu tiên đã có các chứng chỉ hoặc tham gia các khóa đào tạo về: Trí tuệ nhân tạo/ Dữ liệu lớn/ IoT, Cloud,….",
                        "Lương tháng 13 (Trung bình 4-5 tháng lương cơ bản)\n" +
                                "Được hưởng lương, thưởng và các cơ chế khuyến khích theo thỏa thuận và theo quy định của Ngân hàng TMCP Đầu tư và Phát triển Việt Nam.\n" +
                                "Được chi bổ sung thu nhập theo kết quả làm việc, vị trí công việc và theo quy định của BIDV.\n" +
                                "Review lương 2 lần/năm\n" +
                                "Cung cấp thiết bị làm việc\n" +
                                "Du lịch - Nghỉ dưỡng - Team building hằng năm\n" +
                                "Khám sức khỏe định kỳ\n" +
                                "Các phúc lợi hiếu hỷ, tiền mừng sinh nhật\n" +
                                "Tham gia đầy đủ bảo hiểm theo quy định\n" +
                                "Nghỉ phép năm theo quy định của Nhà nước\n" +
                                "Thời gian làm việc: Thứ 2 - Thứ 6 từ 08 giờ tới 17 giờ"
                        ,"Round 1: Sơ tuyển hồ sơ\n" +
                        "Round 2: Phỏng vấn (Nghiệp vụ và tiếng Anh)",
                        2,
                        "From 1 year",
                        null,
                        "Có Thể Thương Lượng",
                        new Date("7/7/2024"),
                        new Date("2/8/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(4),
                        _LocationRepo.getOne(4),
                        _JobTypeRepo.getOne(1)));


                data.add(new Jobs(
                        5,
                        "Chuyên viên Phân tích nghiệp vụ",
                        null,
                        "Tiến hành khảo sát, thu thập yêu cầu và các hạng mục công việc từ khách hàng, đánh giá tính khả thi và tác động có liên quan\n" +
                                "Phân tích yêu cầu, mô hình hóa quy trình kinh doanh, xây dựng tài liệu kinh doanh (Phân tích yêu cầu, đặc điểm kỹ thuật), thiết kế prototye (Mockup) cho sản phẩm\n" +
                                "Lên ý tưởng thiết kế bằng storyboards, sơ đồ quy trình và sitemaps\n" +
                                "Thiết kế giao diện người, như menu, tab và widget\n" +
                                "Quản lý các yêu cầu thay đổi về sản phẩm\n" +
                                "Rà soát, đánh giá sản phẩm trước khi bàn giao cho khách hàng",
                        "Tốt nghiệp đại học chuyên ngành Công nghệ Thông tin, Toán Tin hoặc tương đương.\n" +
                                "Dưới 35 tuổi\n" +
                                "Có kiến thức về CNTT: Cấu trúc phần mềm, phân tích và thiết kế hệ thống, cơ sở dữ liệu\n" +
                                "Thuần thục các kỹ năng: Lập kế hoạch, định vị chiến lược, đàm phán, thuyết trình, thuyết phục khách hàng, giao tiếp và làm việc nhóm\n" +
                                "Có tư duy phân tích hệ thống, tư duy logic, kỹ năng lập luận và phản biện\n" +
                                "Chủ động, có trách nhiệm, chịu được áp lực công việc cao\n" +
                                "Sử dụng thành thạo các techniques như: Market Analysis; Brainstorming; Backlog Management; Use Cases and Scenarios; User Stories; Business Rules Analysis\n" +
                                "Kiến thức về quy trình phát triển phần mềm\n" +
                                "Tư duy tốt, có khả năng nghiên cứu, đánh giá và cập nhật công nghệ mới",
                        "Trung Tâm Công nghệ thông tin MobiFone\n" +
                                "Làm việc trong môi trường chuyên nghiệp, ổn định\n" +
                                "Chăm sóc sức khỏe bởi gói Bảo hiểm với quyền lợi lên tới $8000\n" +
                                "Các chế độ bồi dưỡng, phụ cấp ăn trưa, thuê bao nội bộ\n" +
                                "Trải nghiệm các hoạt động teambuilding, văn hóa, du lịch, du xuân, nghỉ mát hè trong và ngoài nước đa dạng…\n" +
                                "Thường xuyên tham dự các khóa đào tạo phong phú nhằm giúp CBCNV không ngừng phát triển bản thân, nâng cao các kỹ năng cũng như chuyên môn nghề nghiệp",
                        "Round 1: Phỏng vấn 1 vòng",
                        5,
                        "From 1 year"
                        ,null,
                        "Thương Lượng",
                        new Date("7/7/2024"),
                        new Date("7/8/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(5),
                        _LocationRepo.getOne(5),
                        _JobTypeRepo.getOne(1)));

                data.add(new Jobs(
                        6,
                        "DevOps Engineer (All Levels)",
                        "We are Stepmedia Software Viet Nam. We are looking for .NET Developer staff to join in our software project in Viet Nam.",
                        "Phụ trách nền tảng có thể mở rộng hiện tại chạy trên Cơ sở hạ tầng (AWS & GCP) phục vụ đối tác khách hàng.\n" +
                                "Xây dựng các công cụ triển khai tích hợp tự động CI/CD\n" +
                                "Tối ưu hệ thống xử lý các vấn đề truy vấn ảnh hưởng perfomance\n" +
                                "Viết các module tích hợp sản phẩm khác vào hệ thống dịch vụ\n" +
                                "Chuyển microservices sang cơ sở hạ tầng dựa trên container bằng Kubernetes\n" +
                                "Nghiên cứu các kỹ thuật / công nghệ mới để cải thiện hiệu suất của nhóm DevOps.\n" +
                                "Thiết lập môi trường kỹ thuật cho nhóm phát triển\n" +
                                "Theo dõi và khắc phục sự cố ứng dụng hoặc hệ thống.\n" +
                                "Vận hành và thiết kế các hệ thống để giải quyết các vấn đề: Cloud (AWS & GCP), Kubernetes, CI / CD (Gitlab CI, octopus).",
                        "Yêu thích kỹ thuật, sẵn sàng nghiên cứu và phát triển công nghệ mới\n" +
                                "Có khả năng tìm hiểu độc lập, cũng như phối hợp với nhóm\n" +
                                "Có kinh nghiệm làm việc với AWS hoặc OpenStack hơn 1 năm\n" +
                                "Ưu tiên ứng viên:\n" +
                                "\n" +
                                "Thành thạo ít nhất 01 ngôn ngữ lập trình (Python, Java...)\n" +
                                "Có kinh nghiệm bảo mật và nguy cơ an ninh mạng trên điện toán đám mây\n" +
                                "Có bằng đại học/cao học các ngành CNTT và ĐTVT",
                        "Build solid foundation for IT career path through an accelerate 12-month development\n" +
                                "Acquire strong technical and soft skills\n" +
                                "Work in cutting edge technology projects\n" +
                                "Buddy with friendly colleagues and learn from senior experts\n" +
                                "Develop a strong sense of business insight\n" +
                                "Development journey come along with growing benefits\n" +
                                "Receive attractive benefits (meal allowance, 13th month salary, performance bonus, healthcare insurance,...)"
                        ,"Round 1: Sàng lọc CV\n" +
                        "Round 2: Phỏng vấn trực tiếp với Nhân Sự\n" +
                        "Round 3: Phỏng vấn trực tiếp với Trưởng Bộ phận",
                        0,
                        "Not required"
                        ,null,
                        "Thương Lượng",
                        new Date("9/7/2024"),
                        new Date("9/8/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(6),
                        _LocationRepo.getOne(6),
                        _JobTypeRepo.getOne(3)));

                data.add(new Jobs(
                        7,
                        "Software Quality Assurance Executive",
                        null,
                        "We are looking for a QA who will join to IT Team, support and ensure the successful completion of analytical, building, testing and deployment tasks of our mobile products.\n" +
                                "\n" +
                                "Design and execute test cases according to the specifications\n" +
                                "Test product on multiple platforms: Android, iOS, Web, API\n" +
                                "Perform different test methods, including integration tests, functional tests, system tests, acceptance tests, performance tests, and regression tests\n" +
                                "Prepare test data as required\n" +
                                "Develop and maintain software documentation\n" +
                                "Manage of overall UAT process over business teams to improve overall quality\n" +
                                "Work closely with BA and developer to ensure the quality of products.",
                        "2+ years of experience in software testing\n" +
                                "Having knowledge of software testing methodologies and practices\n" +
                                "Experience in Agile/Scrum\n" +
                                "Experience with Mobile App UI/UX and responsive Web Application\n" +
                                "Domain knowledge in Banking or Finance is a big advantage\n" +
                                "Basic knowledge about some Programming languages and Database SQL\n" +
                                "Experience with automation testing is a plus (Selenium, Jmeter, Locust.io, Postman, SoapUI)\n" +
                                "Good logical and analytical thinking\n" +
                                "Good problem-solving skills\n" +
                                "Good communication skills and interpersonal skills\n" +
                                "WHAT WE OFFER:\n" +
                                "\n" +
                                "Mirae Asset Finance Company Vietnam aims to build a \"Professional - Friendly - Effective\" working environment. Our strategic objective is to provide a working place with attractive package, growth opportunity, and sustainable development.",
                        "Attractive packages with 13th salary year-end bonus and a week trip to Korea in order to recognize all your good performance and effort at MAFC.\n" +
                                "15 days annual leave.\n" +
                                "Annual health check, company events.\n" +
                                "Annual healthcare insurance package from senior level and above.\n" +
                                "Young and proactive environment; no barriers, no limitation for new idea.\n" +
                                "Flexible internal career opportunity.",
                        "Round 1: Interview with HR & Hiring Manager (1 round only)",
                        1,
                        "From 2 years",
                        null,
                        "Thương Lượng",
                        new Date("9/7/2024"),
                        new Date("29/8/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(7),
                        _LocationRepo.getOne(7),
                        _JobTypeRepo.getOne(1)));

                data.add(new Jobs(
                        8,
                        "Senior Android Developer",
                        null,
                        "We are looking for experienced Android Developers to join our high-powered experienced product team who follow agile development principles, and who value well-designed software, creative thinking, and thrive on solving the unsolvable.",
                        "Bachelor’s degree minimum\n" +
                                "At least 5 years Prior Android development and Kotlin experience\n" +
                                "Solid understanding of the full mobile development\n" +
                                "Good data structure & algorithm background\n" +
                                "Understand at least one of these architectures: MVP, MVVM, Clean Architecture\n" +
                                "Know some design patterns (singleton, factory, data repository...)\n" +
                                "Familiar with new technology such as Jetpack libraries(Coroutines, Hilt, Room,…), Android Material 3, AndroidX,Android Architecture Component (LiveData, ViewModel), and so on.\n" +
                                "Have experience with Canvas drawing, TCP socket handling, location\n" +
                                "Enthusiasm for technology with a pulse on current trends and technologies in mobile application development\n" +
                                "Familiarity with mobile applications and development, including the use of hardware such as accelerometers, cameras, and gyroscopes\n" +
                                "Comfortable working as part of a cross-functional team and with code written by others, including bug fixing and refactoring legacy code\n" +
                                "Proficient understanding of code versioning tools, such as Git\n" +
                                "Top-notch teamwork and excellent communication skills\n" +
                                "Highly Desirable Skills:\n" +
                                "\n" +
                                "Experience with complicated projects with multiple features is a plus\n" +
                                "Experience with and understanding of test-driven design and unit testing is a plus\n" +
                                "Agile/Scrum experience is a plus",
                        "Product company with global reputation specialized in end-point security\n" +
                                "Very attractive salary\n" +
                                "Global standard working environment\n" +
                                "100% salary during probation period\n" +
                                "13th month salary\n" +
                                "Birthday Bonus, New Year Bonus\n" +
                                "Social Insurance, health insurance, unemployment insurance on total salary after probation period\n" +
                                "Bao Viet Healthcare Insurance\n" +
                                "Health Check\n" +
                                "Team Building\n" +
                                "Flexible working hours\n" +
                                "Training & development opportunities\n" +
                                "Laptop and PC for everyone",
                        "Round 1: 2 vòng (Phỏng vấn trực tiếp)",
                        4,
                        "From 5 years",
                        "45.000.000 VND",
                        "30.000.000 VND",
                        new Date("10/7/2024"),
                        new Date("10/8/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(8),
                        _LocationRepo.getOne(8),
                        _JobTypeRepo.getOne(1)));

                // cái này c description riêng => nên kham khảo trên phone ròi đưa ra phương án thích hợp
                data.add(new Jobs(
                        9,
                        "Dynamics 365 Support Technician (Open for freshers)",
                        "Are you passionate about helping others and have a deep understanding of Microsoft Dynamics 365? \n" +
                                "\n" +
                                "Microsoft Dynamics 365 (D365) is a cloud-based suite of business applications that empowers organizations to streamline their operations, improve customer engagement, and make data-driven decisions. It includes modules for Sales, Customer Service, Field Service, Finance, Supply Chain Management, and more.\n" +
                                "\n" +
                                "We're seeking a talented Technical Support Engineer to join our growing team! In this role, you'll leverage your expertise in Dynamics 365 to troubleshoot and resolve customer issues, ensuring a smooth and successful user experience.",
                        "Reviews issues and contacts customers to understand issues. Ensures customers stay informed as to the status/solution of their issue. Utilizes troubleshooting tools (e.g., event logs, and performance traces) to help resolve customer issues.\n" +
                                "Resolves or escalates multiple and varied customer issues. Documents technical work and research.\n" +
                                "Analyzes problems and develops solutions for customer needs using log analysis and other proprietary tools.\n" +
                                "Collaborates on cross-team and cross-product technical issues by working with resources from other groups as needed to resolve moderately complex customer issues.\n" +
                                "Attends readiness training and non-technical training to ensure that they become proficient in support topics. Product/Process Improvement\n" +
                                "Provides feedback to improve products to more senior engineers or technical advisors.\n" +
                                "Identifies potential defects and escalates to more senior engineers to resolve.\n" +
                                "Uses automated tools to deliver solutions for a wide range of issues. Provides feedback on how to improve automated tools.\n" +
                                "Follows processes provided by the business.\n" +
                                "Attends case triage meetings or case discussions to collaborate and share ideas to resolve problems.",
                        "Proficient in English (4 skills)\n" +
                                "Available to work night shifts (rotate between 9:00 PM and 9:00 AM, working 8 hours per shift, with a total of 5 shifts per week)\n" +
                                "Freshers are welcome with a good learning ability and working attitude\n" +
                                "Experience/Knowledge in IT industry skills is a must\n" +
                                "Customer service mindset",
                        "Competitive salary depending on experience: starting from 20,000,000 VND GROSS\n" +
                                "Salary at 100% during the probationary period\n" +
                                "Training will be offered\n" +
                                "Full working equipment will be provided\n" +
                                "90% contribution of the gross salary to social insurance\n" +
                                "12 days of annual leave, 8 days of sick leave\n" +
                                "30% allowance on gross salary + PVI insurance + 500,000 VND food allowance for employees working night shift\n" +
                                "Annual Health Checkup"
                        ,"Round 1: Communication + English test\n" +
                        "Round 2: Technical test",
                        2,
                        "No Required",
                        "22.000.000 VND",
                        "18.000.000 VND",
                        new Date("9/7/2024"),
                        new Date("9/8/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(9),
                        _LocationRepo.getOne(9),
                        _JobTypeRepo.getOne(1)));
                // cái này c description riêng => nên kham khảo trên phone ròi đưa ra phương án thích hợp
                data.add(new Jobs(
                        10,
                        "Nhân Viên Vận Hành Ứng Dụng",
                        "Vị trí tuyển dụng:  Nhân viên  vận hành ứng dụng\n" +
                                "Bộ phận: phòng Công nghệ thông tin\n" +
                                "Số lượng cần tuyển: 02\n" +
                                "Nơi làm việc: Hà Nội\n" +
                                "Thời gian tuyển dụng: 06/2024",
                        "Nhiệm vụ:\n" +
                                "\n" +
                                "Triển khai các dự án ứng dụng, phần mềm tại công ty, công ty thành viên và các chi nhánh.\n" +
                                "Hỗ trợ người sử dụng phần mềm, ứng dụng xử lý các vấn đề gặp phải trong quá trình sử dụng.\n" +
                                "Vận hành các phần mềm, ứng dụng đảm bảo ứng dụng hoạt động hiệu quả, ổn định.\n" +
                                "Tham gia kiểm thử và nghiệm thu các phần mềm ứng dụng đảm bảo chất lượng trước khi triển khai.\n" +
                                "Tham gia tiếp cận các quy trình nghiệp vụ và hệ thống phần mềm ứng dụng. Tư vấn các quy trình và nghiệp vụ đảm bảo ứng dụng đạt hiệu quả.\n" +
                                "Tham gia quá trình đào tạo,xây dựng tài liệu  và kiến thức liên quan của các phần mềm ứng dụng.\n" +
                                "Thực hiện các nhiệm vụ khác theo sự phân công của Quản lý/ Lãnh đạo/Ban Chuyển đổi số.",
                        "Tuổi: Dưới 30\n" +
                                "Giới tính: Nam/ Nữ\n" +
                                "Trình độ chuyên môn: Tốt nghiệp Đại học trở lên, ưu tiên chuyên ngành CNTT-Phần mềm, Hệ thống thông tin Quản lý, tin học ứng dụng, toán tin.\n" +
                                "Có kiến thức về một trong các hệ quản trị cơ sở dữ liệu như MySQL, SQL, Oracle…\n" +
                                "Có kiến thức đối với các hệ thống ERP, HRM, E-Office…\n" +
                                "Trình độ tiếng Anh: đọc, dịch tài liệu tiếng Anh chuyên nghành.\n" +
                                "Kinh nghiệm: ít nhất 1 năm kinh nghiệm hỗ trợ triển khai và vận hành phần mềm tại các doanh nghiệp hoặc doanh nghiệp dịch vụ phần mềm.",
                        "Lương cứng: Theo quy chế lương của công ty + Thưởng khác tương đương 20-30%\n" +
                                "Bảo hiểm: xã hội; y tế; thất nghiệp; thân thể\n" +
                                "Chế độ Lễ, Tết; 27/2; Giỗ tổ; 08/3; 20/10; 30/4+01/5; 02/09; Tết Thiếu nhi, trung thu, ngày TL công ty; Nghỉ mát, thưởng hoàn thành KH..\n" +
                                "Được đào tạo phát triển bản thân tại trong và ngoài nước"
                        ,"Ưu tiên hồ sơ nộp online trên cổng tuyển dụng của topdev.vn",
                        2,
                        "From 1 year",
                        "800 USD",
                        "500 USD",
                        new Date("4/7/2024"),
                        new Date("29/9/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(10),
                        _LocationRepo.getOne(10),
                        _JobTypeRepo.getOne(1)));
                return data;
        }

}
