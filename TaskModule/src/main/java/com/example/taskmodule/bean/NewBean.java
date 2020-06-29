package com.example.taskmodule.bean;

/**
 * @author rjs
 * @package com.example.taskmodule.bean
 * @date 2020/6/29
 * @desc
 */
public class NewBean {

    private String title;
    private String context;
    private String imgUrl;

    public NewBean(String title, String context, String imgUrl) {
        this.title = title;
        this.context = context;
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
