package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.Location;
import com.company.phtv.Repository.CityProvinceRepo;
import com.company.phtv.Repository.CompanyRepo;

import java.util.ArrayList;
import java.util.List;

public class LocationData {
    private final CompanyRepo _CompanyRepo;
    private final CityProvinceRepo _CityProvinceRepo;
    public LocationData(CompanyRepo _CompanyRepo, CityProvinceRepo _CityProvinceRepo) {
        this._CompanyRepo = _CompanyRepo;
        this._CityProvinceRepo = _CityProvinceRepo;
    }
    @SuppressWarnings("deprecation")
    public List<Location> Data(){
        List<Location> data = new ArrayList<>();
        data.add(new Location(1, "Số 5 Lê Trung Nghĩa, Phường 12, Quận Tân Bình, Thành phố Hồ Chí Minh, Việt Nam",_CompanyRepo.getOne(1),_CityProvinceRepo.getOne(1)));
        data.add(new Location(2, "Tầng 25, Tòa nhà Lim Tower, 9 - 11 Tôn Đức Thắng, Phường Bến Nghé, Quận 1, Thành phố Hồ Chí Minh",_CompanyRepo.getOne(1),_CityProvinceRepo.getOne(1)));
        data.add(new Location(3, "Tòa nhà LPB, số 210 Trần Quang Khải, Phường Tràng Tiền, Quận Hoàn Kiếm, Thành phố Hà Nội",_CompanyRepo.getOne(1),_CityProvinceRepo.getOne(2)));
        return data;
    }
}
