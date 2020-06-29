package com.example.taskmodule.cache;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;

/**
 * @author rjs
 * @package com.example.taskmodule.cache
 * @date 2020/6/29
 * @desc
 */
public class LruUtils {

    private LruCache<String, Bitmap> lruCache;
    private long max=Runtime.getRuntime().maxMemory();

    public LruUtils() {
        lruCache=new LruCache<String,Bitmap>((int) (max/8)){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount();
            }
        };
    }

    /**
     * 缓存中获取图片
     * @param key
     * @return
     */
    public Bitmap getBitmap(String key){
        return lruCache.get(key);
    }

    /**
     * 图片放置缓存中
     */
    public void setBitmap(String key,Bitmap bitmap){
        lruCache.put(key,bitmap);
    }


}
