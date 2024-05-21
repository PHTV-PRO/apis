package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.CityProvince;
import com.company.phtv.Models.Entity.Company;
import com.company.phtv.Models.Entity.Industry;
import com.company.phtv.Models.Entity.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationData {
    public List<Location> Data(){
        List<Location> data = new ArrayList<>();
        data.add(new Location(1, "Số 5 Lê Trung Nghĩa, Phường 12, Quận Tân Bình, Thành phố Hồ Chí Minh, Việt Nam",new Company(1),new CityProvince(1)));
        data.add(new Location(1, "Tầng 25, Tòa nhà Lim Tower, 9 - 11 Tôn Đức Thắng, Phường Bến Nghé, Quận 1, Thành phố Hồ Chí Minh",new Company(1),new CityProvince(1)));
        data.add(new Location(1, "Tòa nhà LPB, số 210 Trần Quang Khải, Phường Tràng Tiền, Quận Hoàn Kiếm, Thành phố Hà Nội",new Company(1),new CityProvince(2)));
        return data;
    }
}
