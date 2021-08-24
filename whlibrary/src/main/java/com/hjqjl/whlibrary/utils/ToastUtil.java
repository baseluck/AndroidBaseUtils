package com.hjqjl.whlibrary.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hjqjl.whlibrary.R;

public class ToastUtil {
    private static Toast toast;

    public static void showC(Context context, String text) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        if (toast == null) {
            toast = new Toast(context);
        } else {
            toast.cancel();
            toast = new Toast(context);
        }
        LayoutInflater inflater = LayoutInflater.from(context);
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.custom_toast_layout, null);
        TextView textView1 = view.findViewById(R.id.tv_toast);
        textView1.setText(text);
        toast.setView(view);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }
}
