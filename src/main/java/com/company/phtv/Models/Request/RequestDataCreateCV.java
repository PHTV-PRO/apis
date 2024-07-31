package com.company.phtv.Models.Request;

import com.company.phtv.Enums.Role;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestDataCreateCV {

    // candidate
    @Nullable
    public String name;
    @Nullable
    public String name_cv;
    @Nullable
    public String decription;
    @Nullable
    public String email;
    @Nullable
    public String address;
    @Nullable
    public String phone;
    @Nullable
    public String skill;

    // schooll
    @Nullable
    public String name_school;
    @Nullable
    public String year;
    @Nullable
    public String major;

    // project
    @Nullable
    public List<RequestProject> projects;

}
