package com.example.chengang.twolistview;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by chengang on 2017/1/3.
 */

public class LvRightAdapter extends BaseAdapter {

    List<DataBeans.DataBean.CategoriesBean> datas;
    LinearLayout layout;

    public LvRightAdapter(List<DataBeans.DataBean.CategoriesBean> datas) {
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            //最外层
       // initView(position, parent);
        return layout;
    }

    private void initView(int position, ViewGroup parent) {
        layout = new LinearLayout(parent.getContext());
        ViewGroup.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layout.setOrientation(LinearLayout.VERTICAL);
        //文字
        TextView textView = new TextView(parent.getContext());
        textView.setGravity(Gravity.CENTER);
        //Rx布局
        ViewGroup.LayoutParams params1_tv = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setText(datas.get(position).getName());
        RightRecycleAdapter adapter = new RightRecycleAdapter(parent.getContext(), datas.get(position).getSubcategories());
        MyRecycleView recyclerView = new MyRecycleView(parent.getContext());
        MyRecycleView.LayoutParams params1 = new MyRecycleView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        recyclerView.setLayoutManager(new GridLayoutManager(parent.getContext(), 3));
        recyclerView.setAdapter(adapter);
        //添加到布局
        layout.addView(textView, params1_tv);
        layout.addView(recyclerView, params1);
    }


}
