package com.example.taskmodule.mvp;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * @author RongJs
 * @package com.example.taskmodule.mvp
 * @date 2020/6/3
 * @desc
 */
public class TaskModel implements TaskContract.TaskModel {

    @Inject
    public TaskModel() {
    }

    @Override
    public Observable<String> getData() {

        Observable<String> stringObservable = new Observable<String>() {
            @Override
            protected void subscribeActual(Observer observer) {

            }
        };
        return stringObservable;
    }
}
