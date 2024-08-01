package com.company.phtv.Services;

import com.company.phtv.Models.DTO.ChartForEmployer;
import com.company.phtv.Models.DTO.CompanyDTO;
import com.company.phtv.Models.DTO.JobDTO;
import com.company.phtv.Models.DTO.LocationDTO;
import com.company.phtv.Models.DTO.SkillDTO;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.Application;
import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Models.Entity.FollowCompany;
import com.company.phtv.Models.Entity.FollowJob;
import com.company.phtv.Models.Entity.Jobs;
import com.company.phtv.Models.Entity.Location;
import com.company.phtv.Models.Entity.SkillCompany;
import com.company.phtv.Models.Entity.SubcriptionPlanCompany;
import com.company.phtv.Models.Entity.ViewedJob;
import com.company.phtv.Models.Map.CompanyMapping;
import com.company.phtv.Models.Map.JobMapping;
import com.company.phtv.Models.Map.LocationMapping;
import com.company.phtv.Models.Map.SkillMapping;
import com.company.phtv.Models.Request.RequestCompany;
import com.company.phtv.Models.Request.RequestFilterCompany;
import com.company.phtv.Models.Request.RequestFollowCompany;
import com.company.phtv.Repository.AccountRepo;
import com.company.phtv.Repository.ApplicationRepo;
import com.company.phtv.Repository.CompanyImageRepo;
import com.company.phtv.Repository.CompanyRepo;
import com.company.phtv.Repository.FollowCompanyRepo;
import com.company.phtv.Repository.FollowJobRepo;
import com.company.phtv.Services.IServices.ICompanyService;
import com.company.phtv.Utils.Convert;
import com.company.phtv.Utils.CurrentAccount;
import com.company.phtv.Utils.HandleDate;
import com.company.phtv.Utils.Pagination;
import com.company.phtv.Utils.Variable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

@Service
public class CompanyService implements ICompanyService {
    // call Repository (handle with database)
    @Autowired
    CompanyRepo _companyRepo;
    @Autowired
    AccountRepo _accountRepo;
    @Autowired
    FollowCompanyRepo _followCompanyRepo;
    @Autowired
    ApplicationRepo _applicationRepo;
    @Autowired
    FollowJobRepo _followJobRepo;
    @Autowired
    CompanyImageRepo _companyImageRepo;

    // call service
    @Autowired
    CloudinaryService _cloudinaryService;

    // call util
    Pagination<CompanyDTO> pagination = new Pagination<CompanyDTO>();
    Convert convert = new Convert();
    HandleDate handleDate = new HandleDate();
    @Autowired
    CurrentAccount _currentAccount;

    // for method get
    @Override
    public List<CompanyDTO> getAll(int size, int page) {
        List<Company> companies = _companyRepo.findAll();
        return pagination.pagination(size, page, companyDTOMapping(companies));
    }

    @Override
    public CompanyDTO getById(int id) {
        // STEP 1:
        // get data in repository(database)

        Account account = _currentAccount.getAccount();
        Company company = _companyRepo.findCompanyById(id);

        // check company
        boolean checkCompanyNotFound = (company != null && company.getDeleted_at() == null) ? false : true;
        if (checkCompanyNotFound || company == null) {
            throw Variable.NOT_FOUND;
        }

        // STEP 2: set data dto child
        CompanyDTO companyDTO = CompanyMapping.CompanyDTO(company);
        // handle string image to list image
        String[] convertStringToArray = convert.convertStringToObject(company.getList_image());
        List<String> list_image_mobile = new ArrayList<>();
        if (convertStringToArray != null) {
            for (String image : convertStringToArray) {
                list_image_mobile.add(image);
            }
        }
        companyDTO.setList_image_mobile(list_image_mobile);

        // get location
        List<LocationDTO> locationDTO = new ArrayList<>();
        for (Location l : company.getLocations()) {
            boolean checkLocationDeleted = l.getDeleted_at() != null;
            if (checkLocationDeleted) {
                continue;
            }
            locationDTO.add(LocationMapping.LocationDTO(l));
        }
        // get skill
        List<SkillDTO> skillDTOs = new ArrayList<>();
        for (SkillCompany s : company.getSkillCompanies()) {
            boolean checkSkillDeleted = s.getSkill().getDeleted_at() != null;
            if (checkSkillDeleted) {
                continue;
            }
            skillDTOs.add(SkillMapping.getSkill(s.getSkill()));
        }
        List<JobDTO> jobDTOS = new ArrayList<>();
        int count = 0;
        // STEP 3: get job
        for (Jobs j : company.getJobs()) {
            boolean checkJobDeleted = j.getDeleted_at() != null;
            if (checkJobDeleted) {
                continue;
            }
            boolean checkDateJob = j.getStart_date().before(Date.from(Instant.now()))
                    && j.getEnd_date().after(Date.from(Instant.now()));
            if (checkDateJob) {
                count++;
            }
            JobDTO job = JobMapping.getJob(j);
            // set job have save and applicatin ( yes or no) by account
            if (account != null) {
                boolean applied = _applicationRepo.findByAccountAndJobs(account, j) != null;
                if (applied) {
                    job.setJob_is_apply(true);
                }
                boolean saved = _followJobRepo.findByAccountAndJobs(account, j) != null;
                if (saved) {
                    job.setJob_is_save(true);
                }
            }
            jobDTOS.add(job);
        }
        // STEP 4: set final data for dto
        companyDTO.setOpening_jobs(count);
        companyDTO.setSkills(skillDTOs);
        companyDTO.setLocations(locationDTO);
        companyDTO.setJobs(jobDTOS);
        return companyDTO;
    }

