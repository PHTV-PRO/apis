package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Repository.AccountRepo;
import com.company.phtv.Repository.CityProvinceRepo;

import java.util.ArrayList;
import java.util.List;

public class CompanyData {

        private final AccountRepo _AccountRepo;
        private final CityProvinceRepo _CityProvinceRepo;

        public CompanyData(AccountRepo _AccountRepo, CityProvinceRepo _CityProvinceRepo) {
                this._AccountRepo = _AccountRepo;
                this._CityProvinceRepo = _CityProvinceRepo;
        }

        // Mỗi Employer ại diện 1 cty
        @SuppressWarnings("deprecation")
        public List<Company> Data() {
                List<Company> data = new ArrayList<>();
                data.add(new Company(1,
                                "LIEN VIET POST JOINT STOCK COMMERCIAL BANK",
                                "Lien Viet Post Joint Stock Commercial Bank (LPBank), formerly Lien Viet Commercial Joint Stock Bank (LienVietBank), was established under the Establishment and Operation License No. 91/GP-NHNN dated March 28, 2008 of the Governor of the State Bank of Vietnam.\n"

                                                +
                                                "\n" +
                                                "In 2011, with the Vietnam Post Corporation contributing capital to LienVietBank with the value of the Postal Savings Service Company (VPSC) and in cash. Lien Viet Bank was allowed by the Prime Minister and the Governor of the State Bank of Vietnam to change its name to Lien Viet Post Joint Stock Commercial Bank. Along with this name change, Vietnam Post Corporation officially became the largest shareholder of LPBank\n"
                                                +
                                                "\n" +
                                                "After 15 years of establishment and operation, LPBank has developed into one of the top 10 largest joint stock commercial banks in Vietnam with total assets of over 327,000 billion VND, charter capital reached 17,241 billion VND. Currently, LPBank is also one of the banks with the largest network in the banking system with 561 branches, transaction offices and more than 10,000 service points. The total number of employees of LPBank has reached more than 12,000 people.",
                                "Bonuses on holidays and Tet according to the banking policy of each period (From 16-18 months salary/year)\n"
                                                +
                                                "Full regimes and benefits of Bank staff.\n" +
                                                "Dynamic, friendly and close environment. There are many opportunities for training, learning and development.\n"
                                                +
                                                "Annual salary review policy\n" +
                                                "Providing working equipment\n" +
                                                "Annual travel/team building\n" +
                                                "Full participation in insurance (social insurance/health insurance)\n"
                                                +
                                                "12 days of annual leave\n" +
                                                "Working hours from 08:00 to 17:00, from Monday to Friday every week. From 08:00 to 12:00 on Saturday morning",
                                "Middle, Senior",
                                "1900-2000",
                                "https://jobs.lpbank.com.vn/vi",
                                "Viet Nam",
                                "https://lienvietbankvn.com/wp-content/uploads/2021/06/hotline-ud.png",
                                "https://lienvietbankvn.com/wp-content/uploads/2024/03/photo_2024-01-14_10-55-17.jpg",
                                "[\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722878203/phongtro123/ty858v7drq5dztxhnq2v.jpg\",\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722878204/phongtro123/bhtwf4wgqow4o7l3erb0.jpg\"]",
                                1,
                                0,
                                _AccountRepo.getOne(2),
                                "Số 5 Lê Trung Nghĩa, Phường 12, Quận Tân Bình, Thành phố Hồ Chí Minh, Việt Nam",
                                _CityProvinceRepo.getOne(1),
                                3));
                data.add(new Company(2,
                                "Company Mission Useful SPRAYWAY-TPR",
                                "About Sprayway-TPR\\n\" +\n" +
                                                "\"• Sprayway-TPR is a subsidiary of Sprayway Singapore, headquartered in Singapore, with branches in the United States, China, India, Cambodia and Vietnam.\\n\"\n"
                                                +
                                                "+\n" +
                                                "\"• Our company specializes in supplying, supporting and distributing Sprayway and TPR branded products in countries such as the United States, Africa, Asia, Europe and the Middle East. For more than 70 years in the United States, Sprayway has provided high-quality sprays in 18 industries such as the garment-embroidery-printing industry, household appliances, automotive industry, etc. With leading-edge technology, we ensure that customers will receive high-end products in perfect packaging conditions.\\n\"\n"
                                                +
                                                "+\n" +
                                                "\"• Please visit our websites for more details:\\n\" +\n" +
                                                "\"www.spraywayvietnam.com; www.sprayway-tpr.com",
                                "None",
                                "Staff",
                                "99-1000",
                                "http://www.sprayway-tpr.com/vn/",
                                "Viet Nam",
                                "https://res.cloudinary.com/delgfr7a0/image/upload/v1722876595/phongtro123/di1f5ivtaq2lyfzajg0g.jpg",
                                "http://www.sprayway-tpr.com/vnt_upload/File/Image/Capture_3.png",
                                "[\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722876477/phongtro123/hhfckyol5wnn5cdjpx5k.jpg\",\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722876483/phongtro123/ysbraj8syi17uvf9dnow.jpg\",\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722876490/phongtro123/yeq2xpfu36n7o4ddofgb.jpg\",\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722876499/phongtro123/n7lpmznk86okol32yxbw.jpg\"]",
                                1,
                                0,
                                _AccountRepo.getOne(3),
                                "Tầng 25, Tòa nhà Lim Tower, 9 - 11 Tôn Đức Thắng, Phường Bến Nghé, Quận 1, Thành phố Hồ Chí Minh",
                                _CityProvinceRepo.getOne(2),
                                3));
                data.add(new Company(3,
                                "COMPANY Mission Useful LIKELION",
                                "100% funded by the Korean Government, this is the first project to connect jobs for Vietnamese students with Korean Start-up Enterprises. You will undergo practical training and experience living and working in major cities in Korea.",
                                "Lunch support for full-time classes\n" +
                                                "Lending learning equipment during training\n" +
                                                "Supporting interpretation during interviews with Enterprises\n" +
                                                "Supporting consulting on preparing VISA application documents (after passing the recruitment)\n"
                                                +
                                                "Candidates receive free training for 5 months\n" +
                                                "Job connection at Start-up companies in Korea\n" +
                                                "Supported in applying for E-7 VISA within the project framework",
                                "Fresher, Intern, All Levels",
                                "10-50",
                                "https://www.likelion.edu.vn/",
                                "South-Korea",
                                "https://salt.topdev.vn/1gqkMlaODtuHsUUfukg2NnL650zqwFNyqYPX_ZVyqQo/fit/384/1000/ce/1/aHR0cHM6Ly9hc3NldHMudG9wZGV2LnZuL2ltYWdlcy8yMDI0LzA1LzA4L1RvcERldi05NjAxY2I2NjI1OTdlYTM1NzIzYTBmMjkwODc1MTM3Yi0xNzE1MTYyMjY2LnBuZw",
                                "https://salt.topdev.vn/EUtbh-V5PBrEVe_Otnj4AwhZmbZDr8LuDy6XjM3KEgg/fit/1920/1000/ce/1/aHR0cHM6Ly9hc3NldHMudG9wZGV2LnZuL2ltYWdlcy8yMDI0LzA1LzA4L1RvcERldi00MDc1NjU0YjcxMTk2MTE5OTEyZjUwMDE5Y2UxODM3My0xNzE1MTYyMjY4LmpwZWc",
                                "[\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722876830/phongtro123/nmh8htfrdykcvub18pnr.jpg\",\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722876840/phongtro123/ph8ornhrqdnovm4qnbcr.png\",\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722876846/phongtro123/zpnf5sedjon5ynbax3lf.jpg\",\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722876851/phongtro123/uefnsihaczzluwyhwb9o.jpg\",\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722876856/phongtro123/mhpys0squ6layg6msnbi.jpg\"]",
                                1, 0,
                                _AccountRepo.getOne(4),
                                "Tòa nhà LPB, số 210 Trần Quang Khải, Phường Tràng Tiền, Quận Hoàn Kiếm, Thành phố Hà Nội",
                                _CityProvinceRepo.getOne(4),
                                3));

                // Ngân Hàng
                data.add(new Company(4,
                                "BIDV Technology Department",
                                "The Joint Stock Commercial Bank for Investment and Development of Vietnam (BIDV) is a leading bank in Vietnam, operating in many fields such as Banking, Insurance, Securities. With more than 25,000 employees, BIDV recognizes that human resources are a key factor for the development and success of the organization. Therefore, one of BIDV's most important goals is to build, maintain and develop a team of employees that is sufficient in quantity and quality to successfully implement the goals and business strategies of the system. \n"
                                                +
                                                "\n" +
                                                "66 years of construction and growth is a proud journey of generations of BIDV leaders and employees, going through 'many waterfalls and rapids' to forge and cultivate the mettle, resilience and overcoming difficulties of 'BIDV people'. At this milestone, with the determination of the Board of Directors, the solidarity and unity of the staff and employees, dynamic, BIDV has gathered all the conditions, determination and aspiration to change and conquer new heights.",
                                "13th month salary (Average 4-5 months of basic salary)\n" +
                                                "Enjoy salary, bonus and incentive mechanisms according to the agreement and regulations of the Joint Stock Commercial Bank for Investment and Development of Vietnam.\n"
                                                +
                                                "Enjoy additional income according to work results, job position and regulations of BIDV.\n"
                                                +
                                                "Salary review twice a year\n" +
                                                "Providing working equipment\n" +
                                                "Travel - Vacation - Team building every year\n" +
                                                "Regular health check-up\n" +
                                                "Wedding benefits, birthday money\n" +
                                                "Full participation in insurance according to regulations\n" +
                                                "Annual leave according to regulations of the State\n" +
                                                "Working hours: Monday - Friday from 8:00 a.m. to 5:00 p.m. hour",
                                "Technology Research Specialist - Position Code CN04 (Quantity: 02)",
                                "10-30",
                                "https://tuyendung.bidv.com.vn/",
                                "Viet Nam",
                                "https://salt.topdev.vn/Wt2k62htIQ3R5MXDy2T6eNJNoS8gArlxjQ-WtPnoD9s/fit/384/1000/ce/1/aHR0cHM6Ly9hc3NldHMudG9wZGV2LnZuL2ltYWdlcy8yMDIyLzA3LzE4L1RvcERldi04MWYzNjc3Y2Q2MGQyY2I5ZWI2ZDdmZWQ2YjdkNTI1MS0xNjU4MTEwOTA3LnBuZw",
                                "https://salt.topdev.vn/NYxQ4SK6H1v2z7cqZS2ZKJTvS0P1Ct5Ks21Saaxb6NA/fit/1920/1000/ce/1/aHR0cHM6Ly9hc3NldHMudG9wZGV2LnZuL2ltYWdlcy8yMDIzLzA3LzI0L1RvcERldi02ZmYzOWYyODBlNDY5MmI5OTU3MDBjYTM3MGFkYzAwYy0xNjkwMTY2MjQwLmpwZw",
                                "[\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722876889/phongtro123/z6qe8d59r3n86gncgnlw.jpg\",\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722876890/phongtro123/zz8gyv8us6onnz0k20zw.jpg\",\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722876892/phongtro123/wkeeyn0tlzhpn0gjoo5c.jpg\"]",
                                1, 0,
                                _AccountRepo.getOne(5),
                                "Tầng 14, Tháp A Vincom, 191 Bà Triệu, Phường Lê Đại Hành, Quận Hai Bà Trưng, Thành phố Hà Nội",
                                _CityProvinceRepo.getOne(1),
                                3));

                // Phần Mền
                data.add(new Company(5,
                                "Mobifone Information Technology Center",
                                "HELLO CANDIDATES\n" +
                                                "\n" +
                                                "There are many IT companies in Vietnam but only a few can compare to MobiFone in terms of working environment. The actual evidence is that MobiFone has been surveyed and evaluated by Anphabe Career Network Community as one of the 15 best places to work in Vietnam for many consecutive years. With all the elements that make up a good working environment: Clear vision, mission, and operational goals; Dynamic, open, and friendly working environment; Balance between work and life; Recognition of employees' contributions and dedication; Clear and transparent career development opportunities; Attractive welfare and salary mechanisms;….\n"
                                                +
                                                "\n" +
                                                "MobiFone Information Technology Center always opens its doors to welcome candidates who are suitable for the job position, working environment and are willing to contribute and strive their best together MobiFone!\n"
                                                +
                                                "\n" +
                                                "MobiFone IT Center\n" +
                                                "\n" +
                                                "MobiFone Information Technology Center is a unit under MobiFone Telecommunications Corporation, responsible for deploying business solutions and IT services for Government and Enterprise customers.\n"
                                                +
                                                "\n" +
                                                "Vision: MobiFone - Conquering the digital world\n" +
                                                "Mission: Bringing connected technology solutions in a comprehensive ecosystem to help promote digital transformation in businesses, agencies and organizations.\n"
                                                +
                                                "MobiFone Information Technology Center, formerly the Software Development Center under MobiFone Telecommunications Corporation, officially came into operation on January 24, 2014.\n"
                                                +
                                                "\n" +
                                                "Over 8 years of operation, with the main expertise in researching, developing and trading IT solutions and services for Government and Enterprise customers, MobiFone IT Center has launched more than 20 specific IT products in 3 groups: Digital Government, Digital Enterprise, Technology 4.0 (AI - IoT - Big Data) and provided to thousands of customers.\n"
                                                +
                                                "\n" +
                                                "After only 6 years of effective and independent development as a member company of the Corporation, MobiFone IT Center has continuously grown and expanded in scale. Currently, the Center has a team of experienced leaders, more than 30 excellent experts and a team of enthusiastic and dynamic employees, over 1,000 Account Managers, serving over 20,000 large and small domestic and foreign business customers. Since then, the Center has officially joined the Business unit group of MobiFone Telecommunications Corporation.",
                                "Income up to 480 million/year\n" +
                                                "Social insurance/unemployment benefits and other attractive benefits, health insurance package with benefits up to $8000\n"
                                                +
                                                "Compensation regimes, lunch 1,000,000 VND/month, internal subscription 320,000 VND/month\n"
                                                +
                                                "Training to develop yourself, improve professional skills and expertise\n"
                                                +
                                                "Work in a professional, dynamic, youthful environment and experience unique corporate cultural activities\n"
                                                +
                                                "Opportunity to approach large businesses, projects, the latest technology/platform trends, freely develop yourself creatively\n"
                                                +
                                                "Working hours: 08:00 - 17:00 from Monday to Friday every week (Closed on Saturday, Sunday)",
                                "Business Analyst",
                                "1-40",
                                "https://it.mobifone.vn/tuyen-dung/",
                                "Vietnam",
                                "https://salt.topdev.vn/6Ocwn3fA5uAXL8EYX3_RuaULkbzr84DRGxGy-SNmLZY/fit/384/1000/ce/1/aHR0cHM6Ly9hc3NldHMudG9wZGV2LnZuL2ltYWdlcy8yMDIyLzA4LzE2L1RvcERldi1sb2dvaEFUOEhsbVFDYXVmdlZ2ckNzanBJR1ppVndBRDZSU1otMTY2MDY1NDkxOS5qcGVn",
                                "https://salt.topdev.vn/YtmzTwIbwQPZuHJ4sITYorHC0gghwXURKNSK-mMXa-s/fit/1920/1000/ce/1/aHR0cHM6Ly9hc3NldHMudG9wZGV2LnZuL2ltYWdlcy8yMDIyLzEwLzA3L1RvcERldi1IRVkwMjMyOC0xNjY1MTEzMTA4LmpwZw",
                                "[\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722876927/phongtro123/hxrwpeoe2secjxumnalt.jpg\",\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722876930/phongtro123/yz6cowzy9ce9tssb1ymt.jpg\"]",
                                1, 0,
                                _AccountRepo.getOne(6),
                                "Văn phòng Hà Nội: Tầng 9-10, tòa nhà Thái Nam, đường Dương Đình Nghệ, Phường Yên Hoà, Quận Cầu Giấy, Thành phố Hà Nội",
                                _CityProvinceRepo.getOne(1),
                                3));
                // Dịch Vụ Doanh Nghiệp
                data.add(new Company(6,
                                "TopDev's Client",
                                "We are American company that specializes in developing software for the music industry. The programs we develop help record labels and artists market and monetize their music. We have offices in US and Europe, and we opened our Hanoi office in 2018. We are a young, dynamic company that is committed to making the music industry a simpler, more profitable place for artists.",
                                "Build solid foundation for IT career path through an accelerate 12-month development\n"
                                                +
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
                                "https://salt.topdev.vn/SQLQ2crvJd89D-maj2gk_Sla1kU36bI8UMz8d_w_IHg/fit/384/1000/ce/1/aHR0cHM6Ly9hc3NldHMudG9wZGV2LnZuL2ltYWdlcy8yMDI0LzAzLzAxL1RvcERldi1TRTZxUTE4RWJBVWpjZm9ELTE3MDkyNzg3MTcucG5n",
                                "https://salt.topdev.vn/KCDbINiKQWqOXrY1mJJghjs7_ShTBmt7Ad1bpNpd1B8/fit/1920/1000/ce/1/aHR0cHM6Ly9hc3NldHMudG9wZGV2LnZuL2ltYWdlcy8yMDI0LzA1LzA4L1RvcERldi12aUp2bm1pZmhKVXVZYWRlLTE3MTUxNDQyNTUucG5n",
                                "[\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722876979/phongtro123/iojsur961rr0dalmz4vg.png\",\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722876980/phongtro123/tgdqluc3fs5aspyqei7m.png\",\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722876983/phongtro123/ugtr8ycde1uikat93qyr.png\"]",
                                1, 1,
                                _AccountRepo.getOne(7),
                                "Tầng 12A, Toà nhà AP Tower, 518B Điện Biên Phủ, Phường 21, Quận Bình Thạnh, Thành phố Hồ Chí Minh",
                                _CityProvinceRepo.getOne(3),
                                3));
                // Finance

                data.add(new Company(7,
                                "Mirae Asset Finance Company (Vietnam)",
                                "Mirae Asset Finance Company Vietnam is a member of Mirae Asset Financial Group, a global financial group from Korea, with 20 years of experience in finance, securities, investment, asset management etc., and is present in 16 countries with 200 offices and branches worldwide.\n"
                                                +
                                                "\n" +
                                                "Being present in Vietnam in 2006 and officially operating in 2011, the Company has been built with the vision of always pursuing an optimal investment management strategy in order to support customers with achieving their long-term goals. In addition, Mirae Asset Finance Company Vietnam has made continuous efforts to improve its consumer financial products with a purpose of creating favorable conditions for the customers to effectively, legally and safely access the capital.",
                                "15 Annual Leaves\n" +
                                                "13th Salary and pro-Rate and performance bonus\n" +
                                                "Annual healthcare insurance package from senior level and above\n" +
                                                "A week trip to Korea in order to recognize all your good performance and effort\n"
                                                +
                                                "Work-life balance 42,5-hr per week from Mon to Fri.",
                                "Software Quality Assurance Executive",
                                "50-100",
                                "http://mafc.com.vn",
                                "South-Korea",
                                "https://salt.topdev.vn/S8bSkxCCiyB_TM656KwMU-0vAHXutXwO7Q9VN4JTVCY/fit/384/1000/ce/1/aHR0cHM6Ly9hc3NldHMudG9wZGV2LnZuL2ltYWdlcy8yMDI0LzAyLzA1L1RvcERldi1kQUJCeHhpOXdSZXBHMkl6LTE3MDcxMjU1NDYucG5n",
                                "https://salt.topdev.vn/Kz91Py1lfYsNmBPblM-XJrOQOsOfMS30-1RjILko70A/fit/1920/1000/ce/1/aHR0cHM6Ly9hc3NldHMudG9wZGV2LnZuL2ltYWdlcy8yMDIyLzA1LzI0L1RvcERldi1Ub3BEZXYtZ2FsbGVyeTJxNGtUelRjc1N1dHhjdnVwNVd1VFU2NlZ1T25UV0FwLTE2NDE0NjUzMDUtMTY1MzM4Mzg4Ny5qcGVn",
                                "[\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722877000/phongtro123/basuveqzbyosfgpcvp6a.jpg\",\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722877002/phongtro123/zbkzyudd18psbl1zrtcu.jpg\",\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722877004/phongtro123/tidbjwqthbwjgfibnmyn.jpg\"]",
                                1, 1,
                                _AccountRepo.getOne(8),
                                "67B phố Hàm Long, Phường Hàng Bài, Quận Hoàn Kiếm, Thành phố Hà Nội",
                                _CityProvinceRepo.getOne(2),
                                3));
                // Ecomerce Platforms
                data.add(new Company(
                                8,
                                "Megazone Vietnam Company Limited",
                                "Megazone Cloud is one of the largest cloud managed service providers (MSP) in the Asia Pacific region. Since its foundation in 1998, the company has offered business-to-business IT services, and currently boasts over 1,000 experts. Megazone Cloud is Korea’s first AWS Premier Consulting Partner is leading the development of the cloud market in the APAC region. Recently, the company has been actively expanding its global market by establishing overseas subsidiaries in the United States, Japan, China, and others. Megazone reported about US$ 1.7 billion of sales in the field of cloud transformation and operational management in 2018 and is foreseeing to reach up to about US$ 3.8 billion of sales. Megazone's customer companies range from big companies such as Samsung Electronics Co. and LG Electronics Inc. to financial institutes and start-ups.",
                                "Product company with global reputation specialized in end-point security\n" +
                                                "Very attractive salary\n" +
                                                "Global standard working environment\n" +
                                                "100% salary during probation period\n" +
                                                "13th month salary\n" +
                                                "Birthday Bonus, New Year Bonus\n" +
                                                "Social Insurance, health insurance, unemployment insurance on total salary after probation period\n"
                                                +
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
                                "https://www.megazonecdn.com/pops/images/og-megazone-pops.png",
                                "https://imgnew.megazone.com/2022/01/168380_91940_3339.jpg",
                                "[\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722877272/phongtro123/pgw3xfaihqg5iiw6owrh.jpg\",\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722877273/phongtro123/lcimrlalkjgvbm4coouh.jpg\",\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722877275/phongtro123/sscylpxupx07beo8zzlw.png\"]",
                                1, 1,
                                _AccountRepo.getOne(9),
                                "Tòa nhà Bitexco, Ho Chi Minh City, Phường Bến Nghé, Quận 1, Thành phố Hồ Chí Minh",
                                _CityProvinceRepo.getOne(8),
                                3));

                // B2b
                data.add(new Company(9,
                                "Dynamics 365 Support Technician (Open for freshers)",
                                "iTechwx is newly born in the summer of 2022 in Ho Chi Minh City, Vietnam. We locate in Binh Thanh District, settling the office inside Opal Tower. As the first stop in SEA region, iTechwx encounters Vietnam, and particularly the city of Ho Chi Minh because of the richness in human resources, as well as the prospecting technology industries in this robust city.\n"
                                                +
                                                "\n" +
                                                "We see opportunities - specifically to the sector of cloud solutions and managed IT services. We believe a One-Stop Digital Transformation Service is the solution to most enterprises. iTechwx is specialized in agile recruiting, designated training, and managing services to drive exceptional quality in delivery. iTechwx is also empowered to incubate technical talents. We invent highly efficient training, mentoring, onboarding, and quality assurance processes, incorporating with the essence of customer services. We see the city is awaiting to practice the most to succeed.\n"
                                                +
                                                "\n" +
                                                "We invest on the talents. iTechwx commits to carefully treat each employee, and to forge a company brand full of vitality. Employees in iTechwx always find easy access to company resources. Teams are supplemented with supporting groups to take care of employee work experience.\n"
                                                +
                                                "\n" +
                                                "iTechwx dedicates the One-Stop Digital Transformation Service to our customers\n"
                                                +
                                                "\n" +
                                                "Contact Center Services\n" +
                                                "iTechwx constructs contact centers with customer-oriented advocates, supporting global customers with multi-languages and multi-media. iTechwx offers tech-focused contact center services, with our advanced operation standards, specialized training programs, and innovative management structure.\n"
                                                +
                                                "\n" +
                                                "Information Technology Services\n" +
                                                "iTechwx provides services including design, development, testing, maintenance, support, and project management for both software and hardware products in frontier technological domains such as Cloud Computing, Internet of Things, Big Data, Smart Technology, Mobile Technology, etc.\n"
                                                +
                                                "\n" +
                                                "Conquer the Everest, Together with iTechwx.",
                                "Competitive salary depending on experience: starting from 20,000,000 VND GROSS\n" +
                                                "Salary at 100% during the probationary period\n" +
                                                "Training will be offered\n" +
                                                "Full working equipment will be provided\n" +
                                                "90% contribution of the gross salary to social insurance\n" +
                                                "12 days of annual leave, 8 days of sick leave\n" +
                                                "30% allowance on gross salary + PVI insurance + 500,000 VND food allowance for employees working night shift\n"
                                                +
                                                "Annual Health Checkup",
                                "Dynamics 365 Support Technician (Open for freshers)",
                                "100-500",
                                "https://itechwxrecruiting.jobday.vn",
                                "United States",
                                "https://itechwxrecruiting.jobday.vn/APIS/g1/JobDayAPI/api/Image?tenantCode=QDPNTNMD&fileName=d8d7bc53-fc75-42b2-832c-b776dfc47520.jpg&storageType=4",
                                "https://itechwxrecruiting.jobday.vn/APIS/g1/JobDayAPI/api/Image?tenantCode=QDPNTNMD&fileName=ecbe8bc7-4b2e-464b-bdf2-4cea9d77e92f.jpg&storageType=4",
                                "[\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722866224/phongtro123/uwn3tukklto1clxnfrso.png\",\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722866229/phongtro123/ciridaczp9zz0hlbashp.png\",\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722866232/phongtro123/n7tecq6fpzvm6qj9f7ai.png\",\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722866237/phongtro123/iz1nehpfru1zcadfvb9h.png\"]",
                                1, 1,
                                _AccountRepo.getOne(10),
                                "The Sun Avenue 28 Mai Chí Thọ, An Phú, Quận 2, Phường An Phú, Thành phố Thủ Đức, Thành phố Hồ Chí Minh",
                                _CityProvinceRepo.getOne(8),
                                3));
                // Phần Cứng
                data.add(new Company(10,
                                "Traphaco Joint Stock Company",
                                "Traphaco Joint Stock Company is one of the leading pharmaceutical companies in Vietnam, specializing in manufacturing and trading pharmaceutical products, functional foods and health care products on the basis of a green supply chain from raw materials to clean production technology, distribution system, and environmentally friendly services.",
                                "Insurance: social; medical; unemployment; body; health care\\n\" +\n" +
                                                "\"Bonus and welfare regime: according to Company regulations\\n\" +\n"
                                                +
                                                "\"Training: trained according to Company regulations\\n\" +\n" +
                                                "\"Salary: According to Company regulations.\\n\" +\n" +
                                                "\"Income outside of salary is about 20-25%",
                                "Application Operator",
                                "1000-1200",
                                "https://traphaco.com.vn/",
                                "Vietnam",
                                "https://salt.topdev.vn/a3a-266ApVQlUcAN_Hu2CZIKu1y-p6mQ49Yhb8Zp4yI/fit/384/1000/ce/1/aHR0cHM6Ly9hc3NldHMudG9wZGV2LnZuL2ltYWdlcy8yMDI0LzA2LzA1L1RvcERldi1sb2dvX3ZpLS0tbmd1eWVuLWxhcC0xNzE3NTUzMzg3LnBuZw",
                                "https://res.cloudinary.com/delgfr7a0/image/upload/v1722865311/phongtro123/l6omjqthf2a8rsrz5h2p.jpg",
                                "[\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722865311/phongtro123/l6omjqthf2a8rsrz5h2p.jpg\",\"https://res.cloudinary.com/delgfr7a0/image/upload/v1722865315/phongtro123/ttdyajssmv0depdaz9rh.jpg\"]",
                                1, 1,
                                _AccountRepo.getOne(11),
                                "Số 75 phố Yên Ninh, Phường Quán Thánh, Quận Ba Đình, Thành phố Hà Nội",
                                _CityProvinceRepo.getOne(4),
                                3));
                return data;
        }
}
