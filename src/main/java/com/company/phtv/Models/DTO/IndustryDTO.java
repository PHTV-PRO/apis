package com.company.phtv.Models.DTO;

import com.company.phtv.Models.Entity.Skill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IndustryDTO {
    private int id;
    private  String name;
    private Set<Skill> skills;// skill dto
}