    @Override
    public List<CompanyDTO> companyContractAll(int size, int page) {
        // get all company contract with PHTV4 (we-> developer =)))))
        // STEP 1: get data
        List<Company> companies = _companyRepo.findCompanyByContract();
        List<CompanyDTO> companyDTOS = new ArrayList<>();
        for (int i = 0; i < companies.size(); i++) {
            boolean checkNotDeleted = companies.get(i).getDeleted_at() == null;
            boolean checkContract = companies.get(i).getContract() == 1;
            if (checkNotDeleted && checkContract) {
                // STEP 2: map dto
                CompanyDTO companyDTO = CompanyMapping.CompanyDTO(companies.get(i));

                List<SkillDTO> skillDTOs = new ArrayList<>();
                for (SkillCompany s : companies.get(i).getSkillCompanies()) {
                    boolean checkSkillNotDeleted = s.getSkill().getDeleted_at() == null;
                    if (checkSkillNotDeleted) {
                        skillDTOs.add(SkillMapping.getSkill(s.getSkill()));
                    }
                }
                companyDTO.setSkills(skillDTOs);

                // handle Image
                String[] convertStringToArray = convert.convertStringToObject(companies.get(i).getList_image());
                List<String> list_image_mobile = new ArrayList<>();
                if (convertStringToArray != null) {
                    for (String image : convertStringToArray) {
                        list_image_mobile.add(image);
                    }
                }
                // STEP 3: set number job opening
                int count = 0;
                for (Jobs j : companies.get(i).getJobs()) {
                    boolean checkJobNotDeleted = j.getDeleted_at() == null;
                    boolean checkDateJob = j.getStart_date().before(Date.from(Instant.now()))
                            && j.getEnd_date().after(Date.from(Instant.now()));
                    if (checkJobNotDeleted && checkDateJob) {
                        count++;
                    }
                }
                companyDTO.setOpening_jobs(count);
                // STEP 4: add final data dto
                companyDTOS.add(companyDTO);
            }

        }
        return pagination.pagination(size, page, companyDTOS);
    }

