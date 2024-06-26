package com.company.phtv.Models.Map;

import com.company.phtv.Models.DTO.CompanyDTO;
import com.company.phtv.Models.Entity.Account;
import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Models.Request.RequestCompany;

public class CompanyMapping {
    public static CompanyDTO CompanyDTO(Company c) {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(c.getId());
        companyDTO.setName(c.getName());
        companyDTO.setIntroduction(c.getIntroduction());
        companyDTO.setBenefit(c.getBenefit());
        companyDTO.setProfession(c.getProfession());
        companyDTO.setSize_min(c.getSize_min());
        companyDTO.setSize_max(c.getSize_max());
        // companyDTO.setSkill(c.getSkill());
        companyDTO.setLink_website(c.getLink_website());
        companyDTO.setNationnality(c.getNationnality());
        companyDTO.setLogo_image(c.getLogo_image());
        companyDTO.setBackground_image(c.getBackground_image());
        companyDTO.setEnable(c.getEnable());
        companyDTO.setAccount(AccountMapping.accountDTO(c.getAccount()));

        return companyDTO;

    }

    public static Company Company(RequestCompany c) {

        Company company = new Company();
        company.setName(c.getName());
        company.setIntroduction(c.getIntroduction());
        company.setBenefit(c.getBenefit());
        company.setProfession(c.getProfession());
        company.setSize_min(c.getSize_min());
        company.setSize_max(c.getSize_max());
        company.setLink_website(c.getLink_website());
        company.setNationnality(c.getNationnality());
//        company.setLogo_image(c.getLogo_image());
//        company.setBackground_image(c.getBackground_image());
        company.setEnable(c.getEnable());
        return company;
    }

    public static Company CompanyPut(RequestCompany rc, Company c) {
        if (rc.getName() != null) {
            c.setName(rc.getName());
        }
        if (rc.getIntroduction() != null) {
            c.setIntroduction(rc.getIntroduction());
        }
        if (rc.getBenefit() != null) {
            c.setBenefit(rc.getBenefit());
        }
        if (rc.getProfession() != null) {
            c.setProfession(rc.getProfession());
        }
        if (rc.getSize_min() != null) {
            c.setSize_min(rc.getSize_min());
        }
        if (rc.getSize_max() != null) {
            c.setSize_max(rc.getSize_max());
        }
        if (rc.getLink_website() != null) {
            c.setLink_website(rc.getLink_website());
        }
        if (rc.getNationnality() != null) {
            c.setNationnality(rc.getNationnality());
        }
        if (c.getLogo_image() != null) {
            c.setLogo_image(c.getLogo_image());
        }
        if (c.getBackground_image() != null) {
            c.setBackground_image(c.getBackground_image());
        }
        if (rc.getEnable() != 0) {
            c.setEnable(rc.getEnable());
        }
        if (rc.getAccount_id() != 0) {
            c.setAccount(new Account(0));
        }
        return c;
    }
}
