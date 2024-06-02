package com.company.phtv.Services;

import com.company.phtv.Controllers.BaseController.BaseController;
import com.company.phtv.Models.DTO.IndustryDTO;
import com.company.phtv.Models.Entity.Industry;
import com.company.phtv.Models.Map.IndustryMapping;
import com.company.phtv.Models.Request.RequestIndustry;
import com.company.phtv.Repository.IndustryRepo;
import com.company.phtv.Services.IServices.IIndustryService;
import com.company.phtv.Utils.HttpException;
import com.company.phtv.Utils.Variable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class IndustryService implements IIndustryService {
    @Autowired
    IndustryRepo _industryRepo;

    @Override
    public List<IndustryDTO> GetAll() {
        List<Industry> industries = _industryRepo.findAll();
        List<IndustryDTO> industryDTOs = new ArrayList<>();
        if (industries.size() < 1) {
            throw new HttpException(404, "Not Found");
        }
        for (Industry i : industries) {
            industryDTOs.add(IndustryMapping.industryDTO(i));
        }
        return industryDTOs;
    }

    @Override
    public IndustryDTO Create(RequestIndustry requestIndustry) {
        Industry industry = IndustryMapping.Industry(requestIndustry);
        _industryRepo.save(industry);
        return (IndustryDTO) IndustryMapping.industryDTO(industry);
    }

    @Override
    public IndustryDTO Put(int id, RequestIndustry requestIndustry) {
        Industry getIndustry = _industryRepo.findIdIndustry(id);
        Industry industry = IndustryMapping.IndustryPut(requestIndustry, getIndustry);
        industry.setId(id);
        _industryRepo.save(industry);
        return (IndustryDTO) IndustryMapping.industryDTO(industry);
    }

    @Override
    public IndustryDTO Delete(int id) {
        Industry industry = _industryRepo.findIdIndustry(id);
        boolean checkIndustryNotFound = (industry != null && industry.getDeleted_at() == null) ? false : true;
        if (checkIndustryNotFound) {
            throw Variable.notFound;
        }
        industry.setDeleted_at(new Date());
        _industryRepo.save(industry);
        return null;
    }

    @Override
    public IndustryDTO GetById(int id) {
        Industry industry = _industryRepo.findIdIndustry(id);
        IndustryDTO industryDTO = IndustryMapping.industryDTO(industry);
        return industryDTO;
    }

}
