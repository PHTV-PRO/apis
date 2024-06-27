package com.company.phtv.Services.IServices;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.company.phtv.Models.DTO.CVDTO;

public interface ICVService {
    CVDTO create(MultipartFile file);

    CVDTO delete(int id);

    CVDTO getById(int id);

    List<CVDTO> getByAccount();

}
