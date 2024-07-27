package com.company.phtv.Services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.phtv.Models.DTO.AccountDTO;
import com.company.phtv.Models.DTO.ChartForEmployer;
import com.company.phtv.Models.DTO.CompanyDTO;
import com.company.phtv.Models.DTO.JobDTO;
import com.company.phtv.Models.DTO.LevelDTO;
import com.company.phtv.Models.DTO.LocationDTO;
import com.company.phtv.Models.DTO.SearchAll;
import com.company.phtv.Models.DTO.SkillDTO;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.Application;
import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Models.Entity.FollowJob;
import com.company.phtv.Models.Entity.Jobs;
import com.company.phtv.Models.Entity.LevelJob;
import com.company.phtv.Models.Entity.Location;
import com.company.phtv.Models.Entity.Skill;
import com.company.phtv.Models.Entity.SkillCompany;
import com.company.phtv.Models.Entity.SkillJob;
import com.company.phtv.Models.Entity.SubcriptionPlanCompany;
import com.company.phtv.Models.Entity.ViewedJob;
import com.company.phtv.Models.Map.AccountMapping;
import com.company.phtv.Models.Map.CompanyMapping;
import com.company.phtv.Models.Map.JobMapping;
import com.company.phtv.Models.Map.LevelMapping;
import com.company.phtv.Models.Map.LocationMapping;
import com.company.phtv.Models.Map.SkillMapping;
import com.company.phtv.Repository.AccountRepo;
import com.company.phtv.Repository.CompanyRepo;
import com.company.phtv.Repository.JobRepo;
import com.company.phtv.Repository.SkillRepo;
import com.company.phtv.Services.IServices.IAdminService;
import com.company.phtv.Utils.CurrentAccount;
import com.company.phtv.Utils.Variable;

@Service
public class AdminService implements IAdminService {

    @Autowired
    AccountRepo _accountRepo;

    @Autowired
    CompanyRepo _companyRepo;

    @Autowired
    JobRepo _jobRepo;

    @Autowired
    SkillRepo _skillRepo;

    @Autowired
    CurrentAccount _currentAccount;

    @Override
    public SearchAll searchByNameForAdmin(String name) {
        SearchAll searchAll = new SearchAll();
        List<Account> accounts = _accountRepo.findAccountByNameContaining(name);
        List<AccountDTO> accountDTOs = new ArrayList<>();
        if (accounts != null) {
            int accountSize = accounts.size();
            // Fetch a maximum of 2 accounts
            if (accountSize <= 2) {
                for (Account account : accounts) {
                    accountDTOs.add(AccountMapping.accountDTO(account));
                }
            } else if (accountSize > 2) {
                for (int i = 0; i < 2; i++) {
                    accountDTOs.add(AccountMapping.accountDTO(accounts.get(i)));
                }
            }
            searchAll.setAccounts(accountDTOs);
        }

        List<Company> companies = _companyRepo.findCompanyByNameContaining(name);
        List<CompanyDTO> companyDTOs = new ArrayList<>();
        if (companies != null) {
            int companiesize = companies.size();
            // Fetch a maximum of 2 companies
            if (companiesize <= 2) {
                for (Company company : companies) {
                    companyDTOs.add(CompanyMapping.CompanyDTO(company));
                }
            } else if (companiesize > 2) {
                for (int i = 0; i < 2; i++) {
                    companyDTOs.add(CompanyMapping.CompanyDTO(companies.get(i)));
                }
            }
            searchAll.setCompanies(companyDTOs);
        }

        List<Jobs> jobs = _jobRepo.findJobByTitleContaining(name);
        List<JobDTO> jobDTOs = new ArrayList<>();
        if (jobs != null) {
            int jobsize = jobs.size();
            // Fetch a maximum of 2 jobs
            if (jobsize <= 2) {
                for (Jobs job : jobs) {
                    jobDTOs.add(JobMapping.getJob(job));
                }
            } else if (jobsize > 2) {
                for (int i = 0; i < 2; i++) {
                    jobDTOs.add(JobMapping.getJob(jobs.get(i)));
                }
            }
            searchAll.setJobs(jobDTOs);
        }

        return searchAll;
    }

