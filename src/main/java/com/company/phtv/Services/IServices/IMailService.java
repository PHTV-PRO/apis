package com.company.phtv.Services.IServices;

import com.company.phtv.Models.Entity.Mail;

public interface IMailService {
       boolean SendMail(Mail details);
 
       String SendMailWithAttachment(Mail details);
}
