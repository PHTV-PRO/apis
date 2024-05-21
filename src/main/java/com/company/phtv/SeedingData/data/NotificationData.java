package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.*;

import java.util.ArrayList;
import java.util.List;

public class NotificationData {
    public List<Notification> Data(){
        List<Notification> data = new ArrayList<>();
        data.add(new Notification(1,
                "Bạn Có 1 Thông Báo Từ CÔNG TY TNHH SPRAYWAY-TPR",
                "Thông Báo Trúng Tuyển",
                new Company(2),
                new Account(1),
                new Jobs(1)));
        data.add(new Notification(2,
                "Bạn Có 1 Thông Báo Từ CÔNG TY CÔNG TY TNHH LIKELION",
                "Thông Báo Trúng Tuyển",
                new Company(3),
                new Account(2),
                new Jobs(2)));
        data.add(new Notification(3,
                "Bạn Có 1 Thông Báo Từ NGÂN HÀNG THƯƠNG MẠI CỔ PHẦN BƯU ĐIỆN LIÊN VIỆT",
                "Thông Báo Trúng Tuyển",
                new Company(1),
                new Account(3),
                new Jobs(3)));

        return data;
    }
}
