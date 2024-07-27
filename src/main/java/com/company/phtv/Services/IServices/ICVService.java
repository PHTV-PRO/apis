package com.company.phtv.Services.IServices;

import java.util.List;


import com.company.phtv.Models.DTO.CVDTO;
import com.company.phtv.Models.Request.RequestCV;

public interface ICVService {
    CVDTO create(RequestCV requestCV);

    CVDTO delete(int id);

    CVDTO getById(int id);

    List<CVDTO> getByAccount(int size, int page);

}
