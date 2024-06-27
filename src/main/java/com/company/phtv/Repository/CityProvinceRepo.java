package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.CityProvince;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityProvinceRepo extends JpaRepository<CityProvince,Integer> {
    CityProvince getLocationById (int id);
    @Query("select ci from CityProvince ci Where id = ?1 ORDER BY ci.created_at DESC")
    CityProvince findIdCityProvince(int id);
}
