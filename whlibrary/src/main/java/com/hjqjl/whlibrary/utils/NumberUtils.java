package com.hjqjl.whlibrary.utils;

import java.util.Locale;

public class NumberUtils {
    /**
     * 数字添加逗号 例：1000000000-->1,000,000,000
     */
    public static String formatComma(int num) {
        return String.format(Locale.CHINA, "%,d", num);//得到1,000,000,000
    }
}