    public List<CompanyDTO> companyApplicationMost(int size, int page) {
        // sort company by job have application most
        // STEP 1: get data;
        List<Company> companies = _companyRepo.findAll();
        List<CompanyDTO> companyDTOS = new ArrayList<>();
        if (companies.size() < 5) {
            // if company < 5 => return all;
            return pagination.pagination(size, page, companyDTOMapping(companies));
        }
        // company >5
        HashMap<Company, Integer> companiesWithCounts = new HashMap<Company, Integer>();
        for (int i = 0; i < companies.size(); i++) {
            int count = 0;
            boolean checkCompanyDeleted = companies.get(i).getDeleted_at() != null;
            if (!checkCompanyDeleted) {
                // get number all application of job by company
                for (Jobs job : companies.get(i).getJobs()) {
                    boolean checkJobDeleted = job.getDeleted_at() != null;
                    if (!checkJobDeleted) {
                        count += job.getApplications().size();
                    }
                }
                // STEP 2: set HashMap for sort :<<
                if (count != 0) {
                    companiesWithCounts.put(companies.get(i), count);
                }
            }

        }
        // STEP 3: sort data
        if (companiesWithCounts.size() > 5) {
            PriorityQueue<Map.Entry<Company, Integer>> pq = new PriorityQueue<>(
                    (e1, e2) -> e2.getValue() - e1.getValue());
            pq.addAll(companiesWithCounts.entrySet());
            if (pq.size() > 5) {
                pq.poll();
            }
            List<Company> listCompany = new ArrayList<>();

            while (!pq.isEmpty() && companyDTOS.size() < 5) {
                Map.Entry<Company, Integer> entry = pq.poll();
                Company company = entry.getKey();
                // STEP 4: add final data
                listCompany.add(company);
            }
            return pagination.pagination(size, page, companyDTOMapping(listCompany));
        }
        return pagination.pagination(size, page, companyDTOMapping(companies));

    }

    public List<CompanyDTO> CompanyByProvenceAndIndustry(RequestFilterCompany requestFilterCompany, int size,
            int page) {
        // STEP 1: get data
        List<Company> getCompanies = _companyRepo.findCompanyByIndustryAndProvinceCity();
        List<Company> companies = new ArrayList<>();
        int CASE = 0;
        // STEP 2: set case
        if (requestFilterCompany.province_city_id != 0 && requestFilterCompany.industry_id == 0) {
            CASE = 1;
        }
        if (requestFilterCompany.province_city_id == 0 && requestFilterCompany.industry_id != 0) {
            CASE = 2;
        }
        if (requestFilterCompany.industry_id != 0 && requestFilterCompany.province_city_id != 0) {
            CASE = 3;
        }
        if (requestFilterCompany.industry_id == 0 && requestFilterCompany.province_city_id == 0) {
            // get default
            List<CompanyDTO> companyDTOs = companyDTOMapping(getCompanies);
            return pagination.pagination(size, page, companyDTOs);
        }
        // STEP 3: handle logic
        switch (CASE) {
            case 1:
                // filter by province_city
                for (int i = 0; i < getCompanies.size(); i++) {
                    if (getCompanies.get(i).getDeleted_at() != null) {
                        continue;
                    }
                    for (Location l : getCompanies.get(i).getLocations()) {
                        boolean checkLocationDeleted = l.getCity_provence().getDeleted_at() == null;
                        boolean checkLocationTrue = requestFilterCompany.province_city_id == l.getCity_provence()
                                .getId();
                        if (checkLocationDeleted && checkLocationTrue) {
                            companies.add(getCompanies.get(i));
                            break;
                        }
                    }
                }
                return pagination.pagination(size, page, companyDTOMapping(companies));
            case 2:
                // filter by industry
                for (int i = 0; i < getCompanies.size(); i++) {
                    if (getCompanies.get(i).getDeleted_at() != null) {
                        continue;
                    }
                    for (SkillCompany s : getCompanies.get(i).getSkillCompanies()) {
                        boolean checkIndustryTrue = requestFilterCompany.industry_id == s.getSkill().getIndustry()
                                .getId();
                        boolean checkIndustryNotDeleted = s.getSkill().getDeleted_at() == null
                                && s.getSkill().getIndustry().getDeleted_at() == null;
                        if (checkIndustryNotDeleted && checkIndustryTrue) {
                            companies.add(getCompanies.get(i));
                            break;
                        }
                    }
                }
                return pagination.pagination(size, page, companyDTOMapping(companies));
            case 3:
                // filter by industry and province_city
                for (int i = 0; i < getCompanies.size(); i++) {
                    if (getCompanies.get(i).getDeleted_at() != null) {
                        continue;
                    }
                    // get company by province_city for check Industry (step next)
                    boolean checkIndustryConstainId = false;
                    for (Location l : getCompanies.get(i).getLocations()) {
                        boolean checkLocation = requestFilterCompany.province_city_id == l.getCity_provence()
                                .getId();
                        if (checkLocation && l.getCity_provence().getDeleted_at() == null) {
                            checkIndustryConstainId = true;
                        }
                    }
                    // check by industry
                    for (SkillCompany s : getCompanies.get(i).getSkillCompanies()) {
                        // check company have industry and have province_city => add
                        boolean checkLocation = requestFilterCompany.industry_id == s.getSkill().getIndustry().getId();
                        if (checkLocation && s.getSkill().getDeleted_at() == null
                                && s.getSkill().getIndustry().getDeleted_at() == null
                                && checkIndustryConstainId == true) {
                            companies.add(getCompanies.get(i));
                            break;
                        }
                    }
                }
                return pagination.pagination(size, page, companyDTOMapping(companies));
            default:
                // different
                return pagination.pagination(size, page, companyDTOMapping(getCompanies));
        }

    }

