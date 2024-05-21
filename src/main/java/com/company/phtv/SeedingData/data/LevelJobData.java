package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.Industry;
import com.company.phtv.Models.Entity.Jobs;
import com.company.phtv.Models.Entity.Level;
import com.company.phtv.Models.Entity.LevelJob;

import java.util.ArrayList;
import java.util.List;

public class LevelJobData {
    public List<LevelJob> Data(){
        List<LevelJob> data = new ArrayList<>();
        data.add(new LevelJob(1,new Level(1),new Jobs(1)));
        data.add(new LevelJob(2,new Level(2),new Jobs(2)));
        data.add(new LevelJob(3,new Level(3),new Jobs(3)));

        return data;
    }
}
