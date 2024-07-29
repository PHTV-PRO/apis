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
import com.company.phtv.Models.Entity.SubcriptionPlan;
import com.company.phtv.Models.Entity.SubcriptionPlanCompany;
import com.company.phtv.Models.Entity.ViewedJob;
import com.company.phtv.Models.Map.CompanyMapping;
import com.company.phtv.Models.Map.JobMapping;
import com.company.phtv.Models.Map.LocationMapping;
import com.company.phtv.Models.Map.SkillMapping;
import com.company.phtv.Models.Request.RequestCompany;
import com.company.phtv.Models.Request.RequestFollowCompany;
import com.company.phtv.Models.Request.RequestSearchCompany;
import com.company.phtv.Repository.AccountRepo;
import com.company.phtv.Repository.ApplicationRepo;
import com.company.phtv.Repository.CompanyImageRepo;
import com.company.phtv.Repository.CompanyRepo;
import com.company.phtv.Repository.FollowCompanyRepo;
import com.company.phtv.Repository.FollowJobRepo;
import com.company.phtv.Services.IServices.ICompanyService;
import com.company.phtv.Utils.CurrentAccount;
import com.company.phtv.Utils.Variable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

@Service
public class CompanyService implements ICompanyService {
    @Autowired
    CompanyRepo _companyRepo;
    @Autowired
    AccountRepo _accountRepo;
    @Autowired
    CloudinaryService _cloudinaryService;
    @Autowired
    FollowCompanyRepo _followCompanyRepo;
    @Autowired
    ApplicationRepo _applicationRepo;
    @Autowired
    FollowJobRepo _followJobRepo;
    @Autowired
    CompanyImageRepo _companyImageRepo;

    @Autowired
    CurrentAccount _currentAccount;

    @Override
    public List<CompanyDTO> getAll(int size, int page) {
        List<Company> companies = _companyRepo.findAll();
        return pagination(size, page, companyDTOMapping(companies));
    }

    @Override
    public CompanyDTO create(RequestCompany requestCompany) {
        Company company = CompanyMapping.Company(requestCompany);
        Account a = _accountRepo.findById(requestCompany.getAccount_id()).get();
        if (a == null || a.getDeleted_at() != null) {
            throw Variable.ACCOUNT_NOT_FOUND;
        }
        for (Company c : a.getCompanies()) {
            // check list company of account is deleted
            if (c.getDeleted_at() != null) {
                throw Variable.COMPANY_ACCOUNT_EXISTING;
            }
        }
        company.setAccount(a);
        if (requestCompany.getBackground() != null) {
            try {
                // create image in cloudinary
                @SuppressWarnings("rawtypes")
                Map check = _cloudinaryService.uploadImage(requestCompany.getBackground(),
                        company.getBackground_image());
                company.setBackground_image(Variable.PATH_IMAGE + check.get("public_id").toString());
            } catch (IOException e) {
                throw Variable.ADD_IMAGE_FAIL;
            }
        }
        if (requestCompany.getLogo() != null) {
            try {
                // create image in cloudinary
                @SuppressWarnings("rawtypes")
                Map check = _cloudinaryService.uploadImage(requestCompany.getLogo(), company.getLogo_image());
                company.setLogo_image(Variable.PATH_IMAGE + check.get("public_id").toString());
            } catch (IOException e) {
                throw Variable.ADD_IMAGE_FAIL;
            }
        }
        company.setList_image(requestCompany.getList_image());
        company.setCount_job(-1);
        _companyRepo.save(company);
        return (CompanyDTO) CompanyMapping.CompanyDTO(company);
    }

    @Override
    public CompanyDTO put(int id, RequestCompany requestCompany) {
        Company getCompany = _companyRepo.findCompanyById(id);
        boolean checkCompanyNotFound = (getCompany != null && getCompany.getDeleted_at() == null) ? false : true;
        if (checkCompanyNotFound || getCompany == null) {
            throw Variable.NOT_FOUND;
        }
        if (requestCompany.getBackground() != null) {
            try {
                // create image in cloudinary
                @SuppressWarnings("rawtypes")
                Map check = _cloudinaryService.uploadImage(requestCompany.getBackground(),
                        getCompany.getBackground_image());
                getCompany.setBackground_image(Variable.PATH_IMAGE + check.get("public_id").toString());
            } catch (IOException e) {
                throw Variable.ADD_IMAGE_FAIL;
            }
        }
        if (requestCompany.getLogo() != null) {
            try {
                // create image in cloudinary
                @SuppressWarnings("rawtypes")
                Map check = _cloudinaryService.uploadImage(requestCompany.getLogo(), getCompany.getLogo_image());
                getCompany.setLogo_image(Variable.PATH_IMAGE + check.get("public_id").toString());
            } catch (IOException e) {
                throw Variable.ADD_IMAGE_FAIL;
            }
        }
        Company company = CompanyMapping.CompanyPut(requestCompany, getCompany);
        if (requestCompany.getAccount_id() != 0) {
            company.setAccount(_accountRepo.getAccountById(requestCompany.getAccount_id()));
        }
        company.setList_image(requestCompany.getList_image());
        company.setId(id);
        _companyRepo.save(company);

        return (CompanyDTO) CompanyMapping.CompanyDTO(company);
    }

