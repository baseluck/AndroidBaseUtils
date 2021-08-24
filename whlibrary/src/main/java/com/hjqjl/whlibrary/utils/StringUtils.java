package com.hjqjl.whlibrary.utils;

public class StringUtils {
    /**
     * 判断是否是空，字符串 null和"" 都返回 true
     */
    public static boolean isEmpty(String str) {
        return str == null || str.equals("");
    }

    /**
     * 字符串每4个字符添加一个空格 例：qwertyuio--->qwer tyui o
     */
    public static String addSpace(String str) {
        String regex = "(.{4})";
        return str.replaceAll(regex, "$1 ");//每4个字符添加一个空格
    }

    /**
     * 获取从start开始用*替换len个长度后的字符串
     *
     * @param str   要替换的字符串
     * @param start 开始位置
     * @param len   长度
     * @return 替换后的字符串
     */
    public static String getMaskStr(String str, int start, int len) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        if (str.length() < start) {
            return str;
        }
        // 获取*之前的字符串
        StringBuilder ret = new StringBuilder(str.substring(0, start));
        // 获取最多能打的*个数
        int strLen = str.length();
        if (strLen < start + len) {
            len = strLen - start;
        }
        // 替换成*
        for (int i = 0; i < len; i++) {
            ret.append("*");
        }
        // 加上*之后的字符串
        if (strLen > start + len) {
            ret.append(str.substring(start + len));
        }
        return ret.toString();
    }

}
