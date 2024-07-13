package com.company.phtv.Services.IServices;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.company.phtv.Models.DTO.CVDTO;
import com.company.phtv.Models.Request.RequestCV;

public interface ICVService {
    CVDTO create(RequestCV requestCV);

    CVDTO delete(int id);

    CVDTO getById(int id);

    List<CVDTO> getByAccount();

}
