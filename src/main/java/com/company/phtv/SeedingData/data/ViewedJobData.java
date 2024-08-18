package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.*;
import com.company.phtv.Repository.AccountRepo;
import com.company.phtv.Repository.JobRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ViewedJobData {
    private final AccountRepo _AccountRepo;
    private final JobRepo _JobRepo;

    public ViewedJobData(AccountRepo _AccountRepo, JobRepo _JobRepo) {
        this._AccountRepo = _AccountRepo;
        this._JobRepo = _JobRepo;
    }

    @SuppressWarnings("deprecation")
    public List<ViewedJob> Data() {
        List<ViewedJob> data = new ArrayList<>();
        data.add(new ViewedJob(1, _JobRepo.getOne(1), _AccountRepo.getAccountById(12),new Date("06/01/2024")));
        data.add(new ViewedJob(2, _JobRepo.getOne(2), _AccountRepo.getAccountById(13),new Date("02/15/2024")));
        data.add(new ViewedJob(3, _JobRepo.getOne(3), _AccountRepo.getAccountById(14),new Date("03/01/2024")));
        data.add(new ViewedJob(4, _JobRepo.getOne(4), _AccountRepo.getAccountById(15),new Date("04/01/2024")));
        data.add(new ViewedJob(5, _JobRepo.getOne(5), _AccountRepo.getAccountById(16),new Date("06/01/2024")));
        data.add(new ViewedJob(6, _JobRepo.getOne(6), _AccountRepo.getAccountById(17),new Date("06/05/2024")));
        data.add(new ViewedJob(7, _JobRepo.getOne(7), _AccountRepo.getAccountById(18),new Date("04/01/2024")));
        data.add(new ViewedJob(8, _JobRepo.getOne(8), _AccountRepo.getAccountById(19),new Date("04/11/2024")));
        data.add(new ViewedJob(9, _JobRepo.getOne(9), _AccountRepo.getAccountById(20),new Date("06/11/2024")));
        data.add(new ViewedJob(10, _JobRepo.getOne(10), _AccountRepo.getAccountById(21),new Date("06/15/2024")));

        data.add(new ViewedJob(11, _JobRepo.getOne(11), _AccountRepo.getAccountById(12),new Date("09/01/2024")));
        data.add(new ViewedJob(12, _JobRepo.getOne(12), _AccountRepo.getAccountById(13),new Date("09/01/2024")));
        data.add(new ViewedJob(13, _JobRepo.getOne(13), _AccountRepo.getAccountById(14),new Date("09/01/2024")));
        data.add(new ViewedJob(14, _JobRepo.getOne(14), _AccountRepo.getAccountById(15),new Date("09/01/2024")));
        data.add(new ViewedJob(15, _JobRepo.getOne(15), _AccountRepo.getAccountById(16),new Date("09/01/2024")));
        data.add(new ViewedJob(16, _JobRepo.getOne(16), _AccountRepo.getAccountById(17),new Date("09/01/2024")));
        data.add(new ViewedJob(17, _JobRepo.getOne(17), _AccountRepo.getAccountById(18),new Date("09/01/2024")));
        data.add(new ViewedJob(18, _JobRepo.getOne(18), _AccountRepo.getAccountById(19),new Date("09/01/2024")));
        data.add(new ViewedJob(19, _JobRepo.getOne(19), _AccountRepo.getAccountById(20),new Date("09/01/2024")));
        data.add(new ViewedJob(20, _JobRepo.getOne(20), _AccountRepo.getAccountById(21),new Date("09/01/2024")));

        // view job cho 1 emp
        data.add(new ViewedJob(21, _JobRepo.getOne(13), _AccountRepo.getAccountById(14),new Date("09/15/2024")));
        data.add(new ViewedJob(22, _JobRepo.getOne(13), _AccountRepo.getAccountById(16),new Date("09/16/2024")));
        data.add(new ViewedJob(23, _JobRepo.getOne(13), _AccountRepo.getAccountById(21),new Date("09/17/2024")));
        data.add(new ViewedJob(24, _JobRepo.getOne(13), _AccountRepo.getAccountById(20),new Date("09/18/2024")));
        data.add(new ViewedJob(25, _JobRepo.getOne(13), _AccountRepo.getAccountById(19),new Date("09/19/2024")));

        data.add(new ViewedJob(26, _JobRepo.getOne(3), _AccountRepo.getAccountById(21),new Date("03/15/2024")));
        data.add(new ViewedJob(27, _JobRepo.getOne(3), _AccountRepo.getAccountById(19),new Date("03/16/2024")));
        data.add(new ViewedJob(28, _JobRepo.getOne(3), _AccountRepo.getAccountById(13),new Date("03/17/2024")));
        data.add(new ViewedJob(29, _JobRepo.getOne(3), _AccountRepo.getAccountById(15),new Date("03/18/2024")));



        return data;
    }
}
