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
import com.company.phtv.Utils.Pagination;
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

    Pagination<ApplicationDTO> pagination = new Pagination<>();

    @Override
    public List<ApplicationDTO> getByJob(int job_id, int size, int page) {
        // STEP 1: get data job
        Jobs job = _jobRepo.findJobId(job_id);
        if (job == null || job.getDeleted_at() != null) {
            // check job
            // job not found
            throw Variable.ACTION_FAIL;
        }
        List<ApplicationDTO> listApplications = new ArrayList<>();
        for (Application application : job.getApplications()) {
            if (application.getDeleted_at() != null) {
                continue;
            }
            // STEP 2: set data to dto
            ApplicationDTO applicationDTO = new ApplicationDTO();
            applicationDTO.setAccount(AccountMapping.accountDTO(application.getAccount()));
            applicationDTO.setId(application.getId());
            applicationDTO.setNote(application.getNote());
            applicationDTO.setCv(CVMapping.CVDTO(application.getCurriculumVitae()));
            listApplications.add(applicationDTO);
        }
        return pagination.pagination(size, page, listApplications);

    }
}
