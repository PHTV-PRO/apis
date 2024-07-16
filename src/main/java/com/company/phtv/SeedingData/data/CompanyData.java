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
//        Mỗi Employer ại diện 1 cty
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
                                "1900-2000",
                                "https://jobs.lpbank.com.vn/vi",
                                "Việt Nam",
                                null,
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
                                "Không có",
                                "Nhân Viên",
                                "99-1000",
                                "http://www.sprayway-tpr.com/vn/",
                                "Việt Nam",
                                null,
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
                                "10-50",
                                "https://www.likelion.edu.vn/",
                                "South-Korea",
                                null,
                                null,
                                null,
                                0, 0,
                                _AccountRepo.getOne(3)));

                // Ngân Hàng
                data.add(new Company(4,
                        "Ban Công nghệ BIDV",
                        "Ngân hàng TMCP Đầu tư và Phát triển Việt Nam (BIDV) là ngân hàng hàng đầu tại Việt Nam, hoạt động kinh doanh trong nhiều lĩnh vực như: Ngân hàng, Bảo hiểm, Chứng khoán. Với hơn 25.000 cán bộ nhân viên, BIDV nhận thức được rằng nguồn nhân lực là một nhân tố quan trọng hàng đầu cho sự phát triển và thành công của tổ chức. Vì vậy, một trong những mục tiêu quan trọng nhất của BIDV là phải xây dựng, duy trì và phát triển đội ngũ nhân viên đảm bảo đủ về số lượng và chất lượng để thực hiện thắng lợi các mục tiêu, chiến lược kinh doanh của hệ thống. \n" +
                                "\n" +
                                "66 năm xây dựng và trưởng thành là hành trình đầy tự hào của lớp lớp các thế hệ cán bộ lãnh đạo, người lao động của BIDV, trải qua “bao thác, bao ghềnh” đã trui rèn, bồi tụ nên bản lĩnh, cốt cách kiên cường, vượt khó của “Người BIDV”. Tại mốc son này, với quyết tâm của Ban lãnh đạo, sự đồng sức, đồng lòng của tập thể cán bộ người lao động, BIDV đã hội tụ đầy đủ điều kiện, quyết tâm và khát vọng để thay đổi và chinh phục những đỉnh cao mới.",
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
                                "Thời gian làm việc: Thứ 2 - Thứ 6 từ 08 giờ tới 17 giờ",
                        "Chuyên viên nghiên cứu công nghệ - Mã vị trí CN04 (Số lượng: 02)",
                        "10-30",
                        "https://tuyendung.bidv.com.vn/",
                        "Viet Nam",
                        null,
                        null,
                        null,
                        0, 0,
                        _AccountRepo.getOne(17)));

                // Phần Mền
                data.add(new Company(5,
                        "Trung Tâm Công nghệ thông tin Mobifone",
                        "XIN CHÀO ỨNG VIÊN\n" +
                                "\n" +
                                "Có rất nhiều Công ty Công nghệ thông tin tại Việt Nam nhưng chỉ một số ít đơn vị có thể so sánh với MobiFone về môi trường làm việc. Bằng chứng thực tế MobiFone đã được Tổ chức cộng đồng mạng nghề nghiệp Anphabe khảo sát và đánh giá là 1 trong 15 nơi làm việc tốt nhất Việt Nam trong nhiều năm liền. Với đầy đủ những yếu tố cấu thành nên một môi trường làm việc tốt: Tầm nhìn, sứ mệnh, mục tiêu hoạt động rõ ràng; Môi trường làm việc năng động, cởi mở, thân thiện; Cân bằng giữa công việc và cuộc sống; Ghi nhận sự đóng góp, cống hiến của người lao động; Cơ hội phát triển sự nghiệp rõ ràng, minh bạch; Cơ chế phúc lợi, lương thưởng hấp dẫn;….\n" +
                                "\n" +
                                "Trung tâm Công nghệ thông tin MobiFone luôn mở rộng cánh cửa chào đón những Ứng viên phù hợp với vị trí công việc, môi trường làm việc và sẵn sàng cống hiến, phấn đấu hết mình cùng MobiFone!\n" +
                                "\n" +
                                "Trung tâm CNTT MobiFone\n" +
                                "\n" +
                                "Trung tâm Công nghệ thông tin MobiFone là đơn vị trực thuộc Tổng công ty Viễn thông MobiFone, chịu trách nhiệm triển khai kinh doanh các giải pháp, dịch vụ Công nghệ thông tin cho khối khách hàng Chính phủ và Doanh nghiệp.\n" +
                                "\n" +
                                "Tầm nhìn: MobiFone – Chinh phục thế giới số\n" +
                                "Sứ mệnh: Mang tới những giải pháp Công nghệ kết nối trong một hệ sinh thái toàn diện giúp đẩy mạnh thực hiện chuyển đổi số trong các doanh nghiệp, cơ quan và tổ chức.\n" +
                                "Trung tâm Công nghệ thông tin MobiFone, tiền thân là Trung tâm Phát triển phần mềm trực thuộc Tổng Công ty Viễn Thông MobiFone đi vào hoạt động chính thức từ ngày 24/01/2014.\n" +
                                "\n" +
                                "Qua thời gian 8 năm hoạt động, với chuyên môn chính là nghiên cứu, phát triển và kinh doanh các giải pháp, dịch vụ CNTT cho khối khách hàng Chính phủ, Doanh nghiệp, Trung tâm CNTT MobiFone đã tung ra thị trường hơn 20 sản phẩm CNTT đặc thù thuộc 3 nhóm: Chính phủ số, Doanh nghiệp số, Công nghệ 4.0 (AI – IoT – Big Data) và cung cấp tới hàng nghìn khách hàng sử dụng.\n" +
                                "\n" +
                                "Chỉ sau 6 năm phát triển hiệu quả, độc lập như một công ty thành viên của Tổng công ty, Trung tâm CNTT MobiFone không ngừng lớn mạnh và mở rộng quy mô. Hiện nay, Trung tâm đã sở hữu đội ngũ lãnh đạo giàu kinh nghiệm, hơn 30 chuyên gia xuất sắc cùng đội ngũ nhân viên nhiệt huyết, năng động, trên 1000 nhân lực Account Managers, phục vụ trên 20.000 khách hàng doanh nghiệp lớn nhỏ trong và ngoài nước. Từ đó, Trung tâm chính thức gia nhập nhóm đơn vị Kinh doanh của Tổng công ty Viễn thông MobiFone.",
                        "Thu nhập lên đến 480 triệu/năm\n" +
                                "Quyền lợi về Bảo hiểm xã hội/thất nghiệp và các phúc lợi hấp dẫn khác, gói bảo hiểm y tế quyền lợi đến $8000\n" +
                                "Các chế độ bồi dưỡng, ăn trưa 1.000.000đ/tháng, thuê bao nội bộ 320.000đ/tháng\n" +
                                "Được đào tạo phát triển bản thân, nâng cao các kỹ năng và chuyên môn nghề nghiệp\n" +
                                "Làm việc tại môi trường chuyên nghiệp, năng động, trẻ trung và trải nghiệm các hoạt động văn hóa doanh nghiệp đặc sắc\n" +
                                "Cơ hội tiếp cận với những doanh nghiệp, dự án lớn, những xu hướng công nghệ/nền tảng mới nhất, thỏa sức sáng tạo phát triển bản thân\n" +
                                "Thời gian làm việc: 08h - 17h từ Thứ 2 đến Thứ 6 hàng tuần (Nghỉ Thứ 7, CN)",
                        "Chuyên viên Phân tích nghiệp vụ",
                        "0-40",
                        "https://it.mobifone.vn/tuyen-dung/",
                        "Vietnam",
                        null,
                        null,
                        null,
                        0, 0,
                        _AccountRepo.getOne(11)));
                // Dịch Vụ Doanh Nghiệp
                data.add(new Company(6,
                        "TopDev's Client",
                        "We are American company that specializes in developing software for the music industry. The programs we develop help record labels and artists market and monetize their music. We have offices in US and Europe, and we opened our Hanoi office in 2018. We are a young, dynamic company that is committed to making the music industry a simpler, more profitable place for artists.",
                        "Build solid foundation for IT career path through an accelerate 12-month development\n" +
                                "Acquire strong technical and soft skills\n" +
                                "Work in cutting edge technology projects\n" +
                                "Buddy with friendly colleagues and learn from senior experts\n" +
                                "Develop a strong sense of business insight\n" +
                                "Development journey come along with growing benefits\n" +
                                "Receive attractive benefits (meal allowance, 13th month salary, performance bonus, healthcare insurance,...)",
                        "DevOps Engineer (All Levels)",
                        "25-100",
                        "topdev.vn",
                        "Vietnam",
                        null,
                        null,
                        null,
                        0, 0,
                        _AccountRepo.getOne(12)));
                //Finance

                data.add(new Company(7,
                        "Mirae Asset Finance Company (Vietnam)",
                        "Mirae Asset Finance Company Vietnam is a member of Mirae Asset Financial Group, a global financial group from Korea, with 20 years of experience in finance, securities, investment, asset management etc., and is present in 16 countries with 200 offices and branches worldwide.\n" +
                                "\n" +
                                "Being present in Vietnam in 2006 and officially operating in 2011, the Company has been built with the vision of always pursuing an optimal investment management strategy in order to support customers with achieving their long-term goals. In addition, Mirae Asset Finance Company Vietnam has made continuous efforts to improve its consumer financial products with a purpose of creating favorable conditions for the customers to effectively, legally and safely access the capital.",
                        "15 Annual Leaves\n" +
                                "13th Salary and pro-Rate and performance bonus\n" +
                                "Annual healthcare insurance package from senior level and above\n" +
                                "A week trip to Korea in order to recognize all your good performance and effort\n" +
                                "Work-life balance 42,5-hr per week from Mon to Fri.",
                        "Software Quality Assurance Executive",
                        "50-100",
                        "http://mafc.com.vn",
                        "South-Korea",
                        null,
                        null,
                        null,
                        0, 0,
                        _AccountRepo.getOne(13)));
                // Ecomerce Platforms
                data.add(new Company(
                        8,
                        "Megazone Vietnam Company Limited",
                        "Megazone Cloud is one of the largest cloud managed service providers (MSP) in the Asia Pacific region. Since its foundation in 1998, the company has offered business-to-business IT services, and currently boasts over 1,000 experts. Megazone Cloud is Korea’s first AWS Premier Consulting Partner is leading the development of the cloud market in the APAC region. Recently, the company has been actively expanding its global market by establishing overseas subsidiaries in the United States, Japan, China, and others. Megazone reported about US$ 1.7 billion of sales in the field of cloud transformation and operational management in 2018 and is foreseeing to reach up to about US$ 3.8 billion of sales. Megazone's customer companies range from big companies such as Samsung Electronics Co. and LG Electronics Inc. to financial institutes and start-ups."
                        ,"Product company with global reputation specialized in end-point security\n" +
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
                        "Senior Android Developer",
                        "99-200",
                        "https://www.megazone.com/\n",
                        "South-Korea\n" +
                                "Vietnam\n",
                        null,
                        null,
                        null,
                        0, 0,
                        _AccountRepo.getOne(14)));

