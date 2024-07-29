package com.company.phtv.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Convert {
    public static String[] convertStringToObject(String listImage) {
        if (listImage == null) {
            return null;
        }
        String jsonString = listImage;
        ObjectMapper mapper = new ObjectMapper();
        try {
            String[] imageUrls = mapper.readValue(jsonString, String[].class);
            return imageUrls;
        } catch (Exception e) {
        }
        return null;
    }
}
