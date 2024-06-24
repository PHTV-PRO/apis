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
public class SearchAll {
    private List<AccountDTO> accounts;
    private List<CompanyDTO> companies;
    private List<JobDTO> jobs;
}
