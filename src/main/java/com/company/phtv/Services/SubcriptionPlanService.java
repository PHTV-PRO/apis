package com.company.phtv.Services;

import com.company.phtv.Models.DTO.SubcriptionPlanCompanyDTO;
import com.company.phtv.Models.DTO.SubcriptionPlanDTO;
import com.company.phtv.Models.Entity.SubcriptionPlan;
import com.company.phtv.Models.Entity.SubcriptionPlanCompany;
import com.company.phtv.Models.Map.SubcriptionPlanCompanyMapping;
import com.company.phtv.Models.Map.SubcriptionPlanMapping;
import com.company.phtv.Models.Request.RequestSubcriptionPlan;
import com.company.phtv.Repository.SubcriptionPlanCompanyRepo;
import com.company.phtv.Repository.SubcriptionPlanRepo;
import com.company.phtv.Services.IServices.ISubcriptionPlanService;
import com.company.phtv.Utils.Variable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SubcriptionPlanService implements ISubcriptionPlanService {
    @Autowired
    SubcriptionPlanRepo _subcriptionPlanRepo;
    SubcriptionPlanCompanyRepo _subcriptionPlanCompanyRepo;

    @Override
    public List<SubcriptionPlanDTO> getAll() {
        List<SubcriptionPlan> subcriptionPlans = _subcriptionPlanRepo.findAll();
        List<SubcriptionPlanDTO> subcriptionPlanDTOS = new ArrayList<>();
        for (int i = 0; i < subcriptionPlans.size(); i++) {
            if (subcriptionPlans.get(i).getDeleted_at() == null) {
                List<SubcriptionPlanCompanyDTO> subcriptionPlanCompanyDTOS = new ArrayList<>();
                SubcriptionPlanDTO subcriptionPlanDTO = SubcriptionPlanMapping.subcriptionPlanDTO(subcriptionPlans.get(i));
                for(SubcriptionPlanCompany sc : subcriptionPlans.get(i).getSubcritionPlanCompanies()){
                    SubcriptionPlanCompanyDTO spc   = SubcriptionPlanCompanyMapping.getSubcriptionPlanCompany(sc);
                    subcriptionPlanCompanyDTOS.add(spc);
                };
                subcriptionPlanDTO.setSubcriptionPlanCompanies(subcriptionPlanCompanyDTOS);
                subcriptionPlanDTOS.add(subcriptionPlanDTO);
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

}
