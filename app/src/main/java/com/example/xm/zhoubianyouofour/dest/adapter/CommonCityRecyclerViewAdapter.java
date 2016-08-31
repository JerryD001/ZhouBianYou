package com.example.xm.zhoubianyouofour.dest.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xm.zhoubianyouofour.R;
import com.example.xm.zhoubianyouofour.dest.Contants_dest;
import com.example.xm.zhoubianyouofour.dest.entity.CityTitleBean;
import com.example.xm.zhoubianyouofour.dest.entity.CommonCityContentBean;
import com.example.xm.zhoubianyouofour.dest.ui.CityScenicListActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by JerryDeng on 2016/6/29.
 */
public class CommonCityRecyclerViewAdapter extends RecyclerView.Adapter<CommonCityRecyclerViewAdapter.VHolder> {

    private static final int HOT_TXT_SCENIC = 0;
    private static final int HOT_TXT_CITY = 3;
    private static final int CITY_PICTURE = 1;
    private static final int CITY_LIST = 2;

    private Context context;
    private LayoutInflater inflater;

    private List<CommonCityContentBean.ContentBean.HotScenicBean> hsbList;
    private List<CommonCityContentBean.ContentBean.HotCityBean> hcbList;
    private CityTitleBean.ContentBean contentBean;

    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;

    public CommonCityRecyclerViewAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setHsbList(List<CommonCityContentBean.ContentBean.HotScenicBean> hsbList) {
        this.hsbList = hsbList;
    }

    public void setHcbList(List<CommonCityContentBean.ContentBean.HotCityBean> hcbList) {
        this.hcbList = hcbList;
    }

    public void setContentBean(CityTitleBean.ContentBean contentBean) {
        this.contentBean = contentBean;
    }

    @Override
    public VHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case HOT_TXT_CITY:
            case HOT_TXT_SCENIC:
                view = inflater.inflate(R.layout.dest_item_hot_txt, parent, false);
                break;
            case CITY_PICTURE:
                view = inflater.inflate(R.layout.dest_item_hotscenic, parent, false);
                break;
            case CITY_LIST:
                view = inflater.inflate(R.layout.dest_citylist_gridview, parent, false);
                break;
            default:
                break;
        }
        return new VHolder(view);
    }

    @Override
    public void onBindViewHolder(VHolder holder, final int position) {
        int type = getItemViewType(position);
        switch (type) {
            case HOT_TXT_SCENIC:
                ((TextView) holder.getView(R.id.dest_fit_item)).setText(contentBean.getName() + "热门景区");
                break;
            case HOT_TXT_CITY:
                ((TextView) holder.getView(R.id.dest_fit_item)).setText(contentBean.getName() + "热门城市");
                break;
            case CITY_PICTURE:
                holder.itemView.setTag(hsbList.get(position - 1));
                ImageLoader.getInstance().displayImage(hsbList.get(position - 1).getMudiPic(), (ImageView) holder.getView(R.id.dest_img_hot_scenic));
                ((TextView) holder.getView(R.id.dest_name_scenic)).setText(hsbList.get(position - 1).getScenicName());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onRecyclerViewItemClickListener.onItemClick((CommonCityContentBean.ContentBean.HotScenicBean) v.getTag(), position - 1);
                    }
                });

                break;
            case CITY_LIST:
                // TODO: 2016/6/29 0029
                ((GridView) holder.getView(R.id.dest_citylist_gridview)).setAdapter(new ItemOfCityListAdapter(context, hcbList));
                ((GridView) holder.getView(R.id.dest_citylist_gridview)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
                        //点击跳转到CityScenicListActivity，并携带HotCityBean过去
                        Intent intent = new Intent(context, CityScenicListActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(Contants_dest.HOT_CITY_LIST_KEY, hcbList.get(position));
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                    }
                });
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 1 + 4 + 1 + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HOT_TXT_SCENIC;
        } else if (position == 5) {
            return HOT_TXT_CITY;
        } else if (position >= 1 && position <= 4) {
            return CITY_PICTURE;
        } else {
            return CITY_LIST;
        }
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
                    return getItemViewType(position) == CITY_PICTURE ? 1 : gridManager.getSpanCount();
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
        void onItemClick(CommonCityContentBean.ContentBean.HotScenicBean hotScenicBean, int position);
    }

    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }
}
