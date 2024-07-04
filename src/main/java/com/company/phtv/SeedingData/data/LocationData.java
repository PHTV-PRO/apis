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
        data.add(new Location(2, "Tầng 25, Tòa nhà Lim Tower, 9 - 11 Tôn Đức Thắng, Phường Bến Nghé, Quận 1, Thành phố Hồ Chí Minh",_CompanyRepo.getOne(2),_CityProvinceRepo.getOne(1)));
        data.add(new Location(3, "Tòa nhà LPB, số 210 Trần Quang Khải, Phường Tràng Tiền, Quận Hoàn Kiếm, Thành phố Hà Nội",_CompanyRepo.getOne(3),_CityProvinceRepo.getOne(2)));
        data.add(new Location(4, "Tầng 14, Tháp A Vincom, 191 Bà Triệu, Phường Lê Đại Hành, Quận Hai Bà Trưng, Thành phố Hà Nội",_CompanyRepo.getOne(4),_CityProvinceRepo.getOne(2)));
        data.add(new Location(5, "Văn phòng Hà Nội: Tầng 9-10, tòa nhà Thái Nam, đường Dương Đình Nghệ, Phường Yên Hoà, Quận Cầu Giấy, Thành phố Hà Nội",_CompanyRepo.getOne(5),_CityProvinceRepo.getOne(2)));
        data.add(new Location(6, "Tầng 12A, Toà nhà AP Tower, 518B Điện Biên Phủ, Phường 21, Quận Bình Thạnh, Thành phố Hồ Chí Minh",_CompanyRepo.getOne(6),_CityProvinceRepo.getOne(1)));
        data.add(new Location(7, "67B phố Hàm Long, Phường Hàng Bài, Quận Hoàn Kiếm, Thành phố Hà Nội",_CompanyRepo.getOne(7),_CityProvinceRepo.getOne(2)));
        data.add(new Location(8, "Tòa nhà Bitexco, Ho Chi Minh City, Phường Bến Nghé, Quận 1, Thành phố Hồ Chí Minh",_CompanyRepo.getOne(8),_CityProvinceRepo.getOne(1)));
        data.add(new Location(9, "The Sun Avenue 28 Mai Chí Thọ, An Phú, Quận 2, Phường An Phú, Thành phố Thủ Đức, Thành phố Hồ Chí Minh",_CompanyRepo.getOne(9),_CityProvinceRepo.getOne(1)));
        data.add(new Location(10, "Số 75 phố Yên Ninh, Phường Quán Thánh, Quận Ba Đình, Thành phố Hà Nội",_CompanyRepo.getOne(10),_CityProvinceRepo.getOne(2)));

        return data;
    }
}