    @Override
    public SearchAll searchByNameForAll(String name) {
        SearchAll searchAll = new SearchAll();
        List<Company> companies = _companyRepo.findCompanyByNameContaining(name);
        List<CompanyDTO> companyDTOs = new ArrayList<>();
        if (companies != null) {
            for (Company company : companies) {
                if (searchAll.getCompanies().size() >= 30) {
                    break;
                }
                boolean checkCompanyNotDeleted = company.getDeleted_at() == null;
                if (checkCompanyNotDeleted) {
                    CompanyDTO companyDTO = CompanyMapping.CompanyDTO(company);
                    List<JobDTO> jobs = new ArrayList<>();
                    for (Jobs j : company.getJobs()) {
                        if (j.getDeleted_at() == null) {
                            jobs.add(JobMapping.getJob(j));
                        }
                    }
                    companyDTO.setJobs(jobs);
                    List<LocationDTO> lDtos = new ArrayList<>();
                    for (Location l : company.getLocations()) {
                        if (l.getDeleted_at() == null) {
                            lDtos.add(LocationMapping.LocationDTO(l));
                        }
                    }
                    List<SkillDTO> skillDTOs = new ArrayList<>();
                    for (SkillCompany s : company.getSkillCompanies()) {
                        if (s.getSkill().getDeleted_at() == null) {
                            skillDTOs.add(SkillMapping.getSkill(s.getSkill()));
                        }
                    }
                    companyDTO.setLocations(lDtos);
                    companyDTO.setSkills(skillDTOs);
                    companyDTOs.add(companyDTO);
                }
            }
            searchAll.setCompanies(companyDTOs);
        }
        Skill getOneSkill = _skillRepo.findSkillByNameContaining(name).get(0);
        if (getOneSkill != null) {

            for (SkillCompany sc : getOneSkill.getSkillCompanies()) {
                if (searchAll.getCompanies().size() >= 30) {
                    break;
                }
                if (sc.getDeleted_at() != null) {
                    continue;
                }
                boolean checkExist = false;
                for (CompanyDTO c : searchAll.getCompanies()) {
                    if (c.getId() == sc.getCompany().getId()) {
                        checkExist = true;
                    }
                }
                if (checkExist == false) {
                    CompanyDTO companyDTO = CompanyMapping.CompanyDTO(sc.getCompany());
                    List<SkillDTO> skillDTOs = new ArrayList<>();
                    for (SkillCompany s : sc.getCompany().getSkillCompanies()) {
                        if (s.getSkill().getDeleted_at() == null) {
                            skillDTOs.add(SkillMapping.getSkill(s.getSkill()));
                        }
                    }
                    companyDTO.setSkills(skillDTOs);
                    searchAll.getCompanies().add(companyDTO);
                }

            }
        }

        List<Jobs> jobs = _jobRepo.findJobByTitleContaining(name);
        List<JobDTO> jobDTOs = new ArrayList<>();
        if (jobs != null) {
            for (Jobs job : jobs) {
                if (searchAll.getJobs().size() >= 30) {
                    break;
                }
                JobDTO jobDTO = JobMapping.getJob(job);
                List<SkillDTO> skillDTOs = new ArrayList<>();
                for (SkillJob s : job.getSkillJobs()) {
                    if (s.getSkills().getDeleted_at() == null) {
                        skillDTOs.add(SkillMapping.getSkill(s.getSkills()));
                    }
                }
                List<LevelDTO> levelDTOs = new ArrayList<>();
                for (LevelJob l : job.getLevelJobs()) {
                    if (l.getLevel().getDeleted_at() == null) {
                        levelDTOs.add(LevelMapping.levelDTO(l.getLevel()));
                    }
                }
                jobDTO.setSkills(skillDTOs);
                jobDTO.setLevels(levelDTOs);
                jobDTOs.add(jobDTO);
            }
            searchAll.setJobs(jobDTOs);
            for (SkillJob s : getOneSkill.getSkillJobs()) {
                if (searchAll.getJobs().size() >= 30) {
                    break;
                }
                if (s.getDeleted_at() != null) {
                    continue;
                }
                boolean checkExist = false;

                for (JobDTO j : searchAll.getJobs()) {
                    if (j.getId() == s.getJobs().getId()) {
                        checkExist = true;
                    }
                }
                if (checkExist == false) {
                    JobDTO jobDTO = JobMapping.getJob(s.getJobs());

                    List<SkillDTO> skillDTOs = new ArrayList<>();
                    for (SkillJob sj : s.getJobs().getSkillJobs()) {
                        if (sj.getSkills().getDeleted_at() == null) {
                            skillDTOs.add(SkillMapping.getSkill(sj.getSkills()));
                        }
                    }
                    List<LevelDTO> levelDTOs = new ArrayList<>();
                    for (LevelJob l : s.getJobs().getLevelJobs()) {
                        if (l.getLevel().getDeleted_at() == null) {
                            levelDTOs.add(LevelMapping.levelDTO(l.getLevel()));
                        }
                    }
                    jobDTO.setSkills(skillDTOs);
                    jobDTO.setLevels(levelDTOs);
                    searchAll.getJobs().add(jobDTO);
                }
            }
        }
        searchAll.setQuantity(searchAll.getCompanies().size() + searchAll.getJobs().size());
        return searchAll;
    }

    public ChartForEmployer getChart() {
        Account account = _currentAccount.getAccount();
        List<Company> companys = _companyRepo.findAll();
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

            for (Company company : companys) {

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

}
