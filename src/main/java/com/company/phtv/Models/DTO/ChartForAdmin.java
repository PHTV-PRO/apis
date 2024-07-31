package com.company.phtv.Models.DTO;

import java.util.List;

import com.company.phtv.Models.Entity.Jobs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChartForAdmin {
    // thông tin job, account, company được tạo trong năm;
    Integer jobs_has_been_created;
    Integer account_has_been_created;
    Integer companys_has_been_created;
    // tổng số doanh thu theo năm ($$$)
    Float overall_payment;
    // tháng có doanh thu cao nhất trong năm
    Integer top_grossing_month;

    // thống kê thông tin tất cả các job của tất cả company theo từng tháng;
    List<Integer> number_of_job_applicated;
    List<Integer> number_of_job_saved;
    List<Integer> number_of_job_viewed;
    List<Integer> month;
    // thống kê số job được tạo theo tháng
    List<Integer> jobs;
    List<Float> price_for_subcription_plan;

    // (table) thông tin company 3  có appli, save cao nhất
    List<Jobs> company_3_job_by_application;
    List<Jobs> company_3_job_by_save;
}
