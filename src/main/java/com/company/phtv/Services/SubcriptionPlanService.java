package com.company.phtv.Services;

import com.company.phtv.Models.DTO.IndustryDTO;
import com.company.phtv.Models.DTO.SubcriptionPlanDTO;
import com.company.phtv.Models.Entity.Industry;
import com.company.phtv.Models.Entity.SubcriptionPlan;
import com.company.phtv.Models.Map.IndustryMapping;
import com.company.phtv.Models.Map.SubcriptionPlanMapping;
import com.company.phtv.Models.Request.RequestIndustry;
import com.company.phtv.Models.Request.RequestSubcriptionPlan;
import com.company.phtv.Repository.SubcriptionPlanRepo;
import com.company.phtv.Services.IServices.ISubcriptionPlanService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubcriptionPlanService implements ISubcriptionPlanService {
    @Autowired
    SubcriptionPlanRepo _subcriptionPlanRepo;
    @Override
    public List<SubcriptionPlanDTO> GetAll() {
        List<SubcriptionPlan> subcriptionPlans = _subcriptionPlanRepo.findAll();
        List<SubcriptionPlanDTO> subcriptionPlanDTOS = new ArrayList<>();
        if (subcriptionPlans.size() < 1) {
            throw new HttpException(404, "Not Found");
        }
        for (SubcriptionPlan s : subcriptionPlans) {
            subcriptionPlanDTOS.add(SubcriptionPlanMapping.subcriptionPlanDTO(s));
        }
        return subcriptionPlanDTOS;
    }

    @Override
    public SubcriptionPlanDTO Create(RequestSubcriptionPlan requestSubcriptionPlan) {
        SubcriptionPlan subcriptionPlan = SubcriptionPlanMapping.SubcriptionPlan(requestSubcriptionPlan);
        _subcriptionPlanRepo.save(subcriptionPlan);
        return (SubcriptionPlanDTO) SubcriptionPlanMapping.subcriptionPlanDTO(subcriptionPlan);
    }

    @Override
    public SubcriptionPlanDTO Put(int id, RequestSubcriptionPlan requestSubcriptionPlan) {
        SubcriptionPlan getSubcriptionPlan = _subcriptionPlanRepo.findIdBySubcriptionPlan(id);
        SubcriptionPlan subcriptionPlan = SubcriptionPlanMapping.SubcriptionPlanPut(requestSubcriptionPlan,getSubcriptionPlan);
        subcriptionPlan.setId(id);
        _subcriptionPlanRepo.save(subcriptionPlan);
        return (SubcriptionPlanDTO) SubcriptionPlanMapping.subcriptionPlanDTO(subcriptionPlan);
    }

    @Override
    public SubcriptionPlanDTO Delete(int id) {
        _subcriptionPlanRepo.deleteById(id);
        return null;
    }

    @Override
    public SubcriptionPlanDTO GetById(int id) {
        SubcriptionPlan subcriptionPlan = _subcriptionPlanRepo.findIdBySubcriptionPlan(id);
        SubcriptionPlanDTO subcriptionPlanDTO = SubcriptionPlanMapping.subcriptionPlanDTO(subcriptionPlan);
        return subcriptionPlanDTO;
    }



}
