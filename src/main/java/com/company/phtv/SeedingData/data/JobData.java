package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.*;
import com.company.phtv.Repository.CompanyRepo;
import com.company.phtv.Repository.JobTypeRepo;
// import com.company.phtv.Repository.LocationRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobData {

        private final CompanyRepo _CompanyRepo;
        // private final LocationRepo _LocationRepo;
        private final JobTypeRepo _JobTypeRepo;

        public JobData(CompanyRepo _CompanyRepo , JobTypeRepo _JobTypeRepo) {
                this._CompanyRepo = _CompanyRepo;
                this._JobTypeRepo = _JobTypeRepo;
        }

        @SuppressWarnings("deprecation")
        public List<Jobs> Data() {
                List<Jobs> data = new ArrayList<>();
                //  Job Expired
                data.add(new Jobs(

                        1,
                        "Designer - Salary 12 - 18 Million (Experienced)",
                        "- Receive design requests; products of beds, cabinets, tables and chairs... (disassembled goods)\n" +
                                "\n" +
                                "- 3D design; extract drawings, upload to AI\n" +
                                "\n" +
                                "- Coordinate with the production workshop, support consulting on materials, production methods...",
                        "No Requirements",
                        "- Graduated from design major or equivalent.\n" +
                                "\n" +
                                "- Proficient in AutoCAD, 2D, 3D design\n" +
                                "\n" +
                                "- Experience in designing beds, cabinets, tables and chairs for 5 years or more",
                        "Salary is negotiable (12-18 million) (negotiable based on the candidate's ability)\n" +
                                "\n" +
                                "Pay social insurance, health insurance according to regulations, Tet bonus, lunch,...\n" +
                                "\n" +
                                "13th month salary, seniority bonus, solar and lunar bonus,...\n"
                                +
                                "\n" +
                                "Annual leave, holidays, Tet,... full of current regime.\n" +
                                "\n" +
                                "Pay insurance after officially working.",
                                "None",
                                1,
                                "5 years",
                                "18 millions",
                                "12 millions",
                                new Date("03/06/2024"),
                                //month/day/year
                                new Date("07/06/2024"),
                                true,
                                0,
                                _CompanyRepo.getOne(2),
                                // _LocationRepo.getOne(1),
                                _JobTypeRepo.getOne(1)));
                data.add(new Jobs(
                                2,
                        "FREE TRAINING AND WORKING OPPORTUNITY IN KOREA FOR FRESHERS (5 months of training + E-7 Engineer visa)",
                        "100% funded by the Korean Government, this is the first project to connect jobs for Vietnamese students with Korean Start-up Enterprises. You will undergo practical training and experience living and working in major cities of Korea.",
                        "Training content:\n" +
                                "\n" +
                                "05 months of training (full-time) with the following content:\n" +
                                "\n" +
                                "Front-end or Back-end\n" +
                                "How to interview with Korean enterprises\n" +
                                "Working culture of Korean companies\n" +
                                "Basic Korean\n" +
                                "E-7 visa to work in Korea\n" +
                                "Training in the direction of practical projects\n" +
                                "Application deadline is 23:00, May 23, 2024\n" +
                                "Training period: June ~ November 2024",
                        "About to graduate from university with IT-related majors\n" +
                                "Graduated from other majors but intend to study and become a Dev\n"
                                +
                                "Knowing Korean is a plus",
                        "Lunch support for full-time classes\n" +
                                "Lending learning equipment during training\n" +
                                "Interpreting support during interviews with businesses\n" +
                                "Support consulting on preparing VISA application documents (after passing the recruitment)\n" +
                                "Candidates receive free training for 5 months\n" +
                                "Job connections at Start-up companies in Korea\n" +
                                "Support for applying for E-7 VISA within the framework of the project sentence",
                        "Round 1: Application deadline is 11:00 p.m., May 23, 2024\n" +
                                "Round 2: Admission and placement deadline: May 31, 2024\n" +
                                "Round 3: Training period: June ~ November 2024",
                                0,
                                "No Required",
                                null,
                                null,
                                new Date("02/06/2024"),
                                new Date("04/07/2024"),
                                true,
                                0,
                                _CompanyRepo.getOne(3),
                                // _LocationRepo.getOne(2),
                                _JobTypeRepo.getOne(2)));

                data.add(new Jobs(
                        3,
                        ".NET Developer",
                        null,
                        "Construct, develop, upgrade, and fix product errors on the enterprise management system according to the requirements of the Business Department.\\n\" +\n"
                                +
                                " \"Programming and developing applications, building documents, serving management and business work approved by the Board of Directors of the Block or equivalent level.\\n\" +\n"
                                +
                                " \"Self-research and contribute ideas, build opinions on business documents, support department leaders with initiatives to serve the work.\\n\" +\n"
                                +
                                " \"Coordinate support, check the system that has been built and deployed.\\n\" +\n"
                                +
                                " \"Manage, review, and compare code before uploading to the UAT, LIVE environment.\\n\" +\n"
                                +
                                " \"Manage source code of related applications.",
                        "About to graduate from University in IT-related majors\n" +
                                "Graduated from majors other majors but intend to study and become a Dev\n"
                                +
                                "Knowing Korean is a plus",
                        "Bonuses on holidays and Tet according to the bank's policy from time to time (From 16-18 months salary/year)\n"
                                +
                                "Full benefits and rights of bank staff.\n" +
                                "Dynamic, friendly, close environment. Many opportunities to study, train, learn and develop.\n"
                                +
                                "Annual salary review policy\n" +
                                "Providing working equipment\n" +
                                "Annual travel/team building\n" +
                                "Full participation in insurance (social insurance/health insurance)\n" +
                                "12 days of annual leave\n" +
                                "Working hours from 08:00 to 17:00, from Monday to Friday every week. From 08:00 to 12:00 on Saturday morning",
                        "Round 1: 01 round only (direct/online)",
                        0,
                        "From 2 years of experience \n" +
                                "Proficient in web coding on .NET platform\n" +
                                "Proficient in Oracle Database\n" +
                                "Priority is given to candidates who know banking operations: payment connection, reconciliation, kpi, credit rating...",
                        null,
                        "Negotiate",
                        new Date("02/05/2024"),
                        new Date("06/07/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(1),
                        // _LocationRepo.getOne(3),
                        _JobTypeRepo.getOne(3)));

                data.add(new Jobs(
                        4,
                        "Technology Research Specialist - Position Code CN04 (Quantity: 02)",
                        null,
                        "Participate in research, identify new technologies, evaluate feasibility, impacts and propose the application of new technologies in IT activities at BIDV.\n" +
                                "Organize and supervise the organization of research on new technologies in the IT field.\n" +
                                "Research on IT knowledge management at BIDV.\n" +
                                "Develop processes, regulations and policies on technology research and IT knowledge management.\n" +
                                "Conduct research and update new technology trends in the IT field.\n" +
                                "Conduct training on new technologies in the IT field.\n" +
                                "Perform other tasks as assigned."
                        , "1. General standards: \n" +
                        "\n" +
                        "Be a Vietnamese citizen, have a permanent residence in Vietnam. Age not over 35 years old for Specialists, 45 years old for Team Leaders/Experts.\n" +
                        "Be in good health to undertake the work.\n" +
                        "Have good moral qualities, no criminal record; not being prosecuted for criminal liability, serving a prison sentence, suspended sentence, non-custodial reform, probation, being subject to local educational measures, being treated for illness, drug addiction treatment...\n" +
                        "2. Specific standards:\n" +
                        "\n" +
                        "2.1. Professional qualifications\n" +
                        "\n" +
                        "Graduated from university or higher, full-time (including university degree 2, not including university transfer) at domestic universities or graduated from university or higher at foreign universities, Affiliated University.\n" +
                        "Major: Graduated from one of the following majors: Information Technology, Information Security, Computer Science, Software Engineering, Information Systems, Computer Engineering, Information Systems Management, Telecommunications Electronics, Communications Electronics, Mathematics - Information Technology or equivalent.\n" +
                        "2.2 Foreign languages: \n" +
                        "\n" +
                        "Candidates must have one of the following certificates: TOEIC 600/990, TOEFL PBT/IPT 500/677, TOEFL CBT 173/300, TOEFL iBT 61/120, IELTS 5.5/9.0, Cambridge Exam First (FCE), B2 European Framework, 4/6 6-level Foreign Language Proficiency Framework for Vietnam. Accept candidates to provide additional English certificates within 24 months from the date of recruitment.\n" +
                        "2.3. Knowledge, skills, experience:\n" +
                        "\n" +
                        "Have experience in researching at least one of the fields of Artificial Intelligence/Big Data/IoT, Cloud,...\n" +
                        "Have the ability to conduct in-depth research, quickly grasp new technology trends.\n" +
                        "Have the ability to program in one of the languages ​​(Python, Perl, Java, .Net, ...)\n" +
                        "Have the ability to use modern BI tools (Tableau, Power BI, ...)\n" +
                        "Have the ability to participate in giving opinions on building regulations, policies, procedures, and professional instructions.\n" +
                        "Have the ability to self-study to improve professional capacity.\n" +
                        "Have knowledge and understanding of IT and IT applications in banking operations.\n" +
                        "Have knowledge and understanding of systems, software solutions/IT ​​applications.\n" +
                        "Have problem-solving skills topic.\n" +
                        "Have skills in planning and writing proposal reports.\n" +
                        "Priority is given to those who have certificates or participated in training courses on: Artificial Intelligence/ Big Data/ IoT, Cloud,….",
                        "13th month salary (Average 4-5 months of basic salary)\n" +
                                "Enjoy salary, bonus and incentive mechanisms according to agreement and regulations of Vietnam Joint Stock Commercial Bank for Investment and Development.\n" +
                                "Additional income based on work results, job position and regulations of BIDV.\n" +
                                "Salary review twice a year\n" +
                                "Providing working equipment\n" +
                                "Travel - Vacation - Team building every year\n" +
                                "Regular health check-up\n" +
                                "Wedding benefits, birthday money\n" +
                                "Full participation in insurance according to regulations\n" +
                                "Annual leave according to State regulations\n" +
                                "Working hours: Monday - Friday from 8:00 to 17:00"
                        ,"Round 1: Preliminary screening of documents\n" +
                        "Round 2: Interview (Business and English)",
                        2,
                        "From 1 year",
                        null,
                        "Negotiable",
                        new Date("03/07/2024"),
                        new Date("06/08/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(4),
                        // _LocationRepo.getOne(4),
                        _JobTypeRepo.getOne(1)));


                data.add(new Jobs(
                        5,
                        "Business Analyst",
                        null,
                        "Conduct surveys, collect requirements and work items from customers, evaluate feasibility and related impacts\n" +
                                "Analyze requirements, model business processes, build business documents (Requirements Analysis, Technical Specifications), design prototypes (Mockups) for products\n" +
                                "Generate design ideas using storyboards, process diagrams and sitemaps\n" +
                                "Design user interfaces, such as menus, tabs and widgets\n" +
                                "Manage product change requests\n" +
                                "Review and evaluate products before handing over to customers",
                        "Graduate from university majoring in Information Technology, Mathematics and Information Technology or equivalent.\n" +
                                "Under 35 years old\n" +
                                "Have knowledge of IT: Software structure, system analysis and design, database\n" +
                                "Proficient in skills: Planning, strategic positioning, negotiation, presentation, customer persuasion, communication and teamwork\n" +
                                "Have systematic analytical thinking, logical thinking, argumentation and critical thinking skills\n" +
                                "Proactive, responsible, able to withstand high work pressure\n" +
                                "Proficient in techniques such as: Market Analysis; Brainstorming; Backlog Management; Use Cases and Scenarios; User Stories; Business Rules Analysis\n" +
                                "Knowledge of software development process\n" +
                                "Good thinking, ability to research, evaluate and update new technology",
                        "MobiFone Information Technology Center\n" +
                                "Working in a professional, stable environment\n" +
                                "Health care with Insurance package with benefits up to $8000\n" +
                                "Compensation regimes, lunch allowances, internal subscriptions\n" +
                                "Experience diverse teambuilding, cultural, tourism, spring travel, summer vacations at home and abroad...\n" +
                                "Regularly attend a variety of training courses to help employees continuously develop themselves, improve their skills and professional expertise",
                        "Round 1: 1 round interview",
                        5,
                        "From 1 year"
                        ,null,
                        "Negotiate",
                        new Date("05/07/2024"),
                        new Date("07/07/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(5),
                        // _LocationRepo.getOne(5),
                        _JobTypeRepo.getOne(1)));

                data.add(new Jobs(
                        6,
                        "DevOps Engineer (All Levels)",
                        "We are Stepmedia Software Viet Nam. We are looking for .NET Developer staff to join in our software project in Viet Nam.",
                        "In charge of the current scalable platform running on Infrastructure (AWS & GCP) serving customer partners.\n" +
                                "Building CI/CD automated integration deployment tools\n" +
                                "Optimizing the system to handle query issues affecting performance\n" +
                                "Writing modules to integrate other products into the service system\n" +
                                "Moving microservices to container-based infrastructure using Kubernetes\n" +
                                "Researching new techniques/technologies to improve the performance of the DevOps team.\n" +
                                "Setting up technical environments for the development team\n" +
                                "Monitoring and troubleshooting application or system issues.\n" +
                                "Operate and design systems to solve problems: Cloud (AWS & GCP), Kubernetes, CI/CD (Gitlab CI, octopus).",
                        "Love technology, willing to research and develop new technologies\n" +
                                "Ability to learn independently, as well as coordinate with the team\n" +
                                "More than 1 year of experience working with AWS or OpenStack\n" +
                                "Prefer candidates:\n" +
                                "\n" +
                                "Proficient in at least 01 programming language (Python, Java...)\n" +
                                "Experience in security and cybersecurity risks on cloud computing\n" +
                                "Have a university/graduate degree in IT and Telecommunication",
                        "Build solid foundation for IT career path through an accelerate 12-month development\n" +
                                "Acquire strong technical and soft skills\n" +
                                "Work in cutting edge technology projects\n" +
                                "Buddy with friendly colleagues and learn from senior experts\n" +
                                "Develop a strong sense of business insight\n" +
                                "Development journey come along with growing benefits\n" +
                                "Receive attractive benefits (meal allowance, 13th month salary, performance bonus, healthcare insurance,...)"
                        ,
                        "Round 1: CV Screening\n" +
                        "Round 2: Face-to-face Interview with HR\n" +
                        "Round 3: Face-to-face Interview with Department Head",
                        0,
                        "Not required"
                        ,null,
                        "Negotiate",
                        new Date("04/07/2024"),
                        new Date("07/07/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(6),
                        // _LocationRepo.getOne(6),
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
                        "Negotiate",
                        new Date("03/07/2024"),
                        new Date("05/08/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(7),
                        // _LocationRepo.getOne(7),
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
                        "2000 VND",
                        "1200 VND",
                        new Date("02/07/2024"),
                        new Date("05/08/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(8),
                        // _LocationRepo.getOne(8),
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
                        "900",
                        "720",
                        new Date("05/7/2024"),
                        new Date("07/8/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(9),
                        // _LocationRepo.getOne(9),
                        _JobTypeRepo.getOne(1)));
                // cái này c description riêng => nên kham khảo trên phone ròi đưa ra phương án thích hợp
                data.add(new Jobs(
                        10,
                        "Application Operator",
                        "Recruitment position: Application Operator\n" +
                                "Department: Information Technology Department\n" +
                                "Number of vacancies: 02\n" +
                                "Working place: Hanoi\n" +
                                "Recruitment period: 06/2024",
                        "Tasks:\n" +
                                "\n" +
                                "Deploy application and software projects at the company, member companies and branches.\n" +
                                "Support software and application users to handle problems encountered during use.\n" +
                                "Operate software and applications to ensure that applications operate effectively and stably.\n" +
                                "Participate in testing and acceptance of application software to ensure quality before deployment.\n" +
                                "Participate in accessing business processes and application software systems. Consulting on processes and operations to ensure effective application.\n" +
                                "Participate in training, document development and related knowledge of application software.\n" +
                                "Perform other tasks as assigned by Manager/Leader/Digital Transformation Board.",
                        "Age: Under 30\n" +
                                "Gender: Male/Female\n" +
                                "Professional qualifications: University degree or higher, priority given to majors in IT-Software, Management Information Systems, Applied Informatics, Mathematics and Information Technology.\n" +
                                "Have knowledge of one of the database management systems such as MySQL, SQL, Oracle...\n" +
                                "Have knowledge of ERP, HRM, E-Office systems...\n" +
                                "English proficiency: reading and translating specialized English documents.\n" +
                                "Experience: at least 1 year of experience supporting software deployment and operation at businesses or software service enterprise.",
                        "Fixed salary: According to the company's salary regulations + Other bonuses equivalent to 20-30%\n" +
                                "Insurance: social; health; unemployment; body\n" +
                                "Holiday and New Year regime; February 27; Hung King's death anniversary; March 8; October 20; April 30 + May 1; September 2; Children's Day, Mid-Autumn Festival, company's TL day; Vacation, bonus for completing the plan..\n" +
                                "Training to develop yourself domestically and internationally"
                        ,"Priority is given to online applications on the recruitment portal of topdev.vn",
                        2,
                        "From 1 year",
                        "800 USD",
                        "500 USD",
                        new Date("04/7/2024"),
                        new Date("07/9/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(10),
                        // _LocationRepo.getOne(10),
                        _JobTypeRepo.getOne(1)));

                //  Jobs Available
                // fresher
                data.add(new Jobs(
                        11,
                        "Content Marketing Staff Graphic Design",
                        "- Support in developing plans and articles with content that is suitable and optimized for each communication channel of the company.\n" +
                                "\n" +
                                "- Create content for the Company's Website, Facebook, PR, Adword, SEO and media publications.\n" +
                                "\n" +
                                "- Design graphics for communication and marketing needs, including but not limited to websites, online advertising, printed materials.\n" +
                                "\n" +
                                "- Work closely with the Marketing department to develop and implement effective communication campaigns.\n" +
                                "\n" +
                                "- Monitor and apply the latest design trends to ensure freshness and creativity in all works.\n" +
                                "\n" +
                                "- Manage projects related to web development and graphic design, including planning, implementation and progress monitoring.\n" +
                                "\n" +
                                "- Perform other professional tasks in the Marketing department as required by the department head.",
                        "No Requirements",
                        "- Qualification: Graduated from high school, college, university ... priority is given to those majoring in marketing, journalism, graphic design or related fields.\n" +
                                "\n" +
                                "- Proficiency in design tools (Adobe Photoshop, Illustrator, InDesign)\n" +
                                "\n" +
                                "- Experience: Priority is given to candidates who know how to write Google or Facebook advertising templates, priority is given to candidates who know how to write SEO standard articles.\n" +
                                "\n" +
                                "- Ability to analyze and work independently.\n" +
                                "\n" +
                                "- Good writing skills, experience in writing PR articles.\n" +
                                "\n" +
                                "- Quick, honest\n" +
                                "\n" +
                                "- Able to work in a pressured environment\n" +
                                "\n" +
                                "- Good teamwork skills\n" +
                                "\n" +
                                "- High sense of responsibility for work",
                        "- Enjoy all current benefits of the company and the state\n" +
                                "\n" +
                                "- Enjoy full social insurance benefits\n" +
                                "\n" +
                                "- Dynamic, professional and friendly working environment with competitive salary.\n" +
                                "\n" +
                                "- Many opportunities for professional training, technical training\n" +
                                "\n" +
                                "- Development and challenge opportunities\n" +
                                "\n" +
                                "- Opportunity to improve missing skills, high promotion opportunities.\n" +
                                "\n" +
                                "- Submit complete application according to current regulations (notarized). The company will not return the application in case of failure to pass the review round",
                        "None",
                        3,
                        "1 year",
                        "Negotiate",
                        null,
                        new Date("08/07/2024"),
                        //month/day/year
                        new Date("10/07/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(2),
                        // _LocationRepo.getOne(1),
                        _JobTypeRepo.getOne(1)));

                data.add(new Jobs(
                        12,
                        "[DI6] SENIOR FRONT-END DEVELOPER (REACTJS/REACT NATIVE/ANGULAR) - MSB -1Y562",
                        "This position is part of the Recruitment Program dedicated to MSB's Major Innovation Projects. The ultimate goal of the Program is to find and create opportunities for experienced Technology Engineers to demonstrate their capabilities, thereby successfully implementing projects to digitize the bank's processes and operations. These Major Innovation Projects are one of the main pillars for MSB to realize its ambition - Becoming a Bank with the best service quality on a modern digital platform.",
                        "Responsible for designing, maintaining and developing Web systems as required\n" +
                                "Work with the team to develop solutions when needed\n" +
                                "Work with designers and BAs on product UI/UX design\n" +
                                "Ensure that the interface meets graphic standards\n" +
                                "Agree with the Backend team on API and perform API integration\n" +
                                "Participate in front-end code review",
                        "At least 3 years of frontend experience\n" +
                                "Experience using one of the CSS preprocessors such as SASS, LESS or Stylus.\n" +
                                "Experience working with Angular 9+, Typescript, RxJS, Angular Material, PrimeNG\n" +
                                "Good use of Angular core techniques such as component, directive, dependency injection\n" +
                                "Ability to optimize web application performance\n" +
                                "Experience building responsive web applications\n" +
                                "Experience working with Redux pattern, state management (NgRx, Akita, Ngxs, ...)\n" +
                                "Experience using data structure libraries (e.g., Immutable.js)\n" +
                                "Experience developing and integrating RESTful API, Web socket. Understanding of Microservice architecture.\n" +
                                "Priority is given to candidates who have deployed products to AWS\n" +
                                "Priority is given to candidates who are proficient in GIT\n" +
                                "Knowledge of Object Oriented Programming (OOP)\n" +
                                "Priority is given to candidates who have experience working in Agile/Scrum",
                        "Participate in mega projects with an investment capital of 2,000 billion VND, applying the latest technologies.\n" +
                                "Led by a team of highly skilled managers, fair evaluation. Opportunity to work directly with the world's leading partners (AWS; BCG; IBM; Temenos...).\n" +
                                "Monthly salary depends on work ability: $1000 - $3000. Income package from 15 to 20 months salary/year with many attractive benefits (Esop, preferential loans, high-class health insurance..., project bonuses depending on job position).\n" +
                                "Many training programs to improve skills and professional capacity. Participate in the Next Generation Leadership program (Talent Pool) when having good performance for many years.\n" +
                                "Work in the \"Outstanding Digital Transformation Bank\" honored for 3 consecutive years by the Association of Banks and the International Data Group (IDG)\n" +
                                "Classy working office according to the advanced Agile model. Good facilities, working tools, powerful configuration.",
                        "Round 1: Application deadline is 11:00 p.m., May 23, 2024\n" +
                                "Round 2: Admission and placement deadline: May 31, 2024\n" +
                                "Round 3: Training period: June ~ November 2024",
                        4,
                        "From 3 years",
                        "Negotiable",
                        null,
                        new Date("08/07/2024"),
                        new Date("11/07/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(3),
                        // _LocationRepo.getOne(2),
                        _JobTypeRepo.getOne(2)));
                //senior
                data.add(new Jobs(
                        13,
                        "Software Engineer II, III (C#, .NET)",
                        "About Us\n" +
                                "\n" +
                                "MiTek is a platform innovator and enabler that exists to transform the building industry with better building solutions. In 1955, MiTek transformed residential construction with the invention of the Gang-Nail plate and a digital platform that provided an affordable and scalable way to manufacture wood trusses. Today, MiTek delivers software, services, engineered products, and automated solutions that enable the building industry to improve efficiencies by optimizing the balance between off-site and on-site. With nearly 5,600 team members worldwide, MiTek collaborates across the building industry to enable and accelerate transformational breakthroughs in design and construction to transform the way the industry designs, makes, and builds. As a Berkshire Hathaway (NYSE: BRK-A, NYSE: BRK-B) company since 2001, MiTek has a record of continuous growth and innovation. Learn more at www.mii.com.\n" +
                                "\n" +
                                "Overview\n" +
                                "\n" +
                                "As a senior software engineer in our Homebuilder division you will be responsible for supporting and enhancing a web-based ERP system (Kova) used widely by construction companies in both the US and Canada.  Kova’s workflow-based approach allows organizations to implement key business processes from customer management, purchase orders, to accounting on a single unified platform.  Coupled with other Homebuilder technology, Kova enables a focused customer engagement effort, using innovation to facilitate key workflows, solve core business challenges, and streamline company operations.",
                        "Provide technical leadership for all phases of the software development life cycle\n" +
                                "Lead, mentor, and coach junior developers\n" +
                                "Collaborate with teams responsible for requirements, development, and quality assurance to ensure solutions are efficient, consistent, and fulfill business needs\n" +
                                "Code, test, document, configure, and debug web solutions\n" +
                                "Help drive CI/CD and unit testing strategies\n" +
                                "Work in an Agile software development environment",
                        "Required\n" +
                                "\n" +
                                "Bachelor of Science degree in Computer Science or related field.  Equivalent work experience may be substituted for the degree requirement \n" +
                                "5+ years working with C# or other object-oriented, server-side language\n" +
                                "Experience developing RESTful web services (Web API, OData, SOAP, etc)\n" +
                                "Knowledge of client-side web frameworks (Angular, React, etc)\n" +
                                "Understanding of relational databases and SQL preferably Microsoft SQL Server\n" +
                                "Knowledge of Design Patterns\n" +
                                "Excellent problem-solving skills\n" +
                                "Proficient in using English at work\n" +
                                "Full-time with flexible work schedule. Occasional after-hours customer support as needed.\n" +
                                "Preferred\n" +
                                "\n" +
                                "Experience working in cloud environments, Azure or AWS\n" +
                                "Knowledge of API-First design\n" +
                                "Experience designing, developing, and integrating with Partner APIs\n" +
                                "Understanding of Git workflows for commercial software\n" +
                                "Experience with ORM frameworks (Entity Framework, Dapper, LINQ to SQL)\n" +
                                "Mobile development experience with Android and iOS",
                        "From Monday to Friday\n" +
                                "International Travel opportunities\n" +
                                "13th month and productivity bonus\n" +
                                "Free lunch, parking, uniforms\n" +
                                "Yearly company trip\n" +
                                "Healthcare insurance package\n" +
                                "24/24 Personal Accident insurance\n" +
                                "Free English training programs (Cambridge English Scale) at office\n" +
                                "Continuing development of technical and soft skills through working and formal training\n" +
                                "Trade Union & Staff Social Club - Sport clubs (Yoga, Zumba, Swimming, Badminton, Football, Gym,...)\n" +
                                "Good working conditions and environment",
                        "None",
                        4,
                        "From 5 years",
                        "Negotiate",
                        null,
                        new Date("08/07/2024"),
                        new Date("10/07/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(1),
                        // _LocationRepo.getOne(3),
                        _JobTypeRepo.getOne(3)));

                data.add(new Jobs(
                        14,
                        "Project Management Officer (PMO) – Position code NHS06 (quantity 06)",
                        null,
                        "Support Project Manager (PM) in implementing project implementation procedures, project planning, project management, project documentation and reporting.\n" +
                                "Perform project administrative tasks such as organizing and arranging meeting schedules, recording working minutes, monitoring progress, supervising; urging relevant parties to follow the consensus and instructions at meetings...\n" +
                                "Coordinate the workflow of assigned projects and software development plans according to the plan and implementation roadmap.\n" +
                                "Monitor the progress and workload of software development plans, urge relevant parties to complete work on time.\n" +
                                "Identify and control risks affecting project implementation.\n" +
                                "Perform summary reports on the implementation status of projects and software development plans.\n" +
                                "Perform other tasks as assigned."
                        , "Your skills & qualifications\n" +
                        "1. General standards:\n" +
                        "\n" +
                        "Be a Vietnamese citizen, have a permanent residence in Vietnam. Age not over 35 years old.\n" +
                        "Be in good health to undertake the job.\n" +
                        "Have good moral qualities, no criminal record; not being prosecuted for criminal liability, serving a prison sentence, suspended sentence, non-custodial reform, probation, being subject to local education measures, being treated for illness, drug addiction treatment, etc.\n" +
                        "2. Specific standards:\n" +
                        "\n" +
                        "2.1. Professional qualifications\n" +
                        "\n" +
                        "Graduate from university or higher, full-time (including university degree 2, not including university transfer) at domestic universities or graduate from university or higher at foreign universities, affiliated universities.\n" +
                        "Major: Requires graduation from the following majors: Information Technology, Economics, Finance, Banking or related majors.\n" +
                        "2.2 Foreign language:\n" +
                        "\n" +
                        "Candidates must have one of the following certificates: TOEIC 600/990, TOEFL PBT/IPT 500/677, TOEFL CBT 173/300, TOEFL iBT 61/120, IELTS 5.5/9.0, Cambridge Exam First (FCE), B2 European Framework, 4/6 6-level Foreign Language Proficiency Framework. Applicants are accepted to provide additional English certificates within 24 months from the date of recruitment.\n" +
                        "2.3. Knowledge, skills, experience:\n" +
                        "\n" +
                        "Experience: At least 03 years of experience in the fields of finance, banking, IT or participating in coordinating IT projects.\n" +
                        "Skills:\n" +
                        "Synthesize information, analyze information\n" +
                        "Work independently and in a team\n" +
                        "Plan and manage work.\n" +
                        "Have good logical thinking, the ability to grasp problems quickly; Good problem-solving skills;\n" +
                        "Proactive, able to work under high pressure;\n" +
                        "Ability to communicate and convey information.\n" +
                        "Priority criteria:\n" +
                        "Experience in coordinating and managing IT projects at commercial banks and financial institutions\n" +
                        "Understanding of software development processes.\n" +
                        "Professional project management certificate.\n" +
                        "Proficient in project management tools.",
                        "Competitive income, suitable for the candidate's capacity and practical experience.\n" +
                                "Bonus level will be based on BIDV's performance, actual working time of staff at BIDV and individual emulation ranking by quarter/6 months/1 year.\n" +
                                "BIDV reviews and evaluates staff capacity to propose salary upgrades: periodically 2 times/year.\n" +
                                "Insurance: health insurance, health insurance, retirement insurance... according to BIDV's policy.\n" +
                                "Unsecured loans, preferential loans for staff.\n" +
                                "Annual travel - vacation - Team building.\n" +
                                "Periodic health check-ups (basic and advanced packages) at leading hospitals in Hanoi.\n" +
                                "Funeral benefits, birthday money, annual uniform money.\n" +
                                "Fully participate in social insurance according to the law; health insurance, life insurance according to BIDV's welfare policy.\n" +
                                "Annual leave according to the State's regulations.\n" +
                                "Working time: Monday - Friday; overtime paid according to regulations"
                        ,"Round 1: Application screening\n" +
                        "Round 2: Interview (Business and English)",
                        6,
                        "From 5 years",
                        "Negotiable",
                        null,
                        new Date("08/07/2024"),
                        new Date("11/07/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(4),
                        // _LocationRepo.getOne(4),
                        _JobTypeRepo.getOne(1)));


                data.add(new Jobs(
                        15,
                        "Development of Mobile (iOS)",
                        null,
                        "Design and build applications for IOS platform using Swift or Objective C\\n\" +\n" +
                                "                                \"Participate in analyzing and designing new features\\n\" +\n" +
                                "                                \"Participate in the process of developing new ideas and applications for IOS\\n\" +\n" +
                                "                                \"Support and fix errors after deployment",
                        "University degree in Information Technology, Mathematics or equivalent.\\n\" +\n" +
                                "                                \"Under 35 years old\\n\" +\n" +
                                "                                \"Have knowledge or experience in mobile native programming on IOS platform with at least 01 year of experience, priority given to those with experience in Flutter\\n\" +\n" +
                                "                                \"Proficient in xCode programming tool, and source code management tool (Git)\\n\" +\n" +
                                "                                \"Mastery of UI/UX, layout, animation in IOS, ability to customize & optimize interface\\n\" +\n" +
                                "                                \"Experience in developing and integrating RESTful API, Web socket. Proficient in using system libraries, experienced in using SDK/3rd party libraries\\n\" +\n" +
                                "                                \"Proficient in building & pushing apps to AppStore\\n\" +\n" +
                                "                                \"Understanding of Agile/Scrum",
                        "Income from 200 - 300 million/year\n" +
                                "Work in a professional, stable environment\n" +
                                "Health care with Insurance package with benefits up to $8000\n" +
                                "Compensation regimes, lunch allowances, internal subscriptions\n" +
                                "Experience diverse teambuilding, cultural, tourism, spring travel, summer vacations at home and abroad...\n" +
                                "Regularly attend a variety of training courses to help employees continuously develop themselves, improve their skills and professional expertise",
                        "Round 1: 1 round interview",
                        2,
                        "From 1 year"
                        ,"Negotiate",
                        null,
                        new Date("08/07/2024"),
                        new Date("11/07/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(5),
                        // _LocationRepo.getOne(5),
                        _JobTypeRepo.getOne(1)));

                data.add(new Jobs(
                        16,
                        ".NET Developer",
                        null,
                        "Develop and maintain web applications using ASP.NET, .NET Core, and related technologies.\n" +
                                "Develop and maintain desktop applications using Windows Forms.\n" +
                                "Design and implement SQL Server databases, including writing and optimizing SQL queries.\n" +
                                "Participate in requirement analysis, software design, development, and testing processes.\n" +
                                "Collaborate closely with team members to ensure project quality and progress.\n" +
                                "Troubleshoot and resolve software issues, improve performance, and optimize code.\n" +
                                "Perform other tasks as requested by management.",
                        "At least 2-3 years of experience in application development with .NET Framework and .NET Core.\n" +
                                "Proficiency in developing web applications with ASP.NET, ASP.NET MVC, and .NET Core.\n" +
                                "Experience in developing desktop applications with Windows Forms.\n" +
                                "Skilled in working with SQL Server databases, including design, implementation, and query optimization.\n" +
                                "Knowledge of HTML, CSS, JavaScript, and front-end frameworks such as Angular, React, or Vue.js is a plus.\n" +
                                "Experience with tools like Visual Studio, Git, Azure DevOps, or other CI/CD tools.\n" +
                                "Strong teamwork, effective communication, and time management skills.\n" +
                                "Analytical thinking and quick problem-solving abilities.\n" +
                                "Eagerness to learn and stay updated with new technologies.\n" +
                                "Preference will be given to candidates who can communicate in English.",
                        "Working hours: Monday to Friday.\n" +
                                "Competitive salary with performance-based bonuses.\n" +
                                "13th-month salary and other performance bonuses, including project bonuses, business performance bonuses, and other individual and collective achievement bonuses.\n" +
                                "Participation in FPTCare insurance for both the employee and their family members, including periodic health check-ups.\n" +
                                "Opportunities to participate in short-term or long-term overseas projects.\n" +
                                "Dynamic and youthful working environment: Modern office, open and creative space, encouraging collaboration and idea exchange.\n" +
                                "Continuous development of both hard and soft skills through practical work experience and professional training courses.\n" +
                                "Access to the latest technology trends.\n" +
                                "Flexible working policy: Support for remote work and flexible working hours, helping employees balance work and life.\n" +
                                "Annual company trips/vacations.\n" +
                                "12 days of annual leave, 03 days of summer vacation, and holidays as per regulations.\n" +
                                "Annual salary review.\n" +
                                "Participation in exciting cultural activities and events of FPT IS and FPT Corporation."
                        ,
                        "Round 1: 1 round of Technical interview without test",
                        2,
                        "From 2 years"
                        ,"Negotiate",
                        null,
                        new Date("08/07/2024"),
                        new Date("11/07/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(6),
                        // _LocationRepo.getOne(6),
                        _JobTypeRepo.getOne(3)));

                data.add(new Jobs(
                        17,
                        "Software Quality Assurance (SQA)",
                        null,
                        "Create and execute manual test cases to validate software functionality.\n" +
                                "Collaborate with cross-functional teams to identify, prioritize, and report bugs and defects.\n" +
                                "Stay up-to-date with the latest testing methodologies and tools.\n" +
                                "Review requirements, specifications, and technical design documents to provide meaningful feedback.\n" +
                                "Participate in code reviews to ensure solutions are designed for testability and maintainability",
                        "Kỹ năng yêu cầu:\n" +
                                "\n" +
                                "Bachelor's degree in Computer Science or a related field.\n" +
                                "1-3 years of experience in software testing\n" +
                                "Strong analytical and problem-solving skills.\n" +
                                "Excellent written and verbal communication skills.\n" +
                                "Điểm cộng:\n" +
                                "\n" +
                                "Familiarity with agile software development methodologies\n" +
                                "Experience with crypto currency, web3 decentralized application or financial products (stocks, FOREX, etc.)\n" +
                                "Have basic knowledge of software development, database, automation script, etc.",
                        "Income: agreed (500-1500 USD), salary review after 6 months of official work.\n" +
                                "Work 40 hours/week (Monday - Friday: Morning 08:30 - 12:00; Afternoon: 13:00 - 17:30) Receive at least 13 months salary/year.\n" +
                                "Bonus 5 holidays, birthday bonus Quarterly bonus and profit sharing Annual travel, health discovery.\n" +
                                "Extremely dynamic, youthful working environment, rapid development, many opportunities.\n" +
                                "Regular training and skill development.\n" +
                                "Free parking, free daily Teabreak snacks.",
                        "Round 1: Face-to-face interview with Tech Lead\n" +
                                "Round 2: Salary Deal",
                        3,
                        "From 1 year",
                        "1500",
                        "500",
                        new Date("08/07/2024"),
                        new Date("11/07/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(7),
                        // _LocationRepo.getOne(7),
                        _JobTypeRepo.getOne(1)));

                data.add(new Jobs(
                        18,
                        "Mid MTS (Mobile Trading System) Developer - Android/iOS",
                        null,
                        "Develop Mobile Stock Trading app using JavaScript under the Kiwoom platform\n" +
                                "Work directly with remote team to clarify tasks and requirements\n" +
                                "Develop new features based on the user requirements (analyzing requirements and system design)\n" +
                                "Fix the reported problems/bugs of the system during the integration test, the user acceptance test, and the test for maintenance\n" +
                                "Managing time and resources based on the WBS\n" +
                                "Compile a weekly-report about the progress of tasks\n" +
                                "Perform self-learning about a domain knowledge, write a report and conduct a seminar about it\n" +
                                "Write high-quality, clean, elegant, maintainable, and testable code\n" +
                                "Maintaining technical documents up-to-date\n" +
                                "Mentor junior developers and conduct technical training when needed\n" +
                                "You will have the chance to be involved with each stage of different projects, to various aspects of software engineering and fostering your career growth.",
                        "Skills Required\n" +
                                "\n" +
                                "Minimum 2-3 years of professional experience in mobile app development using JavaScript or iOS/Android native.\n" +
                                "Experience and knowledge in markup language, including HTML, CSS is a must.\n" +
                                "Ability to write clean, easy to understand code.\n" +
                                "Solid understanding of the full mobile development life cycle\n" +
                                "Familiarity with version control systems, such as Git or SVN.\n" +
                                "Familiarity with issues tracking tools, such as Redmine.\n" +
                                "Strong problem-solving and analytical skills.\n" +
                                "Bachelor's Degree in Computer Science/Information Technology or relevant fields.\n" +
                                "Able to communicate in English, written and spoken (processed by English interview).\n" +
                                "Strong communication skills and teamwork, international experience is preferred.\n" +
                                "Experience operating in an Agile environment, with a deep understanding of agile development principles.\n" +
                                "Give Reference\n" +
                                "\n" +
                                "Over 1 year of experience in developing securities solutions, including a smartphone-based trading platform utilizing the Mobile Trading System (MTS)\n" +
                                "Proficient in utilizing the Mobile development Framework (Ionic, PhoneGap, React, Vue, Nexacro)\n" +
                                "Experience on working with oversea team.\n" +
                                "Mission\n" +
                                "\n" +
                                "Supporting IT Development and Maintenance of the Stock Trading Platform developed based on the Kiwoom Framework for Kiwoom Indonesia, Finansia (in Thailand), and so on\n" +
                                "SPECIAL OFFER\n" +
                                "\n" +
                                "Providing training and education experience in Korea with Korean Finance/IT expert \n" +
                                "Providing opportunitites to work and support in IT/Finance fields overseas",
                        "Competitive salary, salary review once a year\n" +
                                "13th month salary and Annual Performance Bonus\n" +
                                "MVP and Shining star awards at the end of year\n" +
                                "Global and professional working environment\n" +
                                "Full SHUI as Vietnamese Law\n" +
                                "Premium Private Medical Insurance PVI and annual health check\n" +
                                "15-day annual leave, Christmas leave and 30-mins menstrual leave for women\n" +
                                "Company trip, YEP and monthly gathering time\n" +
                                "Gifts on special occasion and fully stocked snack corner\n" +
                                "Sponsored training courses and book purchase quarterly\n" +
                                "Be well-equipped with new working equipment",
                        "Round 1: Interview with Tech Lead, CTO\n" +
                                "Round 2: Salary Negotiation",
                        2,
                        "From 2 years",
                        "2000",
                        "1000",
                        new Date("08/07/2024"),
                        new Date("11/07/2024"),
                        true,
                        1,
                        _CompanyRepo.getOne(8),
                        // _LocationRepo.getOne(8),
                        _JobTypeRepo.getOne(1)));

                // cái này c description riêng => nên kham khảo trên phone ròi đưa ra phương án thích hợp
                data.add(new Jobs(
                        19,
                        "SECURITY INCIDENT ANALYST (SOC ANALYST) - INFORMATION SECURITY CENTER",
                        null,
                        "\"Monitor and collect information on cyber security threats (Threat Intelligence), conduct analysis and warnings to relevant Units, propose prevention and mitigation plans for information security risks;\\n\" +\n" +
                                "                                \"Receive, analyze, investigate, and handle events, warn about risks/threats of cyber attacks, information security incidents; promptly warn relevant Units when detecting information security incidents related to information systems;\\n\" +\n" +
                                "                                \"Participate in responding to information security incidents, prevent and minimize impacts and damage to information systems when incidents arise; analyze incidents, propose preventive measures to avoid incidents from recurring;\\n\" +\n" +
                                "                                \"Coordinate with information security incident handling and response teams throughout the investigation and response process;\\n\" +\n" +
                                "                                \"Participate in drills on attacks, defenses, and response to information security incidents; develop processes and scenarios for monitoring and handling information security incidents.\",\n" +
                                " ",
                        "For staff level: Graduated from College/University majoring in Information Technology, Information Security;\\n\" +\n" +
                                "                                \"For specialist level: Graduated from University majoring in IT or related majors, with 2 years of experience.\\n\" +\n" +
                                "                                \"Proficient in Windows, Linux operating systems (Kali/Redhat/Ubuntu), able to use programming languages, scripts such as shell/powershell, python...\\n\" +\n" +
                                "                                \"Have knowledge and understanding of web attacks, server system attacks, Network, Cloud, IT infrastructure;\\n\" +\n" +
                                "                                \"Have the ability to analyze system logs, chain events, digital forensics, analyze malware, reverse engineering (RE), read and understand source code;\\n\" +\n" +
                                "                                \"Good use of support tools in the process of malware analysis, incident investigation and response such as: IDA, OllyDBG, Sysinternals Suite, ...\\n\" +\n" +
                                "                                \"Understand and use product portals in the SOC ecosystem proficiently (SIEM, SOAR, EDR, Email Security, WAF, ...)\\n\" +\n" +
                                "                                \"Have knowledge and understanding of security standards and frameworks: NIST, OWASP, MITRE ATT&CK Framework...;\\n\" +\n" +
                                "                                \"Having information security certificates such as: OSCP, CTIA, ECSA, ECIH, CHFI, GDAT, GWAPT,... is an advantage.",
                        "Trained & worked with foreign experts; expanded scope of work through digital projects; directly worked and advised the Bank's Board of Directors.\n" +
                                "Ensure competitive income in the labor market.\n" +
                                "Clear career advancement/development roadmap, planning to become a Manager after 2 years.\n" +
                                "Attractive welfare mechanism, including: preferential loans for employees, year-end bonuses based on individual & collective business performance, vacation regime, insurance, annual health check-ups...etc.\n" +
                                "Monday - Friday (depending on the project, assignment of the Board of Directors and Covid epidemic situation)"
                        ,null,
                        2,
                        "From 2 years",
                        "Negotiable",
                        null,
                        new Date("08/07/2024"),
                        new Date("11/07/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(9),
                        // _LocationRepo.getOne(9),
                        _JobTypeRepo.getOne(1)));
                // cái này c description riêng => nên kham khảo trên phone ròi đưa ra phương án thích hợp
                data.add(new Jobs(
                        20,
                        "Sr. AI Engineer - Remote/Hanoi/Saigon",
                        "Location\n" +
                                "\n" +
                                "Hanoi/Saigon, Vietnam\n" +
                                "Remote\n" +
                                "Salary Expectation\n" +
                                "\n" +
                                "Up to 5K USD. Pay above the market + stock options as long as you are really good.",
                        "We are a product startup in Silicon Valley looking for exceptional full-stack developers in Vietnam, who will own/build/deploy our AI-based product. You will be working and mentored by successful startup founders, who have built and sold companies in Silicon Valley and have experience working in top technology companies such as Amazon and Facebook. You will own the critical product features that have direct customer impacts. This position is NOT for someone who is looking for a steady and well-defined job but for someone who has an entrepreneurial mentality, who can embrace changes, fast execution speed, and are eager to learn/explore advanced technologies."
                        ,"Requirements\n" +
                        "\n" +
                        "More than 5 years of experience in the industry.\n" +
                        "Strong experience in building AI products serving real customers (e.g. data processing, finetuning models, building chatbot).\n" +
                        "Very good at English (verbal and written)\n" +
                        "Experience with AI Stack: Python/LLM (OpenAI, Claude)/Lang Chain/Jupyter Notebook.\n" +
                        "Preferences\n" +
                        "\n" +
                        "You are young and hungry. You love building kick-ass products so much that sometimes you forget that you are living on earth. You are willing to work really really hard regardless of time and get great reward for doing so.\n" +
                        "You have built and deployed 1 or 2 serious AI products.\n" +
                        "You have an entrepreneurial mentality. Always want to learn new things and explore new technology frontiers.\n" +
                        "Your friends found you boring because you are always talking about coding.\n" +
                        "You admit your mistakes and learn fast to not repeat the same ones."
                        ,"Stock options\n" +
                        "Work computer and equipments\n" +
                        "On-site business trips to company HQ in the US\n" +
                        "Health Insurance\n" +
                        "Unlimited time off"
                        ,"Round 1: Telephone screening\n" +
                        "Round 2: Technical Interviews",
                        2,
                        "From 5 years",
                        "Negotiable",
                        null,
                        new Date("08/07/2024"),
                        new Date("11/08/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(10),
                        // _LocationRepo.getOne(10),
                        _JobTypeRepo.getOne(1)));

                //  Jobs Upcoming
                // fresher
                data.add(new Jobs(
                        21,
                        "Graphic Designer ",
                        null
                        ,"\"- Design store listing images for games (icons, screenshots, banners).\\n\" +\n" +
                        "                                \"- Design publications for the company's marketing purposes.\\n\" +\n" +
                        "                                \"- Participate in the research and content creation process.\\n\" +\n" +
                        "                                \"- Research the market and competitors.\\n\" +\n" +
                        "                                \"- Coordinate with the Marketing team to optimize content performance/efficiency.\\u200B\\u200B\\u200B\\u200B\\u200B\\u200B\\u200B\",\n" +
                        "                        ",
                        "- 6 months of experience in a similar position\n" +
                                "- Priority is given to graduates from graphic design schools: Industrial Fine Arts, Architecture, FPT University, Arena Multimedia, FPT Arena, Monster Lab.\n" +
                                "- Have knowledge and skills in layout, color, lighting.\n" +
                                "- Proficient in Photoshop, Illustrator.\n" +
                                "- Attach Portfolio/Product Link when applying (having related products is an advantage).\n" +
                                "- Priority: Able to use 3D",
                        "INCOME\n" +
                                "- Salary: Up to 18M\n" +
                                "- Receive 100% of fixed salary, salary increase according to company regulations\n" +
                                "- Lunch allowance for official employees: 1,000,000 VND/month\n" +
                                "- Income based on work results and performance\n" +
                                "\n" +
                                "DEVELOPMENT OPPORTUNITIES\n" +
                                "- Expand and improve professional knowledge and skills\n" +
                                "- Experience in real-life projects in progress\n" +
                                "- Have a clearly personalized career development roadmap\n" +
                                "\n" +
                                "WORKING ENVIRONMENT\n" +
                                "- Experience a dynamic and professional international environment\n" +
                                "- Enjoy 100% of daily life care benefits\n" +
                                "\n" +
                                "WELFARE POLICY\n" +
                                "- The company fully pays all types of insurance according to the law (social insurance, health insurance, unemployment insurance, etc.)\n" +
                                "- Get free periodic general health check-ups at the hospital: Hong Ngoc, Thu Cuc, Vinmec.\n" +
                                "- Wedding/funeral regime, holiday/Tet gifts and other welfare regimes.\n" +
                                "- Bonus for New Year, March 8, April 30-May 1, Mid-Autumn Festival, Mid-year, September 2, October 20, Christmas.\n" +
                                "- Continuous sharing of achievements, unlimited based on performance.\n" +
                                "- Administrative working hours:\n" +
                                "\n" +
                                "From Monday to Friday. Closed on Saturday and Sunday\n" +
                                "Morning: 8:30 - 12:00, Afternoon: 13:00 - 18:00, Mid-afternoon break 15:00 - 15:30"
                        ,"None",
                        3,
                        "less than 1 year experience",
                        "900",
                        "500",
                        new Date("09/07/2024"),
                        //month/day/year
                        new Date("12/07/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(2),
                        // _LocationRepo.getOne(1),
                        _JobTypeRepo.getOne(1)));

                data.add(new Jobs(
                        22,
                        "Fullstack Developer (Node JS/ React JS) up to $3000",
                        "ShopStack is a technology company with offices in Vietnam and Thailand.  We assist companies across Southeast Asia with achieving their technology goals.  We are a team of technology experts, developers, and architects. problem solvers, designers, and managers working together to solve technology problems. \n" +
                                "\n" +
                                "We work on exciting projects, have cool brands and have great clients. We are ambitious, hardworking, passionate, sincere, and striving to be the best.  We are committed to our staff and each other, building a great work environment, and culture, and creating opportunities for everyone to grow, develop, lead, and advance themselves. We have fun, we work hard, and best of all offer great benefits.  \n" +
                                "\n" +
                                "We are looking for a Fullstack Developer (Node Js/ React JS) to join our growing team.  We offer great salaries, great people, and opportunities for advancement. We are looking for people with passion, willingness to work hard, and be leaders.",
                        "Develop innovative user-facing features with React.js.\n" +
                                "Create new API functionalities utilizing Node.js.\n" +
                                "Work across web and mobile platforms, ensuring versatility and adaptability.\n" +
                                "Construct and maintain reusable components for scalability.\n" +
                                "Convert designs and wireframes into high-quality code.\n" +
                                "Enhance component performance for an optimal user experience.\n" +
                                "Exhibit initiative by proactively addressing issues and seeking solutions.",
                        "Solid experience: Must have at least 2 years with Backend End Development \n" +
                                "Solid experience with NodeJS\n" +
                                "Experience with designing application structures and architectures\n" +
                                "Familiarity with AWS\n" +
                                "As part of our job scope, English is a must and we welcome a candidate who can conduct conference calls with PMs and Clients without any support from other team members.\n" +
                                "React JS experience is a plus \n" +
                                "E-commerce experience is a plus.",
                        "Salary: Up To 3000 USD Per Month\n" +
                                "Excellent and competitive salary packages\n" +
                                "Excellent healthcare\n" +
                                "Professional, dynamic working environment\n" +
                                "Guaranteed permanent employment and career development.\n" +
                                "Flexible working hours with 40 hours per week (Monday - Friday)\n" +
                                "13-month salary bonus\n" +
                                "13 paid leave days per year\n" +
                                "Free Swimming Ticket at Hapulico Swimming Pool\n" +
                                "Annual company trip",
                        "None",
                        4,
                        "From 2 years",
                        "3.000 USD",
                        "1.000 USD",
                        new Date("09/07/2024"),
                        new Date("12/07/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(3),
                        // _LocationRepo.getOne(2),
                        _JobTypeRepo.getOne(2)));
                //senior
                data.add(new Jobs(
                        23,
                        "Senior Software Engineer (English required)",
                        "Years of experience: Min 4 years \n" +
                                "Education and qualifications: Bachelor of Engineering (Computer, Software, Electronics or Communications) or Computer Science degree.",
                        "1. Develop and deliver cloud applications\n" +
                                "\n" +
                                "Design, develop, and deploy cloud-based applications using modern development frameworks and tools.\n" +
                                "Write clean, maintainable, and efficient code following best practices and coding standards. \n" +
                                "Ensure cloud applications are designed for scalability, high availability, and optimal performance.\n" +
                                "Implement monitoring and alerting systems to proactively manage application performance and health.\n" +
                                "2. Refactor and improve existing solutions\n" +
                                "\n" +
                                "Conduct thorough code reviews to identify areas of improvement in existing solutions.\n" +
                                "Analyse current codebase for inefficiencies, bugs, and potential performance bottlenecks.\n" +
                                "Implement changes to optimize existing code for better performance, scalability, and maintainability.\n" +
                                "Enhance the functionality of existing solutions by incorporating new features and technologies.\n" +
                                "Apply best practices in refactoring, ensuring code quality and consistency.\n" +
                                "Utilize automated testing and continuous integration tools to validate refactored code.",
                        "English Proficiency: Solid written and spoken English skills are paramount.\n" +
                                "Customer Interaction: Ability to work with English-speaking customers from Australia and Eastern Europe.\n" +
                                "Advanced knowledge of C# and .NET/.NET Core frameworks.\n" +
                                "Development and delivery of RESTful and GraphQL APIs.\n" +
                                "Proficiency in HTML, CSS, JavaScript, and modern frameworks (e.g., React, Angular, Vue). \n" +
                                "Expertise in profiling and optimizing application performance.\n" +
                                "AWS Expertise: Proficiency in AWS technologies, including EC2, RDS, S3, and Elastic Load Balancing.\n" +
                                "Real-time Trading Platforms: Experience in supporting real-time trading platforms running on highly optimized servers.\n" +
                                "PostgreSQL Expertise: Solid experience with PostgreSQL, preferably with exposure to AWS RDS and serverless Aurora.\n" +
                                "CI/CD: Proficiency in Continuous Integration and Continuous Deployment methodologies and tools.\n" +
                                "Team Collaboration: Ability to work closely with cross-functional teams and stakeholders.\n" +
                                "Problem Solving: Strong troubleshooting and analytical skills.\n" +
                                "[Preferred] RUST commercial/business programming experience. " +
                                "Preferred Qualifications\n" +
                                "\n" +
                                "AWS Certification.\n" +
                                "Previous experience in the financial and real-time trading industry.",
                        "Round 1: Technical Interview (Skills & Qualifications Test)\n" +
                                "Round 2: Culture Fit Interview",
                        "None",
                        2,
                        "From 4 years",
                        "1.500 ",
                        "2000",
                        new Date("09/07/2024"),
                        new Date("12/07/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(1),
                        // _LocationRepo.getOne(3),
                        _JobTypeRepo.getOne(3)));

                data.add(new Jobs(
                        24,
                        "Data Administration Specialist (DG) – Position code QTDL01 (quantity 02)",
                        null,
                        "Data Governance:\n" +
                                "Coordinate the development and management of regulations, processes, and standards on data governance across the entire organization.\n" +
                                "Monitor, coordinate, and synthesize documents on metadata management and data quality management in data governance across the entire organization according to the assigned scope and data topics.\n" +
                                "Provide data governance consulting and support to stakeholders, provide advice on directions, standards, tools, and initiatives on Data Governance.\n" +
                                "Monitor and measure data governance performance (by scope and data topics): develop data governance criteria and reports, build and monitor data governance dashboards.\n" +
                                "Handle data issues according to scope and data topics.\n" +
                                "Administer and operate data governance tools.\n" +
                                "Participate in data privacy management:\n" +
                                "Develop policies, regulations, and data protection procedures such as data encryption, data masking, data classification, and data loss prevention.\n" +
                                "Monitor, coordinate, and implement data protection, data classification, labeling, and data loss prevention activities; support units in the process of implementing data protection, data classification, and labeling procedures.\n" +
                                "Monitor, summarize violations in data loss prevention, investigate, and handle violations.\n" +
                                "Participate in operational management of data classification, data labeling, and data loss prevention tools."
                        , "1. General standards:\n" +
                        "\n" +
                        "Be a Vietnamese citizen, have a permanent residence in Vietnam. Age not over 35 years old.\n" +
                        "\n" +
                        "Be in good health to undertake the job.\n" +
                        "\n" +
                        "Have good moral qualities, no criminal record; not being prosecuted for criminal liability, serving a prison sentence, suspended sentence, non-custodial reform, probation, being subject to local education measures, being treated for illness, drug addiction treatment, etc.\n" +
                        "\n" +
                        "2. Specific standards:\n" +
                        "\n" +
                        "2.1. Professional qualifications\n" +
                        "\n" +
                        "Graduate from university or higher, full-time (including university degree 2, not including university transfer) at domestic universities or graduate from university or higher at foreign universities, affiliated universities.\n" +
                        "\n" +
                        "Major: Requires graduation from the following majors: Economics, Business, Finance, Banking, Insurance, Administration - Management, Statistics or other suitable majors.\n" +
                        "\n" +
                        "2.2. Foreign language:\n" +
                        "\n" +
                        "Candidates must have one of the following certificates: TOEIC 600/990, TOEFL PBT/IPT 500/677, TOEFL CBT 173/300, TOEFL iBT 61/120, IELTS 5.5/9.0, Cambridge Exam First (FCE), B2 European Framework, 4/6 6-level Foreign Language Proficiency Framework. Applicants are accepted to provide additional English certificates within 24 months from the date of recruitment.\n" +
                        "2.3. Knowledge, skills, experience:\n" +
                        "\n" +
                        "Have at least 01 year of experience working in the fields of: Data Administration; Data quality management; Managing information systems in banking, finance, securities, insurance, etc.\n" +
                        "Have knowledge and experience in building, managing data quality, data standards (master data, metadata, data profiling...) of data domains in the banking sector such as customer data, products, finance...\n" +
                        "Have knowledge and experience in information security policies or data security, personal data protection.\n" +
                        "Proficient in using at least 01 data management/data quality tool.\n" +
                        "Have knowledge and skills in database design and querying such as SQL, Oracle...\n" +
                        "Priority is given to those with certificates related to Data Governance, Data Quality, Data Management, Data Protection/Privacy.\n" +
                        "Priority is given to those with experience participating in and implementing data-related projects.",
                        "13th month salary (Average 4-5 months of basic salary)\n" +
                                "Enjoy salary, bonus and incentive mechanisms according to agreement and regulations of Vietnam Joint Stock Commercial Bank for Investment and Development.\n" +
                                "Get additional income based on work results, job position and regulations of BIDV.\n" +
                                "Salary review twice a year\n" +
                                "Working equipment provided\n" +
                                "Annual travel - Vacation - Team building\n" +
                                "Regular health check-up\n" +
                                "Welcome benefits, birthday money\n" +
                                "Full participation in insurance according to regulations\n" +
                                "Annual leave according to regulations of the State\n" +
                                "Working time: Monday - Friday from 08:00 to 17:00"
                        ,"None",
                        2,
                        "From 1 year",
                        "Negotiable",
                        null,
                        new Date("09/07/2024"),
                        new Date("12/07/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(4),
                        // _LocationRepo.getOne(4),
                        _JobTypeRepo.getOne(1)));


                data.add(new Jobs(
                        25,
                        "Development of PHP",
                        null,
                        "Participate in developing the company's projects\n" +
                                "Design and build the system using PHP language with laravel framework\n" +
                                "Build interfaces with vue, react, bootstrap, ...\n" +
                                "Research and use new technology to support project development\n" +
                                "Actively contribute experiences, ideas and best solutions for the project\n" +
                                "Support, fix errors, optimize the system after deployment",
                        "University degree or higher, formal training system, major in Information Technology/Mathematics-Informatics or other related majors\n" +
                                "Under 35 years old\n" +
                                "At least 1 year of programming experience with PHP language\n" +
                                "Proficient in programming with PHP language\n" +
                                "Mastery of OOP programming, MVC model, design pattern\n" +
                                "Experience programming with frameworks: Laravel, symfony...\n" +
                                "Good knowledge of HTML/CSS, Javascript, Typescript, jquery\n" +
                                "Mastery of Databases such as: MySQL, MariaDB...\n" +
                                "Experience working with Vue, React\n" +
                                "Experience deploying systems using Docker, Linux is an advantage.",
                        "Income from 200 - 300 million/year\n" +
                                "Work in a professional, stable environment\n" +
                                "Health care with Insurance package with benefits up to $8000\n" +
                                "Compensation regimes, lunch allowances, internal subscriptions\n" +
                                "Experience diverse teambuilding, cultural, tourism, spring travel, summer vacations at home and abroad...\n" +
                                "Regularly attend a variety of training courses to help employees continuously develop themselves, improve their skills and professional expertise",
                        "Round 1: 1 round interview",
                        2,
                        "From 1 year"
                        ,"Negotiate",
                        null,
                        new Date("09/07/2024"),
                        new Date("12/07/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(5),
                        // _LocationRepo.getOne(5),
                        _JobTypeRepo.getOne(1)));

                data.add(new Jobs(
                        26,
                        "Full-stack (NodeJs, ReactJs, .Net, Mobile)",
                        "We're currently looking for talented individuals skilled in various technologies: Full-stack (NodeJs, ReactJs, .Net, Mobile)\n" +
                                "\n" +
                                "Join our team to work on international projects and contribute to our global outreach and innovation efforts.",
                        "As a Software Engineer (Full-stack), you will create impact by:\n" +
                                "\n" +
                                "Developing and implementing software applications based on specifications\n" +
                                "Writing functional, clean, scalable code, and code refactoring good practice\n" +
                                "Creating and testing of software prototypes\n" +
                                "Analyzing and troubleshooting any issues by developing scripts and database queries\n" +
                                "Collaborating with the deployment team on continuous integration\n" +
                                "Supporting the operations team for potential post-implementation issues\n" +
                                "Participating in scrum meetings, providing necessary feedback\n" +
                                "Contributing to the entire phase of the development lifecycle",
                        "Experience: Full-stack (NodeJs, ReactJs, .Net, Mobile)\n" +
                                "\n" +
                                "General Expectations of a Software Engineer: \n" +
                                "\n" +
                                "Good knowledge of problem-solving, algorithms, and data structures\n" +
                                "Knowledge of data and network, relevant securities, and best practices\n" +
                                "Knowledge of CI/CD and automated software testing methodologies\n" +
                                "Good knowledge of AWS / Azure cloud services (having certifications will be an advantage)\n" +
                                "Able to contribute effectively in a fast-paced, deadline-driven, and agile environment\n" +
                                "Good English communication is an advantage\n" +
                                "Good knowledge of the following frameworks one of stacks: NodeJs, ReactJs, .Net, Mobile.\n" +
                                "At least 1 year of experience.",
                        "Working time: 9.00 am to 6.00 pm, Monday to Friday\n" +
                                "Hybrid mode, no need to come to the office everyday. In Hanoi, Danang: remote\n" +
                                "Company trip / Year-end party / Quarterly team building / Weekly happy hour\n" +
                                "Competitive Net salary (The company is responsible for paying taxes, insurance)\n" +
                                "Nice and friendly working environment. Kind bosses\n" +
                                "MacBook Pro + 24\" monitor provided\n" +
                                "Annual health-check\n" +
                                "Premium health insurance\n" +
                                "13th month bonus\n" +
                                "Free snacks and juice. No worries if you feel hungry or thirsty"
                        ,
                        "None",
                        2,
                        "From 1 year"
                        ,"Negotiate",
                        null,
                        new Date("09/07/2024"),
                        new Date("12/07/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(6),
                        // _LocationRepo.getOne(6),
                        _JobTypeRepo.getOne(3)));

                data.add(new Jobs(
                        27,
                        "Senior Software QA Automation Engineer",
                        "The Senior Software QA Automation Engineer will be responsible for ensuring the quality and reliability of our software products through the development and execution of automated test scripts. \n" +
                                "This role involves working closely with development and QA teams to create a seamless and efficient testing process \n" +
                                "The successful candidate will bring a high level of expertise in automation testing to drive improvements in our QA practices and mentor junior team members.",
                        "Design, develop, and maintain automated test scripts using Selenium and Java.\n" +
                                "Create and execute automated regression tests, functional tests, and performance tests.\n" +
                                "Collaborate with development and QA teams to identify and prioritize test cases for automation.\n" +
                                "Integrate automated tests into the CI/CD pipeline to ensure continuous testing and delivery.\n" +
                                "Analyze test results, identify issues, and work with development teams to resolve defects.\n" +
                                "Mentor and guide junior QA engineers in automation best practices and strategies.\n" +
                                "Participate in code reviews and provide constructive feedback to ensure high-quality code standards.\n" +
                                "Continuously improve and update testing frameworks and tools to enhance testing efficiency.\n" +
                                "Stay up-to-date with industry best practices and emerging technologies in QA automation.\n" +
                                "Assign tasks for junior team members"
                        , "Skills \n" +
                        "\n" +
                        "Proficiency in Selenium and Java Core.\n" +
                        "Hands-on experience with CI/CD tools such as Jenkins, GitLab CI, or similar.\n" +
                        "Strong understanding of software development lifecycle (SDLC) and QA methodologies.\n" +
                        "Good problem-solving skills and attention to detail.\n" +
                        "Strong communication and teamwork skills.\n" +
                        "Ability to mentor and guide junior team members.\n" +
                        "Knowledge of additional testing frameworks and tools is an advantage.\n" +
                        "Fluency in English\n" +
                        "Leadership experience, including leading or managing a team of testers is a plus.\n" +
                        "Qualifications:\n" +
                        "\n" +
                        "Bachelor’s degree in computer science, Engineering, or a related field.\n" +
                        "Proven experience as a QA Automation Engineer, with at least 4 years in automation testing.\n" +
                        "Extensive experience with Selenium, Java Core and API testing.\n" +
                        "Demonstrated experience with CI/CD processes and tools.\n" +
                        "Solid understanding of QA methodologies, testing types, and testing tools.\n" +
                        "Certification in QA or related fields is a plus.\n" +
                        "Good time-management skill, able to multi-task and pay attention to details as well as a fast learner",
                        "Competitive Salary\n" +
                                "13th Month Salary & Performance Bonus\n" +
                                "Employee of the Year Award\n" +
                                "In-house & Overseas Training\n" +
                                "Full reimbursement for international Technical Certification\n" +
                                "Global career opportunity\n" +
                                "Vacation Leave: 12 days per year\n" +
                                "Medical Leave: 8 days per year\n" +
                                "1 extra seniority day for every 3 years of service\n" +
                                "Annual Routine Check-up\n" +
                                "Premium healthcare insurance\n" +
                                "Comprehensive Insurance\n" +
                                "Annual company trip for team building\n" +
                                "Soccer & Badminton Club and Sports activities\n" +
                                "Entertainment activities: Music band, Karaoke & Play-station time\n" +
                                "Celebrations special events: Birthdays, Christmas, New Year/Year-end Party.\n" +
                                "Fruit days twice a month. Unlimited snacks & beverages\n" +
                                "Unlimited snacks & beverages",
                        "Round 1: Technical Interview\n" +
                                "Round 2: Culture Fit Interview",
                        6,
                        "From 4 years",
                        "2300",
                        "1000",
                        new Date("09/07/2024"),
                        new Date("12/07/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(7),
                        // _LocationRepo.getOne(7),
                        _JobTypeRepo.getOne(1)));

                data.add(new Jobs(
                        28,
                        "Senior Android Developer (Kotlin)",
                        "Why join us?\n" +
                                "\n" +
                                "Hybrid working mode\n" +
                                "Be part of a transformational journey that's redefining the banking landscape, driving innovation that impacts millions of users’ financial well-being.\n" +
                                "Work in a vibrant, inclusive, and diverse environment that values your unique perspective.\n" +
                                "Collaborate with top-tier professionals, learning and growing alongside the best in the industry.\n" +
                                "Competitive compensation package, including benefits that support your well-being and professional development.\n" +
                                "Position: Senior Android Developer (Kotlin)\n" +
                                "\n" +
                                "Number of hiring: 3",
                        "We are seeking a skilled and passionate Android Developer (Kotlin) to join our dynamic development team. As an Android Developer, you will be responsible for designing, developing, and maintaining high-quality mobile applications for the Android platform. You will collaborate with cross-functional teams to deliver innovative and user-friendly mobile solutions that meet our clients' needs. The ideal candidate has a strong technical background, a creative mindset, and a passion for mobile application development.\n" +
                                "\n" +
                                "What will you do?\n" +
                                "\n" +
                                "Collaborate with product managers, designers, and other developers to define project requirements and develop innovative mobile applications for the Android platform.\n" +
                                "Design and implement efficient, reusable, and reliable code following best practices and coding standards.\n" +
                                "Conduct thorough testing and debugging of applications to ensure optimal performance and user experience.\n" +
                                "Continuously research and evaluate new technologies, frameworks, and libraries to enhance the development process and improve application performance.\n" +
                                "Collaborate with the backend development team to integrate mobile applications with server-side systems.\n" +
                                "Optimize application performance, responsiveness, and battery usage.\n" +
                                "Participate in code reviews to maintain code quality and ensure adherence to coding standards.\n" +
                                "Stay up to date with the latest industry trends and best practices in mobile application development.\n" +
                                "Provide technical guidance and support to junior developers when needed.\n" +
                                "Document the development process, technical specifications, and troubleshooting steps.",
                        "What we expect from you:\n" +
                                "\n" +
                                "1. Technical Background:\n" +
                                "\n" +
                                "Bachelor's degree in computer science, Software Engineering, or a related field\n" +
                                "Proven experience as an Android Developer at least 5 years, with a strong portfolio of mobile applications developed and deployed on the Google Play Store.\n" +
                                "Proficient in Kotlin programming languages.\n" +
                                "Strong experience in mobile application architecture (MVVM preferred)\n" +
                                "Hands on experience in Unit Test\n" +
                                "Solid understanding of the Android SDK, Android Studio, and related development tools.\n" +
                                "Experience working with RESTful APIs, JSON, and web services integration.\n" +
                                "Knowledge of the full mobile development life cycle, including design, development, testing, and deployment.\n" +
                                "2. Soft skills:\n" +
                                "\n" +
                                "Very good communication in English with ability to explain technical problem in a logical and structural way.\n" +
                                "Excellent communication and interpersonal skills, with the ability to effectively communicate technical concepts to both technical and non-technical stakeholders.\n" +
                                "Strong problem-solving skills and ability to work effectively in a fast-paced, collaborative environment.\n" +
                                "Self-motivated and eager to learn new technologies and frameworks.\n" +
                                "3. Preferred Qualifications:\n" +
                                "\n" +
                                "Familiarity with Agile/Scrum development methodologies.\n" +
                                "Knowledge of UI/UX principles and best practices for mobile application design.\n" +
                                "Experience with performance profiling and optimization techniques.\n" +
                                "Published open-source contributions or personal projects related to mobile application development.\n" +
                                "Prefer banking domain experience\n" +
                                "*** We appreciate your interest and application to HCLTech Vietnam; however, due to large number of profiles, only suitable resumes will be contacted by HCL's recruiter within 15 days ***",
                        "Attractive package including base salary + 13th month salary + Performance Bonus\n" +
                                "Insurance based on full base salary\n" +
                                "Medical Benefit (Bao Viet Insurance Package) for Employee and Family\n" +
                                "100% of full salary and benefits as an official employee from the 1st day of working\n" +
                                "100% salary during probation time\n" +
                                "Working in a fast paced, flexible, and multinational working environment with opportunity to travel onsite (in 60 countries)\n" +
                                "Internal Training (Technical & Functional & English)\n" +
                                "Working with outstanding colleagues coming from top universities and top companies in Vietnam and foreign countries\n" +
                                "Friendly environment with flexible working hours, hybrid mode",
                        "None",
                        2,
                        "From 5 years",
                        "Negotiable",
                        null,
                        new Date("09/07/2024"),
                        new Date("12/07/2024"),
                        true,
                        1,
                        _CompanyRepo.getOne(8),
                        // _LocationRepo.getOne(8),
                        _JobTypeRepo.getOne(1)));

                // cái này c description riêng => nên kham khảo trên phone ròi đưa ra phương án thích hợp
                data.add(new Jobs(
                        29,
                        "DATA STEWARD",
                        "Position Overview: \n" +
                                "\n" +
                                "The Data Steward is pivotal in our Data Management team. He or she is responsible for ensuring that master data is understood, used, and shared effectively and meets the highest quality and integrity standards. This position operates cross-domain, overseeing dependencies and collaborating closely with various stakeholders to solve data issues and improve data quality. It is a key player in our data management strategy.\n" +
                                "\n" +
                                "He or she will also need to support orchestrating global and regional programs in the Operating Companies.",
                        "Responsibility Summary:\n" +
                                "\n" +
                                "Ensure integrity of high-quality data in the OpCo in order to drive accurate analysis, business insights and data-driven decision making; ensure data is understood, used and shared effectively.\n" +
                                "Supports the Data Owner and SME with executing all tasks needed for realization, documentation, maintenance and continuous improvement of the data assets.\n" +
                                "The first point of contact when there is a data quality issue and support resolutions by involving the right individuals (SMEs) and the Data Owner where required.\n" +
                                "Responsible for identifying the data assets needed to meet business objective.\n" +
                                "\n" +
                                "Collaborate with Data Requestors, Owners, and Global Data Services to solve data issues.\n" +
                                "Review metrics and initiate actions to improve data quality.\n" +
                                "Conduct root cause analysis for data-related issues and impact analysis.\n" +
                                "Implement and maintain Data Standards, Governance, processes, and documentation.\n" +
                                "Conduct regular Data Quality Assessments.\n" +
                                "Advocate for the effective application and usage of Master Data.\n" +
                                "Identify opportunities for improvement and actively champion data management projects and initiatives.\n" +
                                "Collaborate and support Regional and Operating Companies' projects (D&T, Analytics, Functions).\n",
                        "Education & Experience:\n" +
                                "\n" +
                                "High school diploma or equivalent; further data management or IT education.\n" +
                                "Experience in data management (3+ years) and familiarity with Service Request tools (e.g., Nextgen, ServiceNow).\n" +
                                "Proficient in MS Office and fluent in English.\n" +
                                "Knowledge of ERP systems like SAP or JDE is required.\n" +
                                "Understanding the FMCG industry and business domains such as Commerce, Supply Chain, and Finance is beneficial.\n" +
                                "Profile:\n" +
                                "\n" +
                                "Strong commitment to Data Quality and Management.\n" +
                                "Solid understanding of data structures, data flows, and data processes.\n" +
                                "Proven ability to establish credibility and build relationships across business and IT functions.\n" +
                                "Demonstrated ability to engage stakeholders and drive participation in data management projects.\n" +
                                "Track record of achieving goals and delivering on objectives.\n" +
                                "Strict adherence to data governance policies and procedures.\n" +
                                "Analytical, detail-oriented, communicates well, takes initiative, and solves problems effectively.\n" +
                                "Agile Mindset:\n" +
                                "\n" +
                                "Embrace customer value, team empowerment, swift action, and continuous learning principles.\n" +
                                "Display self-reflection, adaptability, collaboration, and resilience.\n" +
                                "Drive personal and team development through awareness of strengths and weaknesses.\n" +
                                "Language: Excellent written and verbal English\n" +
                                "\n" +
                                "Functional Competencies:\n" +
                                "\n" +
                                "Master Data Management: Skilled in maintaining accurate Master Data records.\n" +
                                "Data Accuracy: Ensures precise data capture and validation.\n" +
                                "MDM Platform Skills: Proficient in handling data requests on MDM platforms.\n" +
                                "Collaboration: Works effectively with stakeholders for data verification.\n" +
                                "Quality Control: Monitors and audits data to rectify discrepancies.\n" +
                                "Process Improvement: Contributes to refining data management workflows.\n" +
                                "Compliance: Adheres to data governance, security, and privacy standards."
                        ,"Competitive Salary: Negotiated based on individual capabilities.\n" +
                        "Performance bonuses and a 13th-month salary bonus.\n" +
                        "Bao Viet insurance for employees and their dependents (spouse/children).\n" +
                        "18 days of annual leave.\n" +
                        "80% of lunch costs covered at the company canteen.\n" +
                        "Holiday gifts and sponsorship for travel expenses to return home for Tet.\n" +
                        "Working hours: Monday to Friday (Morning 8:00 AM - 12:00 PM, Afternoon 1:00 PM - 5:00 PM)\n" +
                        "Hybrid working model."
                        ,"Round 1: Screening by phone -> 1st interview with LM: Overview\n" +
                        "Round 2: 2nd interview with LM: Case study\n" +
                        "Round 3: Final interview with D&T Director & People Business Partner",
                        3,
                        "From 2 years",
                        "Negotiable",
                        null,
                        new Date("09/07/2024"),
                        new Date("12/07/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(9),
                        // _LocationRepo.getOne(9),
                        _JobTypeRepo.getOne(1)));
                // cái này c description riêng => nên kham khảo trên phone ròi đưa ra phương án thích hợp
                data.add(new Jobs(
                        30,
                        "AI Engineer",
                        null,
                        "Your role & responsibilities\n" +
                                "Research and develop text-to-design & text-to-image AI product\n" +
                                "Develop and maintain generative AI products\n" +
                                "Analyze business requirements and propose AI technology\n" +
                                "Develop models / PoC and verify the solution\n" +
                                "Design, plan, and execute tasks related to the project"
                        ,"Required skills\n" +
                        "\n" +
                        "At least 2 years of experience with AI development\n" +
                        "Experience with Generative AI, NLP\n" +
                        "Experience with LLM and prompt engineering\n" +
                        "Ability to build web demos / PoC\n" +
                        "Good knowledge of Statistics and Analytics\n" +
                        "Good self-research, problem-solving, and presentation skills\n" +
                        "Commit to high-quality work results\n" +
                        "Interests in a production environment\n" +
                        "Nice-to-have\n" +
                        "\n" +
                        "Experience with LLM services\n" +
                        "Experience with Amazon Web Services\n" +
                        "Experience with production environment\n" +
                        "Experience with cost management and optimization\n" +
                        "Experience with SOTA architectures in generative AI\n" +
                        "Experience with performance profiling and optimization\n" +
                        "Experience with system design and implementation using emerging technology\n" +
                        "Willing to take part in different positions during the product’s life cycle (AI Engineer, Cloud Engineer, Product Development, Cost Management, etc.)\n" +
                        "Education Level\n" +
                        "\n" +
                        "Bachelor's / Engineer's Degree"
                        ,"Yearly bonus\n" +
                        "Yearly company trip\n" +
                        "Monthly team building events\n" +
                        "Monthly internal technical seminar (Osaka - Hanoi - Da Nang)\n" +
                        "Work-from-home on Wednesday\n" +
                        "Social insurance based on full income\n" +
                        "iMac and smart desk\n" +
                        "For Osaka Office positions: House rental support ; Commuting expenses support ; Japanese class"
                        ,"Round 1: Interview with team leader\n" +
                        "Round 2: Interview with CTO\n" +
                        "Round 3: Interview with Director",
                        2,
                        "From 1 year",
                        "2000",
                        "5000",
                        new Date("09/07/2024"),
                        new Date("12/08/2024"),
                        true,
                        0,
                        _CompanyRepo.getOne(10),
                        // _LocationRepo.getOne(10),
                        _JobTypeRepo.getOne(1)));
                return data;
        }

}
