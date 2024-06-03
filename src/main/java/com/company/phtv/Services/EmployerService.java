package com.company.phtv.Services;

import com.company.phtv.Models.DTO.EmployerDTO;
import com.company.phtv.Models.Entity.Employer;
import com.company.phtv.Models.Map.EmployerMapping;
import com.company.phtv.Models.Request.RequestEmployer;
import com.company.phtv.Repository.EmployerRepo;
import com.company.phtv.Services.IServices.IEmployerService;
import com.company.phtv.Utils.Variable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployerService implements IEmployerService {
    @Autowired
    EmployerRepo _employerRepo;

    @Override
    public List<EmployerDTO> GetAll() {
        List<Employer> employers = _employerRepo.findAll();
        List<EmployerDTO> employerDTOS = new ArrayList<>();
         for (int i = 0; i < employers.size(); i++) {
            if (employers.get(i).getDeleted_at() == null) {
                employerDTOS.add(EmployerMapping.employerDTO(employers.get(i)));
            }
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
        boolean checkEmployerNotFound = (getEmployer != null && getEmployer.getDeleted_at() == null) ? false : true;
        if (checkEmployerNotFound) {
            throw Variable.notFound;
        }
        Employer employer = EmployerMapping.EmployerPut(requestEmployer, getEmployer);
        employer.setId(id);
        _employerRepo.save(employer);
        return (EmployerDTO) EmployerMapping.employerDTO(employer);
    }

    @Override
    public EmployerDTO Delete(int id) {
        Employer employer = _employerRepo.findIdEmployer(id);
        boolean checkEmployerNotFound = (employer != null && employer.getDeleted_at() == null) ? false : true;
        if (checkEmployerNotFound) {
            throw Variable.notFound;
        }
        employer.setDeleted_at(new Date());
        _employerRepo.save(employer);
        return null;
    }

    @Override
    public EmployerDTO GetById(int id) {
        Employer employer = _employerRepo.findIdEmployer(id);
        boolean checkEmployerNotFound = (employer != null && employer.getDeleted_at() == null) ? false : true;
        if (checkEmployerNotFound) {
            throw Variable.notFound;
        }
        EmployerDTO employerDTO = EmployerMapping.employerDTO(employer);
        return employerDTO;
    }
}
