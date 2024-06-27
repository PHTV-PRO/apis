package com.company.phtv.Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.phtv.Models.DTO.CVDTO;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.CurriculumVitae;
import com.company.phtv.Models.Map.CVMapping;
import com.company.phtv.Models.Request.RequestCV;
import com.company.phtv.Models.Request.RequestIndustry;
import com.company.phtv.Repository.AccountRepo;
import com.company.phtv.Repository.CVRepo;
import com.company.phtv.Services.IServices.ICVService;
import com.company.phtv.Utils.Variable;

@Service
public class CVService implements ICVService {

    @Autowired
    CVRepo _cvRepo;
    @Autowired
    AccountRepo _accountRepo;

    @Autowired
    CloudinaryService _cloudinaryService;

    @Override
    public CVDTO create(RequestCV requestCV) {
        CurriculumVitae CV = new CurriculumVitae();
        Account account = _accountRepo.findIdAccount(requestCV.getAccount_id());
        boolean checkAccountNotFound = account == null || account.getDeleted_at() != null;
        if (checkAccountNotFound) {
            throw Variable.ACCOUNT_NOT_FOUND;
        }
        if (requestCV.getUpload_file() != null) {
            try {
                // create image in cloudinary
                @SuppressWarnings("rawtypes")
                Map check = _cloudinaryService.uploadCV(requestCV.getUpload_file(), requestCV.toString());
                CV.setFile_name(check.get("public_id").toString());
                CV.setAccount(account);
                return new CVDTO();
            } catch (IOException e) {
                throw Variable.ACTION_FAIL;
            }
        }
        throw Variable.ACTION_FAIL;

    }

    @Override
    public CVDTO put(int id, RequestIndustry requestIndustry) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'put'");
    }

    @Override
    public CVDTO delete(int id) {
        CurriculumVitae CV = _cvRepo.findById(id).get();
        boolean checkExisting = CV == null || CV.getDeleted_at() != null;
        if (checkExisting) {
            throw Variable.NOT_FOUND;
        }
        CV.setDeleted_at(new Date());
        _cvRepo.save(CV);
        return new CVDTO();
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
    public List<CVDTO> getByAccount(int id) {
        Account account = _accountRepo.findIdAccount(id);
        List<CurriculumVitae> CVs = _cvRepo.findByAccount(account);
        if (CVs == null) {
            throw Variable.NOT_FOUND;
        }
        List<CVDTO> cvdto = new ArrayList<>();
        for (CurriculumVitae CV : CVs) {
            if (CV.getDeleted_at() == null) {
                cvdto.add(CVMapping.CVDTO(CV));
            }
        }
        if (cvdto.size() < 1) {
            throw Variable.NOT_FOUND;
        }
        return cvdto;
    }

}
