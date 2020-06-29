package com.example.mainlyprogect;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.commonentlib.base.BaseActivity;
import com.example.commonentlib.config.ArouterConfig;

public class MainActivity extends BaseActivity {

    private String[] permissions;

    @Override
    protected void doEvent() {
        ARouter.getInstance().build(ArouterConfig.TASKMODULEPATH).navigation();
        finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initData() {
        initPermission();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * 申请权限
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initPermission() {
        permissions = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE};

        boolean flag=true;
        for(int i=0;i<permissions.length;i++){
            if(!(ActivityCompat.checkSelfPermission(this,permissions[i])== PackageManager.PERMISSION_GRANTED)){
                flag=false;
            }
        }
        if(!flag){
            requestPermissions(permissions,100);
        }
    }

    /**
     * 响应权限事件
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            boolean flag = true;
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    flag = false;
                }
            }
            if (flag) {
                Toast.makeText(this, R.string.permission_pass, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, R.string.permission_nopass, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
