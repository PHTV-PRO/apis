package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.*;
import com.company.phtv.Repository.AccountRepo;
import com.company.phtv.Repository.CompanyRepo;
import com.company.phtv.Repository.JobRepo;

import java.util.ArrayList;
import java.util.List;


public class NotificationData {
        private final AccountRepo _AccountRepo;
        private final CompanyRepo _CompanyRepo;
        private final JobRepo _JobRepo;
        public NotificationData(AccountRepo _AccountRepo, JobRepo _JobRepo, CompanyRepo _CompanyRepo) {
            this._AccountRepo = _AccountRepo;
        this._CompanyRepo = _CompanyRepo;
        this._JobRepo = _JobRepo;
        }
    @SuppressWarnings("deprecation")
public List<Notification> Data(){
        List<Notification> data = new ArrayList<>();
        data.add(new Notification(1,
                "Bạn Có 1 Thông Báo Từ CÔNG TY TNHH SPRAYWAY-TPR",
                "Thông Báo Trúng Tuyển",
                _CompanyRepo.getOne(2),
                _AccountRepo.getAccountById(1),
                _JobRepo.getOne(1)));
        data.add(new Notification(2,
                "Bạn Có 1 Thông Báo Từ CÔNG TY CÔNG TY TNHH LIKELION",
                "Thông Báo Trúng Tuyển",
                _CompanyRepo.getOne(3),
                _AccountRepo.getAccountById(2),
                _JobRepo.getOne(2)));
        data.add(new Notification(3,
                "Bạn Có 1 Thông Báo Từ NGÂN HÀNG THƯƠNG MẠI CỔ PHẦN BƯU ĐIỆN LIÊN VIỆT",
                "Thông Báo Trúng Tuyển",
                _CompanyRepo.getOne(1),
                _AccountRepo.getAccountById(3),
                _JobRepo.getOne(3)));

        return data;
    }
}
