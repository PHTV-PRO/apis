package com.company.phtv.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.company.phtv.Models.Entity.SubcriptionPlanCompany;
import com.company.phtv.Models.Request.RequestDataCreateCV;

public interface Variable {
    // 400
    public static HttpException TOKEN_ERROR = new HttpException(400, "Understand token request from client");
    public static HttpException EMAIL_OR_PASSWORD_INCORRECT = new HttpException(400, "Email or Password incorrect!!");
    public static HttpException EMAIL_INVALID = new HttpException(400, "Enter Email invalid. please change email!!");
    public static HttpException PASSWORD_INVALID = new HttpException(400, "Enter Password invalid!!");
    public static HttpException LIMIT_JOB = new HttpException(400, "Company not create more job!!");
    public static HttpException SUBCRIPTION_PLAN_NOT_FOUND = new HttpException(400,
            "Company not create job, because subcription plan not found!!");
    // 401
    public static HttpException NOT_SIGNED_IN = new HttpException(401, "Not signed in");
    // 404
    public static HttpException NOT_FOUND = new HttpException(404, "Not Found");
    public static HttpException ACCOUNT_NOT_FOUND = new HttpException(404, "Account not found ");
    // 409
    public static HttpException EMAIL_EXISTING = new HttpException(409,
            "Email existing in database. please change email!!");
    public static HttpException SUBCRIPTION_PLAN_EXIST = new HttpException(409, "SubScription plan existing");
    public static HttpException COMPANY_CONFLIG = new HttpException(409, "Company is follow!!");
    public static HttpException CONFLIG = new HttpException(409, "Action Confliig data!!");
    // 500
    public static Exception FAIL = new HttpException(500, "Action Fail");
    public static HttpException ADD_IMAGE_FAIL = new HttpException(500, "Action add image Fail");
    public static HttpException COMPANY_ACCOUNT_EXISTING = new HttpException(500,
            "The account already exists for this company. Please delete the existing company before creating a new one.");
    public static HttpException ACTION_FAIL = new HttpException(500, "Action Fail");
    public static String PATH_IMAGE = "https://res.cloudinary.com/dj7xlmndj/image/upload/v1719238271/";

    // date
    public static String MONTH = "MONTH";
    public static String YEAR = "YEAR";

