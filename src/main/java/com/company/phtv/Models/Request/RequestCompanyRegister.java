package com.company.phtv.Models.Request;

import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestCompanyRegister {
    // need
    @Nullable
    public String email;
    @Nullable
    public String password;
    @Nullable
    public String name_company;
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
    public String location;
    @Nullable
    public MultipartFile background_image;
    // need
    @Nullable
    public MultipartFile logo_image;

}
