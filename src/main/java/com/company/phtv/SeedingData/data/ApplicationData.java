package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.*;

import java.util.ArrayList;
import java.util.List;

public class ApplicationData {
    public List<Application> Data(){
        List<Application> data = new ArrayList<>();
        data.add(new Application(1,"Hello",new Account(1),new Jobs(1),new CurriculumVitae(1)));
        data.add(new Application(2,"Hi",new Account(2),new Jobs(2),new CurriculumVitae(2)));
        data.add(new Application(3,"Say Hi",new Account(3),new Jobs(3),new CurriculumVitae(3)));
        return data;
    }
}

