package com.company.phtv.Utils;

public interface Variable {
  public static HttpException notFound = new HttpException(404, "not Found");
  public static HttpException tokenError = new HttpException(400, "understand token request from client");
  public static HttpException emailOrPasswordIncorrect = new HttpException(400, "Email or Password incorrect!!");
  public static HttpException emailExisting = new HttpException(400,
      "Email existing in database. please change email!!");
  public static HttpException emailInvalid = new HttpException(400, "Enter Email invalid. please change email!!");
  public static HttpException passwordInvalid = new HttpException(400, "Enter Password invalid!!");
  public static Exception Fail = new HttpException(500, "Action Fail");
  public static HttpException AddImageFail = new HttpException(500, "Action add image Fail");
  public static HttpException CompanyOfAccountIsExist = new HttpException(500, "The account already exists for this company. Please delete the existing company before creating a new one.");
  public static HttpException AccountNotFound = new HttpException(404, "Account not found ");
public static HttpException EmailExisted = new HttpException(404, "Account is existing ");;


}
