package com.company.phtv.Services.IServices;

import com.company.phtv.Models.Entity.Advertisement;
import com.company.phtv.Models.Request.RequestAdvertisement;

import java.util.List;

public interface IAdvertisementService {
    List<Advertisement> getAll();

    Advertisement create(RequestAdvertisement requestAdvertisement);

    Advertisement put(int id, RequestAdvertisement requestAdvertisement);

    String delete(int id);

    Advertisement getById(int id);

}
