package com.hjqjl.whlibrary.utils;

import android.graphics.Bitmap;
import android.os.Environment;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SDCardUtils {
    /**
     * 检查是否存在SDCard
     * @return 是否存在SDCard
     */
    public static boolean hasSdcard(){
        String state = Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            return true;
        }else{
            return false;
        }
    }

    private final static String ALBUM_PATH = Environment.getExternalStorageDirectory() + "/download_test/";

    /**
     * 要sd卡权限  将bitmap存放到sdcard中,利用线程
     * @param bm
     * @param fileName
     * @throws IOException
     */
    public void saveFile(Bitmap bm, String fileName) throws IOException {
        File dirFile = new File(ALBUM_PATH);
        if (!dirFile.exists()) {
            dirFile.mkdir();
        }
        File myCaptureFile = new File(ALBUM_PATH + fileName);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
        bm.compress(Bitmap.CompressFormat.JPEG, 30, bos);;//30 是压缩率，表示压缩70%; 如果不压缩是100，表示压缩率为0。范围是0-100
        bos.flush();
        bos.close();
    }
}
