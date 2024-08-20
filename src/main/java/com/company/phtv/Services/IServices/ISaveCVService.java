package com.company.phtv.Services.IServices;

import java.util.List;

import com.company.phtv.Models.DTO.SaveCVDTO;

public interface ISaveCVService {
    List<SaveCVDTO> getAllSaveCV(int size, int page);
    String saveOrUnsaveCV(int application_id); 

}
