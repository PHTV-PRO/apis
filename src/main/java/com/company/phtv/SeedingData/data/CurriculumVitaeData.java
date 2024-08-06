package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.CurriculumVitae;
import com.company.phtv.Repository.AccountRepo;

import java.util.ArrayList;
import java.util.List;

public class CurriculumVitaeData {
    private final AccountRepo _AccountRepo;

    public CurriculumVitaeData(AccountRepo _AccountRepo) {
        this._AccountRepo = _AccountRepo;
    }

    public List<CurriculumVitae> Data() {
        List<CurriculumVitae> data = new ArrayList<>();
        data.add(new CurriculumVitae(1, "http://res.cloudinary.com/dj7xlmndj/image/upload/v1722859351/l3t9mqsc11m00ormzzbs.pdf","Intern", _AccountRepo.getAccountById(12)));
        data.add(new CurriculumVitae(2, "http://res.cloudinary.com/dj7xlmndj/image/upload/v1722860152/lip7xhvxyhod1wlfjbcg.pdf","Fresher", _AccountRepo.getAccountById(13)));
        data.add(new CurriculumVitae(3, "http://res.cloudinary.com/dj7xlmndj/image/upload/v1722860438/vqixzjqazjpsrv5ugwvm.pdf","Fresher", _AccountRepo.getAccountById(14)));
        data.add(new CurriculumVitae(4, "http://res.cloudinary.com/dj7xlmndj/image/upload/v1722860741/n5lo8jscpzwu9urvrwuz.pdf","Tester", _AccountRepo.getAccountById(15)));
        data.add(new CurriculumVitae(5, "http://res.cloudinary.com/dj7xlmndj/image/upload/v1722861048/chp8voplix0tzssmnfo3.pdf","Fresher", _AccountRepo.getAccountById(16)));
        data.add(new CurriculumVitae(6, "http://res.cloudinary.com/dj7xlmndj/image/upload/v1722859351/l3t9mqsc11m00ormzzbs.pdf","Fresher", _AccountRepo.getAccountById(17)));
        data.add(new CurriculumVitae(7, "http://res.cloudinary.com/dj7xlmndj/image/upload/v1722861985/brslq9zes8f4waaga9zj.pdf","Fresher", _AccountRepo.getAccountById(18)));
        data.add(new CurriculumVitae(8, "http://res.cloudinary.com/dj7xlmndj/image/upload/v1722862146/ggnkknptlgzm4fhpuxa7.pdf","Intern", _AccountRepo.getAccountById(19)));
        data.add(new CurriculumVitae(9, "ttp://res.cloudinary.com/dj7xlmndj/image/upload/v1722862306/pdz7pomzmoyu5npeybxz.pdf","Fresher", _AccountRepo.getAccountById(20)));
        data.add(new CurriculumVitae(10, "http://res.cloudinary.com/dj7xlmndj/image/upload/v1722862453/xstyhaced4mggl9znle9.pdf","Tester", _AccountRepo.getAccountById(21)));

        return data;
    }
}
