package com.company.phtv.Models.DTO;

import com.company.phtv.Enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private int id;
    private String name;
    private String email;
    private  String password;
    private  int gender;
    private  String address;
    private  String image;
    private Role role;
}
