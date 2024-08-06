package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.SkillJob;
import com.company.phtv.Repository.JobRepo;
import com.company.phtv.Repository.SkillRepo;

import java.util.ArrayList;
import java.util.List;

public class SkillJobData {
    private final JobRepo _JobRepo;
    private final SkillRepo _SkillRepo;
    public SkillJobData(JobRepo _JobRepo, SkillRepo _SkillRepo) {
        this._JobRepo = _JobRepo;
        this._SkillRepo = _SkillRepo;
    }
    @SuppressWarnings("deprecation")
    public List<SkillJob> Data(){
        List<SkillJob> data = new ArrayList<>();
        data.add(new SkillJob(1,_SkillRepo.getOne(4),_JobRepo.getOne(1)));
        data.add(new SkillJob(2,_SkillRepo.getOne(5),_JobRepo.getOne(1)));
        data.add(new SkillJob(3,_SkillRepo.getOne(6),_JobRepo.getOne(1)));
        data.add(new SkillJob(4,_SkillRepo.getOne(8),_JobRepo.getOne(1)));
        data.add(new SkillJob(5,_SkillRepo.getOne(3),_JobRepo.getOne(2)));
        data.add(new SkillJob(6,_SkillRepo.getOne(21),_JobRepo.getOne(2)));
        data.add(new SkillJob(7,_SkillRepo.getOne(13),_JobRepo.getOne(2)));
        data.add(new SkillJob(8,_SkillRepo.getOne(1),_JobRepo.getOne(2)));
        data.add(new SkillJob(9,_SkillRepo.getOne(15),_JobRepo.getOne(3)));
        data.add(new SkillJob(10,_SkillRepo.getOne(17),_JobRepo.getOne(3)));
        data.add(new SkillJob(11,_SkillRepo.getOne(4),_JobRepo.getOne(4)));
        data.add(new SkillJob(12,_SkillRepo.getOne(14),_JobRepo.getOne(4)));
        data.add(new SkillJob(13,_SkillRepo.getOne(19),_JobRepo.getOne(5)));
        data.add(new SkillJob(14,_SkillRepo.getOne(2),_JobRepo.getOne(5)));
        data.add(new SkillJob(15,_SkillRepo.getOne(12),_JobRepo.getOne(6)));
        data.add(new SkillJob(16,_SkillRepo.getOne(14),_JobRepo.getOne(6)));
        data.add(new SkillJob(17,_SkillRepo.getOne(16),_JobRepo.getOne(7)));
        data.add(new SkillJob(18,_SkillRepo.getOne(3),_JobRepo.getOne(7)));
        data.add(new SkillJob(19,_SkillRepo.getOne(22),_JobRepo.getOne(8)));
        data.add(new SkillJob(20,_SkillRepo.getOne(23),_JobRepo.getOne(8)));
        data.add(new SkillJob(21,_SkillRepo.getOne(24),_JobRepo.getOne(9)));
        data.add(new SkillJob(22,_SkillRepo.getOne(25),_JobRepo.getOne(9)));
        data.add(new SkillJob(23,_SkillRepo.getOne(26),_JobRepo.getOne(10)));
        data.add(new SkillJob(24,_SkillRepo.getOne(27),_JobRepo.getOne(10)));
        data.add(new SkillJob(25,_SkillRepo.getOne(28),_JobRepo.getOne(10)));

        data.add(new SkillJob(26,_SkillRepo.getOne(4),_JobRepo.getOne(11)));
        data.add(new SkillJob(27,_SkillRepo.getOne(5),_JobRepo.getOne(11)));
        data.add(new SkillJob(28,_SkillRepo.getOne(6),_JobRepo.getOne(11)));
        data.add(new SkillJob(29,_SkillRepo.getOne(8),_JobRepo.getOne(11)));
        data.add(new SkillJob(30,_SkillRepo.getOne(3),_JobRepo.getOne(12)));
        data.add(new SkillJob(31,_SkillRepo.getOne(21),_JobRepo.getOne(12)));
        data.add(new SkillJob(32,_SkillRepo.getOne(13),_JobRepo.getOne(12)));
        data.add(new SkillJob(33,_SkillRepo.getOne(1),_JobRepo.getOne(12)));
        data.add(new SkillJob(34,_SkillRepo.getOne(15),_JobRepo.getOne(13)));
        data.add(new SkillJob(35,_SkillRepo.getOne(17),_JobRepo.getOne(13)));
        data.add(new SkillJob(36,_SkillRepo.getOne(4),_JobRepo.getOne(14)));
        data.add(new SkillJob(37,_SkillRepo.getOne(14),_JobRepo.getOne(14)));
        data.add(new SkillJob(38,_SkillRepo.getOne(19),_JobRepo.getOne(15)));
        data.add(new SkillJob(39,_SkillRepo.getOne(2),_JobRepo.getOne(15)));
        data.add(new SkillJob(40,_SkillRepo.getOne(12),_JobRepo.getOne(16)));
        data.add(new SkillJob(41,_SkillRepo.getOne(14),_JobRepo.getOne(16)));
        data.add(new SkillJob(42,_SkillRepo.getOne(16),_JobRepo.getOne(17)));
        data.add(new SkillJob(43,_SkillRepo.getOne(3),_JobRepo.getOne(17)));
        data.add(new SkillJob(44,_SkillRepo.getOne(22),_JobRepo.getOne(18)));
        data.add(new SkillJob(45,_SkillRepo.getOne(23),_JobRepo.getOne(18)));
        data.add(new SkillJob(46,_SkillRepo.getOne(24),_JobRepo.getOne(19)));
        data.add(new SkillJob(47,_SkillRepo.getOne(25),_JobRepo.getOne(19)));
        data.add(new SkillJob(48,_SkillRepo.getOne(26),_JobRepo.getOne(20)));
        data.add(new SkillJob(49,_SkillRepo.getOne(27),_JobRepo.getOne(20)));
        data.add(new SkillJob(50,_SkillRepo.getOne(28),_JobRepo.getOne(20)));

        data.add(new SkillJob(51,_SkillRepo.getOne(4),_JobRepo.getOne(21)));
        data.add(new SkillJob(52,_SkillRepo.getOne(5),_JobRepo.getOne(21)));
        data.add(new SkillJob(53,_SkillRepo.getOne(6),_JobRepo.getOne(21)));
        data.add(new SkillJob(54,_SkillRepo.getOne(8),_JobRepo.getOne(21)));
        data.add(new SkillJob(55,_SkillRepo.getOne(3),_JobRepo.getOne(22)));
        data.add(new SkillJob(56,_SkillRepo.getOne(21),_JobRepo.getOne(22)));
        data.add(new SkillJob(57,_SkillRepo.getOne(13),_JobRepo.getOne(22)));
        data.add(new SkillJob(58,_SkillRepo.getOne(1),_JobRepo.getOne(22)));
        data.add(new SkillJob(59,_SkillRepo.getOne(15),_JobRepo.getOne(23)));
        data.add(new SkillJob(60,_SkillRepo.getOne(17),_JobRepo.getOne(23)));
        data.add(new SkillJob(61,_SkillRepo.getOne(4),_JobRepo.getOne(24)));
        data.add(new SkillJob(62,_SkillRepo.getOne(14),_JobRepo.getOne(24)));
        data.add(new SkillJob(63,_SkillRepo.getOne(19),_JobRepo.getOne(25)));
        data.add(new SkillJob(64,_SkillRepo.getOne(2),_JobRepo.getOne(25)));
        data.add(new SkillJob(65,_SkillRepo.getOne(12),_JobRepo.getOne(26)));
        data.add(new SkillJob(66,_SkillRepo.getOne(14),_JobRepo.getOne(26)));
        data.add(new SkillJob(67,_SkillRepo.getOne(16),_JobRepo.getOne(27)));
        data.add(new SkillJob(68,_SkillRepo.getOne(3),_JobRepo.getOne(27)));
        data.add(new SkillJob(69,_SkillRepo.getOne(22),_JobRepo.getOne(28)));
        data.add(new SkillJob(70,_SkillRepo.getOne(23),_JobRepo.getOne(28)));
        data.add(new SkillJob(71,_SkillRepo.getOne(24),_JobRepo.getOne(29)));
        data.add(new SkillJob(72,_SkillRepo.getOne(25),_JobRepo.getOne(29)));
        data.add(new SkillJob(73,_SkillRepo.getOne(26),_JobRepo.getOne(30)));
        data.add(new SkillJob(74,_SkillRepo.getOne(27),_JobRepo.getOne(30)));
        data.add(new SkillJob(75,_SkillRepo.getOne(28),_JobRepo.getOne(30)));

        return data;
    }
}
