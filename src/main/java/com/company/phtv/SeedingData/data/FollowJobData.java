package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.*;
import com.company.phtv.Repository.AccountRepo;
import com.company.phtv.Repository.JobRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FollowJobData {
    private final AccountRepo _AccountRepo;
    private final JobRepo _JobRepo;

    public FollowJobData(AccountRepo _AccountRepo, JobRepo _JobRepo) {
        this._AccountRepo = _AccountRepo;
        this._JobRepo = _JobRepo;
    }

    @SuppressWarnings("deprecation")
    public List<FollowJob> Data() {
        List<FollowJob> data = new ArrayList<>();
        data.add(new FollowJob(1, _JobRepo.getOne(1), _AccountRepo.getAccountById(12),new Date("06/01/2024")));
        data.add(new FollowJob(2, _JobRepo.getOne(2), _AccountRepo.getAccountById(13),new Date("02/15/2024")));
        data.add(new FollowJob(3, _JobRepo.getOne(3), _AccountRepo.getAccountById(14),new Date("03/01/2024")));
        data.add(new FollowJob(4, _JobRepo.getOne(4), _AccountRepo.getAccountById(15),new Date("04/01/2024")));
        data.add(new FollowJob(5, _JobRepo.getOne(5), _AccountRepo.getAccountById(16),new Date("06/01/2024")));
        data.add(new FollowJob(6, _JobRepo.getOne(6), _AccountRepo.getAccountById(17),new Date("06/05/2024")));
        data.add(new FollowJob(7, _JobRepo.getOne(7), _AccountRepo.getAccountById(18),new Date("04/01/2024")));
        data.add(new FollowJob(8, _JobRepo.getOne(8), _AccountRepo.getAccountById(19),new Date("04/11/2024")));
        data.add(new FollowJob(9, _JobRepo.getOne(9), _AccountRepo.getAccountById(20),new Date("06/11/2024")));
        data.add(new FollowJob(10, _JobRepo.getOne(10), _AccountRepo.getAccountById(21),new Date("05/11/2024")));

        data.add(new FollowJob(11, _JobRepo.getOne(11), _AccountRepo.getAccountById(12),new Date("08/08/2024")));
        data.add(new FollowJob(12, _JobRepo.getOne(12), _AccountRepo.getAccountById(13),new Date("08/08/2024")));
        data.add(new FollowJob(13, _JobRepo.getOne(13), _AccountRepo.getAccountById(14),new Date("08/08/2024")));
        data.add(new FollowJob(14, _JobRepo.getOne(14), _AccountRepo.getAccountById(15),new Date("08/09/2024")));
        data.add(new FollowJob(15, _JobRepo.getOne(15), _AccountRepo.getAccountById(16),new Date("08/10/2024")));
        data.add(new FollowJob(16, _JobRepo.getOne(16), _AccountRepo.getAccountById(17),new Date("08/11/2024")));
        data.add(new FollowJob(17, _JobRepo.getOne(17), _AccountRepo.getAccountById(18),new Date("08/12/2024")));
        data.add(new FollowJob(18, _JobRepo.getOne(18), _AccountRepo.getAccountById(19),new Date("08/13/2024")));
        data.add(new FollowJob(19, _JobRepo.getOne(19), _AccountRepo.getAccountById(20),new Date("08/14/2024")));
        data.add(new FollowJob(20, _JobRepo.getOne(20), _AccountRepo.getAccountById(21),new Date("08/15/2024")));


        // data.add(new FollowJob(21, _JobRepo.getOne(13), _AccountRepo.getAccountById(14),new Date("08/15/2024")));
        data.add(new FollowJob(22, _JobRepo.getOne(13), _AccountRepo.getAccountById(15),new Date("08/16/2024")));
        data.add(new FollowJob(23, _JobRepo.getOne(13), _AccountRepo.getAccountById(16),new Date("08/16/2024")));
        data.add(new FollowJob(24, _JobRepo.getOne(13), _AccountRepo.getAccountById(17),new Date("08/18/2024")));
        data.add(new FollowJob(25, _JobRepo.getOne(13), _AccountRepo.getAccountById(21),new Date("08/17/2024")));
        data.add(new FollowJob(26, _JobRepo.getOne(13), _AccountRepo.getAccountById(20),new Date("08/18/2024")));
        data.add(new FollowJob(27, _JobRepo.getOne(13), _AccountRepo.getAccountById(19),new Date("08/19/2024")));

        data.add(new FollowJob(28, _JobRepo.getOne(3), _AccountRepo.getAccountById(21),new Date("03/15/2024")));
        data.add(new FollowJob(29, _JobRepo.getOne(3), _AccountRepo.getAccountById(19),new Date("03/16/2024")));
        data.add(new FollowJob(30, _JobRepo.getOne(3), _AccountRepo.getAccountById(13),new Date("03/17/2024")));
        data.add(new FollowJob(31, _JobRepo.getOne(3), _AccountRepo.getAccountById(15),new Date("03/19/2024")));
        data.add(new FollowJob(32, _JobRepo.getOne(3), _AccountRepo.getAccountById(12),new Date("03/21/2024")));
        data.add(new FollowJob(33, _JobRepo.getOne(3), _AccountRepo.getAccountById(16),new Date("03/09/2024")));
        data.add(new FollowJob(34, _JobRepo.getOne(3), _AccountRepo.getAccountById(17),new Date("03/03/2024")));
        data.add(new FollowJob(35, _JobRepo.getOne(3), _AccountRepo.getAccountById(18),new Date("03/08/2024")));

        data.add(new FollowJob(36, _JobRepo.getOne(32), _AccountRepo.getAccountById(21),new Date("05/15/2024")));
        data.add(new FollowJob(37, _JobRepo.getOne(32), _AccountRepo.getAccountById(19),new Date("05/16/2024")));
        data.add(new FollowJob(38, _JobRepo.getOne(32), _AccountRepo.getAccountById(13),new Date("05/17/2024")));
        data.add(new FollowJob(39, _JobRepo.getOne(32), _AccountRepo.getAccountById(16),new Date("05/18/2024")));
        data.add(new FollowJob(40, _JobRepo.getOne(32), _AccountRepo.getAccountById(20),new Date("05/20/2024")));
        data.add(new FollowJob(41, _JobRepo.getOne(32), _AccountRepo.getAccountById(18),new Date("05/21/2024")));
        data.add(new FollowJob(42, _JobRepo.getOne(32), _AccountRepo.getAccountById(17),new Date("05/22/2024")));
        data.add(new FollowJob(43, _JobRepo.getOne(32), _AccountRepo.getAccountById(15),new Date("05/23/2024")));
        data.add(new FollowJob(44, _JobRepo.getOne(32), _AccountRepo.getAccountById(14),new Date("05/24/2024")));

        data.add(new FollowJob(45, _JobRepo.getOne(33), _AccountRepo.getAccountById(21),new Date("06/15/2024")));
        data.add(new FollowJob(46, _JobRepo.getOne(33), _AccountRepo.getAccountById(19),new Date("06/16/2024")));
        data.add(new FollowJob(47, _JobRepo.getOne(33), _AccountRepo.getAccountById(13),new Date("06/17/2024")));
        data.add(new FollowJob(48, _JobRepo.getOne(33), _AccountRepo.getAccountById(16),new Date("06/18/2024")));
        data.add(new FollowJob(49, _JobRepo.getOne(33), _AccountRepo.getAccountById(20),new Date("06/20/2024")));
        data.add(new FollowJob(50, _JobRepo.getOne(33), _AccountRepo.getAccountById(18),new Date("06/21/2024")));
        data.add(new FollowJob(51, _JobRepo.getOne(33), _AccountRepo.getAccountById(17),new Date("06/22/2024")));

        data.add(new FollowJob(52, _JobRepo.getOne(34), _AccountRepo.getAccountById(21),new Date("07/15/2024")));
        data.add(new FollowJob(53, _JobRepo.getOne(34), _AccountRepo.getAccountById(19),new Date("07/16/2024")));
        data.add(new FollowJob(54, _JobRepo.getOne(34), _AccountRepo.getAccountById(13),new Date("07/17/2024")));
        data.add(new FollowJob(55, _JobRepo.getOne(34), _AccountRepo.getAccountById(16),new Date("07/18/2024")));
        data.add(new FollowJob(56, _JobRepo.getOne(34), _AccountRepo.getAccountById(20),new Date("07/20/2024")));
        data.add(new FollowJob(57, _JobRepo.getOne(34), _AccountRepo.getAccountById(18),new Date("07/21/2024")));
        data.add(new FollowJob(58, _JobRepo.getOne(34), _AccountRepo.getAccountById(17),new Date("07/22/2024")));
        data.add(new FollowJob(59, _JobRepo.getOne(34), _AccountRepo.getAccountById(14),new Date("07/24/2024")));


        data.add(new FollowJob(60, _JobRepo.getOne(31), _AccountRepo.getAccountById(21),new Date("04/15/2024")));
        data.add(new FollowJob(61, _JobRepo.getOne(31), _AccountRepo.getAccountById(19),new Date("04/16/2024")));
        data.add(new FollowJob(62, _JobRepo.getOne(31), _AccountRepo.getAccountById(13),new Date("04/17/2024")));
        data.add(new FollowJob(63, _JobRepo.getOne(31), _AccountRepo.getAccountById(16),new Date("04/18/2024")));
        data.add(new FollowJob(64, _JobRepo.getOne(31), _AccountRepo.getAccountById(20),new Date("04/20/2024")));
        data.add(new FollowJob(65, _JobRepo.getOne(31), _AccountRepo.getAccountById(18),new Date("04/21/2024")));
        data.add(new FollowJob(66, _JobRepo.getOne(31), _AccountRepo.getAccountById(17),new Date("04/22/2024")));
        data.add(new FollowJob(67, _JobRepo.getOne(31), _AccountRepo.getAccountById(15),new Date("04/23/2024")));
        data.add(new FollowJob(68, _JobRepo.getOne(31), _AccountRepo.getAccountById(14),new Date("04/24/2024")));


        // data.add(new FollowJob(69, _JobRepo.getOne(34), _AccountRepo.getAccountById(21),new Date("02/15/2024")));
        data.add(new FollowJob(70, _JobRepo.getOne(34), _AccountRepo.getAccountById(19),new Date("02/16/2024")));
        data.add(new FollowJob(71, _JobRepo.getOne(34), _AccountRepo.getAccountById(13),new Date("02/17/2024")));
        data.add(new FollowJob(72, _JobRepo.getOne(34), _AccountRepo.getAccountById(16),new Date("02/18/2024")));
        data.add(new FollowJob(73, _JobRepo.getOne(34), _AccountRepo.getAccountById(20),new Date("02/20/2024")));


        data.add(new FollowJob(74, _JobRepo.getOne(35), _AccountRepo.getAccountById(21),new Date("01/15/2024")));
        data.add(new FollowJob(75, _JobRepo.getOne(35), _AccountRepo.getAccountById(19),new Date("01/16/2024")));
        data.add(new FollowJob(75, _JobRepo.getOne(35), _AccountRepo.getAccountById(13),new Date("01/17/2024")));
        data.add(new FollowJob(77, _JobRepo.getOne(35), _AccountRepo.getAccountById(16),new Date("01/18/2024")));
        data.add(new FollowJob(78, _JobRepo.getOne(35), _AccountRepo.getAccountById(20),new Date("01/20/2024")));
        data.add(new FollowJob(79, _JobRepo.getOne(35), _AccountRepo.getAccountById(18),new Date("01/21/2024")));
        data.add(new FollowJob(80, _JobRepo.getOne(35), _AccountRepo.getAccountById(17),new Date("01/22/2024")));
        data.add(new FollowJob(81, _JobRepo.getOne(35), _AccountRepo.getAccountById(15),new Date("01/23/2024")));
        data.add(new FollowJob(82, _JobRepo.getOne(35), _AccountRepo.getAccountById(14),new Date("01/24/2024")));



        return data;
    }
}
