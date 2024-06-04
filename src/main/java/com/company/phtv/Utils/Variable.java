package com.company.phtv.Utils;

public interface Variable {
  public static HttpException notFound =  new HttpException(404,"not Found");
  public static HttpException tokenError =  new HttpException(400,"understand token request from client");
  public static HttpException emailOrPasswordIncorrect =  new HttpException(400, "Email or Password incorrect!!");
  public static HttpException emailExisting =  new HttpException(400, "Email existing in database. please change email!!");





}
