package com.company.phtv.Models.Request;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestLocation {
    @Nullable
    public String name;
    @Nullable
    public int company_id;
    @Nullable
    public int city_provence_id ;
}



