package com.company.phtv.Services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.phtv.Models.DTO.ApplicationDTO;
import com.company.phtv.Models.Entity.Application;
import com.company.phtv.Models.Entity.Jobs;
import com.company.phtv.Models.Map.AccountMapping;
import com.company.phtv.Models.Map.CVMapping;
import com.company.phtv.Repository.AccountRepo;
import com.company.phtv.Repository.ApplicationRepo;
import com.company.phtv.Repository.JobRepo;
import com.company.phtv.Services.IServices.IApplicationService;
import com.company.phtv.Utils.CurrentAccount;
import com.company.phtv.Utils.Variable;

@Service
public class ApplicationService implements IApplicationService {

    @Autowired
    ApplicationRepo _applicationRepo;
    @Autowired
    AccountRepo _accountRepo;

    CloudinaryService _cloudinaryService;

    @Autowired
    JobRepo _jobRepo;

    @Autowired
    CurrentAccount _currentAccount;

    @Override
    public List<ApplicationDTO> getByJob(int job_id, int size, int page) {
        Jobs job = _jobRepo.findJobId(job_id);
        if (job == null || job.getDeleted_at() != null) {
            throw Variable.ACTION_FAIL;
        }
        List<ApplicationDTO> listApplications = new ArrayList<>();
        for (Application application : job.getApplications()) {
            if (application.getDeleted_at() != null) {
                continue;
            }
            ApplicationDTO applicationDTO = new ApplicationDTO();
            applicationDTO.setAccount(AccountMapping.accountDTO(application.getAccount()));
            applicationDTO.setId(application.getId());
            applicationDTO.setNote(application.getNote());
            applicationDTO.setCv(CVMapping.CVDTO(application.getCurriculumVitae()));
            listApplications.add(applicationDTO);
        }
        return pagination(size, page, listApplications);

    }

    List<ApplicationDTO> pagination(int size, int page, List<ApplicationDTO> applications) {
        if (size <= 0 || page < 0) {
            applications = new ArrayList<>();
            return applications;
        }
        if (applications == null || applications.isEmpty()) {
            return applications;
        }
        int startIndex = Math.max(0, (page - 1) * size);
        int endIndex = Math.min(startIndex + size, applications.size());
        if (startIndex > applications.size()) {
            applications = new ArrayList<>();
            return applications;
        }
        if (endIndex > applications.size()) {
            return applications.subList(startIndex, applications.size() - 1);
        }
        return applications.subList(startIndex, endIndex);
    }

}
