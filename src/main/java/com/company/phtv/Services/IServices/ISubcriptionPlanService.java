package com.company.phtv.Services.IServices;

import com.company.phtv.Models.DTO.SubcriptionPlanDTO;
import com.company.phtv.Models.Request.RequestSubcriptionPlan;

import java.util.List;

public interface ISubcriptionPlanService {
    List<SubcriptionPlanDTO> getAll();

    SubcriptionPlanDTO create(RequestSubcriptionPlan requestSubcriptionPlan);

    SubcriptionPlanDTO put(int id, RequestSubcriptionPlan requestSubcriptionPlan);

    String delete(int id);

    SubcriptionPlanDTO getById(int id);
}
