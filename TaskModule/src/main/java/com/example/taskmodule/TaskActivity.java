package com.example.taskmodule;

import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonentlib.base.BaseActivity;
import com.example.commonentlib.config.ArouterConfig;
import com.example.taskmodule.adapter.NewsRecyAdapter;
import com.example.taskmodule.bean.NewBean;
import com.example.taskmodule.dagger.DaggerComponent;
import com.example.taskmodule.dagger.DaggerDaggerComponent;
import com.example.taskmodule.dagger.DaggerModule;
import com.example.taskmodule.mvp.TaskContract;
import com.example.taskmodule.mvp.TaskModel;
import com.example.taskmodule.mvp.TaskPresenter;

import java.util.ArrayList;

import javax.inject.Inject;

@Route(path = ArouterConfig.TASKMODULEPATH)
public class TaskActivity extends BaseActivity implements TaskContract.TaskView, View.OnClickListener {

    @Inject
    TaskPresenter taskPresenter;
    private ArrayList<NewBean> list;
    private RecyclerView recyclerView;

    @Override
    protected void doEvent() {
        recyclerView.setAdapter(new NewsRecyAdapter(list,this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initData() {
        DaggerDaggerComponent.Builder builder = DaggerDaggerComponent.builder().daggerModule(new DaggerModule(new TaskModel(), TaskActivity.this));
        DaggerComponent build = builder.build();
        build.injectMV(TaskActivity.this);
        initListData();
    }

    @Override
    protected void initView() {
        recyclerView=findViewById(R.id.recyclerView);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_task;
    }

    @Override
    public LifecycleOwner getOwner() {
        return this;
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 模拟数据
     */
    private void initListData() {
        list = new ArrayList<>();
        list.add(new NewBean("新西兰克马德克群岛发生5.7级地震 震源深度10千米", "#地震快讯#中国地震台网正式测定：12月04日08时08分在克马德克群岛（南纬32.82度，西经178.73度）发生5.7级地震，震源深度10千米。", "http://cms-bucket.nosdn.127.net/catchpic/2/27/27e2ce7fd02e6c096e21b1689a8a3fe9.jpg?imageView&thumbnail=550x0"));
        list.add(new NewBean("俄罗斯喊冤不当\"背锅侠\" 俄美陷入\"后真相\"旋涡", "差到令人震惊”，但不怪特朗普。俄罗斯总理德米特里·梅德韦杰夫近日在谈到俄美关系时这样说。俄罗斯近来连遭美国“恶毒”指责和西方国家连环出击。一些国际舆论认为，俄罗斯成了“背锅侠”，俄罗斯自己也公开喊冤斥责美国。在俄美你来我往的互掐中，真相似乎变得已不那么重要了。", "http://cms-bucket.nosdn.127.net/catchpic/c/c8/c8b0685089258b82f3ca1997def78d8d.png?imageView&thumbnail=550x0"));
        list.add(new NewBean("中企投资巴西获支持 英媒:巴西人感激\"保住饭碗\"", "参考消息网12月4日报道 英媒称，里约热内卢附近的阿苏港曾被埃克·巴蒂斯塔称为“通往中国的公路”，10多年前，这位现已名誉扫地的巴西前首富创建了这个超级港，大宗商品热潮结束后，他在巴西的商业帝国几乎无一幸存并于2014年破产，但此后至今有一个项目仍蓬勃发展，那就是阿苏港。", "http://cms-bucket.nosdn.127.net/catchpic/8/8b/8ba2d19b7f63efc5cf714960d5edd2c3.jpg?imageView&thumbnail=550x0"));
        list.add(new NewBean("美电视台记者因误报有关弗林新闻被停职四周", "【环球网报道】据俄罗斯卫星网12月3日报道，美国ABC电视台记者布莱恩·罗素因在有关美国总统前国家安全顾问迈克尔·弗林的新闻报道中的失误，临时被停职。", "http://cms-bucket.nosdn.127.net/5d18566fde70407b9cc3a728822115c320171203133214.jpeg?imageView&thumbnail=550x0"));
    }

}
