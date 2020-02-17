package com.car.asistant.demo.kit;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class VerificationToken {


    public static String calculateExpiryDate(int expiryTimeInDays,String userId) {
        String pattern = "yyyy-MM-dd";
        Utils utils = new Utils();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        date  = calendar.getTime();

        String token = simpleDateFormat.format(date)+userId+utils.generateUserId(10);;

        return  token;
    }

}