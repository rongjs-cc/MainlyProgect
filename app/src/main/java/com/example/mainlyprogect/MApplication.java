package com.example.mainlyprogect;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author RongJs
 * @package com.example.mainlyprogect
 * @date 2020/6/3
 * @desc
 */
public class MApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initArouter();
    }

    private void initArouter() {
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
    }
}
