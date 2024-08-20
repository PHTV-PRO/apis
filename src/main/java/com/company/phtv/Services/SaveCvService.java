package com.company.phtv.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.phtv.Models.DTO.CVDTO;
import com.company.phtv.Models.DTO.SaveCVDTO;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.Application;
import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Models.Entity.SaveCV;
import com.company.phtv.Models.Map.AccountMapping;
import com.company.phtv.Models.Map.JobMapping;
import com.company.phtv.Repository.ApplicationRepo;
import com.company.phtv.Repository.SaveCvRepo;
import com.company.phtv.Services.IServices.ISaveCVService;
import com.company.phtv.Utils.CurrentAccount;
import com.company.phtv.Utils.Pagination;
import com.company.phtv.Utils.Variable;

@Service
public class SaveCvService implements ISaveCVService {

    @Autowired
    ApplicationRepo _applicationRepo;

    @Autowired
    SaveCvRepo _saveCvRepo;

    @Autowired
    CurrentAccount _currentAccount;

    Pagination<SaveCVDTO> pagination = new Pagination<>();

    @Override
    public List<SaveCVDTO> getAllSaveCV(int size, int page) {
        Account account = _currentAccount.getAccount();
        if (account == null) {
            throw Variable.ACCOUNT_NOT_FOUND;
        }
        Company company = null;
        for (Company c : account.getCompanies()) {
            if (c.getDeleted_at() == null) {
                company = c;
            }
        }
        if (company == null) {
            throw Variable.COMPANY_NOT_FOUND;
        }
        List<SaveCVDTO> saveCVDTOs = new ArrayList<>();
        List<SaveCV> saveCVs = _saveCvRepo.findAllByCompany(company);
        for (SaveCV saveCV : saveCVs) {
            SaveCVDTO saveCVDTO = new SaveCVDTO();
            CVDTO cvdto = new CVDTO();

            cvdto.setFile_name(saveCV.getApplication().getCurriculumVitae().getFile_name());
            cvdto.setName(saveCV.getApplication().getCurriculumVitae().getName());
            cvdto.setId(saveCV.getApplication().getCurriculumVitae().getId());

            saveCVDTO.setId(saveCV.getId());
            saveCVDTO.setCv(cvdto);
            saveCVDTO.setAccount(AccountMapping.accountDTO(saveCV.getApplication().getCurriculumVitae().getAccount()));
            saveCVDTO.setJob(JobMapping.getJob(saveCV.getApplication().getJobs()));
            saveCVDTO.setDate_applied(saveCV.getApplication().getCreated_at());

            saveCVDTOs.add(saveCVDTO);
        }

        return pagination.pagination(size,page,saveCVDTOs);
    }

    @Override
    public String saveOrUnsaveCV(int application_id) {
        Account account = _currentAccount.getAccount();
        if (account == null) {
            throw Variable.ACCOUNT_NOT_FOUND;
        }
        Company company = null;
        for (Company c : account.getCompanies()) {
            if (c.getDeleted_at() == null) {
                company = c;
            }
        }
        if (company == null) {
            throw Variable.COMPANY_NOT_FOUND;
        }
        Application application = _applicationRepo.getOne(application_id);
        if (application == null || application.getDeleted_at() != null) {
            throw Variable.NOT_FOUND;
        }
        SaveCV saveCV = _saveCvRepo.findByCompanyAndCv(company, application);
        if (saveCV == null) {
            _saveCvRepo.save(new SaveCV(company, application));
            return "Save Success!";
        }
        _saveCvRepo.delete(saveCV);
        return "UnSave Success!";
    }

}
