package com.hjqjl.whlibrary.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

import java.io.InputStream;

/**
 * Created by wh on 2016/1/19.
 */
public class BitmapUtils {
    /**
     * 将二进制流转化为Bitmap图片
     *
     * @param b 二进制字节流
     */
    public static Bitmap Bytes2Bitmap(byte[] b) {
        if (b.length != 0) {
            return BitmapFactory.decodeByteArray(b, 0, b.length);
        } else {
            return null;
        }
    }

    /**
     * 将图片改变颜色
     *
     * @param bitmap 图片
     */
    public static Bitmap changeColor(Bitmap bitmap, float[] colorArray) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap grayImg = null;
        try {
            grayImg = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(grayImg);
            Paint paint = new Paint();
            ColorMatrix colorMatrix = new ColorMatrix();
//          float[] colorArray = {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0};//改变 colorArray的值时会得到不同的效果
            colorMatrix.set(colorArray);
//            colorMatrix.setSaturation(0);//灰色
            ColorMatrixColorFilter colorMatrixFilter = new ColorMatrixColorFilter(colorMatrix);
            paint.setColorFilter(colorMatrixFilter);
            canvas.drawBitmap(bitmap, 0, 0, paint);
            bitmap.recycle();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return grayImg;
    }

    /**
     * 一、降低图片像素读取本地资源的图片
     *
     * @param context
     * @param resId   图片id，如：R.drawable.ic_launcher
     * @return Bitmap
     */
    public static Bitmap readBitmap(Context context, int resId) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        // 获取资源图片
        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt);
    }


    /**
     * 二、读取图片缩略图，原图片宽和高哪个数大，就按大的那个对应的输入的数换算倍数
     * 比三更节省内存
     *
     * @param context
     * @param resId     图片id，如：R.drawable.ic_launcher
     * @param reqWidth  缩略图的宽
     * @param reqHeight 缩略图的高
     * @return Bitmap
     */
    public static Bitmap decodeSampledBitmapFromStream(Context context,
                                                       int resId, int reqWidth, int reqHeight) {


        final BitmapFactory.Options options = new BitmapFactory.Options();
        // 获取资源图片
        InputStream is = context.getResources().openRawResource(resId);

        // true,只是读图片大小，不申请bitmap内存
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(is, null, options);


        // 计算缩小倍数：inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth,
                reqHeight);


        // 设为false，这次不是预读取图片大小，而是返回申请内存，bitmap数据
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(is, null, options);
    }

    /**
     * 三、读取图片缩略图，原图片宽和高哪个数大，就按大的那个对应的输入的数换算倍数
     *
     * @param res
     * @param resId     图片id，如：R.drawable.ic_launcher
     * @param reqWidth  缩略图的宽
     * @param reqHeight 缩略图的高
     * @return Bitmap
     */
    public static Bitmap decodeSampledBitmapFromResource(Resources res,
                                                         int resId, int reqWidth, int reqHeight) {


        final BitmapFactory.Options options = new BitmapFactory.Options();
        // true,只是读图片大小，不申请bitmap内存
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);


        // 计算缩小倍数：inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth,
                reqHeight);


        // 设为false，这次不是预读取图片大小，而是返回申请内存，bitmap数据
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }


    // 计算缩小倍数
    public static int calculateInSampleSize(BitmapFactory.Options options,
                                            int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;


        if (height > reqHeight || width > reqWidth) {
            if (width > height) {
                inSampleSize = Math.round((float) height / (float) reqHeight);
            } else {
                inSampleSize = Math.round((float) width / (float) reqWidth);
            }
        }
        return inSampleSize;
    }
}