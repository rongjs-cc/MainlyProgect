package com.example.taskmodule;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonentlib.base.BaseActivity;
import com.example.commonentlib.config.ArouterConfig;
import com.example.taskmodule.dagger.DaggerComponent;
import com.example.taskmodule.dagger.DaggerDaggerComponent;
import com.example.taskmodule.dagger.DaggerModule;
import com.example.taskmodule.mvp.TaskContract;
import com.example.taskmodule.mvp.TaskModel;
import com.example.taskmodule.mvp.TaskPresenter;
import javax.inject.Inject;

@Route(path = ArouterConfig.TASKMODULEPATH)
public class TaskActivity extends BaseActivity implements TaskContract.TaskView {
    private TextView textView;
    @Inject
    TaskPresenter taskPresenter;
    @Override
    protected void doEvent() {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
    @Override
    protected void initData() {
        DaggerDaggerComponent.Builder builder = DaggerDaggerComponent.builder().daggerModule(new DaggerModule(new TaskModel(), TaskActivity.this));
        DaggerComponent build = builder.build();
        build.injectMV(TaskActivity.this);
    }
    @Override
    protected void initView() {
        textView=findViewById(R.id.tv);
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_task;
    }
    @Override
    public LifecycleOwner getOwner() {
        return this;
    }
}