    @Override
    public CompanyDTO getById(int id) {
        Account account = _currentAccount.getAccount();
        Company company = _companyRepo.findCompanyById(id);
        boolean checkCompanyNotFound = (company != null && company.getDeleted_at() == null) ? false : true;
        if (checkCompanyNotFound || company == null) {
            throw Variable.NOT_FOUND;
        }
        CompanyDTO companyDTO = CompanyMapping.CompanyDTO(company);

        List<LocationDTO> locationDTO = new ArrayList<>();
        for (Location l : company.getLocations()) {
            boolean checkLocationDeleted = l.getDeleted_at() != null;
            if (checkLocationDeleted) {
                continue;
            }
            locationDTO.add(LocationMapping.LocationDTO(l));
        }
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
        companyDTO.setOpening_jobs(count);
        companyDTO.setSkills(skillDTOs);
        companyDTO.setLocations(locationDTO);
        companyDTO.setJobs(jobDTOS);
        return companyDTO;
    }

    @Override
    public CompanyDTO delete(int id) {
        Company company = _companyRepo.findCompanyById(id);
        boolean checkCompanyNotFound = (company != null && company.getDeleted_at() == null) ? false : true;
        if (checkCompanyNotFound || company == null) {
            throw Variable.NOT_FOUND;
        }
        company.setDeleted_at(new Date());
        _companyRepo.save(company);
        return null;
    }

    @Override
    public List<CompanyDTO> companyContractAll(int size, int page) {
        List<Company> companies = _companyRepo.findCompanyByContract();
        List<CompanyDTO> companyDTOS = new ArrayList<>();
        for (int i = 0; i < (companies.size() < 5 ? companies.size() : 5); i++) {
            boolean checkNotDeleted = companies.get(i).getDeleted_at() == null;
            boolean checkContract = companies.get(i).getContract() == 1;
            if (checkNotDeleted && checkContract) {
                CompanyDTO companyDTO = CompanyMapping.CompanyDTO(companies.get(i));
                List<SkillDTO> skillDTOs = new ArrayList<>();
                for (SkillCompany s : companies.get(i).getSkillCompanies()) {
                    boolean checkSkillNotDeleted = s.getSkill().getDeleted_at() == null;
                    if (checkSkillNotDeleted) {
                        skillDTOs.add(SkillMapping.getSkill(s.getSkill()));
                    }
                }
                companyDTO.setSkills(skillDTOs);
                companyDTOS.add(companyDTO);
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
            }

        }
        return pagination(size, page, companyDTOS);
    }

