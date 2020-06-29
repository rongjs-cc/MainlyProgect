package com.example.commonentlib.base.mvp;

/**
 * @author RongJs
 * @package com.example.commonentlib.base.mvp
 * @date 2020/6/3
 * @desc
 */
public abstract class BasePresenter  <V extends BaseView,M extends BaseModel>{

    protected M mModel;
    protected V mView;

    public BasePresenter(M mModel, V mView) {
        this.mModel = mModel;
        this.mView = mView;
    }
    /**
     * 解除绑定View
     */
    public void destoryView(){
        if(mView!=null){
            mView=null;
        }
    }

    /**
     * 解除绑定Model
     */
    public void destoryModel(){
        if(mModel!=null){
            mModel=null;
        }
    }
}
