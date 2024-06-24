package com.company.phtv.Services.IServices;

import com.company.phtv.Models.DTO.SearchAll;

public interface IAdminService {
    SearchAll searchByName(String name);
}