    public List<CompanyDTO> companyApplicationMost(int size, int page) {
        List<Company> companies = _companyRepo.findAll();
        List<CompanyDTO> companyDTOS = new ArrayList<>();
        if (companies.size() < 5) {
            return pagination(size, page, companyDTOMapping(companies));
        }

        HashMap<Company, Integer> companiesWithCounts = new HashMap<Company, Integer>();
        for (int i = 0; i < companies.size(); i++) {
            int count = 0;
            boolean checkCompanyDeleted = companies.get(i).getDeleted_at() != null;
            if (!checkCompanyDeleted) {
                for (Jobs job : companies.get(i).getJobs()) {
                    boolean checkJobDeleted = job.getDeleted_at() != null;
                    if (!checkJobDeleted) {
                        count += job.getApplications().size();
                    }
                }
                if (count != 0) {
                    companiesWithCounts.put(companies.get(i), count);
                }
            }

        }
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
                listCompany.add(company);
            }
            return pagination(size, page, companyDTOMapping(listCompany));
        }
        return pagination(size, page, companyDTOMapping(companies));

    }

    public CompanyDTO followCompany(RequestFollowCompany requestCompany) {
        Account account = _currentAccount.getAccount();
        Company company = _companyRepo.findCompanyById(Integer.parseInt(requestCompany.getCompany_id()));
        if (account == null || company == null) {
            throw Variable.ACTION_FAIL;
        }
        FollowCompany followCompany = _followCompanyRepo.findByAccountAndCompany(account, company);
        if (followCompany != null) {
            _followCompanyRepo.delete(followCompany);
            return null;
        }
        _followCompanyRepo.save(new FollowCompany(0, company, account));
        return null;

    }

    public List<CompanyDTO> CompanyByProvenceAndIndustry(RequestSearchCompany requestSearchCompany, int size,
            int page) {
        List<Company> getCompanies = _companyRepo.findCompanyByIndustryAndProvinceCity();
        List<Company> companies = new ArrayList<>();
        int CASE = 0;
        if (requestSearchCompany.province_city_id != 0 && requestSearchCompany.industry_id == 0) {
            CASE = 1;
        }
        if (requestSearchCompany.province_city_id == 0 && requestSearchCompany.industry_id != 0) {
            CASE = 2;
        }
        if (requestSearchCompany.industry_id != 0 && requestSearchCompany.province_city_id != 0) {
            CASE = 3;
        }
        if (requestSearchCompany.industry_id == 0 && requestSearchCompany.province_city_id == 0) {
            List<CompanyDTO> companyDTOs = companyDTOMapping(getCompanies);
            return pagination(size, page, companyDTOs);
        }
        switch (CASE) {
            case 1:
                for (int i = 0; i < getCompanies.size(); i++) {
                    if (getCompanies.get(i).getDeleted_at() != null) {
                        continue;
                    }
                    for (Location l : getCompanies.get(i).getLocations()) {
                        boolean checkLocationDeleted = l.getCity_provence().getDeleted_at() == null;
                        boolean checkLocationTrue = requestSearchCompany.province_city_id == l.getCity_provence()
                                .getId();
                        if (checkLocationDeleted && checkLocationTrue) {
                            companies.add(getCompanies.get(i));
                            break;
                        }
                    }
                }
                return pagination(size, page, companyDTOMapping(companies));
            case 2:
                for (int i = 0; i < getCompanies.size(); i++) {
                    if (getCompanies.get(i).getDeleted_at() != null) {
                        continue;
                    }
                    for (SkillCompany s : getCompanies.get(i).getSkillCompanies()) {
                        boolean checkIndustryTrue = requestSearchCompany.industry_id == s.getSkill().getIndustry()
                                .getId();
                        boolean checkIndustryNotDeleted = s.getSkill().getDeleted_at() == null
                                && s.getSkill().getIndustry().getDeleted_at() == null;
                        if (checkIndustryNotDeleted && checkIndustryTrue) {
                            companies.add(getCompanies.get(i));
                            break;
                        }
                    }
                }
                return pagination(size, page, companyDTOMapping(companies));
            case 3:
                for (int i = 0; i < getCompanies.size(); i++) {
                    if (getCompanies.get(i).getDeleted_at() != null) {
                        continue;
                    }
                    boolean checkIndustryConstainId = false;
                    for (Location l : getCompanies.get(i).getLocations()) {
                        boolean checkLocation = requestSearchCompany.province_city_id == l.getCity_provence()
                                .getId();
                        if (checkLocation && l.getCity_provence().getDeleted_at() == null) {
                            checkIndustryConstainId = true;
                        }
                    }
                    for (SkillCompany s : getCompanies.get(i).getSkillCompanies()) {
                        boolean checkLocation = requestSearchCompany.industry_id == s.getSkill().getIndustry().getId();
                        if (checkLocation && s.getSkill().getDeleted_at() == null
                                && s.getSkill().getIndustry().getDeleted_at() == null
                                && checkIndustryConstainId == true) {
                            companies.add(getCompanies.get(i));
                            break;
                        }
                    }
                }
                return pagination(size, page, companyDTOMapping(companies));
            default:
                return pagination(size, page, companyDTOMapping(getCompanies));
        }

    }

    List<CompanyDTO> companyDTOMapping(List<Company> companies) {
        List<CompanyDTO> companyDTOS = new ArrayList<>();
        for (int i = 0; i < companies.size(); i++) {
            List<JobDTO> jobs = new ArrayList<>();
            if (companies.get(i).getDeleted_at() == null) {
                CompanyDTO companyDTO = CompanyMapping.CompanyDTO(companies.get(i));
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
                companyDTO.setOpening_jobs(count);
                companyDTO.setJobs(jobs);
                companyDTOS.add(companyDTO);
            }
        }

        // Sort by openingJob in descending order
        List<CompanyDTO> sortedCompanies = companyDTOS.stream()
                .sorted(Comparator.comparingInt(CompanyDTO::getOpening_jobs).reversed())
                .collect(Collectors.toList());
        return sortedCompanies;
    }

    public ChartForEmployer companyChart() {

        Account account = _currentAccount.getAccount();
        Company company = _companyRepo.findOneCompanyWithAccount(account);
        ChartForEmployer chart = new ChartForEmployer();

        List<Integer> listMonth = new ArrayList<>();
        List<Integer> listApplicated = new ArrayList<>();
        List<Integer> listViewed = new ArrayList<>();
        List<Integer> listSaved = new ArrayList<>();
        List<Integer> listJobs = new ArrayList<>();
        List<Float> listPrice = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            // get by month 1, 2, 3, 4, 5, 6, .....;

            int number_of_job_applicated = 0;
            int number_of_job_saved = 0;
            int number_of_job_viewed = 0;
            int number_jobs = 0;
            Float price_for_subcription_plan = (float) 0;
            // int subcription_plan = 0;

            for (Jobs job : company.getJobs()) {
                // get current year (2024)
                int currentYear = getYearOrMonth(new Date(), Variable.YEAR);
                // get year start of job
                int yearStartJob = getYearOrMonth(job.getStart_date(), Variable.YEAR);
                // get year end of job
                int yearEndJob = getYearOrMonth(job.getEnd_date(), Variable.YEAR);
                boolean checkYearJob = currentYear >= yearStartJob || currentYear <= yearEndJob;
                if (!checkYearJob) {
                    continue;
                }
                // get month start date
                int month_start = getYearOrMonth(job.getStart_date(), Variable.MONTH);
                // get month end date
                int month_end = getYearOrMonth(job.getEnd_date(), Variable.MONTH);
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
                    int monthApplicated = getYearOrMonth(app.getCreated_at(), Variable.MONTH);
                    // check month part 2
                    boolean checkMonthApplicated = monthApplicated == i + 1;
                    if (checkMonthApplicated) {
                        number_of_job_applicated += 1;
                    }
                }
                // get applicated by job
                for (ViewedJob viewed : job.getViewedJobs()) {
                    // get month applicated
                    int monthViewd = getYearOrMonth(viewed.getCreated_at(), Variable.MONTH);
                    // check month part 2
                    boolean checkMonthViewed = monthViewd == i + 1;
                    if (checkMonthViewed) {
                        number_of_job_viewed += 1;
                    }
                }
                // get applicated by job
                for (FollowJob saved : job.getFollowJobs()) {
                    // get month applicated
                    int monthSaved = getYearOrMonth(saved.getCreated_at(), Variable.MONTH);
                    // check month part 2
                    boolean checkMonthSaved = monthSaved == i + 1;
                    if (checkMonthSaved) {
                        number_of_job_saved += 1;
                    }
                }
            }

            for (SubcriptionPlanCompany spc : company.getSubcritionPlanCompanies()) {
                // get current year (2024)
                int currentYear = getYearOrMonth(new Date(), Variable.YEAR);
                // get year subcription plan
                int yearSubcriptionPlanCompany = getYearOrMonth(spc.getCreated_at(), Variable.YEAR);
                boolean checkYear = currentYear == yearSubcriptionPlanCompany;
                if (!checkYear) {
                    continue;
                }
                // get month
                int month = getYearOrMonth(spc.getCreated_at(), Variable.MONTH);
                boolean checkMonth = month == i + 1;
                if (!checkMonth) {
                    // if month of subcription plan different month(i+1)
                    continue;
                }
                price_for_subcription_plan += spc.getSubscription_plan().getPrice();

            }
            // add list
            listApplicated.add(number_of_job_applicated);
            listViewed.add(number_of_job_viewed);
            listSaved.add(number_of_job_saved);
            listMonth.add(i + 1);
            listJobs.add(number_jobs);
            listPrice.add(price_for_subcription_plan);
        }
        // set dto
        chart.setMonth(listMonth);
        chart.setNumber_of_job_applicated(listApplicated);
        chart.setNumber_of_job_saved(listSaved);
        chart.setNumber_of_job_viewed(listViewed);
        chart.setJobs(listJobs);
        chart.setPrice_for_subcription_plan(listPrice);
        return chart;
    }

    int getYearOrMonth(Date date, String yearOrMonth) {
        if (Variable.MONTH == yearOrMonth) {
            Calendar get = Calendar.getInstance();
            get.setTime(date);
            int result = get.get(Calendar.MONTH) + 1;
            return result;
        }
        Calendar get = Calendar.getInstance();
        get.setTime(date);
        int result = get.get(Calendar.YEAR);
        return result;
    }

    List<CompanyDTO> pagination(int size, int page, List<CompanyDTO> companyDTOs) {
        if (size == 0 && page == 0) {
            return companyDTOs;
        }
        if (size <= 0 || page < 0) {
            companyDTOs = new ArrayList<>();
            return companyDTOs;
        }
        if (companyDTOs == null || companyDTOs.isEmpty()) {
            return companyDTOs;
        }
        int startIndex = Math.max(0, (page - 1) * size);
        int endIndex = Math.min(startIndex + size, companyDTOs.size());
        if (startIndex > companyDTOs.size()) {
            companyDTOs = new ArrayList<>();
            return companyDTOs;
        }
        if (endIndex > companyDTOs.size()) {
            return companyDTOs.subList(startIndex, companyDTOs.size() - 1);
        }
        return companyDTOs.subList(startIndex, endIndex);
    }

}
