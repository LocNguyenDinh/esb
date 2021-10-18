package com.esb.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private final static String DD_MM_YYYY = "dd/MM/YYYY";

    public static String convertDate(Date date){
        DateFormat convert = new SimpleDateFormat(DateUtil.DD_MM_YYYY);
        String dateConvert = convert.format(date);
        return dateConvert;
    }
}
