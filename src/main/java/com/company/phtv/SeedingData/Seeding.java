package com.company.phtv.SeedingData;

import com.company.phtv.Models.Entity.*;
import com.company.phtv.Repository.*;
import com.company.phtv.SeedingData.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Seeding implements CommandLineRunner {
    @Autowired
    AccountRepo _AccountRepo;

    @Autowired
    ApplicationRepo _ApplicationRepo;

    @Autowired
    CityProvinceRepo _CityProvinceRepo;

    @Autowired
    CompanyRepo _CompanyRepo;

    @Autowired
    CurriculumRepo _CurriculumRepo;

    @Autowired
    FollowCompanyRepo _FollowCompanyRepo;

    @Autowired
    FollowJobRepo _FollowJobRepo;

    @Autowired
    ViewedJobRepo _ViewedJobRepo;

    @Autowired
    IndustryRepo _IndustryRepo;

    @Autowired
    JobRepo _JobRepo;

    @Autowired
    JobTypeRepo _JobTypeRepo;

    @Autowired
    LevelRepo _LevelRepo;

    @Autowired
    LevelJobRepo _LevelJobRepo;

    @Autowired
    LocationRepo _LocationRepo;

    @Autowired
    NotificationRepo _NotificationRepo;

    @Autowired
    SkillRepo _SkillRepo;

    @Autowired
    SkillJobRepo _SkillJobRepo;

    @Autowired
    SubcriptionPlanRepo _SubcriptionPlanRepo;

    @Autowired
    SubcriptionPlanCompanyRepo _SubcriptionPlanCompanyRepo;

    @Autowired
    PasswordEncoder _PasswordEncoder;

    @Override
    public void run(String... args) throws Exception {
        LoadAccountData();
        LoadCurriculumData();
        LoadIndustryData();
        // LoadEmployerData();
        LoadCompanyData();
        LoadLevelData();
        LoadSkillData();
        LoadCityProvinceData();
        LoadLocationData();
        LoadJobTypeData();
        LoadSubcriptionPlanData();

        LoadFollowCompanyData();
        LoadJobData();
        LoadLevelJobData();

        LoadNotificationData();
        LoadSubcriptionPlanCompanyData();
        LoadFollowJobData();
        LoadViewedJobData();
        LoadApplicationData();
        LoadSkillJobData();

    }

    private void LoadAccountData() {
        if (_AccountRepo.count() == 0) {

            List<Account> list = new AccountData(_PasswordEncoder).Data();
            for (Account acc : list) {
                _AccountRepo.save(acc);
            }
        }
    }

    private void LoadApplicationData() {
        if (_ApplicationRepo.count() == 0) {

            List<Application> list = new ApplicationData(_AccountRepo, _JobRepo, _CurriculumRepo).Data();
            for (Application a : list) {
                _ApplicationRepo.save(a);
            }
        }
    }

    private void LoadCityProvinceData() {
        if (_CityProvinceRepo.count() == 0) {

            List<CityProvince> list = new CityProvinceData().Data();
            for (CityProvince l : list) {
                _CityProvinceRepo.save(l);
            }
        }
    }

    private void LoadCompanyData() {
        if (_CompanyRepo.count() == 0) {

            List<Company> list = new CompanyData(_AccountRepo).Data();
            for (Company l : list) {
                _CompanyRepo.save(l);
            }
        }
    }

    private void LoadCurriculumData() {
        if (_CurriculumRepo.count() == 0) {

            List<CurriculumVitae> list = new CurriculumVitaeData(_AccountRepo).Data();
            for (CurriculumVitae c : list) {
                _CurriculumRepo.save(c);
            }
        }
    }

    // private void LoadEmployerData() {
    // if (_EmployerRepo.count() == 0) {

    // List<Employer> list = new EmployerData(_PasswordEncoder).Data();
    // for (Employer e : list) {
    // _EmployerRepo.save(e);
    // }
    // }
    // }

    private void LoadFollowCompanyData() {
        if (_FollowCompanyRepo.count() == 0) {

            List<FollowCompany> list = new FollowCompanyData(_AccountRepo, _CompanyRepo).Data();
            for (FollowCompany c : list) {
                _FollowCompanyRepo.save(c);
            }
        }
    }

    private void LoadFollowJobData() {
        if (_FollowJobRepo.count() == 0) {

            List<FollowJob> list = new FollowJobData(_AccountRepo, _JobRepo).Data();
            for (FollowJob l : list) {
                _FollowJobRepo.save(l);
            }
        }
    }

    private void LoadViewedJobData() {
        if (_ViewedJobRepo.count() == 0) {

            List<ViewedJob> list = new ViewedJobData(_AccountRepo, _JobRepo).Data();
            for (ViewedJob l : list) {
                _ViewedJobRepo.save(l);
            }
        }
    }

    private void LoadIndustryData() {
        if (_IndustryRepo.count() == 0) {

            List<Industry> list = new IndustryData().Data();
            for (Industry i : list) {
                _IndustryRepo.save(i);
            }
        }
    }

    private void LoadJobData() {
        if (_JobRepo.count() == 0) {

            List<Jobs> list = new JobData(_CompanyRepo, _LocationRepo, _JobTypeRepo).Data();
            for (Jobs j : list) {
                _JobRepo.save(j);
            }
        }
    }

    private void LoadJobTypeData() {
        if (_JobTypeRepo.count() == 0) {

            List<JobType> list = new JobTypeData().Data();
            for (JobType j : list) {
                _JobTypeRepo.save(j);
            }
        }
    }

    private void LoadLevelJobData() {
        if (_LevelJobRepo.count() == 0) {

            List<LevelJob> list = new LevelJobData(_JobRepo, _LevelRepo).Data();
            for (LevelJob l : list) {
                _LevelJobRepo.save(l);
            }
        }
    }

    private void LoadLevelData() {
        if (_LevelRepo.count() == 0) {

            List<Level> list = new LevelData().Data();
            for (Level c : list) {
                _LevelRepo.save(c);
            }
        }
    }

    private void LoadLocationData() {
        if (_LocationRepo.count() == 0) {

            List<Location> list = new LocationData(_CompanyRepo, _CityProvinceRepo).Data();
            for (Location l : list) {
                _LocationRepo.save(l);
            }
        }
    }

    private void LoadNotificationData() {
        if (_NotificationRepo.count() == 0) {

            List<Notification> list = new NotificationData(_AccountRepo, _JobRepo, _CompanyRepo).Data();
            for (Notification n : list) {
                _NotificationRepo.save(n);
            }
        }
    }

    private void LoadSkillData() {
        if (_SkillRepo.count() == 0) {

            List<Skill> list = new SkillData(_IndustryRepo).Data();
            for (Skill s : list) {
                _SkillRepo.save(s);
            }
        }
    }

    private void LoadSkillJobData() {
        if (_SkillJobRepo.count() == 0) {

            List<SkillJob> list = new SkillJobData(_JobRepo, _SkillRepo).Data();
            for (SkillJob s : list) {
                _SkillJobRepo.save(s);
            }
        }
    }

    private void LoadSubcriptionPlanCompanyData() {
        if (_SubcriptionPlanCompanyRepo.count() == 0) {

            List<SubcriptionPlanCompany> list = new SubcriptionPlanCompanyData(_CompanyRepo, _SubcriptionPlanRepo)
                    .Data();
            for (SubcriptionPlanCompany s : list) {
                _SubcriptionPlanCompanyRepo.save(s);
            }
        }
    }

    private void LoadSubcriptionPlanData() {
        if (_SubcriptionPlanRepo.count() == 0) {

            List<SubcriptionPlan> list = new SubcriptionPlanData().Data();
            for (SubcriptionPlan s : list) {
                _SubcriptionPlanRepo.save(s);
            }
        }
    }

}
