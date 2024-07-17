package com.company.phtv.Services;

import com.company.phtv.Models.DTO.SubcriptionPlanDTO;
import com.company.phtv.Models.DTO.SubcriptionPlanForEmployer;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Models.Entity.SubcriptionPlan;
import com.company.phtv.Models.Entity.SubcriptionPlanCompany;
import com.company.phtv.Models.Map.SubcriptionPlanMapping;
import com.company.phtv.Models.Request.RequestSubcriptionPlan;
import com.company.phtv.Repository.CompanyRepo;
import com.company.phtv.Repository.SubcriptionPlanRepo;
import com.company.phtv.Services.IServices.ISubcriptionPlanService;
import com.company.phtv.Utils.CurrentAccount;
import com.company.phtv.Utils.Variable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SubcriptionPlanService implements ISubcriptionPlanService {
    @Autowired
    SubcriptionPlanRepo _subcriptionPlanRepo;

    @Autowired
    CompanyRepo _companyRepo;

    @Autowired
    CurrentAccount _currentAccount;

    @Override
    public List<SubcriptionPlanDTO> getAll() {
        List<SubcriptionPlan> subcriptionPlans = _subcriptionPlanRepo.findAll();
        List<SubcriptionPlanDTO> subcriptionPlanDTOS = new ArrayList<>();
        for (int i = 0; i < subcriptionPlans.size(); i++) {
            if (subcriptionPlans.get(i).getDeleted_at() == null) {
                subcriptionPlanDTOS.add(SubcriptionPlanMapping.subcriptionPlanDTO(subcriptionPlans.get(i)));
            }
        }
        return subcriptionPlanDTOS;
    }

    @Override
    public SubcriptionPlanDTO create(RequestSubcriptionPlan requestSubcriptionPlan) {
        SubcriptionPlan subcriptionPlan = SubcriptionPlanMapping.SubcriptionPlan(requestSubcriptionPlan);
        _subcriptionPlanRepo.save(subcriptionPlan);
        return (SubcriptionPlanDTO) SubcriptionPlanMapping.subcriptionPlanDTO(subcriptionPlan);
    }

    @Override
    public SubcriptionPlanDTO put(int id, RequestSubcriptionPlan requestSubcriptionPlan) {
        SubcriptionPlan getSubcriptionPlan = _subcriptionPlanRepo.findIdBySubcriptionPlan(id);
        boolean checkSubcriptionPlanNotFound = (getSubcriptionPlan != null
                && getSubcriptionPlan.getDeleted_at() == null)
                        ? false
                        : true;
        if (checkSubcriptionPlanNotFound) {
            throw Variable.NOT_FOUND;
        }
        SubcriptionPlan subcriptionPlan = SubcriptionPlanMapping.SubcriptionPlanPut(requestSubcriptionPlan,
                getSubcriptionPlan);
        subcriptionPlan.setId(id);
        _subcriptionPlanRepo.save(subcriptionPlan);
        return (SubcriptionPlanDTO) SubcriptionPlanMapping.subcriptionPlanDTO(subcriptionPlan);
    }

    @Override
    public SubcriptionPlanDTO delete(int id) {
        SubcriptionPlan subcriptionPlan = _subcriptionPlanRepo.findIdBySubcriptionPlan(id);
        boolean checkSubcriptionPlanNotFound = (subcriptionPlan != null && subcriptionPlan.getDeleted_at() == null)
                ? false
                : true;
        if (checkSubcriptionPlanNotFound) {
            throw Variable.NOT_FOUND;
        }
        subcriptionPlan.setDeleted_at(new Date());
        _subcriptionPlanRepo.save(subcriptionPlan);
        return null;
    }

    @Override
    public SubcriptionPlanDTO getById(int id) {
        SubcriptionPlan subcriptionPlan = _subcriptionPlanRepo.findIdBySubcriptionPlan(id);
        boolean checkSubcriptionPlanNotFound = (subcriptionPlan != null && subcriptionPlan.getDeleted_at() == null)
                ? false
                : true;
        if (checkSubcriptionPlanNotFound) {
            throw Variable.NOT_FOUND;
        }
        SubcriptionPlanDTO subcriptionPlanDTO = SubcriptionPlanMapping.subcriptionPlanDTO(subcriptionPlan);
        return subcriptionPlanDTO;
    }

    public SubcriptionPlanForEmployer getByAccountAuto() {
        Account account = _currentAccount.getAccount();
        boolean checkAccountNotFound = (account != null && account.getDeleted_at() == null) ? false : true;
        if (account == null || checkAccountNotFound) {
            throw Variable.NOT_FOUND;
        }
        Company company = null;
        for (Company c : account.getCompanies()) {
            if (c.getDeleted_at() == null) {
                company = c;
            }
        }
        SubcriptionPlanForEmployer subcriptionPlan = new SubcriptionPlanForEmployer();
        if (company != null && company.getDeleted_at() == null) {
            List<SubcriptionPlanDTO> sbp = new ArrayList<>();
            for (SubcriptionPlanCompany sub : company.getSubcritionPlanCompanies()) {
                if( sub.getDeleted_at() == null){
                    SubcriptionPlanDTO subcriptionPlanDTO =   SubcriptionPlanMapping.subcriptionPlanDTO(sub.getSubscription_plan());
                    subcriptionPlanDTO.setEnd_date(sub.getEnd_date());
                    subcriptionPlanDTO.setStart_date(sub.getStart_date());
                    boolean checkSubcritionplan = (sub.getStart_date().before(Date.from(Instant.now()))
                                    && sub.getEnd_date().after(Date.from(Instant.now())));
                    if (checkSubcritionplan) {
                        subcriptionPlan.setSubcriptionPlanDTO(subcriptionPlanDTO);
                    } else {
                        sbp.add(subcriptionPlanDTO);
                    }
                }
               
            }
            subcriptionPlan.setSubcriptionPlanDTOs(sbp);
        }
        return subcriptionPlan;
    }

}
