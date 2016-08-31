package com.example.xm.zhoubianyouofour.dest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.xm.zhoubianyouofour.R;

import java.util.List;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class PopupWindowAdapter extends BaseAdapter {

    private List<String> titleList;
    private Context context;

    public PopupWindowAdapter(Context context) {
        this.context = context;
    }

    public void setTitleList(List<String> titleList) {
        this.titleList = titleList;
    }

    @Override
    public int getCount() {
        return titleList.size();
    }

    @Override
    public Object getItem(int position) {
        return titleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
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
        vHolder.textView.setText(titleList.get(position));
        return convertView;
    }

    class VHolder {
        TextView textView;
    }
}
