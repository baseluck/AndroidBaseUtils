package com.hjqjl.whlibrary.utils;

import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;

/**
 * wh 创建时间：2017/5/3 17:17
 */

/**
 * animation的使用方法
 * imageView.startAnimation(animation);
 */
public class AnimationUtils {
    /**
     * 获取一个放大动画
     *
     * @param durationMillis    时间
     * @param animationListener 监听
     * @return 返回一个放大的效果
     */
    public static ScaleAnimation getAmplificationAnimation(long durationMillis, AnimationListener animationListener) {
        // 以下四个值的解释只在RELATIVE_TO_SELF正确
        // fromX：起始该view横向所占的长度与自身宽度比值。
        // toX：结束该view横向所占的长度与自身长度比值。
        // fromY：起始该view纵向所占的长度与自身高度比值。
        // toY：结束该view纵向所占的长度与自身长度比值。
        // 以上四种属性值 0.0表示收缩到没有， 1.0表示正常无伸缩， 值小于1.0表示收缩， 值大于1.0表示放大
        //
        // pivotXType：X轴的伸缩模式，可以取值为ABSOLUTE、RELATIVE_TO_SELF、RELATIVE_TO_PARENT。
        // pivotXValue：为动画相对于物件的X坐标的开始位置
        //
        // pivotYType：Y轴的伸缩模式，可以取值为ABSOLUTE、RELATIVE_TO_SELF、RELATIVE_TO_PARENT。
        // pivotYValue：为动画相对于物件的Y坐标的开始位置
        // pivotXValue、pivotYValue 从0%-100%中取值
        // 50%为物件的X或Y方向坐标上的中点位置 ,如果是伸长，则是端点左右（上下）两边同时伸长toX-fromX（toY-fromy）
        // 100%为物体的右端点（下端点），如果是伸长，则只是向左（上）伸长toX-fromX（toY-fromy），端点的另一边无任何动作。
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(durationMillis);
        //动画执行完毕后是否停在结束时的角度上
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(animationListener);
        return scaleAnimation;
    }
}
