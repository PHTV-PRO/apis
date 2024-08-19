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
        data.add(new Application(1, "Job application from Lê Minh Mẫn", _AccountRepo.getAccountById(12), _JobRepo.getOne(1),
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

//        Thêm Data từ 1 account 2 com 1

        //32
        data.add(new Application(11, "Job application from Từ Nguyễn Lệ Nhi", _AccountRepo.getAccountById(21), _JobRepo.getOne(32),
                _CurriculumRepo.getOne(10),new Date("05/15/2024")));
        data.add(new Application(12, "Job application from Từ Phạm Phúc Hậu", _AccountRepo.getAccountById(19), _JobRepo.getOne(32),
                _CurriculumRepo.getOne(8),new Date("05/16/2024")));
        data.add(new Application(13, "Job application from Trần Minh Minh", _AccountRepo.getAccountById(13), _JobRepo.getOne(32),
                _CurriculumRepo.getOne(2),new Date("05/17/2024")));
        data.add(new Application(14, "Job application from Từ Lê Diễm My", _AccountRepo.getAccountById(16), _JobRepo.getOne(32),
                _CurriculumRepo.getOne(5),new Date("05/19/2024")));
        data.add(new Application(15, "Job application from Từ Lê Văn Luyện", _AccountRepo.getAccountById(20), _JobRepo.getOne(32),
                _CurriculumRepo.getOne(9),new Date("05/17/2024")));

//3
        data.add(new Application(16, "Job application from Từ Nguyễn Lệ Nhi", _AccountRepo.getAccountById(21), _JobRepo.getOne(3),
                _CurriculumRepo.getOne(10),new Date("03/15/2024")));
        data.add(new Application(17, "Job application from Từ Phạm Phúc Hậu", _AccountRepo.getAccountById(19), _JobRepo.getOne(3),
                _CurriculumRepo.getOne(8),new Date("03/16/2024")));
        data.add(new Application(18, "Job application from Trần Minh Minh", _AccountRepo.getAccountById(13), _JobRepo.getOne(3),
                _CurriculumRepo.getOne(2),new Date("03/17/2024")));
//31
        data.add(new Application(19, "Job application from Từ Nguyễn Lệ Nhi", _AccountRepo.getAccountById(21), _JobRepo.getOne(31),
                _CurriculumRepo.getOne(10),new Date("04/15/2024")));
        data.add(new Application(20, "Job application from Từ Phạm Phúc Hậu", _AccountRepo.getAccountById(19), _JobRepo.getOne(31),
                _CurriculumRepo.getOne(8),new Date("04/16/2024")));
        data.add(new Application(21, "Job application from Trần Minh Minh", _AccountRepo.getAccountById(13), _JobRepo.getOne(31),
                _CurriculumRepo.getOne(2),new Date("04/17/2024")));
        data.add(new Application(22, "Job application from Từ Lê Diễm My", _AccountRepo.getAccountById(16), _JobRepo.getOne(31),
                _CurriculumRepo.getOne(5),new Date("04/19/2024")));


//33
        data.add(new Application(23, "Job application from Từ Nguyễn Lệ Nhi", _AccountRepo.getAccountById(21), _JobRepo.getOne(33),
                _CurriculumRepo.getOne(10),new Date("06/15/2024")));
        data.add(new Application(24, "Job application from Từ Phạm Phúc Hậu", _AccountRepo.getAccountById(19), _JobRepo.getOne(33),
                _CurriculumRepo.getOne(8),new Date("06/16/2024")));
        data.add(new Application(25, "Job application from Trần Minh Minh", _AccountRepo.getAccountById(13), _JobRepo.getOne(33),
                _CurriculumRepo.getOne(2),new Date("06/17/2024")));

//34
        data.add(new Application(26, "Job application from Từ Nguyễn Lệ Nhi", _AccountRepo.getAccountById(21), _JobRepo.getOne(34),
                _CurriculumRepo.getOne(10),new Date("07/15/2024")));
        data.add(new Application(27, "Job application from Từ Phạm Phúc Hậu", _AccountRepo.getAccountById(19), _JobRepo.getOne(34),
                _CurriculumRepo.getOne(8),new Date("07/16/2024")));
        data.add(new Application(28, "Job application from Trần Minh Minh", _AccountRepo.getAccountById(13), _JobRepo.getOne(34),
                _CurriculumRepo.getOne(2),new Date("07/17/2024")));
        data.add(new Application(29, "Job application from Từ Lê Diễm My", _AccountRepo.getAccountById(16), _JobRepo.getOne(34),
                _CurriculumRepo.getOne(5),new Date("07/19/2024")));
        data.add(new Application(30, "Job application from Từ Lê Văn Luyện", _AccountRepo.getAccountById(20), _JobRepo.getOne(34),
                _CurriculumRepo.getOne(9),new Date("07/17/2024")));


//35
        data.add(new Application(31, "Job application from Từ Nguyễn Lệ Nhi", _AccountRepo.getAccountById(21), _JobRepo.getOne(35),
                _CurriculumRepo.getOne(10),new Date("01/15/2024")));
        data.add(new Application(32, "Job application from Từ Phạm Phúc Hậu", _AccountRepo.getAccountById(19), _JobRepo.getOne(35),
                _CurriculumRepo.getOne(8),new Date("01/16/2024")));
        data.add(new Application(33, "Job application from Trần Minh Minh", _AccountRepo.getAccountById(13), _JobRepo.getOne(35),
                _CurriculumRepo.getOne(2),new Date("01/17/2024")));
        data.add(new Application(34, "Job application from Từ Lê Diễm My", _AccountRepo.getAccountById(16), _JobRepo.getOne(35),
                _CurriculumRepo.getOne(5),new Date("01/19/2024")));
        data.add(new Application(35, "Job application from Từ Lê Văn Luyện", _AccountRepo.getAccountById(20), _JobRepo.getOne(35),
                _CurriculumRepo.getOne(9),new Date("01/20/2024")));
        data.add(new Application(36, "Job application from Trần Đại Nghĩa", _AccountRepo.getAccountById(14), _JobRepo.getOne(35),
                _CurriculumRepo.getOne(3),new Date("01/18/2024")));
        data.add(new Application(37, "Job application from Nguyễn Ngọc Trâm", _AccountRepo.getAccountById(15), _JobRepo.getOne(35),
                _CurriculumRepo.getOne(4),new Date("01/21/2024")));

//13
        data.add(new Application(38, "Job application from Từ Nguyễn Lệ Nhi", _AccountRepo.getAccountById(21), _JobRepo.getOne(13),
                _CurriculumRepo.getOne(10),new Date("08/15/2024")));
        data.add(new Application(39, "Job application from Từ Phạm Phúc Hậu", _AccountRepo.getAccountById(19), _JobRepo.getOne(13),
                _CurriculumRepo.getOne(8),new Date("08/16/2024")));
        data.add(new Application(40, "Job application from Trần Minh Minh", _AccountRepo.getAccountById(13), _JobRepo.getOne(13),
                _CurriculumRepo.getOne(2),new Date("08/17/2024")));
        data.add(new Application(41, "Job application from Từ Lê Diễm My", _AccountRepo.getAccountById(16), _JobRepo.getOne(13),
                _CurriculumRepo.getOne(5),new Date("08/11/2024")));
        data.add(new Application(42, "Job application from Từ Lê Văn Luyện", _AccountRepo.getAccountById(20), _JobRepo.getOne(13),
                _CurriculumRepo.getOne(9),new Date("08/12/2024")));
        data.add(new Application(43, "Job application from Trần Đại Nghĩa", _AccountRepo.getAccountById(14), _JobRepo.getOne(13),
                _CurriculumRepo.getOne(3),new Date("08/13/2024")));
        data.add(new Application(44, "Job application from Nguyễn Ngọc Trâm", _AccountRepo.getAccountById(15), _JobRepo.getOne(13),
                _CurriculumRepo.getOne(4),new Date("08/14/2024")));

        // 34
        data.add(new Application(45, "Job application from  Lê Minh Mẫn", _AccountRepo.getAccountById(12), _JobRepo.getOne(34),
                _CurriculumRepo.getOne(10),new Date("02/15/2024")));
        data.add(new Application(46, "Job application from Từ Lê Thành", _AccountRepo.getAccountById(18), _JobRepo.getOne(34),
                _CurriculumRepo.getOne(8),new Date("02/16/2024")));
        data.add(new Application(47, "Job application from Trinh Xuan Thanh", _AccountRepo.getAccountById(17), _JobRepo.getOne(34),
                _CurriculumRepo.getOne(2),new Date("02/17/2024")));

        // 13
        // hidden data of Application By Month will be deleted
//        data.add(new Application(48, "Job application from  Lê Minh Mẫn", _AccountRepo.getAccountById(12), _JobRepo.getOne(13),
//                _CurriculumRepo.getOne(10),new Date("09/15/2024")));
//        data.add(new Application(49, "Job application from Từ Lê Thành", _AccountRepo.getAccountById(18), _JobRepo.getOne(13),
//                _CurriculumRepo.getOne(8),new Date("09/16/2024")));
//        data.add(new Application(50, "Job application from Trinh Xuan Thanh", _AccountRepo.getAccountById(17), _JobRepo.getOne(13),
//                _CurriculumRepo.getOne(2),new Date("09/17/2024")));



        return data;
    }
}
