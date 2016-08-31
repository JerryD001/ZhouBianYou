package com.example.xm.zhoubianyouofour.utils.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * created Jerry on 16/5/5.
 * <p>
 * Fragment的基类
 */
public abstract class BaseFragment extends Fragment {
    /**
     * Fragment对应的底部布局
     **/
    protected View root;

    /**
     * 创建Fragment对应的布局文件
     *
     * @param inflater           布局加载器
     * @param container          父容器
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(getLayout(), container, false);
        return root;
    }

    /**
     * Fragment对应的宿主Activity创建完成后的回调方法
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

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
     * 初始化布局
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
