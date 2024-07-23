package com.company.phtv.Models.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChartForEmployer {
    List<Integer> number_of_job_applicated;
    List<Integer> number_of_job_saved;
    List<Integer> number_of_job_viewed;
    List<Integer> month;
    List<Integer> jobs;
    List<Float> price_for_subcription_plan;
    List<Integer> subcription_plan;
}
