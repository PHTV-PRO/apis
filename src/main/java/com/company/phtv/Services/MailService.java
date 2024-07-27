package com.company.phtv.Services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Models.Entity.Jobs;
import com.company.phtv.Models.Entity.Mail;
import com.company.phtv.Models.Entity.SubcriptionPlanCompany;
import com.company.phtv.Services.IServices.IMailService;
import com.company.phtv.Utils.Variable;

@Service
public class MailService implements IMailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;

	public boolean SendMailForEmployer(String email, SubcriptionPlanCompany subcriptionPlanCompany) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
			helper.setSubject("PHTV4: BUY SUBCRIPTION PLAN");

			String html = Variable.GETHTMLSUBCRIPTIONPLAN(subcriptionPlanCompany);

			helper.setText(html, true);
			helper.setTo(email);
			helper.setFrom(sender);
			javaMailSender.send(mimeMessage);
			return true;
		} catch (Exception e) {
			throw Variable.ACTION_FAIL;
		}

	}

	public String SendMailWithAttachment(Mail details) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		try {
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(details.getRecipient());
			mimeMessageHelper.setSubject(
					details.getSubject());

			javaMailSender.send(mimeMessage);
			return "Mail sent Successfully";
		}

		catch (MessagingException e) {

			return "Error while sending mail!!!";
		}
	}

	public void SendMailForCreateJob(String email, Company c, Jobs job) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
			helper.setSubject("PHTV4: BUY SUBCRIPTION PLAN");

			String html = "";

			helper.setText(html, true);
			helper.setTo(email);
			helper.setFrom(sender);
			javaMailSender.send(mimeMessage);
		} catch (Exception e) {
		}
	}
}
