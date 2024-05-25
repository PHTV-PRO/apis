package com.company.phtv.Services.IServices;
import com.company.phtv.Models.DTO.SubcriptionPlanDTO;
import com.company.phtv.Models.Request.RequestSubcriptionPlan;

import java.util.List;

public interface ISubcriptionPlanService {
    List<SubcriptionPlanDTO> GetAll();
    SubcriptionPlanDTO Create(RequestSubcriptionPlan requestSubcriptionPlan);
    SubcriptionPlanDTO Put(int id, RequestSubcriptionPlan requestSubcriptionPlan);

    SubcriptionPlanDTO Delete(int id);
    SubcriptionPlanDTO GetById(int id);
}
