package com.company.phtv.Services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.company.phtv.Models.Entity.Mail;
import com.company.phtv.Services.IServices.IMailService;
import com.company.phtv.Utils.HttpException;
import com.company.phtv.Utils.Variable;

@Service
public class MailService implements IMailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;

	public boolean SendMail(Mail details) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
			helper.setSubject("Welcome " + details.getRecipient());

			String html = "<!doctype html>\n" +
					"<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\"\n" +
					"      xmlns:th=\"http://www.thymeleaf.org\">\n" +
					"<head>\n" +
					"    <meta charset=\"UTF-8\">\n" +
					"    <meta name=\"viewport\"\n" +
					"          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n"
					+
					"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
					"    <title>Email</title>\n" +
					"</head>\n" +
					"<body>\n" +
					"<div>Welcome <b>" + details.getRecipient() + "</b></div>\n" +
					"\n" +
					"<a href=\"https://www.google.com\" target=\"_blank\">\n" +
					"    <button>Visit Google</button>\n" +
					"</a>\n" +
					"<div> Your username is <b>" + details.getRecipient() + "</b></div>\n" +
					"</body>\n" +
					"</html>\n";

			helper.setText(html, true);
			helper.setTo(details.getRecipient());
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
}
