# AndroidUtils

#### 介绍
android开发中收集和整理的帮助类（部分未测试，仅供大家参考）
[AndroidUtilCode](https://github.com/Blankj/AndroidUtilCode)有的我就不整理了。

#### 内容说明
##### utils
帮助类     | 描述
---------- | ------------------
[ActivityUtils](https://gitee.com/hjqjl/AndroidUtils/blob/master/whlibrary/src/main/java/com/hjqjl/whlibrary/utils/ActivityUtils.java) | 关闭所有activity用的帮助类
[AmountUtils](https://gitee.com/hjqjl/AndroidUtils/blob/master/whlibrary/src/main/java/com/hjqjl/whlibrary/utils/AmountUtils.java) | 金额元分之间转换工具类
[AnimationUtils](https://gitee.com/hjqjl/AndroidUtils/blob/master/whlibrary/src/main/java/com/hjqjl/whlibrary/utils/AnimationUtils.java) | animation的使用方法
[BarCodeBitmapUtils](http://gitee.com/hjqjl/AndroidUtils/blob/master/whlibrary/src/main/java/com/hjqjl/whlibrary/utils/BarCodeBitmapUtils) | 生成条形码和二维码工具类
[BitmapUtils](http://gitee.com/hjqjl/AndroidUtils/blob/master/whlibrary/src/main/java/com/hjqjl/whlibrary/utils/BitmapUtils)| BitmapUtils
[ButtonUtils](http://gitee.com/hjqjl/AndroidUtils/blob/master/whlibrary/src/main/java/com/hjqjl/whlibrary/utils/ButtonUtils)| ButtonUtils
[DateUtils](http://gitee.com/hjqjl/AndroidUtils/blob/master/whlibrary/src/main/java/com/hjqjl/whlibrary/utils/DateUtils)| 日期操作工具类
[ImageUtils](http://gitee.com/hjqjl/AndroidUtils/blob/master/whlibrary/src/main/java/com/hjqjl/whlibrary/utils/ImageUtils)| ImageUtils
[LogUtils](http://gitee.com/hjqjl/AndroidUtils/blob/master/whlibrary/src/main/java/com/hjqjl/whlibrary/utils/LogUtils)| 日志工具类
[NetWorkUtils](http://gitee.com/hjqjl/AndroidUtils/blob/master/whlibrary/src/main/java/com/hjqjl/whlibrary/utils/NetWorkUtils)| 网络状态
[NumberUtils](http://gitee.com/hjqjl/AndroidUtils/blob/master/whlibrary/src/main/java/com/hjqjl/whlibrary/utils/NumberUtils)| 数字处理工具类
[SDCardUtils](http://gitee.com/hjqjl/AndroidUtils/blob/master/whlibrary/src/main/java/com/hjqjl/whlibrary/utils/SDCardUtils)| SDCardUtils
[StreamUtils](http://gitee.com/hjqjl/AndroidUtils/blob/master/whlibrary/src/main/java/com/hjqjl/whlibrary/utils/StreamUtils)| 字节流工具类
[StringUtils](http://gitee.com/hjqjl/AndroidUtils/blob/master/whlibrary/src/main/java/com/hjqjl/whlibrary/utils/StringUtils)| 字符串工具类
[ThreadPoolManager](http://gitee.com/hjqjl/AndroidUtils/blob/master/whlibrary/src/main/java/com/hjqjl/whlibrary/utils/ThreadPoolManager)| 线程池管理类
[ValidUtils](http://gitee.com/hjqjl/AndroidUtils/blob/master/whlibrary/src/main/java/com/hjqjl/whlibrary/utils/ValidUtils)| 判断帮助类
[MapUtils](http://gitee.com/hjqjl/AndroidUtils/blob/master/whlibrary/src/main/java/com/hjqjl/whlibrary/utils/MapUtils)| Map帮助类

##### widget
帮助类     | 描述
---------- | ------------------
[CountDownButtonHelper](http://gitee.com/hjqjl/AndroidUtils/blob/master/whlibrary/src/main/java/com/hjqjl/whlibrary/widget/CountDownButtonHelper)  | 倒计时Button帮助类


### How to 
To get a Git project into your build:

 **Step 1. Add the JitPack repository to your build file**

gradle使用方法

Add it in your root build.gradle at the end of repositories:

```
allprojects {
	repositories {
	...
	maven { url 'https://jitpack.io' }
	}
}
```
 **Step 2. Add the dependency** 

```

dependencies {
        implementation 'com.gitee.hjqjl:AndroidUtils:v1.0.2'
}
```
