package com.example.taskmodule.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author rjs
 * @package com.example.taskmodule.cache
 * @date 2020/6/29
 * @desc
 */
public class SDUtil {

    /**
     * SD卡存入图片
     * @param key
     * @param bitmap
     */
    public static void setBitmap(String key, Bitmap bitmap){
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File file = new File(externalStoragePublicDirectory, key);
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,new FileOutputStream(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * SD卡获取图片
     */
    public static  Bitmap getBitmap(String key){
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File file = new File(externalStoragePublicDirectory, key);
            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
            return bitmap;
        }

        return null;
    }
}
