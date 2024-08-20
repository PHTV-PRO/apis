package com.company.phtv.Models.DTO;



import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveCVDTO {
    private int id;
    private JobDTO job;
    private CVDTO cv;
    private AccountDTO account;
    private Date date_applied;
}
