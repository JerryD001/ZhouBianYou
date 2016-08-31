package com.example.xm.zhoubianyouofour.utils.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Activity基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        initData();
        initEvents();
    }

    /**
     * 获取对应的布局文件
     *
     * @return
     */
    protected abstract int getLayout();

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化事件
     */
    protected abstract void initEvents();

}
