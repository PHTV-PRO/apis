package com.company.phtv.Services;

import com.company.phtv.Models.DTO.EmployerDTO;
import com.company.phtv.Models.DTO.IndustryDTO;
import com.company.phtv.Models.Entity.Employer;
import com.company.phtv.Models.Entity.Industry;
import com.company.phtv.Models.Map.EmployerMapping;
import com.company.phtv.Models.Map.IndustryMapping;
import com.company.phtv.Models.Request.RequestEmployer;
import com.company.phtv.Repository.EmployerRepo;
import com.company.phtv.Services.IServices.IEmployerService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployerService implements IEmployerService {
    @Autowired
    EmployerRepo _employerRepo;
    @Override
    public List<EmployerDTO> GetAll() {
        List<Employer> employers = _employerRepo.findAll();
        List<EmployerDTO> employerDTOS = new ArrayList<>();
        if(employers.size() < 1){
            throw new HttpException(404,"Not Found");
        }
        for(Employer e : employers){
            employerDTOS.add(EmployerMapping.employerDTO(e));
        }
        return employerDTOS;
    }

    @Override
    public EmployerDTO Create(RequestEmployer requestEmployer) {
        Employer employer = EmployerMapping.employer(requestEmployer);
        _employerRepo.save(employer);
        return (EmployerDTO) EmployerMapping.employerDTO(employer);
    }

    @Override
    public EmployerDTO Put(int id, RequestEmployer requestEmployer) {
        Employer getEmployer = _employerRepo.findIdEmployer(id);
        Employer employer = EmployerMapping.EmployerPut(requestEmployer,getEmployer);
        employer.setId(id);
        _employerRepo.save(employer);
        return (EmployerDTO) EmployerMapping.employerDTO(employer);
    }

    @Override
    public EmployerDTO Delete(int id) {
        _employerRepo.deleteById(id);
        return null;
    }

    @Override
    public EmployerDTO GetById(int id) {
        Employer employer = _employerRepo.findIdEmployer(id);
        EmployerDTO employerDTO = EmployerMapping.employerDTO(employer);
        return employerDTO;
    }
}
