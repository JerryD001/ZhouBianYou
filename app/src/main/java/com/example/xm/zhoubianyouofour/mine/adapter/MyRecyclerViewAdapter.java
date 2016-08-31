package com.example.xm.zhoubianyouofour.mine.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.xm.zhoubianyouofour.R;
import com.example.xm.zhoubianyouofour.mine.ui.MineLoginActivity;
import com.example.xm.zhoubianyouofour.mine.ui.MineRegisterActivity;
import com.example.xm.zhoubianyouofour.utils.other.customindicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private static final int HEAD = 0;
    private static final int MIDDLE = 1;
    private static final int BOTTOM = 2;
    private static final int LINE = 3;
    private int type = 0;
    private Resources mRes;
    private int is;
    private List<String> mText;
    private Context mContext;
    private List<View> mViews;


    private int[] mPics = {0,0,R.drawable.ic_my_list_myorder, R.drawable.ic_my_list_panic_buying,0, R.drawable.ic_my_list_vip,
            R.drawable.ic_my_list_history, R.drawable.ic_my_list_favourite, R.drawable.ic_my_list_setting, R.drawable.ic_my_list_myorder,
            R.drawable.ic_my_list_history, R.drawable.ic_my_list_panic_buying,0, R.drawable.ic_my_list_favourite};


    public MyRecyclerViewAdapter(Context context, List<String> text) {
        this.mText = text;
        inflater = LayoutInflater.from(context);
        mRes = context.getResources();
        mViews = new ArrayList<View>();
        this.mContext =context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEAD) {
            View view = inflater.inflate(R.layout.mine_items_head_recyclerview_layout, parent, false);
            return new MyViewHolderHead(view);
        } else if (viewType == MIDDLE) {
            View view = inflater.inflate(R.layout.mine_items_middle_recyclerview_layout, parent, false);
            return new MyViewHolderMiddle(view);
        } else if (viewType == LINE) {
            View view = inflater.inflate(R.layout.mine_items_line_layout, parent, false);
            return new MyViewHolderLine(view);
        } else {
            View view = inflater.inflate(R.layout.mine_bottom_viewpager_layout, parent, false);
            return new MyViewHolderBottom(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolderHead) {

            ((MyViewHolderHead)holder).btn_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(mContext, MineLoginActivity.class);
                    mContext.startActivity(in);
                }
            });

            ((MyViewHolderHead)holder).btn_register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(mContext,MineRegisterActivity.class);
                    mContext.startActivity(in);
                }
            });

        } else if (holder instanceof MyViewHolderMiddle) {

            Integer pics = mPics[position];
            String text = mText.get(position);
            ((MyViewHolderMiddle) holder).img_order.setImageResource(pics);
            ((MyViewHolderMiddle) holder).text_order.setText(text);

            ((MyViewHolderMiddle)holder).accountInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(mContext,MineLoginActivity.class);
                    mContext.startActivity(in);

                }
            });

        }
        if (holder instanceof MyViewHolderBottom){
            View[] view = new View[4];
            for (int i=0;i<4;i++){
                view[0] = inflater.inflate(R.layout.mine_viewpager_items_layout,null);

                view[1] = inflater.inflate(R.layout.mine_viewpager_items2_layout,null);

                view[2] = inflater.inflate(R.layout.mine_viewpager_items3_layout,null);

                view[3] = inflater.inflate(R.layout.mine_viewpager_items4_layout,null);
                mViews.add(view[i]);
            }
            MyViewPagerAdapter mAdapter = new MyViewPagerAdapter();
            mAdapter.setViews(mViews);
            ((MyViewHolderBottom) holder).viewPager.setAdapter(mAdapter);
            ((MyViewHolderBottom) holder).indicator.setViewPager(((MyViewHolderBottom) holder).viewPager);

        }
    }

    @Override
    public int getItemCount() {
        return mText.size()+2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEAD;
        }
        if (position == 14) {
            return BOTTOM;
        }
        if (position == 1 || position == 4 || position == 12 || position == 15) {
            return LINE;
        }
        return MIDDLE;
    }

        class MyViewHolderHead extends RecyclerView.ViewHolder {

            private Button btn_login, btn_register;
            private LinearLayout myScore, myCashTicket;

            public MyViewHolderHead(View itemView) {
                super(itemView);

                btn_login = (Button) itemView.findViewById(R.id.btn_login);
                btn_register = (Button) itemView.findViewById(R.id.btn_register);
                myScore = (LinearLayout) itemView.findViewById(R.id.myScore);
                myCashTicket = (LinearLayout) itemView.findViewById(R.id.myCashTicket);


            }
        }

        class MyViewHolderMiddle extends RecyclerView.ViewHolder {

            private ImageView img_order, order_detail;
            private TextView text_order;
            private RelativeLayout accountInfo;

            public MyViewHolderMiddle(View itemView) {
                super(itemView);

                img_order = (ImageView) itemView.findViewById(R.id.img_order);
                text_order = (TextView) itemView.findViewById(R.id.text_order);
                order_detail = (ImageView) itemView.findViewById(R.id.order_detail);
                accountInfo = (RelativeLayout) itemView.findViewById(R.id.accountInfo);
            }
        }

        class MyViewHolderLine extends RecyclerView.ViewHolder {

            private View line;

            public MyViewHolderLine(View itemView) {
                super(itemView);
                line = itemView.findViewById(R.id.line);
            }
        }

        class MyViewHolderBottom extends RecyclerView.ViewHolder {
            private ViewPager viewPager;
            private CircleIndicator indicator;

            public MyViewHolderBottom(View itemView) {
                super(itemView);
                viewPager = (ViewPager) itemView.findViewById(R.id.mine_viewPager);
                indicator = (CircleIndicator) itemView.findViewById(R.id.mine_indicator);
            }

        }
    }


