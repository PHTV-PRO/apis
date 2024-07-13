package com.company.phtv.Models.Map;

import com.company.phtv.Models.DTO.CVDTO;
import com.company.phtv.Models.Entity.CurriculumVitae;

public class CVMapping {
    public static CVDTO CVDTO(CurriculumVitae c) {
        CVDTO cvdto = new CVDTO();
        cvdto.setId(c.getId());
        cvdto.setFile_name(c.getFile_name());
        cvdto.setName(c.getName());
        cvdto.setCreate_at(c.getCreated_at());
        return cvdto;
    }

}
