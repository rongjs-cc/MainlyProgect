package com.example.taskmodule.mvp;

import javax.inject.Inject;

/**
 * @author RongJs
 * @package com.example.taskmodule.mvp
 * @date 2020/6/3
 * @desc
 */
public class TaskPresenter extends TaskContract.TaskPresenter {

    @Inject
    public TaskPresenter(TaskContract.TaskModel mModel, TaskContract.TaskView mView) {
        super(mModel, mView);

    }

    @Override
    public void toPresenter() {

    }


}
