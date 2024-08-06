package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.*;
import com.company.phtv.Repository.AccountRepo;
import com.company.phtv.Repository.CVRepo;
import com.company.phtv.Repository.JobRepo;

import java.util.ArrayList;
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
        data.add(new Application(1, "Thư Xin Việc Từ Lê Minh Mẫn", _AccountRepo.getAccountById(12), _JobRepo.getOne(1),
                _CurriculumRepo.getOne(1)));
        data.add(new Application(2, "Thư Xin Việc Từ Trần Minh Minh", _AccountRepo.getAccountById(13), _JobRepo.getOne(2),
                _CurriculumRepo.getOne(2)));
        data.add(new Application(3, "Thư Xin Việc Trần Đại Nghĩa", _AccountRepo.getAccountById(14), _JobRepo.getOne(3),
                _CurriculumRepo.getOne(3)));
        data.add(new Application(4, "Thư Xin Việc Từ Nguyễn Ngọc Trâm", _AccountRepo.getAccountById(15), _JobRepo.getOne(4),
                _CurriculumRepo.getOne(4)));
        data.add(new Application(5, "Thư Xin Việc Từ Lê Diễm My", _AccountRepo.getAccountById(16), _JobRepo.getOne(5),
                _CurriculumRepo.getOne(5)));
        data.add(new Application(6, "Thư Xin Việc Từ Trinh Xuan Thanh", _AccountRepo.getAccountById(17), _JobRepo.getOne(6),
                _CurriculumRepo.getOne(6)));
        data.add(new Application(7, "Thư Xin Việc Từ Lê Thành", _AccountRepo.getAccountById(18), _JobRepo.getOne(7),
                _CurriculumRepo.getOne(1)));
        data.add(new Application(8, "Thư Xin Việc Từ Phạm Phúc Hậu", _AccountRepo.getAccountById(19), _JobRepo.getOne(8),
                _CurriculumRepo.getOne(2)));
        data.add(new Application(9, "Thư Xin Việc Từ Lê Văn Luyện", _AccountRepo.getAccountById(20), _JobRepo.getOne(9),
                _CurriculumRepo.getOne(3)));
        data.add(new Application(10, "Thư Xin Việc Từ Nguyễn Lệ Nhi", _AccountRepo.getAccountById(21), _JobRepo.getOne(10),
                _CurriculumRepo.getOne(4)));

        return data;
    }
}
