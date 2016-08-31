package com.example.xm.zhoubianyouofour.dest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.xm.zhoubianyouofour.R;
import com.example.xm.zhoubianyouofour.dest.entity.CommonCityContentBean;

import java.util.List;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class ItemOfCityListAdapter extends BaseAdapter {

    private List<CommonCityContentBean.ContentBean.HotCityBean> hcbList;
    private Context context;

    public ItemOfCityListAdapter(Context context, List<CommonCityContentBean.ContentBean.HotCityBean> hcbList) {
        this.hcbList = hcbList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return hcbList.size();
    }

    @Override
    public Object getItem(int i) {
        return hcbList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VHolder vHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.dest_item_city_btn, null);
            vHolder = new VHolder();
            vHolder.textView = (TextView) convertView.findViewById(R.id.dest_item_city_btn);
            convertView.setTag(vHolder);
        } else {
            vHolder = (VHolder) convertView.getTag();
        }
        vHolder.textView.setText(hcbList.get(position).getCityName());
        return convertView;
    }

    class VHolder {
        TextView textView;
    }
}
