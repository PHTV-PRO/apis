package com.company.phtv.Services;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.company.phtv.Models.DTO.CVDTO;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.CurriculumVitae;
import com.company.phtv.Models.Map.CVMapping;
import com.company.phtv.Models.Request.RequestCV;
import com.company.phtv.Repository.AccountRepo;
import com.company.phtv.Repository.CVRepo;
import com.company.phtv.Services.IServices.ICVService;
import com.company.phtv.Utils.CurrentAccount;
import com.company.phtv.Utils.Variable;

@Service
public class CVService implements ICVService {

    @Autowired
    CVRepo _cvRepo;
    @Autowired
    AccountRepo _accountRepo;

    @Autowired
    CloudinaryService _cloudinaryService;

    @Autowired
    CurrentAccount _currentAccount;

    @Override
    public CVDTO create(RequestCV requestCV) {
        CurriculumVitae CV = new CurriculumVitae();
        Account account = _currentAccount.getAccount();
        boolean checkAccountNotFound = account == null || account.getDeleted_at() != null;
        if (checkAccountNotFound) {
            throw Variable.ACCOUNT_NOT_FOUND;
        }
        if (requestCV.getFile() != null) {
            try {
                // create image in cloudinary
                @SuppressWarnings("rawtypes")
                Map check = _cloudinaryService.uploadCV(requestCV.getFile(), requestCV.getFile().toString());
                CV.setFile_name(check.get("public_id").toString());
                CV.setAccount(account);
                CV.setName(requestCV.getName());
                _cvRepo.save(CV);
                return new CVDTO();
            } catch (IOException e) {
                throw Variable.ACTION_FAIL;
            }
        }
        throw Variable.ACTION_FAIL;

    }

    @Override
    public CVDTO delete(int id) {
        CurriculumVitae CV = _cvRepo.findById(id).get();
        boolean checkExisting = CV == null || CV.getDeleted_at() != null;
        if (checkExisting) {
            throw Variable.NOT_FOUND;
        }
        if (CV.getApplications().size() > 0) {
            CV.setDeleted_at(Date.from(Instant.now()));
            _cvRepo.save(CV);
            return null;
        }
        CV.setDeleted_at(new Date());
        _cvRepo.delete(CV);
        return null;
    }

    @Override
    public CVDTO getById(int id) {
        CurriculumVitae CV = _cvRepo.findById(id).get();
        boolean checkExisting = CV == null || CV.getDeleted_at() != null;
        if (checkExisting) {
            throw Variable.NOT_FOUND;
        }
        return CVMapping.CVDTO(CV);
    }

    @Override
    public List<CVDTO> getByAccount() {
        Account account = _currentAccount.getAccount();
        if(account==null){
            throw Variable.ACCOUNT_NOT_FOUND;
        }
        List<CurriculumVitae> CVs = _cvRepo.findByAccount(account);
        List<CVDTO> cvdto = new ArrayList<>();
        for (CurriculumVitae CV : CVs) {
            if (CV.getDeleted_at() == null) {
                cvdto.add(CVMapping.CVDTO(CV));
            }
        }
        return cvdto;
    }

}
