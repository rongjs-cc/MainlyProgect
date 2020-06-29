package com.example.taskmodule.mvp;

import com.example.commonentlib.base.mvp.BaseModel;
import com.example.commonentlib.base.mvp.BasePresenter;
import com.example.commonentlib.base.mvp.BaseView;
import com.example.taskmodule.bean.NewBean;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * @author RongJs
 * @package com.example.taskmodule.mvp
 * @date 2020/6/3
 * @desc
 */
public interface TaskContract {

    interface TaskView extends BaseView{
    }

    interface TaskModel extends BaseModel{
        Observable<ArrayList<NewBean>> getData();
    }

    abstract class  TaskPresenter extends BasePresenter<TaskView,TaskModel>{
        public TaskPresenter(TaskModel mModel, TaskView mView) {
            super(mModel, mView);
        }
        abstract public void toPresenter();
    }
}