    public ChartForEmployer companyChart() {

        // STEP 1: data
        Account account = _currentAccount.getAccount();
        Company company = _companyRepo.findOneCompanyWithAccount(account);
        ChartForEmployer chart = new ChartForEmployer();

        // STEP 2: create list for add result data
        List<Integer> listMonth = new ArrayList<>();
        List<Integer> listApplicated = new ArrayList<>();
        List<Integer> listViewed = new ArrayList<>();
        List<Integer> listSaved = new ArrayList<>();
        List<Integer> listJobs = new ArrayList<>();
        List<Float> listPrice = new ArrayList<>();
        // STEP 3: handle logic
        // get number job application , job save, job view of all job by month
        for (int i = 0; i < 12; i++) {
            // get by month 1, 2, 3, 4, 5, 6, .....;
            // create variable contain
            int number_of_job_applicated = 0;
            int number_of_job_saved = 0;
            int number_of_job_viewed = 0;
            int number_jobs = 0;
            Float price_for_subcription_plan = (float) 0;

            for (Jobs job : company.getJobs()) {
                // get current year (2024)
                int currentYear = handleDate.getYear(new Date());
                // get year start of job
                int yearStartJob = handleDate.getYear(job.getStart_date());
                // get year end of job
                int yearEndJob = handleDate.getYear(job.getEnd_date());
                boolean checkYearJob = currentYear >= yearStartJob || currentYear <= yearEndJob;
                if (!checkYearJob) {
                    continue;
                }
                // get month start date
                int month_start = handleDate.getMonth(job.getStart_date());
                // get month end date
                int month_end = handleDate.getMonth(job.getEnd_date());
                // check month of job == i+1(month 1,2,3,4,5....) ---- get job by month;
                // check month part 1;
                boolean checkMonthJob = month_start <= i + 1 && month_end >= i + 1;
                if (!checkMonthJob) {
                    // if month of job(month start or month end) different month(i+1)
                    continue;
                }
                // count job
                number_jobs += 1;
                // get applicated by job
                for (Application app : job.getApplications()) {
                    // get month applicated
                    int monthApplicated = handleDate.getMonth(app.getCreated_at());
                    // check month part 2
                    boolean checkMonthApplicated = monthApplicated == i + 1;
                    if (checkMonthApplicated) {
                        number_of_job_applicated += 1;
                    }
                }
                // get applicated by job
                for (ViewedJob viewed : job.getViewedJobs()) {
                    // get month applicated
                    int monthViewd = handleDate.getMonth(viewed.getCreated_at());
                    // check month part 2
                    boolean checkMonthViewed = monthViewd == i + 1;
                    if (checkMonthViewed) {
                        number_of_job_viewed += 1;
                    }
                }
                // get applicated by job
                for (FollowJob saved : job.getFollowJobs()) {
                    // get month applicated
                    int monthSaved = handleDate.getMonth(saved.getCreated_at());
                    // check month part 2
                    boolean checkMonthSaved = monthSaved == i + 1;
                    if (checkMonthSaved) {
                        number_of_job_saved += 1;
                    }
                }
            }

            for (SubcriptionPlanCompany spc : company.getSubcritionPlanCompanies()) {
                // get current year (2024)
                int currentYear = handleDate.getYear(new Date());
                // get year subcription plan
                int yearSubcriptionPlanCompany = handleDate.getYear(spc.getCreated_at());
                boolean checkYear = currentYear == yearSubcriptionPlanCompany;
                if (!checkYear) {
                    continue;
                }
                // get month
                int month = handleDate.getMonth(spc.getCreated_at());
                boolean checkMonth = month == i + 1;
                if (!checkMonth) {
                    // if month of subcription plan different month(i+1)
                    continue;
                }
                price_for_subcription_plan += spc.getSubscription_plan().getPrice();

            }
            // STEP 4: add array data type int by month;
            listApplicated.add(number_of_job_applicated);
            listViewed.add(number_of_job_viewed);
            listSaved.add(number_of_job_saved);
            listMonth.add(i + 1);
            listJobs.add(number_jobs);
            listPrice.add(price_for_subcription_plan);
        }
        // STEP 5: set dto final
        chart.setMonth(listMonth);
        chart.setNumber_of_job_applicated(listApplicated);
        chart.setNumber_of_job_saved(listSaved);
        chart.setNumber_of_job_viewed(listViewed);
        chart.setJobs(listJobs);
        chart.setPrice_for_subcription_plan(listPrice);
        return chart;
    }

