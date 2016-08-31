package com.example.xm.zhoubianyouofour.dest.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xm.zhoubianyouofour.R;
import com.example.xm.zhoubianyouofour.dest.entity.HotCityContentBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by JerryDeng on 2016/6/29.
 */
public class HotCityRecyclerViewAdapter extends RecyclerView.Adapter<HotCityRecyclerViewAdapter.VHolder> {

    private static final int SCENIC_TEXT = 0;
    private static final int SCENIC_PICTURE = 1;
    private static final int CITY_TEXT = 2;
    private static final int CITY_PICTURE = 3;

    private LayoutInflater inflater;

    private List<HotCityContentBean.ContentBean.HotScenicBean> hsbList;
    private List<HotCityContentBean.ContentBean.HotCityBean> hcbList;

    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;

    public HotCityRecyclerViewAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setHsbList(List<HotCityContentBean.ContentBean.HotScenicBean> hsbList) {
        this.hsbList = hsbList;
    }

    public void setHcbList(List<HotCityContentBean.ContentBean.HotCityBean> hcbList) {
        this.hcbList = hcbList;
    }

    @Override
    public VHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case SCENIC_TEXT:
                view = inflater.inflate(R.layout.dest_item_nationwidehotscenictxt, parent, false);
                break;
            case SCENIC_PICTURE:
                view = inflater.inflate(R.layout.dest_item_hotscenic, parent, false);
                break;
            case CITY_TEXT:
                view = inflater.inflate(R.layout.dest_item_nationwidehotcitytxt, parent, false);
                break;
            case CITY_PICTURE:
                view = inflater.inflate(R.layout.dest_item_hotcity, parent, false);
                break;
        }
        return new VHolder(view);
    }

    @Override
    public void onBindViewHolder(VHolder holder, final int position) {
        int type = getItemViewType(position);
        switch (type) {
            case SCENIC_TEXT:
                break;
            case SCENIC_PICTURE:
                ImageLoader.getInstance().displayImage(hsbList.get(position - 1).getMudiPic(), (ImageView) holder.getView(R.id.dest_img_hot_scenic));
                ((TextView) holder.getView(R.id.dest_name_scenic)).setText(hsbList.get(position - 1).getScenicName());
                //实现item点击事件
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onRecyclerViewItemClickListener.onHotScenicItemClick(hsbList.get(position - 1), position - 1);
                    }
                });
                break;
            case CITY_TEXT:
                break;
            case CITY_PICTURE:
                ImageLoader.getInstance().displayImage(hcbList.get(position - 8).getPic(), (ImageView) holder.getView(R.id.dest_img_hot_city));
                ((TextView) holder.getView(R.id.dest_name_huocity_cn)).setText(hcbList.get(position - 8).getCityName());
                ((TextView) holder.getView(R.id.dest_name_huocity_pinyin)).setText(hcbList.get(position - 8).getPinYin());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onRecyclerViewItemClickListener.onHotCityItemClick(hcbList.get(position - 8), position - 8);
                    }
                });
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 24;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return SCENIC_TEXT;
        }
        if (position == 7) {
            return CITY_TEXT;
        }
        if (position >= 1 && position <= 6) {
            return SCENIC_PICTURE;
        }
        return CITY_PICTURE;
    }

    /**
     * 抽象方法getSpanSize方法的返回值决定了我们每个position上的item占据的单元格个数
     *
     * @param recyclerView
     */
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = (GridLayoutManager) manager;
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return getItemViewType(position) == SCENIC_TEXT || getItemViewType(position) == CITY_TEXT ? gridManager.getSpanCount() : 1;
                }
            });
        }
    }

    /**
     * 对VHolder进行封装，向外界提供getView方法
     * 这样写的好处是只用写一个VHolder，但值得是注意的是adapter里覆写的几个方法的返回值类型要做相应改变
     */
    public static class VHolder extends RecyclerView.ViewHolder {

        private SparseArray<View> viewCache;

        public VHolder(View itemView) {
            super(itemView);
            viewCache = new SparseArray<>();
        }

        public View getView(int resId) {
            View view;
            if (viewCache.indexOfKey(resId) < 0) {
                view = itemView.findViewById(resId);
                viewCache.put(resId, view);
            } else {
                view = viewCache.get(resId);
            }
            return view;
        }
    }

    public interface OnRecyclerViewItemClickListener {
        void onHotScenicItemClick(HotCityContentBean.ContentBean.HotScenicBean hotScenicBean, int position);

        void onHotCityItemClick(HotCityContentBean.ContentBean.HotCityBean hotCityBean, int position);
    }

    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }
}
