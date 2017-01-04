package com.example.chengang.twolistview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by chengang on 2016/12/30.
 */

public class RightRecycleAdapter extends RecyclerView.Adapter<RightRecycleAdapter.MyHolder> {
    Context mContext;
    List<DataBeans.DataBean.CategoriesBean.SubcategoriesBean> subcategories;

    public RightRecycleAdapter(Context mContext, List<DataBeans.DataBean.CategoriesBean.SubcategoriesBean> subcategories) {
        this.mContext = mContext;
        this.subcategories = subcategories;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_right_rx, parent, false);
        LinearLayout layout=new LinearLayout(mContext);
        return new MyHolder(view);

    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Glide.with(mContext).load(subcategories.get(position).getIcon_url()).into(holder.imageView);
        holder.textView.setText(subcategories.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return subcategories.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public MyHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_rx_iv);
            textView = (TextView) itemView.findViewById(R.id.item_rx_tv);

        }
    }

}
