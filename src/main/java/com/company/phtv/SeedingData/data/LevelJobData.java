package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.LevelJob;
import com.company.phtv.Repository.JobRepo;
import com.company.phtv.Repository.LevelRepo;

import java.util.ArrayList;
import java.util.List;

public class LevelJobData {
    private final JobRepo _JobRepo;
    private final LevelRepo _LevelRepo;

    public LevelJobData(JobRepo _JobRepo, LevelRepo _LevelRepo) {
        this._JobRepo = _JobRepo;
        this._LevelRepo = _LevelRepo;
    }

    @SuppressWarnings("deprecation")
    public List<LevelJob> Data() {

        List<LevelJob> data = new ArrayList<>();
        data.add(new LevelJob(1, _LevelRepo.getOne(1), _JobRepo.getOne(1)));
        data.add(new LevelJob(2, _LevelRepo.getOne(2), _JobRepo.getOne(2)));
        data.add(new LevelJob(3, _LevelRepo.getOne(3), _JobRepo.getOne(3)));

        return data;
    }
}
