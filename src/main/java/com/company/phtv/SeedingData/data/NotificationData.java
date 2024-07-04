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
    // hỏi Phú xem cách tổ chức acc lk vs job và com
public List<Notification> Data(){
        List<Notification> data = new ArrayList<>();
        data.add(new Notification(1,
                "Bạn Có 1 Thông Báo Từ NGÂN HÀNG THƯƠNG MẠI CỔ PHẦN BƯU ĐIỆN LIÊN VIỆT",
                "Thông Báo Trúng Tuyển",
                _CompanyRepo.getOne(1),
                _AccountRepo.getAccountById(5),
                _JobRepo.getOne(1)));
        data.add(new Notification(2,
                "Bạn Có 1 Thông Báo Từ CÔNG TY TNHH SPRAYWAY-TPR",
                "Thông Báo Trúng Tuyển",
                _CompanyRepo.getOne(2),
                _AccountRepo.getAccountById(6),
                _JobRepo.getOne(2)));
        data.add(new Notification(3,
                "Bạn Có 1 Thông Báo Từ CÔNG TY CÔNG TY TNHH LIKELION",
                "Thông Báo Trúng Tuyển",
                _CompanyRepo.getOne(3),
                _AccountRepo.getAccountById(7),
                _JobRepo.getOne(3)));

        data.add(new Notification(4,
                "Bạn Có 1 Thông Báo Từ Ban Công nghệ BIDV",
                "Thông Báo Trúng Tuyển",
                _CompanyRepo.getOne(4),
                _AccountRepo.getAccountById(8),
                _JobRepo.getOne(4)));
        data.add(new Notification(5,
                "Bạn Có 1 Thông Báo Từ Trung Tâm Công nghệ thông tin Mobifone",
                "Thông Báo Trúng Tuyển",
                _CompanyRepo.getOne(5),
                _AccountRepo.getAccountById(9),
                _JobRepo.getOne(5)));
        data.add(new Notification(6,
                "Bạn Có 1 Thông Báo Từ TopDev's Client",
                "Thông Báo Trúng Tuyển",
                _CompanyRepo.getOne(6),
                _AccountRepo.getAccountById(10),
                _JobRepo.getOne(6)));
//        data.add(new Notification(7,
//                "Bạn Có 1 Thông Báo Từ NGÂN HÀNG THƯƠNG MẠI CỔ PHẦN BƯU ĐIỆN LIÊN VIỆT",
//                "Thông Báo Trúng Tuyển",
//                _CompanyRepo.getOne(1),
//                _AccountRepo.getAccountById(3),
//                _JobRepo.getOne(3)));
//        data.add(new Notification(8,
//                "Bạn Có 1 Thông Báo Từ NGÂN HÀNG THƯƠNG MẠI CỔ PHẦN BƯU ĐIỆN LIÊN VIỆT",
//                "Thông Báo Trúng Tuyển",
//                _CompanyRepo.getOne(1),
//                _AccountRepo.getAccountById(3),
//                _JobRepo.getOne(3)));
//        data.add(new Notification(9,
//                "Bạn Có 1 Thông Báo Từ NGÂN HÀNG THƯƠNG MẠI CỔ PHẦN BƯU ĐIỆN LIÊN VIỆT",
//                "Thông Báo Trúng Tuyển",
//                _CompanyRepo.getOne(1),
//                _AccountRepo.getAccountById(3),
//                _JobRepo.getOne(3)));
//        data.add(new Notification(10,
//                "Bạn Có 1 Thông Báo Từ NGÂN HÀNG THƯƠNG MẠI CỔ PHẦN BƯU ĐIỆN LIÊN VIỆT",
//                "Thông Báo Trúng Tuyển",
//                _CompanyRepo.getOne(1),
//                _AccountRepo.getAccountById(3),
//                _JobRepo.getOne(3)));
        return data;
    }
}
