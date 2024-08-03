package com.company.phtv.Models.Request;

import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestCompanyRegister {
    // need
    public String email;
    public String password;
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
    public String nationnality;
    @Nullable
    public int enable;
    @Nullable
    public String skill_id;
    @Nullable
    public String level_id;
    @Nullable
    public MultipartFile background;
    // need
    public MultipartFile logo;
    @Nullable
    public String list_image;

}
