package com.example.a13466.gsst.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    private static String[] ti = new String[]{
                               "yyyy-MM-dd HH:mm:ss",              //1
                               "yyyy.MM.dd HH:mm:ss",              //2
                               "yyyy-MM-dd \n EEE",                //3
                               "yyyy-MM-dd \n EEEE",               //4
                               "yyyy.MM.dd \n HH:mm",              //5
                               "yyyy-MM-dd \n HH:mm",              //6
                               "yyyy-MM-dd \n HH:mm \n EEEE",      //7
                               "yyyy-MM-dd \n EEEE \n HH:mm:ss",}; //8

    public static String dataTime(int str){
        String strtime = ti[(str-1)];
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simp = new SimpleDateFormat(strtime);
        String datetime = simp.format(date);
        return datetime;
    }

}
