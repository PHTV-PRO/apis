package com.company.phtv.Services.IServices;

import com.company.phtv.Models.DTO.LevelDTO;
import com.company.phtv.Models.Request.RequestLevel;

import java.util.List;

public interface ILevelService {
    List<LevelDTO> getAll();

    LevelDTO create(RequestLevel requestLevel);

    LevelDTO put(int id, RequestLevel requestLevel);

    LevelDTO delete(int id);

    LevelDTO getById(int id);
}
