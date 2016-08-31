package com.example.xm.zhoubianyouofour.homepage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xm.zhoubianyouofour.R;
import com.example.xm.zhoubianyouofour.homepage.entity.RecyclerBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/6/30 0030.
 */
public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int MAIN = 0;
    private static final int FOOTER = 1;
    private LayoutInflater minflater;
    private Context context;
    private int mtype = 0;
    private List<RecyclerBean.ContentBean.Data> list;
    private ItemOnClickListen onClickListen;

    public RecyclerviewAdapter(int mtype, Context context) {
        this.mtype = mtype;
        this.context = context;
        this.minflater = LayoutInflater.from(context);
    }

    public void setList(List<RecyclerBean.ContentBean.Data> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = null;
        if (viewType==MAIN){
            if (itemview==null){
                itemview = minflater.inflate(R.layout.home_tab_recylerview_item,parent,false);
                ItemViewholder viewholder = new ItemViewholder(itemview);
                return viewholder;
            }
        }else if (viewType==FOOTER){
            View footitemView = minflater.inflate(R.layout.home_recyclerciew_footer,parent,false);
            FooterViewHolder footerViewHolder = new FooterViewHolder(footitemView);
            return footerViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ItemViewholder){
            RecyclerBean.ContentBean.Data dataBean = list.get(position);
            holder.itemView.setTag(dataBean);
            Picasso.with(context).load(dataBean.getBigImageUrl()).into(((ItemViewholder) holder).imageView);
            ((ItemViewholder) holder).contanttxt.setText(dataBean.getProductName()+"-"+dataBean.getProductTitleContent());
            if (dataBean.isRecommend()){
                ((ItemViewholder) holder).recomendtxt.setVisibility(View.VISIBLE);
            }
            if (dataBean.getStateText()!=null){
                ((ItemViewholder) holder).statetxt.setText(" "+dataBean.getStateText().toString()+" ");
            }
            ((ItemViewholder) holder).citytxt.setText("  "+dataBean.getCityName()+"  ");
            ((ItemViewholder) holder).labeltxt.setText("  "+dataBean.getLabelText()+"  ");
            ((ItemViewholder) holder).saletxt.setText("已售"+dataBean.getSaledCount());
            ((ItemViewholder) holder).pricetxt.setText(" ￥"+dataBean.getPrice()+"起 ");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickListen!=null){
                        onClickListen.onClickListen(v, (RecyclerBean.ContentBean.Data) v.getTag(),position);
                    }
                }
            });

        }else if (holder instanceof FooterViewHolder){

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position+1 == getItemCount()){
            return FOOTER;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ItemViewholder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView contanttxt,recomendtxt,statetxt,citytxt,labeltxt,saletxt,pricetxt;
        public ItemViewholder(View itemView) {
            super(itemView);
            imageView  = (ImageView) itemView.findViewById(R.id.recyclerview_img);
            contanttxt = (TextView) itemView.findViewById(R.id.recyclerview_contant);
            recomendtxt = (TextView) itemView.findViewById(R.id.recyclerview_recommend);
            statetxt = (TextView) itemView.findViewById(R.id.recyclerview_stateText);
            citytxt = (TextView) itemView.findViewById(R.id.recyclerview_city);
            labeltxt = (TextView) itemView.findViewById(R.id.recyclerview_label);
            saletxt = (TextView) itemView.findViewById(R.id.recyclerview_sale);
            pricetxt = (TextView) itemView.findViewById(R.id.recyclerview_price);
        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder{

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }

    public interface ItemOnClickListen{
        void onClickListen(View v, RecyclerBean.ContentBean.Data dataBean, int position);
    }

    public void setOnClickListen(ItemOnClickListen onClickListen) {
        this.onClickListen = onClickListen;
    }
}