//               B2b
                data.add(new Company(9,
                        "Dynamics 365 Support Technician (Open for freshers)",
                       "iTechwx is newly born in the summer of 2022 in Ho Chi Minh City, Vietnam. We locate in Binh Thanh District, settling the office inside Opal Tower. As the first stop in SEA region, iTechwx encounters Vietnam, and particularly the city of Ho Chi Minh because of the richness in human resources, as well as the prospecting technology industries in this robust city.\n" +
                               "\n" +
                               "We see opportunities - specifically to the sector of cloud solutions and managed IT services. We believe a One-Stop Digital Transformation Service is the solution to most enterprises. iTechwx is specialized in agile recruiting, designated training, and managing services to drive exceptional quality in delivery. iTechwx is also empowered to incubate technical talents. We invent highly efficient training, mentoring, onboarding, and quality assurance processes, incorporating with the essence of customer services. We see the city is awaiting to practice the most to succeed.\n" +
                               "\n" +
                               "We invest on the talents. iTechwx commits to carefully treat each employee, and to forge a company brand full of vitality. Employees in iTechwx always find easy access to company resources. Teams are supplemented with supporting groups to take care of employee work experience.\n" +
                               "\n" +
                               "iTechwx dedicates the One-Stop Digital Transformation Service to our customers\n" +
                               "\n" +
                               "Contact Center Services\n" +
                               "iTechwx constructs contact centers with customer-oriented advocates, supporting global customers with multi-languages and multi-media. iTechwx offers tech-focused contact center services, with our advanced operation standards, specialized training programs, and innovative management structure.\n" +
                               "\n" +
                               "Information Technology Services\n" +
                               "iTechwx provides services including design, development, testing, maintenance, support, and project management for both software and hardware products in frontier technological domains such as Cloud Computing, Internet of Things, Big Data, Smart Technology, Mobile Technology, etc.\n" +
                               "\n" +
                               "Conquer the Everest, Together with iTechwx.",
                        "Competitive salary depending on experience: starting from 20,000,000 VND GROSS\n" +
                        "Salary at 100% during the probationary period\n" +
                        "Training will be offered\n" +
                        "Full working equipment will be provided\n" +
                        "90% contribution of the gross salary to social insurance\n" +
                        "12 days of annual leave, 8 days of sick leave\n" +
                        "30% allowance on gross salary + PVI insurance + 500,000 VND food allowance for employees working night shift\n" +
                        "Annual Health Checkup",
                        "Dynamics 365 Support Technician (Open for freshers)",
                        "100-500",
                        "https://itechwxrecruiting.jobday.vn",
                        "United States",
                        null,
                        null,
                        null,
                        0, 0,
                        _AccountRepo.getOne(15)));
                // Phần Cứng
                data.add(new Company(10,
                        "Công ty Cổ phần Traphaco",
                        "Công ty Cổ phần Traphaco là một trong những công ty dược phẩm hàng đầu tại Việt Nam, chuyên sản xuất và kinh doanh các sản phẩm dược phẩm, thực phẩm chức năng và các sản phẩm chăm sóc sức khỏe trên nền tảng chuỗi cung ứng xanh từ nguồn nguyên liệu đến công nghệ sản xuất sạch, hệ thống phân phối, dịch vụ thân thiện với môi trường..",
                        "Bảo hiểm: xã hội; y tế; thất nghiệp; thân thể; Chăm sóc sức khỏe\n" +
                                "Chế độ thưởng, phúc lợi: theo quy định Công ty\n" +
                                "Đào tạo: được đào tạo theo quy định Công ty\n" +
                                "Lương : Theo quy định Công ty.\n" +
                                "Thu nhập ngoài lương khoảng 20-25%",
                        "Nhân Viên Vận Hành Ứng Dụng",
                        "1000-1200",
                        "https://traphaco.com.vn/",
                        "Vietnam",
                        null,
                        null,
                        null,
                        0, 0,
                        _AccountRepo.getOne(16)));
                return data;
        }
}