    // for method post
    @Override
    public CompanyDTO create(RequestCompany requestCompany) {

        // STEP 1: get data
        Company company = CompanyMapping.Company(requestCompany);
        Account a = _accountRepo.findById(requestCompany.getAccount_id()).get();
        // check account
        if (a == null || a.getDeleted_at() != null) {
            throw Variable.ACCOUNT_NOT_FOUND;
        }
        // check company
        for (Company c : a.getCompanies()) {
            // check list company of account is deleted
            if (c.getDeleted_at() == null) {
                throw Variable.COMPANY_ACCOUNT_EXISTING;
            }
        }
        company.setAccount(a);
        // STEP 2: push image to cloudinary
        if (requestCompany.getBackground() != null) {
            try {
                @SuppressWarnings("rawtypes")
                Map check = _cloudinaryService.uploadImage(requestCompany.getBackground(),
                        company.getBackground_image());
                company.setBackground_image(check.get("url").toString());
            } catch (IOException e) {
                throw Variable.ADD_IMAGE_FAIL;
            }
        }
        if (requestCompany.getLogo() != null) {
            try {
                @SuppressWarnings("rawtypes")
                Map check = _cloudinaryService.uploadImage(requestCompany.getLogo(), company.getLogo_image());
                company.setLogo_image(check.get("url").toString());
            } catch (IOException e) {
                throw Variable.ADD_IMAGE_FAIL;
            }
        }
        company.setList_image(requestCompany.getList_image());
        company.setCount_job(-1);
        // STEP 3: save database
        _companyRepo.save(company);
        return (CompanyDTO) CompanyMapping.CompanyDTO(company);
    }

    public CompanyDTO followCompany(RequestFollowCompany requestCompany) {
        // STEP 1: get data
        Account account = _currentAccount.getAccount();
        Company company = _companyRepo.findCompanyById(Integer.parseInt(requestCompany.getCompany_id()));
        // check account
        if (account == null || company == null) {
            throw Variable.ACTION_FAIL;
        }
        // STEP 2: get data if followed => destroy; if not followed => follow (save
        // company :)))
        FollowCompany followCompany = _followCompanyRepo.findByAccountAndCompany(account, company);
        if (followCompany != null) {
            _followCompanyRepo.delete(followCompany);
            return null;
        }
        _followCompanyRepo.save(new FollowCompany(0, company, account));
        return null;

    }

    // for method put
    @Override
    public CompanyDTO put(int id, RequestCompany requestCompany) {
        // STEP 1: get and check company not null
        Company getCompany = _companyRepo.findCompanyById(id);
        boolean checkCompanyNotFound = (getCompany != null && getCompany.getDeleted_at() == null) ? false : true;
        if (checkCompanyNotFound || getCompany == null) {
            // null => return
            throw Variable.NOT_FOUND;
        }
        // STEP 2: push image to cloudinary
        if (requestCompany.getBackground() != null) {
            try {
                // create image in cloudinary
                @SuppressWarnings("rawtypes")
                Map check = _cloudinaryService.uploadImage(requestCompany.getBackground(),
                        getCompany.getBackground_image());
                getCompany.setBackground_image(check.get("url").toString());
            } catch (IOException e) {
                throw Variable.ADD_IMAGE_FAIL;
            }
        }
        if (requestCompany.getLogo() != null) {
            try {
                // create image in cloudinary
                @SuppressWarnings("rawtypes")
                Map check = _cloudinaryService.uploadImage(requestCompany.getLogo(), getCompany.getLogo_image());
                getCompany.setLogo_image(check.get("url").toString());
            } catch (IOException e) {
                throw Variable.ADD_IMAGE_FAIL;
            }
        }
        // STEP 3: map request to company entity
        Company company = CompanyMapping.CompanyPut(requestCompany, getCompany);
        if (requestCompany.getAccount_id() != 0) {
            company.setAccount(_accountRepo.getAccountById(requestCompany.getAccount_id()));
        }
        company.setList_image(requestCompany.getList_image());
        company.setId(id);
        // STEP 4
        _companyRepo.save(company);
        return (CompanyDTO) CompanyMapping.CompanyDTO(company);
    }

