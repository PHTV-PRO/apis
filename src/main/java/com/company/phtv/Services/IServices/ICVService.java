package com.company.phtv.Services.IServices;

import java.util.List;

import com.company.phtv.Models.DTO.CVDTO;
import com.company.phtv.Models.Request.RequestCV;
import com.company.phtv.Models.Request.RequestIndustry;

public interface ICVService {
    CVDTO create(RequestCV requestCV);

    CVDTO put(int id, RequestIndustry requestIndustry);

    CVDTO delete(int id);

    CVDTO getById(int id);
    List<CVDTO> getByAccount(int id);

}
