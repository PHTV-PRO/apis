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
public class RequestIntermediaryJob {
    @Nullable
    public String account_id;
    @Nullable
    public String job_id;
}
