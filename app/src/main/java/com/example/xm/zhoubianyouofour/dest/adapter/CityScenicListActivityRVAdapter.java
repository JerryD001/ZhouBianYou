package com.example.xm.zhoubianyouofour.dest.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xm.zhoubianyouofour.R;
import com.example.xm.zhoubianyouofour.dest.entity.CityScenicListBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by JerryDeng on 2016/7/2.
 */
public class CityScenicListActivityRVAdapter extends RecyclerView.Adapter {

    public static final int TYPE = 0;

    private LayoutInflater inflater;
    private List<CityScenicListBean.ContentBean> cbList;

    public CityScenicListActivityRVAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setCbList(List<CityScenicListBean.ContentBean> cbList) {
        this.cbList = cbList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE) {
            View itemView = inflater.inflate(R.layout.dest_item_activity_city_scenic_list, null);
            return new VHolder(itemView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VHolder) {
            CityScenicListBean.ContentBean contentBean = cbList.get(position);
            String imgUrl = "http://cdn5.yaochufa.com/" + contentBean.getAppImageUrl();//对图片连接进行拼接
            ImageLoader.getInstance().displayImage(imgUrl, ((VHolder) holder).img_homeImage);
            if (!contentBean.getFlag() .equals("")) {// 判断图片左上角有没有立减标志
                ((VHolder) holder).img_homeImage_flag.setVisibility(View.VISIBLE);
                ImageLoader.getInstance().displayImage(contentBean.getFlag(), ((VHolder) holder).img_homeImage_flag);
            }else {
                ((VHolder) holder).img_homeImage_flag.setVisibility(View.GONE);
            }
            ((VHolder) holder).tv_productName.setText(contentBean.getProductName());
            ((VHolder) holder).tv_productTitleContent.setText(contentBean.getProductTitleContent());
            ((VHolder) holder).tv_price.setText(contentBean.getPrice() + "");
            ((VHolder) holder).tv_originalPrice.setText("￥" + contentBean.getRetailPrice());
            ((VHolder) holder).tv_originalPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);// 设置中划线并加清晰
            ((VHolder) holder).tv_saledCount.setText("已售" + contentBean.getSaledCount());
        }
    }

    @Override
    public int getItemCount() {
        return cbList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return TYPE;
    }

    class VHolder extends RecyclerView.ViewHolder {

        ImageView img_homeImage, img_homeImage_flag;
        TextView tv_productName, tv_productTitleContent, tv_price, tv_originalPrice, tv_saledCount;

        public VHolder(View itemView) {
            super(itemView);
            img_homeImage = (ImageView) itemView.findViewById(R.id.dest_img_homeimage);
            img_homeImage_flag = (ImageView) itemView.findViewById(R.id.dest_img_homeimage_flag);
            tv_productName = (TextView) itemView.findViewById(R.id.dest_productName);
            tv_productTitleContent = (TextView) itemView.findViewById(R.id.dest_productTitleContent);
            tv_price = (TextView) itemView.findViewById(R.id.dest_price);
            tv_originalPrice = (TextView) itemView.findViewById(R.id.dest_originalPrice);
            tv_saledCount = (TextView) itemView.findViewById(R.id.dest_saledCount);
        }
    }
}
