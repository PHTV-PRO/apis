package com.company.phtv.Services.IServices;

import com.company.phtv.Models.DTO.LevelDTO;
import com.company.phtv.Models.Entity.Level;
import com.company.phtv.Models.Request.RequestIndustry;
import com.company.phtv.Models.Request.RequestLevel;

import java.util.List;

public interface ILevelService {
    List<LevelDTO> GetAll();
    LevelDTO Create(RequestLevel requestLevel);
    LevelDTO Put(int id, RequestLevel requestLevel);
    LevelDTO Delete(int id);
    LevelDTO GetById(int id);
}
