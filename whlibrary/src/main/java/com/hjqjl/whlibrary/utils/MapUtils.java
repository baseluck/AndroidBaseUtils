package com.hjqjl.whlibrary.utils;

import java.util.Map;
import java.util.Set;

/**
 * @date :2021/4/7 20:39 wh
 */
public class MapUtils {
    /**
     * 处理map，value为null的值处理成空字符串
     */
    public static Map<String, Object> nullToEmpty(Map<String, Object> map) {
        Set<String> set = map.keySet();
        if (set != null && !set.isEmpty()) {
            for (String key : set) {
                if (map.get(key) == null) {
                    map.put(key, "");
                }
            }
        }
        return map;
    }
}