package com.example.taskmodule.dagger;

import com.example.taskmodule.TaskActivity;

import dagger.Component;

/**
 * @author RongJs
 * @package com.example.taskmodule.dagger
 * @date 2020/6/3
 * @desc
 */
@Component(modules = DaggerModule.class)
public interface DaggerComponent {

    void injectMV(TaskActivity taskActivity);
}
