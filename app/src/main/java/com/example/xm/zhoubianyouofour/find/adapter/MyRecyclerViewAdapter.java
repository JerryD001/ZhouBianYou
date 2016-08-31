package com.example.xm.zhoubianyouofour.find.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xm.zhoubianyouofour.R;
import com.example.xm.zhoubianyouofour.find.entity.BottomImgBean;
import com.example.xm.zhoubianyouofour.utils.other.customindicator.CircleIndicator;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter {
    private Boolean flag = true;
    private static final int FOOTER = 5;//底部
    private static final int TOPVIEWPAGER = 4;//发现的viewpager
    private static final int TOPIMG = 0;//发现上面视图
    private static final int BOTTOMIMG = 1;//发现下面列表视图
    private static final int BOTTOMBAR = 2;//发现下面主题
    private static final int TOPBAR = 3;//发现上面专题
    private LayoutInflater mInflater;
    private int mType = 1;//发现下面列表视图
    private Context context;
    private List<BottomImgBean.ContentBean.ThemeListBean> themeListBeanList;
    private OnRecyclerViewFindItemClickListener recyclerViewFindItemClickListener;

    private int[] bigImgs = new int[]{0, R.drawable.t1, 0, R.drawable.t2, 0, R.drawable.t3};//截图的图片资源
    private List<View> list;


    public void setBottomImgBeenList(List<BottomImgBean.ContentBean.ThemeListBean> themeListBeanList) {
        this.themeListBeanList = themeListBeanList;
    }


    public MyRecyclerViewAdapter(Context context, int mType) {
        this.mType = mType;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        if (viewType == BOTTOMIMG) {
            if (itemView == null) {
                itemView = mInflater.inflate(R.layout.find_item_bottomimg, parent, false);
                BottomImgViewHolder bottomImgViewHolder = new BottomImgViewHolder(itemView);
                return bottomImgViewHolder;
            }
        } else if (viewType == BOTTOMBAR) {
            if (itemView == null) {
                itemView = mInflater.inflate(R.layout.find_item_theme, parent, false);
                BottomBarViewHolder bottomBarViewHolder = new BottomBarViewHolder(itemView);
                return bottomBarViewHolder;
            }

        } else if (viewType == TOPBAR) {
            if (itemView == null) {
                itemView = mInflater.inflate(R.layout.find_item_findtheme, parent, false);
                TopBarViewHolder topBarViewHolder = new TopBarViewHolder(itemView);
                return topBarViewHolder;
            }
        } else if (viewType == TOPIMG) {
            if (itemView == null) {
                itemView = mInflater.inflate(R.layout.find_item_topimg, parent, false);
                TopImgViewHolder topImgViewHolder = new TopImgViewHolder(itemView);
                return topImgViewHolder;
            }

        } else if (viewType == TOPVIEWPAGER) {
            if (itemView == null) {
                itemView = mInflater.inflate(R.layout.find_item_topviewpager, parent, false);
                TopViewPagerViewHolder topViewPagerViewHolder = new TopViewPagerViewHolder(itemView);
                return topViewPagerViewHolder;
            }

        }
//        else if (viewType == FOOTER){
//            if (itemView == null){
//                itemView = mInflater.inflate(R.layout.find_item_footer,parent,false);
//                FooterViewHolder footerViewHolder = new FooterViewHolder(itemView);
//                return footerViewHolder;
//            }
//        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof BottomImgViewHolder) {
            final BottomImgBean.ContentBean.ThemeListBean themeListBean = themeListBeanList.get(position - 8);
            holder.itemView.setTag(themeListBean);
//            ImageLoader.getInstance().displayImage(themeListBean.getImageUrl(),((BottomImgViewHolder)holder).img_bottom);
            Picasso.with(context).load(themeListBean.getImageUrl()).into(((BottomImgViewHolder) holder).img_bottom);
            ((BottomImgViewHolder) holder).tv_bottomBig.setText(themeListBean.getTitle());
            ((BottomImgViewHolder) holder).tv_bottomSmall.setText(themeListBean.getSubTitle());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewFindItemClickListener != null) {
                        recyclerViewFindItemClickListener.OnItemClick(view, themeListBean, position);
                    }
                }
            });
        } else if (holder instanceof TopImgViewHolder) {
            ((TopImgViewHolder) holder).img_top.setImageResource(bigImgs[position]);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewFindItemClickListener != null) {
                        recyclerViewFindItemClickListener.OnItemClick(view, bigImgs[position], position);
                    }
                }
            });

        } else if (holder instanceof TopViewPagerViewHolder) {
            list = new ArrayList<>();
            View[] view = new View[2];
//            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            for (int i = 0; i < 2; i++) {
                view[0] = mInflater.inflate(R.layout.find_item_img1, null);
                view[1] = mInflater.inflate(R.layout.find_item_img2, null);
//                view.setLayoutParams(lp);
                list.add(view[i]);
            }
            MyPagerAdapter pagerAdapter = new MyPagerAdapter(list);
            ((TopViewPagerViewHolder) holder).viewPager_top.setAdapter(pagerAdapter);


            ((TopViewPagerViewHolder) holder).circleI.setViewPager(((TopViewPagerViewHolder) holder).viewPager_top);
            flag = false;


        }
    }

    /**
     * RecyclerView的总长度
     *
     * @return
     */
    @Override
    public int getItemCount() {

        return themeListBeanList.size() + 2 + 3 + 3;
    }

    /**
     * 根据位置判断加载item
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        if (position == 1 || position == 3 || position == 5) {
            return TOPIMG;
        } else if (position == 0) {
            return TOPBAR;
        } else if (position == 2 || position == 4 || position == 6) {
            return TOPVIEWPAGER;
        } else if (position == 7) {
            return BOTTOMBAR;
        }
//        else if (position + 1 == getItemCount()){
//            return FOOTER;
//        }
        else {
            return BOTTOMIMG;
        }
    }


    /**
     * 下面5个ViewHolder
     */
    private class TopViewPagerViewHolder extends RecyclerView.ViewHolder {
        private ViewPager viewPager_top;
        private CircleIndicator circleI;

        public TopViewPagerViewHolder(View itemView) {
            super(itemView);
            viewPager_top = (ViewPager) itemView.findViewById(R.id.topimg_viewpager);
            circleI = (CircleIndicator) itemView.findViewById(R.id.find_circleIndicator);
        }
    }

    private class TopImgViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_top;


        public TopImgViewHolder(View itemView) {
            super(itemView);
            img_top = (ImageView) itemView.findViewById(R.id.topimg_img);

        }
    }

//    private class FooterViewHolder extends RecyclerView.ViewHolder{
//
//        public FooterViewHolder(View itemView) {
//            super(itemView);
//        }
//    }

    private class BottomBarViewHolder extends RecyclerView.ViewHolder {

        public BottomBarViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class TopBarViewHolder extends RecyclerView.ViewHolder {

        public TopBarViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class BottomImgViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_bottom;
        private TextView tv_bottomBig;
        private TextView tv_bottomSmall;

        public BottomImgViewHolder(View itemView) {
            super(itemView);
            img_bottom = (ImageView) itemView.findViewById(R.id.bottom_img);
            tv_bottomBig = (TextView) itemView.findViewById(R.id.bottom_bigtv);
            tv_bottomSmall = (TextView) itemView.findViewById(R.id.bottom_smalltv);
        }
    }


    /**
     * 点击事件接口
     */
    public interface OnRecyclerViewFindItemClickListener {
        public void OnItemClick(View view, Object object, int position);
    }

    public void setRecyclerViewFindItemClickListener(OnRecyclerViewFindItemClickListener recyclerViewFindItemClickListener) {
        this.recyclerViewFindItemClickListener = recyclerViewFindItemClickListener;
    }
}
