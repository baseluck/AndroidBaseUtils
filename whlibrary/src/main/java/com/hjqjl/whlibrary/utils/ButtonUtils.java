package com.hjqjl.whlibrary.utils;

public class ButtonUtils {
    /**
     * 防止按钮快速点击
     * 用法
     * public void onClick(View v) {
     * if (ButtonUtils.isFastClick()) {
     * return ;
     * }
     * }
     */
    private static long lastClickTime;

    public synchronized static boolean isFastClick() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}
