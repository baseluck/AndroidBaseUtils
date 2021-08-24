package com.hjqjl.whlibrary.utils;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.view.Gravity;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.util.Hashtable;

/**
 * 条码二维码生成工具
 */
public class BarcodeBitmapUtils {

    /**
     * 生成条形码(上面条形码，下面数字)
     *
     * @param context       上下文
     * @param contents      需要生成的内容(输入数字)
     * @param desiredWidth  生成条形码的宽带
     * @param desiredHeight 生成条形码的高度
     * @param displayCode   是否在条形码shang方显示内容
     * @return 返回合并之后的条形码
     */
    public static Bitmap createMixtureBarcode(Context context, String contents, int desiredWidth, int desiredHeight, boolean displayCode) {
        Bitmap ruseltBitmap = null;

        //条形码的编码类型
        BarcodeFormat barcodeFormat = BarcodeFormat.CODE_128;

        if (displayCode) {
            Bitmap barcodeBitmap = createBarcodeBitmap(contents, barcodeFormat, desiredWidth, desiredHeight);
            Bitmap codeBitmap = createNumCodeBitmap(contents, desiredWidth, desiredHeight, context);
            ruseltBitmap = mixtureBitmap(codeBitmap, barcodeBitmap, new PointF(0, desiredHeight));
        } else {
            ruseltBitmap = createBarcodeBitmap(contents, barcodeFormat, desiredWidth, desiredHeight);
        }

        return ruseltBitmap;
    }

    /**
     * 生成二维码 要转换的地址或字符串,可以是中文
     *
     * @param content 需要生成的内容
     * @param width   宽
     * @param height  高
     * @return 图片Bitmap
     */
    public static Bitmap createQRCode(String content, final int width, final int height) {
        try {
            // 判断URL合法性
            if (content == null || "".equals(content) || content.length() < 1) {
                return null;
            }
            Hashtable<EncodeHintType, String> hints = new Hashtable<>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            // 图像数据转换，使用了矩阵转换
            BitMatrix bitMatrix = new QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            int[] pixels = new int[width * height];
            // 下面这里按照二维码的算法，逐个生成二维码的图片，
            // 两个for循环是图片横列扫描的结果
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (bitMatrix.get(x, y)) {
                        pixels[y * width + x] = 0xff000000;
                    } else {
                        pixels[y * width + x] = 0xffffffff;
                    }
                }
            }
            // 生成二维码图片的格式，使用ARGB_8888
            Bitmap bitmap = Bitmap.createBitmap(width, height, Config.RGB_565);
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
            return bitmap;
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成条形码的Bitmap
     *
     * @param contents      需要生成的内容(输入数字)
     * @param format        编码格式 如：BarcodeFormat.CODE_128
     * @param desiredWidth  生成条码的宽
     * @param desiredHeight 生成条码的高
     * @return 图片Bitmap
     */
    private static Bitmap createBarcodeBitmap(String contents, BarcodeFormat format, int desiredWidth, int desiredHeight) {
        final int WHITE = 0xFFFFFFFF;
        final int BLACK = 0xFF000000;

        MultiFormatWriter writer = new MultiFormatWriter();
        BitMatrix result = null;
        try {
            result = writer.encode(contents, format, desiredWidth, desiredHeight, null);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        if (result != null) {
            int width = result.getWidth();
            int height = result.getHeight();
            int[] pixels = new int[width * height];
            // All are 0, or black, by default
            for (int y = 0; y < height; y++) {
                int offset = y * width;
                for (int x = 0; x < width; x++) {
                    pixels[offset + x] = result.get(x, y) ? BLACK : WHITE;
                }
            }

            Bitmap bitmap = Bitmap.createBitmap(width, height, Config.RGB_565);
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
            return bitmap;
        } else {
            return null;
        }
    }

    /**
     * 生成显示编码数字的Bitmap(一串数字)
     *
     * @param numberStr 需要生成的内容(输入数字)
     * @param width     生成条码的宽
     * @param height    生成条码的高
     * @param context   上下文
     * @return 数字转化的图片Bitmap
     */
    private static Bitmap createNumCodeBitmap(String numberStr, int width, int height, Context context) {
        TextView tv = new TextView(context);
        tv.setTextSize(21);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams(layoutParams);
        //Logger.v(contents);
        String regex = "(.{4})";
        numberStr = numberStr.replaceAll(regex, "$1    ");//每4个字符添加一个空格
        tv.setText(numberStr);
        // tv.setHeight(height);
        tv.setGravity(Gravity.CENTER_HORIZONTAL);
        tv.setWidth(width);
        tv.setDrawingCacheEnabled(true);
        tv.setTextColor(Color.BLACK);
        tv.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
        tv.layout(0, 0, tv.getMeasuredWidth(), tv.getMeasuredHeight());

        tv.buildDrawingCache();
        Bitmap numberBitmapCode = tv.getDrawingCache();
        return numberBitmapCode;
    }

    /**
     * 将两个Bitmap合并成一个（上下）
     *
     * @param firstBitmap  第一张图片
     * @param secondBitmap 第二章图片
     * @param fromPoint    第二个Bitmap开始绘制的起始位置（相对于第一个Bitmap）
     * @return 合并之后的图片
     */
    private static Bitmap mixtureBitmap(Bitmap firstBitmap, Bitmap secondBitmap, PointF fromPoint) {
        if (firstBitmap == null || secondBitmap == null || fromPoint == null) {
            return null;
        }
        Bitmap newBitmap = Bitmap.createBitmap(firstBitmap.getWidth(), firstBitmap.getHeight() + secondBitmap.getHeight(), Config.ARGB_4444);
        Canvas cv = new Canvas(newBitmap);
        cv.drawBitmap(firstBitmap, 0, 0, null);
        cv.drawBitmap(secondBitmap, fromPoint.x, firstBitmap.getHeight(), null);
        cv.save();
        cv.restore();
        return newBitmap;
    }
}