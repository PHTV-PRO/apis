package com.company.phtv.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.company.phtv.Models.Entity.SubcriptionPlanCompany;

public interface Variable {
  public static HttpException NOT_FOUND = new HttpException(404, "not Found");
  public static HttpException TOKEN_ERROR = new HttpException(400, "understand token request from client");
  public static HttpException EMAIL_OR_PASSWORD_INCORRECT = new HttpException(400, "Email or Password incorrect!!");
  public static HttpException EMAIL_EXISTING = new HttpException(409,
      "Email existing in database. please change email!!");
  public static HttpException COMPANY_CONFLIG = new HttpException(409, "Company is follow!!");
  public static HttpException EMAIL_INVALID = new HttpException(400, "Enter Email invalid. please change email!!");
  public static HttpException PASSWORD_INVALID = new HttpException(400, "Enter Password invalid!!");
  public static Exception FAIL = new HttpException(500, "Action Fail");
  public static HttpException ADD_IMAGE_FAIL = new HttpException(500, "Action add image Fail");
  public static HttpException COMPANY_ACCOUNT_EXISTING = new HttpException(500,
      "The account already exists for this company. Please delete the existing company before creating a new one.");
  public static HttpException ACCOUNT_NOT_FOUND = new HttpException(404, "Account not found ");
  public static HttpException ACTION_FAIL = new HttpException(500, "Action Fail");
  public static String PATH_IMAGE = "https://res.cloudinary.com/dj7xlmndj/image/upload/v1719238271/";

  public static HttpException SUBCRIPTION_PLAN_EXIST = new HttpException(409, "SubScription plan existing");
  public static HttpException LIMIT_JOB = new HttpException(400, "Company not create more job!!");
  public static HttpException SUBCRIPTION_PLAN_NOT_FOUND = new HttpException(400, "Company not create job, because subcription plan not found!!");

  public static HttpException CONFLIG = new HttpException(409, "Action Confliig data!!");

  public static String MONTH= "MONTH";
  public static String YEAR= "YEAR";

  public static String GETHTMLSUBCRIPTIONPLAN( SubcriptionPlanCompany subcriptionPlanCompany){
    DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");

    return "<!DOCTYPE html>\n" + //
            "<html>\n" + //
            "<head>\n" + //
            "</head>\n" + //
            "<body>\n" + //
            "\n" + //
            "<div style=\"margin-left:20%\">\n" + //
            "\t<div style=\"width:80%\">\n" + //
            "    <hr/>\n" + //
            "    \t<div style=\"text-align:center\" ><h3>CODE: <span class=\"font-bold\"> "+(subcriptionPlanCompany.getSubscription_plan()!=null? subcriptionPlanCompany.getSubscription_plan().getName():"")+"</span></h3></div>\n" + //
            "        <div>Decripton: "+(subcriptionPlanCompany.getSubscription_plan()!=null?subcriptionPlanCompany.getSubscription_plan().getDescription():"")+"</div>\n" + //
            "        \n" + //
            "        <div><table style=\"margin-left:30%\" class=\"zigzag\">\n" + //
            "  <thead>\n" + //
            "    <tr>\n" + //
            "      <th style=\"background-color:#009;color:#fff;\" class=\"header\">Expiry</th>\n" + //
            "      <th style=\"background-color:#009;color:#fff;\" class=\"header\">Price</th>\n" + //
            "      <th style=\"background-color:#009;color:#fff;\" class=\"header\">Available create job</th>\n" + //
            "      <th style=\"background-color:#009;color:#fff;\" class=\"header\">Date</th>\n" + //
            "    </tr>\n" + //
            "  </thead>\n" + //
            "  <tbody>\n" + //
            "    <tr>\n" + //
            "      <td style=\" background-color:#eee; \">"+(subcriptionPlanCompany.getSubscription_plan()!=null?Integer.toString(subcriptionPlanCompany.getSubscription_plan().getExpiry()) :"0")+" days</td>\n" + //
            "      <td style=\" background-color:#eee; \">"+(subcriptionPlanCompany.getSubscription_plan()!=null?Float.toString(subcriptionPlanCompany.getSubscription_plan().getPrice()) :"0")+" $</td>\n" + //
            "      <td style=\" background-color:#eee; \">"+(subcriptionPlanCompany.getSubscription_plan()!=null?Integer.toString(subcriptionPlanCompany.getSubscription_plan().getExpiry()) :"0")+" jobs</td>\n" + //
            "      <td style=\" background-color:#eee; \">"+(subcriptionPlanCompany!=null?dateFormat.format(subcriptionPlanCompany.getStart_date()):"--/--/--")+" - "+(subcriptionPlanCompany!=null?dateFormat.format(subcriptionPlanCompany.getEnd_date()):"--/--/--")+"</td>\n" + //
            "    </tr>\n" + //
            "    <tr>\n" + //
            "      <td style=\" background-color:#eee; \" colspan=\"4\"></td>\n" + //
            "    </tr>\n" + //
            "  </tbody>\n" + //
            "</table><hr/>\n" + //
            "<div>Thank your for use we service!!</div>\n" + //
            "</div>\n" + //
            "<div><hr/>\n" + //
            "Contact details:\n" + //
            "<div>email: tranphu.thpthht@gmail.com</div>\n" + //
            "<div>sdt: 0123456789</div>\n" + //
            "<div>Link web: http://localhost:3000/</div>\n" + //
            "<div>Address:  Phu Nhuan District, Ho Chi Minh City</div><hr/>\n" + //
            "</div>\n" + //
            "\n" + //
            "         </div>\n" + //
            "</div>\n" + //
            "\n" + //
            "</body>\n" + //
            "</html>\n" + //
            "";
  }

}
