package com.hjqjl.whlibrary.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * 流转换成字符串
 */
public class StreamUtils {
    /**
     * 将输入流转换为字符串
     *
     * @param inputStream inputStream
     * @return 转换之后的字符串
     */
    public static String streamToString(InputStream inputStream) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                out.write(buffer, 0, len);
                out.flush();
            }

            String result = out.toString();
            out.close();
            inputStream.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 将输入流转换为字节数组
     *
     * @param inputStream inputStream
     * @return 转换之后的字节数组
     */
    public static byte[] streamToByteArray(InputStream inputStream) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
            outputStream.flush();
        }
        byte[] result = outputStream.toByteArray();
        outputStream.close();
        inputStream.close();
        return result;
    }

}