package com.company.phtv.Models.Request;

import com.company.phtv.Enums.Role;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestEmployer {
    @Nullable
    public String address;
    @Nullable
    public String email;
    @Nullable
    public String name;
    @Nullable
    public String password;
    @Nullable
    public Role role;
}
