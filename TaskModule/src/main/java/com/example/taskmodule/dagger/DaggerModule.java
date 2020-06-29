package com.example.taskmodule.dagger;


import com.example.taskmodule.mvp.TaskContract;
import com.example.taskmodule.mvp.TaskPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author RongJs
 * @package com.example.taskmodule.dagger
 * @date 2020/6/3
 * @desc
 */
@Module
public class DaggerModule {

    private TaskContract.TaskModel taskModel;
    private TaskContract.TaskView taskView;

    public DaggerModule(TaskContract.TaskModel taskModel, TaskContract.TaskView taskView) {
        this.taskModel = taskModel;
        this.taskView = taskView;
    }

    @Provides
    public TaskPresenter providePresenter(){
        return new TaskPresenter(taskModel,taskView);
    }
}
