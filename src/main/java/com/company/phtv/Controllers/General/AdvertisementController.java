package com.company.phtv.Controllers.General;

import com.company.phtv.Controllers.BaseController;
import com.company.phtv.Models.DTO.LevelDTO;
import com.company.phtv.Models.Entity.Advertisement;
import com.company.phtv.Services.AdvertisementService;
import com.company.phtv.Services.LevelService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/general/advertisement")
public class AdvertisementController {
    @Autowired
    AdvertisementService _AdvertisementService;
    BaseController<Advertisement> _baseController = new BaseController<Advertisement>();
    BaseController<List<Advertisement>> _baseControllers = new BaseController<List<Advertisement>>();

    @GetMapping()
    public ResponseEntity<?> get() {
        try {
            return _baseControllers.success(_AdvertisementService.getAll());
        } catch (HttpException e) {
            return _baseControllers.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseControllers.error(null, 500, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        try {
            return _baseController.success(_AdvertisementService.getById(id));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

}
