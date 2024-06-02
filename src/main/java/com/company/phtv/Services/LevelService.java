package com.company.phtv.Services;

import com.company.phtv.Models.DTO.IndustryDTO;
import com.company.phtv.Models.DTO.LevelDTO;
import com.company.phtv.Models.Entity.Level;
import com.company.phtv.Models.Map.LevelMapping;
import com.company.phtv.Models.Request.RequestLevel;
import com.company.phtv.Repository.LevelRepo;
import com.company.phtv.Services.IServices.ILevelService;
import com.company.phtv.Utils.HttpException;
import com.company.phtv.Utils.Variable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LevelService implements ILevelService {
    @Autowired
    LevelRepo _levelRepo;

    @Override
    public List<LevelDTO> GetAll() {
        List<Level> levels = _levelRepo.findAll();
        List<LevelDTO> levelDTOs = new ArrayList<>();
        if (levels.size() < 1) {
            throw new HttpException(404, "Not Found");
        }
        for (Level l : levels) {
            levelDTOs.add(LevelMapping.levelDTO(l));
        }
        return levelDTOs;
    }

    @Override
    public LevelDTO Create(RequestLevel requestLevel) {
        Level level = LevelMapping.level(requestLevel);
        _levelRepo.save(level);
        return (LevelDTO) LevelMapping.levelDTO(level);
    }

    @Override
    public LevelDTO Put(int id, RequestLevel requestLevel) {
        Level getLevel = _levelRepo.findIdByLevel(id);
        Level level = LevelMapping.levelPut(requestLevel, getLevel);
        level.setId(id);
        _levelRepo.save(level);
        return (LevelDTO) LevelMapping.levelDTO(level);
    }

    @Override
    public LevelDTO Delete(int id) {
        Level level = _levelRepo.findIdByLevel(id);
        boolean checkLevelNotFound = (level != null && level.getDeleted_at() == null) ? false : true;
        if (checkLevelNotFound) {
            throw Variable.notFound;
        }
        level.setDeleted_at(new Date());
        _levelRepo.save(level);
        return null;
    }

    @Override
    public LevelDTO GetById(int id) {
        Level level = _levelRepo.findIdByLevel(id);
        LevelDTO levelDTO = LevelMapping.levelDTO(level);
        return levelDTO;
    }
}
