package com.company.phtv.Services.IServices;

import java.util.List;

import com.company.phtv.Models.DTO.ApplicationDTO;

public interface IApplicationService {
    List<ApplicationDTO> getByJob(int job_id, int size, int page);
}
