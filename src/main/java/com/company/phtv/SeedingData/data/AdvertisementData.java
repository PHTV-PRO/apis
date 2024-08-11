package com.company.phtv.SeedingData.data;

import com.company.phtv.Models.Entity.Advertisement;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementData {
    public List<Advertisement> Data(){
        List<Advertisement> data = new ArrayList<>();
        data.add(new Advertisement("https://shopee.vn/m/Uu-dai-nguoi-dung-moi-Quang-cao-Shopee-2024?utm_campaign=-&utm_content=1-NS-101-45413-&utm_medium=affiliates&utm_source=an_17040400028&utm_term=bkrprumzdhyh","https://res.cloudinary.com/dj7xlmndj/image/upload/v1723367859/i9iqcwln1on8sjvukqo7.png"));
        data.add(new Advertisement("https://enhancv.com/uk/blog/how-to-write-a-cv/","https://res.cloudinary.com/dj7xlmndj/image/upload/v1723368253/pgsjwbhihuybccdyzoh2.jpg"));
        data.add(new Advertisement("https://topdev.vn/page/trac-nghiem-tinh-cach?src=topdev.vn&medium=blog-homepage-middle","https://res.cloudinary.com/dj7xlmndj/image/upload/v1723368401/d0v4nnjicx76o2zlxakq.png"));
        return data;
    }
}
