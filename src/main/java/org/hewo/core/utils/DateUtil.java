package org.hewo.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final String SHORT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String FULL_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String SERIAL_NUMBER_DATE_FORMAT = "yyyyMMddHHmmss";
    public static final String MONTH_DAY_FORMAT = "MM.dd";
    public static final String YEAR_MONTH_FORMAT = "yyyy-MM";
    public static final String MINUTES_AND_SECONDS = "HH:mm:ss";

    public DateUtil() {
    }

    public static String getDateStr(Date date, String pattern) {
        if (null == date) {
            return "";
        } else {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            return format.format(date);
        }
    }
}
