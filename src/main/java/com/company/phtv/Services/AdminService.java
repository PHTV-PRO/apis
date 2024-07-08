package com.company.phtv.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.phtv.Models.DTO.AccountDTO;
import com.company.phtv.Models.DTO.CompanyDTO;
import com.company.phtv.Models.DTO.JobDTO;
import com.company.phtv.Models.DTO.LocationDTO;
import com.company.phtv.Models.DTO.SearchAll;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Models.Entity.Jobs;
import com.company.phtv.Models.Entity.Location;
import com.company.phtv.Models.Map.AccountMapping;
import com.company.phtv.Models.Map.CompanyMapping;
import com.company.phtv.Models.Map.JobMapping;
import com.company.phtv.Models.Map.LocationMapping;
import com.company.phtv.Repository.AccountRepo;
import com.company.phtv.Repository.CompanyRepo;
import com.company.phtv.Repository.JobRepo;
import com.company.phtv.Services.IServices.IAdminService;

@Service
public class AdminService implements IAdminService {

    @Autowired
    AccountRepo _accountRepo;

    @Autowired
    CompanyRepo _companyRepo;

    @Autowired
    JobRepo _jobRepo;

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
                boolean checkCompanyNotDeleted = company.getDeleted_at()== null;
                if(checkCompanyNotDeleted){
                    CompanyDTO companyDTO =CompanyMapping.CompanyDTO(company);
                    List<JobDTO> jobs = new ArrayList<>();
                    for (Jobs j : company.getJobs()) {
                        if(j.getDeleted_at()==null){
                            jobs.add(JobMapping.getJob(j));
                        }
                    }
                    companyDTO.setJobs(jobs);
                    List<LocationDTO> lDtos = new ArrayList<>();
                    for (Location l : company.getLocations()) {
                        if(l.getDeleted_at() == null ){
                            lDtos.add(LocationMapping.LocationDTO(l));
                        }
                    }
                    companyDTO.setLocations(lDtos);
                    companyDTOs.add(companyDTO);

                }
            }
            searchAll.setCompanies(companyDTOs);
        }

        List<Jobs> jobs = _jobRepo.findJobByTitleContaining(name);
        List<JobDTO> jobDTOs = new ArrayList<>();
        if (jobs != null) {
            for (Jobs job : jobs) {
                jobDTOs.add(JobMapping.getJob(job));
            }
            searchAll.setJobs(jobDTOs);
        }
        searchAll.setQuantity(searchAll.getCompanies().size()+searchAll.getJobs().size());
        return searchAll;
    }

}