    // for method delete
    @Override
    public CompanyDTO delete(int id) {
        // STEP 1: get data and check
        Company company = _companyRepo.findCompanyById(id);
        boolean checkCompanyNotFound = (company != null && company.getDeleted_at() == null) ? false : true;
        if (checkCompanyNotFound || company == null) {
            throw Variable.NOT_FOUND;
        }
        // STEP 2: set deleted_at different null => finishe deleted
        company.setDeleted_at(new Date());
        _companyRepo.save(company);
        return null;
    }

    // handle mapping and data like set skill set location...
    // return number job by company
    List<CompanyDTO> companyDTOMapping(List<Company> companies) {
        List<CompanyDTO> companyDTOS = new ArrayList<>();
        for (int i = 0; i < companies.size(); i++) {
            List<JobDTO> jobs = new ArrayList<>();
            if (companies.get(i).getDeleted_at() == null) {
                // STEP 1: map entity to dto for return
                CompanyDTO companyDTO = CompanyMapping.CompanyDTO(companies.get(i));

                //// STEP 2: handle and add dto (image, location, skill, count job, job, company
                //// is_save ?);
                // : handle string image to array path image.
                String[] convertStringToArray = convert.convertStringToObject(companies.get(i).getList_image());
                List<String> list_image_mobile = new ArrayList<>();
                if (convertStringToArray != null) {
                    for (String image : convertStringToArray) {
                        list_image_mobile.add(image);
                    }
                }

                companyDTO.setList_image_mobile(list_image_mobile);
                List<SkillDTO> skillDTOs = new ArrayList<>();
                for (SkillCompany s : companies.get(i).getSkillCompanies()) {
                    if (s.getSkill().getDeleted_at() == null) {
                        skillDTOs.add(SkillMapping.getSkill(s.getSkill()));
                    }
                }
                List<LocationDTO> locationDTOs = new ArrayList<>();
                for (Location l : companies.get(i).getLocations()) {
                    if (l.getDeleted_at() == null) {
                        locationDTOs.add(LocationMapping.LocationDTO(l));
                    }
                }
                companyDTO.setLocations(locationDTOs);
                companyDTO.setSkills(skillDTOs);
                // set count job opening for company and add all job opening
                int count = 0;
                for (Jobs j : companies.get(i).getJobs()) {
                    boolean checkJobNotDeleted = j.getDeleted_at() == null;
                    boolean checkDateJob = j.getStart_date().before(Date.from(Instant.now()))
                            && j.getEnd_date().after(Date.from(Instant.now()));
                    if (checkJobNotDeleted && checkDateJob) {
                        count++;
                        jobs.add(JobMapping.getJob(j));
                    }
                }
                if (_currentAccount.getAccount() != null) {
                    FollowCompany followCompany = _followCompanyRepo
                            .findByAccountAndCompany(_currentAccount.getAccount(), companies.get(i));
                    if (followCompany != null) {
                        companyDTO.setCompany_is_save(true);
                    }
                }
                // STEP 3: set to dto
                companyDTO.setOpening_jobs(count);
                companyDTO.setJobs(jobs);
                companyDTOS.add(companyDTO);
            }
        }

        // STEP 4: Sort by openingJob in descending order
        List<CompanyDTO> sortedCompanies = companyDTOS.stream()
                .sorted(Comparator.comparingInt(CompanyDTO::getOpening_jobs).reversed())
                .collect(Collectors.toList());
        return sortedCompanies;
    }
}
