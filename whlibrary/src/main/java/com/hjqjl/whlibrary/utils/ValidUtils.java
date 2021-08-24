package com.hjqjl.whlibrary.utils;

import java.util.Collection;

public class ValidUtils {
    /**
     * 是否为Email
     */
    public static boolean isValidEmail(String paramString) {
        String regex = "[a-zA-Z0-9_\\.]{1,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
        if (paramString.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 是否为手机号
     */
    public static boolean isValidMobiNumber(String paramString) {
        String regex = "^1\\d{10}$";
        if (paramString.matches(regex)) {
            return true;
        }
        return false;
    }

    /**
     * 判断一个Collection类型的集合是否是一个空集合
     *
     * @param c 要判断集合
     * @return 如果为空返回true，否则返回false
     */
    public static boolean isCollectionEmpty(Collection c) {
        return ((c == null) || (c.size() == 0));
    }
}
