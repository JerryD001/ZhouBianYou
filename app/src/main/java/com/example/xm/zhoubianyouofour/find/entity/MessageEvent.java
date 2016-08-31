package com.example.xm.zhoubianyouofour.find.entity;

/**
 * Created by Administrator on 2016/6/30 0030.
 */
public class MessageEvent {

    private Object object;
    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public MessageEvent(Object object,int position) {
        this.position = position;
        this.object = object;
    }

    public MessageEvent(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
