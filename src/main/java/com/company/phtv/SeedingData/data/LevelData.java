package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.Level;

import java.util.ArrayList;
import java.util.List;

public class LevelData {
    public List<Level> Data(){
        List<Level> data = new ArrayList<>();
        data.add(new Level(1,"Intern"));
        data.add(new Level(2,"Fresher"));
        data.add(new Level(3,"Junior"));
        data.add(new Level(4,"Senior"));
        data.add(new Level(5,"Middle"));
        data.add(new Level(6,"Leader"));
        data.add(new Level(7,"Manager"));
        return data;
    }
}
