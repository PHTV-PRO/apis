package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.Level;

import java.util.ArrayList;
import java.util.List;

public class LevelData {
    public List<Level> Data(){
        List<Level> data = new ArrayList<>();
        data.add(new Level(1,"Nhân Viên"));
        data.add(new Level(2,"Fresher"));
        data.add(new Level(3,"Middle, Senior"));
        return data;
    }
}
