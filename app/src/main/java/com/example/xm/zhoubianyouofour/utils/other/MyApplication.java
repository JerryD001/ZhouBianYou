package com.example.xm.zhoubianyouofour.utils.other;

import android.app.Application;

import com.example.xm.zhoubianyouofour.R;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by JerryDeng on 2016/6/26.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        LogUtil.d("[===============]", "[MyApplication] onCreate");
        JPushInterface.setDebugMode(true);    // 设置开启日志,发布时请关闭日志(极光推送)
        JPushInterface.init(this);            // 初始化 JPush(极光推送)

        initImageLoader(); // 初始化universalImageLoader

    }


    /**
     * 初始化universalImageLoader网络图片缓存库
     * 用法：
     * imageUrl代表图片的URL地址，imageView代表承载图片的imageView控件
     * ImageLoader.getInstance().displayImage(imageUrl,imageView);
     */
    private void initImageLoader() {
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().
                showImageForEmptyUri(R.drawable.img_loading)
                .cacheInMemory(true).cacheOnDisk(true).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext()).defaultDisplayImageOptions(defaultOptions)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO).build();
        ImageLoader.getInstance().init(config);
    }
}
