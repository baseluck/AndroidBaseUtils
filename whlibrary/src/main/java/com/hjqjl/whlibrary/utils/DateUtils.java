package com.hjqjl.whlibrary.utils;

import java.util.Locale;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期操作工具类
 */

public class DateUtils {

    /**
     * 英文全称  如：2020-06-01 23:15:06
     */
    public static String FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss";
    /**
     * 从年到秒的完整时间 如:20200601030303
     */
    public static String FORMAT_YMDHMS_SN = "yyyyMMddHHmmss";

    /**
     * 将yyyyMMddHHmmss格式转化为yyyy-MM-dd HH:mm:ss
     */
    public static String YMDHMS_SN2YMDHMS(String timeStr) {
        DateFormat format = new SimpleDateFormat(FORMAT_YMDHMS_SN, Locale.getDefault());
        Date dDate = null;
        try {
            dDate = format.parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (dDate == null) {
            return "";
        } else {
            DateFormat format2 = new SimpleDateFormat(FORMAT_YMDHMS, Locale.getDefault());
            String reTime = format2.format(dDate);
            return reTime;
        }
    }
}
