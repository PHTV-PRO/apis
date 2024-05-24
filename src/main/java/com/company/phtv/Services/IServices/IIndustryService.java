package com.company.phtv.Services.IServices;

import com.company.phtv.Models.DTO.IndustryDTO;
import com.company.phtv.Models.Request.RequestIndustry;

import java.util.List;

public interface IIndustryService {
    List<IndustryDTO> GetAll();
   IndustryDTO Create(RequestIndustry requestIndustry);
   IndustryDTO Put(int id, RequestIndustry requestIndustry);

   IndustryDTO Delete(int id);
   IndustryDTO GetById(int id);
}
