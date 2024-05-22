package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.SkillJob;
import com.company.phtv.Repository.JobRepo;
import com.company.phtv.Repository.SkillRepo;

import java.util.ArrayList;
import java.util.List;

public class SkillJobData {
    private final JobRepo _JobRepo;
    private final SkillRepo _SkillRepo;
    public SkillJobData(JobRepo _JobRepo, SkillRepo _SkillRepo) {
        this._JobRepo = _JobRepo;
        this._SkillRepo = _SkillRepo;
    }
    @SuppressWarnings("deprecation")
    public List<SkillJob> Data(){
        List<SkillJob> data = new ArrayList<>();
        data.add(new SkillJob(1,_SkillRepo.getOne(4),_JobRepo.getOne(1)));
        data.add(new SkillJob(2,_SkillRepo.getOne(5),_JobRepo.getOne(1)));
        data.add(new SkillJob(3,_SkillRepo.getOne(6),_JobRepo.getOne(1)));
        data.add(new SkillJob(4,_SkillRepo.getOne(8),_JobRepo.getOne(1)));
        data.add(new SkillJob(5,_SkillRepo.getOne(3),_JobRepo.getOne(2)));
        data.add(new SkillJob(6,_SkillRepo.getOne(21),_JobRepo.getOne(2)));
        data.add(new SkillJob(7,_SkillRepo.getOne(13),_JobRepo.getOne(2)));
        data.add(new SkillJob(8,_SkillRepo.getOne(1),_JobRepo.getOne(2)));
        data.add(new SkillJob(9,_SkillRepo.getOne(1),_JobRepo.getOne(2)));
        data.add(new SkillJob(10,_SkillRepo.getOne(1),_JobRepo.getOne(2)));

        return data;
    }
}
