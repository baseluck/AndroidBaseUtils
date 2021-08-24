package com.hjqjl.whlibrary.widget;

import android.os.CountDownTimer;
import android.widget.Button;

/**
 * 倒计时Button帮助类
 * 作者：wh
 * 创建时间：2016/6/14 09:32
 * 用法
 * CountDownButtonHelper countDownButtonHelper = new CountDownButtonHelper(smsBtn);
 * countDownButtonHelper.start();//开始
 * ----------------
 * countDownButtonHelper.cancel();//取消
 */
public class CountDownButtonHelper {
    // 倒计时timer
    private CountDownTimer countDownTimer;
    // 计时结束的回调接口
    private OnFinishListener listener;

    private Button mButton;
    private String btnText;

    /**
     * @param button 需要显示倒计时的Button
     */
    public CountDownButtonHelper(Button button) {
        this.mButton = button;
        // 由于CountDownTimer并不是准确计时，在onTick方法调用的时候，time会有1-10ms左右的误差，这会导致最后一秒不会调用onTick()
        // 因此，设置间隔的时候，默认减去了10ms，从而减去误差。
        // 经过以上的微调，最后一秒的显示时间会由于10ms延迟的积累，导致显示时间比1s长max*10ms的时间，其他时间的显示正常,总时间正常
        countDownTimer = new CountDownTimer(60 * 1000, 1 * 1000 - 10) {//倒计时的最大值60s；倒计时的间隔1s

            @Override
            public void onTick(long time) {
                // 第一次调用会有1-10ms的误差，因此需要+15ms，防止第一个数不显示，第二个数显示2s
                mButton.setText("(" + ((time + 15) / 1000) + "秒)");
                //Logger.d("time = " + (time) + " text = " + ((time + 15) / 1000));
            }

            @Override
            public void onFinish() {
                mButton.setEnabled(true);
                if (btnText == null) {
                    mButton.setText("验证码");
                } else {
                    mButton.setText(btnText);//设置button上的文字
                }
                if (listener != null) {
                    listener.finish();
                }
            }
        };
    }

    /**
     * 开始倒计时
     */
    public void start() {
        mButton.setEnabled(false);
        countDownTimer.start();
    }

    /**
     * 关闭倒计时，一般onDestroy里会用到
     */
    public void cancel() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /**
     * 设置倒计时结束的监听器
     *
     * @param listener
     */
    public void setOnFinishListener(OnFinishListener listener) {
        this.listener = listener;
    }

    /**
     * 计时结束的回调接口
     *
     * @author zhaokaiqiang
     */
    public interface OnFinishListener {
        void finish();
    }

    //设置按钮里的文字
    public void setBtnText(String btnText) {
        this.btnText = btnText;
    }
}