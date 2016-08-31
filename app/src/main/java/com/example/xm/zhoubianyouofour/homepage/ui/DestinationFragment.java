package com.example.xm.zhoubianyouofour.homepage.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xm.zhoubianyouofour.R;
import com.example.xm.zhoubianyouofour.homepage.HomeContants;
import com.example.xm.zhoubianyouofour.homepage.entity.DestinationBean;
import com.example.xm.zhoubianyouofour.utils.other.OkHttpUtils;
import com.example.xm.zhoubianyouofour.utils.ui.BaseFragment;
import com.squareup.okhttp.Request;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class DestinationFragment extends BaseFragment{
    private ImageView[] images;
    private TextView[] textViews;
    private int id;
    private static final String KEY = "OK";
    @Override
    protected int getLayout() {
        return R.layout.home_appbar_destination_viewpager_item;
    }

    @Override
    protected void initView() {
        Bundle b = getArguments();
        if (b!=null){
            id = b.getInt(KEY);
        }
        images=new ImageView[]{(ImageView) root.findViewById(R.id.destination_viewpager_item_img1)
                ,(ImageView) root.findViewById(R.id.destination_viewpager_item_img2)
                ,(ImageView) root.findViewById(R.id.destination_viewpager_item_img3)};
        textViews = new TextView[]{(TextView) root.findViewById(R.id.destination_viewpager_item_txt1)
                ,(TextView) root.findViewById(R.id.destination_viewpager_item_txt2)
                ,(TextView) root.findViewById(R.id.destination_viewpager_item_txt3)};
    }

    @Override
    protected void initData() {
        destinationData(HomeContants.DESTINATIONURL);
    }

    @Override
    protected void initEvents() {

    }

    public static DestinationFragment getInstence(int id){
        Bundle b = new Bundle();
        b.putInt(KEY,id);
        DestinationFragment destinationFragment = new DestinationFragment();
        destinationFragment.setArguments(b);
        return destinationFragment;
    }

    public void destinationData(String url) {
        OkHttpUtils.getAsync(url, new OkHttpUtils.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) {
                DestinationBean destinationBean = DestinationBean.getDestinationBean(result);
                List<DestinationBean.ContentBean.ScenicDataBean> list = destinationBean.getContent().getScenicData();
                int yu = list.size() % 3;
                int chu = list.size() / 3;
                if (id == chu) {
                    for (int j=0;j<yu;j++) {
                        Picasso.with(getContext()).load(list.get(chu*3+j).getCoverPic()).into(images[j]);
                        textViews[j].setText(list.get(chu*3+j).getName());
                    }
                } else {
                    for (int i = 0; i < chu; i++) {
                        if (id == i) {
                            for (int j = 0; j < 3; j++) {
                                Picasso.with(getContext()).load(list.get(j + 3 * id).getCoverPic()).into(images[j]);
                                textViews[j].setText(list.get(j + 3 * id).getName());
                            }
                        }
                    }
                }
            }
        });
    }
}
