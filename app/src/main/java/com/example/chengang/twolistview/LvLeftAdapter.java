package com.example.chengang.twolistview;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by chengang on 2016/12/27.
 */

public class LvLeftAdapter extends BaseAdapter {
    List<DataBeans.DataBean.CategoriesBean> datas;

    public LvLeftAdapter(List<DataBeans.DataBean.CategoriesBean> datas) {
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         ViewHolder holder = null;
        if (convertView==null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_left, parent, false);
            holder.textView = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }

        holder.textView.setText("");
        holder.textView.setText(datas.get(position).getName());
        if (position == selectItem) {
            convertView.setBackgroundColor(Color.RED);
        }
        else {
            convertView.setBackgroundColor(Color.TRANSPARENT);
        }
        return convertView;
    }
    public  void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
        notifyDataSetChanged();
    }
    private int  selectItem=0;

class ViewHolder {
        TextView textView;
    }
}
