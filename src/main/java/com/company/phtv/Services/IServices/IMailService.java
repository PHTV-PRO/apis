package com.company.phtv.Services.IServices;

import com.company.phtv.Models.Entity.Mail;
import com.company.phtv.Models.Entity.SubcriptionPlanCompany;

public interface IMailService {
       boolean SendMailForEmployer(String email, SubcriptionPlanCompany subcriptionPlanCompany);
 
       String SendMailWithAttachment(Mail details);
}
