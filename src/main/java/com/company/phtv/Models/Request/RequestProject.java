package com.company.phtv.Models.Request;

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
public class RequestProject {
    @Nullable
    public String name_project;
    @Nullable
    public String content;
    @Nullable
    public String skill_project;
}
