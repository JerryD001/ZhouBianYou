package com.example.xm.zhoubianyouofour.homepage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xm.zhoubianyouofour.R;
import com.example.xm.zhoubianyouofour.homepage.entity.GridViewBean;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class GridViewBaseAdapter extends BaseAdapter {
    private List<GridViewBean.ContentBean> list;
    private List<GridViewBean.ContentBean.AdBean> adBeanList;
    private LayoutInflater mInflater;
    private Context context;
    public GridViewBaseAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);

    }

    public void setList(List<GridViewBean.ContentBean> list) {
        this.list = list;
        for (int i = 0;i<list.size();i++){
            if (list.get(i).getOperateId().equals("11")){
                adBeanList = list.get(i).getAd();
            }
        }
    }

    @Override
    public int getCount() {
        return adBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return adBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView ==null){
            convertView = mInflater.inflate(R.layout.home_appbar_gridview_item,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(adBeanList.get(position).getCt().getTitle());
        Picasso.with(context).load(adBeanList.get(position).getCt().getApp_picpath()).into(viewHolder.imageView);
        return convertView;
    }
    class ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.home_appbar_gridview_item_img);
            textView = (TextView) view.findViewById(R.id.home_appbar_gridview_item_title);
        }
    }
}
