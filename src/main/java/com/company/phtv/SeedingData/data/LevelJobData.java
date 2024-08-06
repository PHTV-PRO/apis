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
        // 4 vtri
        data.add(new LevelJob(4, _LevelRepo.getOne(4), _JobRepo.getOne(4)));
        // 3 vtri
        data.add(new LevelJob(5, _LevelRepo.getOne(4), _JobRepo.getOne(5)));
        data.add(new LevelJob(6, _LevelRepo.getOne(2), _JobRepo.getOne(6)));
        // 2 vtri
        data.add(new LevelJob(7, _LevelRepo.getOne(5), _JobRepo.getOne(7)));
        data.add(new LevelJob(8, _LevelRepo.getOne(4), _JobRepo.getOne(8)));
        // 4 vtri
        data.add(new LevelJob(9, _LevelRepo.getOne(2), _JobRepo.getOne(9)));
        //2 vtri
        data.add(new LevelJob(10, _LevelRepo.getOne(3), _JobRepo.getOne(10)));

        data.add(new LevelJob(11, _LevelRepo.getOne(1), _JobRepo.getOne(11)));
        data.add(new LevelJob(12, _LevelRepo.getOne(2), _JobRepo.getOne(12)));
        data.add(new LevelJob(13, _LevelRepo.getOne(3), _JobRepo.getOne(13)));
        // 4 vtri
        data.add(new LevelJob(14, _LevelRepo.getOne(4), _JobRepo.getOne(14)));
        // 3 vtri
        data.add(new LevelJob(15, _LevelRepo.getOne(4), _JobRepo.getOne(15)));
        data.add(new LevelJob(16, _LevelRepo.getOne(2), _JobRepo.getOne(16)));
        // 2 vtri
        data.add(new LevelJob(17, _LevelRepo.getOne(5), _JobRepo.getOne(17)));
        data.add(new LevelJob(18, _LevelRepo.getOne(4), _JobRepo.getOne(18)));
        // 4 vtri
        data.add(new LevelJob(19, _LevelRepo.getOne(2), _JobRepo.getOne(19)));
        //2 vtri
        data.add(new LevelJob(20, _LevelRepo.getOne(3), _JobRepo.getOne(20)));

        data.add(new LevelJob(21, _LevelRepo.getOne(1), _JobRepo.getOne(21)));
        data.add(new LevelJob(22, _LevelRepo.getOne(2), _JobRepo.getOne(22)));
        data.add(new LevelJob(23, _LevelRepo.getOne(3), _JobRepo.getOne(23)));
        // 4 vtri
        data.add(new LevelJob(24, _LevelRepo.getOne(4), _JobRepo.getOne(24)));
        // 3 vtri
        data.add(new LevelJob(25, _LevelRepo.getOne(4), _JobRepo.getOne(25)));
        data.add(new LevelJob(26, _LevelRepo.getOne(2), _JobRepo.getOne(26)));
        // 2 vtri
        data.add(new LevelJob(27, _LevelRepo.getOne(5), _JobRepo.getOne(27)));
        data.add(new LevelJob(28, _LevelRepo.getOne(4), _JobRepo.getOne(28)));
        // 4 vtri
        data.add(new LevelJob(29, _LevelRepo.getOne(2), _JobRepo.getOne(29)));
        //2 vtri
        data.add(new LevelJob(30, _LevelRepo.getOne(3), _JobRepo.getOne(30)));
        return data;
    }
}
