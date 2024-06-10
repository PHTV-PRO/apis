package com.company.phtv.Services.IServices;

import com.company.phtv.Models.DTO.IndustryDTO;
import com.company.phtv.Models.Request.RequestIndustry;

import java.util.List;

public interface IIndustryService {
    List<IndustryDTO> getAll();

    IndustryDTO create(RequestIndustry requestIndustry);

    IndustryDTO put(int id, RequestIndustry requestIndustry);

    IndustryDTO delete(int id);

    IndustryDTO getById(int id);
}
