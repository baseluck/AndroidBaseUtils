package com.hjqjl.whlibrary.utils;

import android.util.Log;

/**
 * 日志相关类:默认是测试环境
 */
public class LogUtils {

    public static boolean isShowLog = true;
    private static String LOG_TAG = "LOG_TAG";

    public static void setLogSwitch(boolean isShowLog) {
        LogUtils.isShowLog = isShowLog;
    }

    public static void setGlobalTag(String tag) {
        LOG_TAG = tag;
    }

    public static void v(String msg) {
        if (isShowLog) {
            Log.v(LOG_TAG, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (isShowLog) {
            Log.v(tag, msg);
        }
    }

    public static void d(String msg) {
        if (isShowLog) {
            Log.d(LOG_TAG, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (isShowLog) {
            Log.d(tag, msg);
        }
    }

    public static void i(String msg) {
        if (isShowLog) {
            Log.i(LOG_TAG, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (isShowLog) {
            Log.i(tag, msg);
        }
    }


    public static void w(String msg) {
        if (isShowLog) {
            Log.w(LOG_TAG, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (isShowLog) {
            Log.w(tag, msg);
        }
    }


    public static void e(String msg) {
        if (isShowLog) {
            Log.e(LOG_TAG, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (isShowLog) {
            Log.e(tag, msg);
        }
    }

}