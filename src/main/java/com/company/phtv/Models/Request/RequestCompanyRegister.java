package com.company.phtv.Models.Request;

import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.Nullable;

public class RequestCompanyRegister {
    @Nullable
    public int account_id;
    @Nullable
    public String email;
    @Nullable
    public String password;
    @Nullable
    public String name;
    @Nullable
    public String introduction;
    @Nullable
    public String benefit;
    @Nullable
    public String profession;
    @Nullable
    public String size;
    @Nullable
    public String link_website;
    @Nullable
    public String nationnality;
    @Nullable
    public int enable;
    @Nullable
    public String skill_id;
    @Nullable
    public String level_id;
    @Nullable
    public MultipartFile background;
    @Nullable
    public MultipartFile logo;
    @Nullable
    public String list_image;

}
