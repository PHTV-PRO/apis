package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.*;
import com.company.phtv.Repository.AccountRepo;
import com.company.phtv.Repository.CVRepo;
import com.company.phtv.Repository.JobRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicationData {

    private final AccountRepo _AccountRepo;
    private final JobRepo _JobRepo;
    private final CVRepo _CurriculumRepo;

    public ApplicationData(AccountRepo _AccountRepo, JobRepo _JobRepo, CVRepo _CurriculumRepo) {
        this._AccountRepo = _AccountRepo;
        this._JobRepo = _JobRepo;
        this._CurriculumRepo = _CurriculumRepo;
    }

    @SuppressWarnings("deprecation")
    public List<Application> Data() {
        List<Application> data = new ArrayList<>();
        data.add(new Application(1, "Job application from Từ Lê Minh Mẫn", _AccountRepo.getAccountById(12), _JobRepo.getOne(1),
                _CurriculumRepo.getOne(1), new Date("06/01/2024")));
        data.add(new Application(2, "Job application from Trần Minh Minh", _AccountRepo.getAccountById(13), _JobRepo.getOne(2),
                _CurriculumRepo.getOne(2),new Date("02/15/2024")));
        data.add(new Application(3, "Job application from Trần Đại Nghĩa", _AccountRepo.getAccountById(14), _JobRepo.getOne(3),
                _CurriculumRepo.getOne(3),new Date("03/01/2024")));
        data.add(new Application(4, "Job application from Nguyễn Ngọc Trâm", _AccountRepo.getAccountById(15), _JobRepo.getOne(4),
                _CurriculumRepo.getOne(4),new Date("04/01/2024")));
        data.add(new Application(5, "Job application from Từ Lê Diễm My", _AccountRepo.getAccountById(16), _JobRepo.getOne(5),
                _CurriculumRepo.getOne(5),new Date("06/01/2024")));
        data.add(new Application(6, "Job application from Từ Trinh Xuan Thanh", _AccountRepo.getAccountById(17), _JobRepo.getOne(6),
                _CurriculumRepo.getOne(6),new Date("06/05/2024")));
        data.add(new Application(7, "Job application from Từ Lê Thành", _AccountRepo.getAccountById(18), _JobRepo.getOne(7),
                _CurriculumRepo.getOne(7),new Date("04/01/2024")));
        data.add(new Application(8, "Job application fromTừ Phạm Phúc Hậu", _AccountRepo.getAccountById(19), _JobRepo.getOne(8),
                _CurriculumRepo.getOne(8),new Date("04/11/2024")));
        data.add(new Application(9, "Job application from Từ Lê Văn Luyện", _AccountRepo.getAccountById(20), _JobRepo.getOne(9),
                _CurriculumRepo.getOne(9),new Date("06/11/2024")));
        data.add(new Application(10, "Job application from Từ Nguyễn Lệ Nhi", _AccountRepo.getAccountById(21), _JobRepo.getOne(10),
                _CurriculumRepo.getOne(10),new Date("06/15/2024")));

//        Thêm Data từ 1 account
        data.add(new Application(11, "Job application from Trần Đại Nghĩa", _AccountRepo.getAccountById(14), _JobRepo.getOne(13),
                _CurriculumRepo.getOne(3),new Date("09/15/2024")));
        data.add(new Application(12, "Job application from Từ Nguyễn Lệ Nhi", _AccountRepo.getAccountById(21), _JobRepo.getOne(13),
                _CurriculumRepo.getOne(10),new Date("09/16/2024")));
        data.add(new Application(13, "Job application from Từ Lê Văn Luyện", _AccountRepo.getAccountById(20), _JobRepo.getOne(13),
                _CurriculumRepo.getOne(9),new Date("09/17/2024")));
        data.add(new Application(14, "Job application from Từ Phạm Phúc Hậu", _AccountRepo.getAccountById(19), _JobRepo.getOne(13),
                _CurriculumRepo.getOne(8),new Date("09/18/2024")));
        data.add(new Application(15, "Job application from Từ Lê Diễm My", _AccountRepo.getAccountById(16), _JobRepo.getOne(13),
                _CurriculumRepo.getOne(5),new Date("09/19/2024")));

        data.add(new Application(16, "Job application from Từ Nguyễn Lệ Nhi", _AccountRepo.getAccountById(21), _JobRepo.getOne(3),
                _CurriculumRepo.getOne(10),new Date("03/15/2024")));
        data.add(new Application(17, "Job application from Từ Phạm Phúc Hậu", _AccountRepo.getAccountById(19), _JobRepo.getOne(3),
                _CurriculumRepo.getOne(8),new Date("03/16/2024")));
        data.add(new Application(18, "Job application from Trần Minh Minh", _AccountRepo.getAccountById(13), _JobRepo.getOne(3),
                _CurriculumRepo.getOne(2),new Date("03/17/2024")));
        return data;
    }
}
