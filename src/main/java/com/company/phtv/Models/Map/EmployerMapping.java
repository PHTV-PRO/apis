package com.company.phtv.Models.Map;

import com.company.phtv.Models.DTO.EmployerDTO;
import com.company.phtv.Models.Entity.Employer;
import com.company.phtv.Models.Request.RequestEmployer;


public class EmployerMapping {

    public static EmployerDTO employerDTO(Employer e){
        EmployerDTO employerDTO = new EmployerDTO();
        employerDTO.setId(e.getId());
        employerDTO.setAddress(e.getAddress());
        employerDTO.setEmail(e.getEmail());
        employerDTO.setName(e.getName());
        employerDTO.setPassword(e.getPassword());
        employerDTO.setRole(e.getRole());
        return employerDTO;
    }

    public static Employer employer(RequestEmployer e){
        Employer employer = new Employer();
        employer.setAddress(e.getAddress());
        employer.setEmail(e.getEmail());
        employer.setName(e.getName());
        employer.setPassword(e.getPassword());
        employer.setRole(e.getRole().EMPLOYER);
        return employer;
    }

    public static  Employer EmployerPut(RequestEmployer re,Employer e){
        if(re.getAddress() != null){
            e.setAddress(re.getAddress());
        }
        if(re.getEmail() != null){
            e.setEmail(re.getEmail());
        }
        if(re.getName() != null){
            e.setName(re.getName());
        }
        if(re.getPassword() != null){
            e.setPassword(re.getPassword());
        }
        return  e;
    }
}
