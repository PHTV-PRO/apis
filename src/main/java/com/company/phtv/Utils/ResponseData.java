package com.company.phtv.Utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData <T>{
    public int statusCode;
    public String message;
    public String error;
    public T data;
}
