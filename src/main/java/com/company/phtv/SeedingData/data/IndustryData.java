package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.Industry;

import java.util.ArrayList;
import java.util.List;

public class IndustryData {
    public List<Industry> Data(){
        List<Industry> data = new ArrayList<>();
        data.add(new Industry(1,"Thiết Kế Đồ Hoạ"));
        data.add(new Industry(2,"Front End Developer"));
        data.add(new Industry(3,"Back End Developer"));
        return data;
    }
}
