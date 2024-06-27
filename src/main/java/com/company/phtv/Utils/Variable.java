package com.company.phtv.Utils;

public interface Variable {
  public static HttpException NOT_FOUND = new HttpException(404, "not Found");
  public static HttpException TOKEN_ERROR = new HttpException(400, "understand token request from client");
  public static HttpException EMAIL_OR_PASSWORD_INCORRECT = new HttpException(400, "Email or Password incorrect!!");
  public static HttpException EMAIL_EXISTING = new HttpException(400,
      "Email existing in database. please change email!!");
  public static HttpException EMAIL_INVALID = new HttpException(400, "Enter Email invalid. please change email!!");
  public static HttpException PASSWORD_INVALID = new HttpException(400, "Enter Password invalid!!");
  public static Exception FAIL = new HttpException(500, "Action Fail");
  public static HttpException ADD_IMAGE_FAIL = new HttpException(500, "Action add image Fail");
  public static HttpException COMPANY_ACCOUNT_EXISTING = new HttpException(500,
      "The account already exists for this company. Please delete the existing company before creating a new one.");
  public static HttpException ACCOUNT_NOT_FOUND = new HttpException(404, "Account not found ");
  public static HttpException ACTION_FAIL = new HttpException(500, "Action Fail");
  public static String PATH_IMAGE = "https://res.cloudinary.com/dj7xlmndj/image/upload/v1719238271/";

}