    // mail
    public static String GETHTMLSUBCRIPTIONPLAN(SubcriptionPlanCompany subcriptionPlanCompany) {
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
                "    \t<div style=\"text-align:center\" ><h3>CODE: <span class=\"font-bold\"> "
                + (subcriptionPlanCompany.getSubscription_plan() != null
                        ? subcriptionPlanCompany.getSubscription_plan().getName()
                        : "")
                + "</span></h3></div>\n" + //
                "        <div>Decripton: "
                + (subcriptionPlanCompany.getSubscription_plan() != null
                        ? subcriptionPlanCompany.getSubscription_plan().getDescription()
                        : "")
                + "</div>\n" + //
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
                "      <td style=\" background-color:#eee; \">"
                + (subcriptionPlanCompany.getSubscription_plan() != null
                        ? Integer.toString(subcriptionPlanCompany.getSubscription_plan().getExpiry())
                        : "0")
                + " days</td>\n" + //
                "      <td style=\" background-color:#eee; \">"
                + (subcriptionPlanCompany.getSubscription_plan() != null
                        ? Float.toString(subcriptionPlanCompany.getSubscription_plan().getPrice())
                        : "0")
                + " $</td>\n" + //
                "      <td style=\" background-color:#eee; \">"
                + (subcriptionPlanCompany.getSubscription_plan() != null
                        ? Integer.toString(subcriptionPlanCompany.getSubscription_plan().getExpiry())
                        : "0")
                + " jobs</td>\n" + //
                "      <td style=\" background-color:#eee; \">"
                + (subcriptionPlanCompany != null ? dateFormat.format(subcriptionPlanCompany.getStart_date())
                        : "--/--/--")
                + " - "
                + (subcriptionPlanCompany != null ? dateFormat.format(subcriptionPlanCompany.getEnd_date())
                        : "--/--/--")
                + "</td>\n" + //
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

    // mail
    public static String GET_HTML_CV(RequestDataCreateCV data) {

        return "<!DOCTYPE html>\r\n" + //
                "<html lang=\"en\" style=\" font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;\">\r\n"
                + //
                "\r\n" + //
                "<head>\r\n" + //
                "  <meta charset=\"UTF-8\" />\r\n" + //
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n" + //
                "  <title>Document</title>\r\n" + //
                " \r\n" + //
                "</head>\r\n" + //
                "\r\n" + //
                "<div style=\"width: 690px; margin: auto;\">\r\n" + //
                "  <div  >\r\n" + //
                "    <span  style=\" width: 800px;\">\r\n" + //
                "      <h1><b>" + data.getName() + "</b></h1>\r\n" + //
                "      <span style=\"width: 70%;\">\r\n" + //
                "        " + data.getDecription() + "\r\n" + //
                "      </span>\r\n" + //
                "    </span>\r\n" + //
                "  </div>\r\n" + //
                "  <br/>\r\n" + //
                "\r\n" + //
                "  \r\n" + //
                "\r\n" + //
                "  <div >\r\n" + //
                "    <span style=\"margin-right:70px\"  >\r\n" + //
                "      <img src=\"https://w7.pngwing.com/pngs/226/248/png-transparent-computer-icons-envelope-mail-envelope-miscellaneous-angle-triangle.png\" width=\"30px\" style=\"margin-left: -7px;\" alt=\"mail\" />\r\n"
                + //
                "      " + data.getEmail() + "\r\n" + //
                "    </span>\r\n" + //
                "    <span  style=\"margin-right:70px\">\r\n" + //
                "      <img src=\"https://w7.pngwing.com/pngs/24/51/png-transparent-map-location-pin-icon-thumbnail.png\" width=\"17px\" alt=\"mail\" />\r\n"
                + //
                "      " + data.getAddress() + "\r\n" + //
                "    </span>\r\n" + //
                "    <span >\r\n" + //
                "      <img src=\"https://w7.pngwing.com/pngs/731/937/png-transparent-mobile-phones-telephone-handset-phone-icon-miscellaneous-angle-telephone-call-thumbnail.png\" width=\"13px\" alt=\"mail\" />\r\n"
                + //
                "      " + data.getPhone() + "\r\n" + //
                "    </span>\r\n" + //
                "  </div>\r\n" + //
                "  <hr style=\"margin: 8px 0\" />\r\n" + //
                "  <div style=\"margin-top: 10px;\">\r\n" + //
                "    <h3><b>Education</b></h3>\r\n" + //
                "    <div class=\"d-flex justify-content-between\">\r\n" + //
                "      <div style=\"font-size: 18px\"><b>" + data.getName_school() + "</b></div>\r\n" + //
                "      <div><b>" + data.getYear() + "</b></div>\r\n" + //
                "    </div>\r\n" + //
                "    <div class=\"text-secondary\">\r\n" + //
                "      " + data.getMajor() + "\r\n" + //
                "    </div>\r\n" + //
                "  </div>\r\n" + //
                "\r\n" + //
                "  <hr style=\"margin: 8px 0\" />\r\n" + //
                "  <div class=\"mt-4\">\r\n" + //
                "    <h3><b>Skills :</b></h3> \r\n" + //
                "    <span>" + data.getSkill() + "</span>\r\n" + //
                "    \r\n" + //
                "\r\n" + //
                "  </div>\r\n" + //
                "  <hr style=\"margin: 8px 0\" />\r\n" + //
                "  <div style=\"margin-top: 10px;\">\r\n" + //
                "    <div class=\"d-flex align-items-baseline\">\r\n" + //
                "      <h3><b>Projects</b></h3>\r\n" + //
                "    </div>\r\n" + //
                "\r\n" + //
                "    <div style=\" padding: 0px 10px 3px 10px;border-radius: 12px; border: solid;\">\r\n" + //
                "        <div ><h3 class=\"card-title\">" + data.getName_project() + "</h3></div>\r\n" + //
                "           <h5 > "+data.getContent()+"</h5>\r\n" + //
                "        <p class=\"card-text\">Skill:\r\n" + //
                "          <span >" + data.getSkill_project() + "</span>\r\n"
                + //
                "        </p>\r\n" + //
                "    </div>\r\n" + //
                "  </div>\r\n" + //
                "</div>\r\n" + //
                "</html>";
    }

}
