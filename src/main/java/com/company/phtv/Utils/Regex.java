package com.company.phtv.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static boolean regexEmail(String email) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");//a@gmail.com
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static boolean regexPassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{2,}$");//At least one letter and one number
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
