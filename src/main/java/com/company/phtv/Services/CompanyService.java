package com.company.phtv.Services;

import com.company.phtv.Models.DTO.CompanyDTO;
import com.company.phtv.Models.DTO.JobDTO;
import com.company.phtv.Models.DTO.LocationDTO;
import com.company.phtv.Models.DTO.SkillDTO;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Models.Entity.FollowCompany;
import com.company.phtv.Models.Entity.ImageCompany;
import com.company.phtv.Models.Entity.Jobs;
import com.company.phtv.Models.Entity.Location;
import com.company.phtv.Models.Entity.SkillCompany;
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
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

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
    public List<CompanyDTO> getAll() {
        List<Company> companies = _companyRepo.findAll();
        return companyDTOMapping(companies);
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
        if (requestCompany.UploadFileBackground != null) {
            try {
                // create image in cloudinary
                @SuppressWarnings("rawtypes")
                Map check = _cloudinaryService.uploadImage(requestCompany.UploadFileBackground,
                        company.getBackground_image());
                company.setBackground_image(Variable.PATH_IMAGE + check.get("public_id").toString());
            } catch (IOException e) {
                throw Variable.ADD_IMAGE_FAIL;
            }
        }
        if (requestCompany.UploadFileLogo != null) {
            try {
                // create image in cloudinary
                @SuppressWarnings("rawtypes")
                Map check = _cloudinaryService.uploadImage(requestCompany.UploadFileLogo, company.getLogo_image());
                company.setLogo_image(Variable.PATH_IMAGE + check.get("public_id").toString());
            } catch (IOException e) {
                throw Variable.ADD_IMAGE_FAIL;
            }
        }
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
        if (requestCompany.UploadFileBackground != null) {
            try {
                // create image in cloudinary
                @SuppressWarnings("rawtypes")
                Map check = _cloudinaryService.uploadImage(requestCompany.UploadFileBackground,
                        getCompany.getBackground_image());
                getCompany.setBackground_image(Variable.PATH_IMAGE + check.get("public_id").toString());
            } catch (IOException e) {
                throw Variable.ADD_IMAGE_FAIL;
            }
        }
        if (requestCompany.UploadFileLogo != null) {
            try {
                // create image in cloudinary
                @SuppressWarnings("rawtypes")
                Map check = _cloudinaryService.uploadImage(requestCompany.UploadFileLogo, getCompany.getLogo_image());
                getCompany.setLogo_image(Variable.PATH_IMAGE + check.get("public_id").toString());
            } catch (IOException e) {
                throw Variable.ADD_IMAGE_FAIL;
            }
        }
        Company company = CompanyMapping.CompanyPut(requestCompany, getCompany);
        if (requestCompany.getAccount_id() != 0) {
            company.setAccount(_accountRepo.getAccountById(requestCompany.getAccount_id()));
        }
        company.setId(id);
        String inputString = requestCompany.fileCompany;
        String[] listImage = inputString.split(",data");
        List<ImageCompany> imageCompanies = _companyImageRepo.findByCompany(company);
        for (int i = 0; i < listImage.length; i++) {
            MultipartFile file;
            if (i != 0) {
                listImage[i] = "data" + listImage[i];
            }
            file = convertBase64ToMultipart(listImage[i]);
            Boolean checkExistImage = true;
            for (ImageCompany imageC : imageCompanies) {
                if (imageC.getImage() == Variable.PATH_IMAGE + file.getName()) {
                    checkExistImage = false;
                }
            }
            if (checkExistImage) {
                try {
                    // create image in cloudinary
                    @SuppressWarnings("rawtypes")
                    Map check = _cloudinaryService.uploadImage(file, getCompany.getLogo_image());
                    ImageCompany ic = new ImageCompany();
                    ic.setImage(Variable.PATH_IMAGE + check.get("public_id").toString());
                    ic.setCompany(company);
                    _companyImageRepo.save(ic);
                } catch (IOException e) {
                    throw Variable.ADD_IMAGE_FAIL;
                }
            }

        }

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
    public List<CompanyDTO> companyContractAll() {
        List<Company> companies = _companyRepo.findAll();
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
        return companyDTOS;
    }

    public List<CompanyDTO> companyApplicationMost() {
        List<Company> companies = _companyRepo.findAll();
        List<CompanyDTO> companyDTOS = new ArrayList<>();
        if (companies.size() < 5) {
            return companyDTOMapping(companies);
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
            while (!pq.isEmpty() && companyDTOS.size() < 5) {
                Map.Entry<Company, Integer> entry = pq.poll();
                Company company = entry.getKey();
                CompanyDTO companyDTO = CompanyMapping.CompanyDTO(company);
                if (_currentAccount.getAccount() != null) {
                    FollowCompany followCompany = _followCompanyRepo
                            .findByAccountAndCompany(_currentAccount.getAccount(), company);
                    if (followCompany != null) {
                        companyDTO.setCompany_is_save(true);
                    }
                }
                companyDTOS.add(companyDTO);
            }
            return companyDTOS;
        }
        return companyDTOMapping(companies);

    }

    public CompanyDTO followCompany(RequestFollowCompany requestCompany) {
        Account account = _currentAccount.getAccount();
        Company company = _companyRepo.findCompanyById(Integer.parseInt(requestCompany.getCompany_id()));
        if (account == null || company == null) {
            throw Variable.ACTION_FAIL;
        }
        FollowCompany followCompany = _followCompanyRepo.findByAccountAndCompany(account, company);
        if (followCompany != null) {
            throw Variable.COMPANY_CONFLIG;
        }
        _followCompanyRepo.save(new FollowCompany(0, company, account));
        return new CompanyDTO();
    }

    public List<CompanyDTO> CompanyByProvenceAndIndustry(RequestSearchCompany requestSearchCompany) {
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
            return companyDTOs;
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
                return companyDTOMapping(companies);
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
                return companyDTOMapping(companies);
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
                return companyDTOMapping(companies);
            default:
                return companyDTOMapping(getCompanies);
        }

    }

    List<CompanyDTO> companyDTOMapping(List<Company> companies) {
        List<CompanyDTO> companyDTOS = new ArrayList<>();
        for (int i = 0; i < companies.size(); i++) {
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
                companyDTOS.add(companyDTO);
            }
        }
        return companyDTOS;
    }

    public File convertBase64ToImage(String base64String) {
        String imageData = base64String.substring(base64String.indexOf(",") + 1);
        byte[] decodedBytes = Base64.getDecoder().decode(imageData);

        String imageFormat = base64String.substring(base64String.indexOf(":") + 1, base64String.indexOf(";"));
        String fileName = "image." + (imageFormat != null ? imageFormat.split("/")[1] : "png");

        File imageFile = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(imageFile)) {
            fos.write(decodedBytes);
        } catch (Exception e) {

        }

        return imageFile;
    }

    public MultipartFile convertBase64ToMultipart(String base64String) {
        String imageData = base64String.substring(base64String.indexOf(",") + 1);
        byte[] decodedBytes = Base64.getDecoder().decode(imageData);

        String imageFormat = base64String.substring(base64String.indexOf(":") + 1, base64String.indexOf(";"));
        String fileName = "image." + (imageFormat != null ? imageFormat.split("/")[1] : "png");
        String contentType = imageFormat != null ? "image/" + imageFormat.split("/")[1] : "application/octet-stream";

        MultipartFile multipartFile = new MockMultipartFile(fileName, fileName, contentType, decodedBytes);
        return multipartFile;
    }

}
