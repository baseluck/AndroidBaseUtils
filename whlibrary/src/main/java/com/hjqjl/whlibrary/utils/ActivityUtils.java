package com.hjqjl.whlibrary.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/*
 * 关闭所有activity用的，用System.exit（0）退不全
 * 然后在每个Activity的onCreate()方法中添加下面代码：
 * ActivityUtils.getInstance().addActivity(this);
 * 在需要结束所有Activity的时候调用exit方法：
 * ActivityUtils.getInstance().exit();
 */
public class ActivityUtils {
    private List<Activity> activityList = new ArrayList<>();
    private static ActivityUtils instance;

    private ActivityUtils() {// 单例模式中获取唯一的MyApplication实例
    }

    public static ActivityUtils getInstance() {
        if (null == instance) {
            instance = new ActivityUtils();
        }
        return instance;
    }

    public void addActivity(Activity activity) {// 添加Activity到容器中
        activityList.add(activity);
    }

    public void removeActivity(Activity activity) {//从容器中删除Activity
        activityList.remove(activity);
    }

    public void exit() {
        clearAllActivity();
        System.exit(0);
    }

    private void clearAllActivity() {
        for (Activity activity : activityList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}