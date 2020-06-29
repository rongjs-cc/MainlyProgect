package com.example.taskmodule.cache;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

/**
 * @author rjs
 * @package com.example.taskmodule.cache
 * @date 2020/6/29
 * @desc
 */
public class NetUtil {

    static class MyTask extends AsyncTask<String,String,Bitmap>{

        @Override
        protected Bitmap doInBackground(String... strings) {
            String imageUrl=strings[0];
            HttpURLConnection connection=null;
            try {
                URL url = new URL(imageUrl);
                connection  = (HttpURLConnection) url.openConnection();
                connection.setReadTimeout(5000);
                connection.setConnectTimeout(5000);
                connection.setRequestMethod("GET");
                if(connection.getResponseCode()==200){
                    InputStream is = connection.getInputStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    return bitmap;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if(connection!=null){
                    connection.disconnect();
                }
            }
            return null;
        }
    }

    public static Bitmap getBitMap(String url) throws ExecutionException, InterruptedException {
        return new MyTask().execute(url).get();
    }
}
