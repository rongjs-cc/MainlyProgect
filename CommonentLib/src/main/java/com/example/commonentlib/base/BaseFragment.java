package com.example.commonentlib.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author RongJs
 * @package com.example.commonentlib.base
 * @date 2020/6/3
 * @desc Fragment的基类
 */
public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getResId(), null);
        initData(view);
        initView(view);
        doEvent(view);
        return view;
    }

    /**
     * 初始化数据
     * @param view
     */

    protected abstract void initData(View view);

    /**
     * 初始化视图
     */
    protected abstract void initView(View view);

    /**
     * 事件处理
     */
    protected abstract void doEvent(View view);

    /**
     * 获取布局ID
     * @return
     */
    protected abstract  int getResId();

}
