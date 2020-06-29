package com.example.commonentlib.base.mvp;

import androidx.lifecycle.LifecycleOwner;

/**
 * @author RongJs
 * @package com.example.commonentlib.base.mvp
 * @date 2020/6/3
 * @desc MVP中View的基层
 */
public interface BaseView {

    /**
     * 绑定生命周期
     * @return
     */
     LifecycleOwner getOwner();
}
