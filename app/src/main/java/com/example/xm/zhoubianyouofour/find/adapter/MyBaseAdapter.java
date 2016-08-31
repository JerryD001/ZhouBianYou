package com.example.xm.zhoubianyouofour.find.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xm.zhoubianyouofour.R;
import com.example.xm.zhoubianyouofour.find.entity.BottomImgClickBean;
import com.example.xm.zhoubianyouofour.utils.other.OkHttpUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/6/30 0030.
 */
public class MyBaseAdapter extends BaseAdapter {
    private List<BottomImgClickBean.ContentBean.ProductListBean> productListBeenList;
    private Context context;
    private int resourceId;

    public MyBaseAdapter(List<BottomImgClickBean.ContentBean.ProductListBean> productListBeenList, Context context, int resourceId) {
        this.productListBeenList = productListBeenList;
        this.context = context;
        this.resourceId = resourceId;
    }

    @Override
    public int getCount() {
        return productListBeenList.size();
    }

    @Override
    public Object getItem(int position) {
        return productListBeenList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View converView, ViewGroup viewGroup) {
        View view;
        ViewHolder viewHolder;
        if (converView == null){
            view = LayoutInflater.from(context).inflate(resourceId,null);
            viewHolder = new ViewHolder();
            viewHolder.find_group1img = (ImageView) view.findViewById(R.id.find_group1img);
            viewHolder.find_productName = (TextView) view.findViewById(R.id.find_productName);
            viewHolder.find_productTitleContent = (TextView) view.findViewById(R.id.find_productTitleContent);
            viewHolder.find_price = (TextView) view.findViewById(R.id.find_price);
            viewHolder.find_originalPrice = (TextView) view.findViewById(R.id.find_originalPrice);
            viewHolder.find_originalPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//设置文字中间横线
            viewHolder.find_saledCount = (TextView) view.findViewById(R.id.find_saledCount);
            view.setTag(viewHolder);
        }else {
            view = converView;
            viewHolder = (ViewHolder) view.getTag();
        }
        String url = "http://cdn5.jinxidao.com/"+productListBeenList.get(position).getUrl();
        Picasso.with(context).load(url).into(viewHolder.find_group1img);
        viewHolder.find_productName.setText(productListBeenList.get(position).getProductName());
        viewHolder.find_productTitleContent.setText(productListBeenList.get(position).getProductTitleContent());
        viewHolder.find_price.setText(productListBeenList.get(position).getPrice()+"");
        viewHolder.find_originalPrice.setText(productListBeenList.get(position).getOriginalPrice()+"");
        viewHolder.find_saledCount.setText(productListBeenList.get(position).getSaledCount()+"");

        return view;
    }



    class ViewHolder{
        ImageView find_group1img;
        TextView find_productName,find_productTitleContent,find_price,find_originalPrice,find_saledCount;
    }
}
