package com.example.app2.adapter;


import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.app2.R;

/**
 * 左侧菜单ListView的适配器
 * @author Administrator
 *
 */
public class MenuAdapter extends BaseAdapter{
	
	private Context context;
	private int selectItem = 0;
	private String data[] = {"热销榜","新品套餐","便当套餐","单点菜品","饮料类","水果罐头","米饭"};
	
	public MenuAdapter(Context context) {
		this.context = context;
	}
	
	public int getSelectItem() {
		return selectItem;
	}

	public void setSelectItem(int selectItem) {
		this.selectItem = selectItem;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if(arg1 == null) {
			holder = new ViewHolder();
			arg1 = View.inflate(context, R.layout.item_menu, null);
			holder.tv_name = (TextView)arg1.findViewById(R.id.item_name);
			arg1.setTag(holder);
		}else {
			holder = (ViewHolder)arg1.getTag();
		}
		if(arg0 == selectItem){
			holder.tv_name.setBackgroundColor(Color.WHITE);
			holder.tv_name.setTextColor(context.getResources().getColor(R.color.text_green));
		}else {
			holder.tv_name.setBackgroundColor(context.getResources().getColor(R.color.ll_coachback));
			holder.tv_name.setTextColor(context.getResources().getColor(R.color.text_deep));
		}
		holder.tv_name.setText(data[arg0]);
		return arg1;
	}
	static class ViewHolder{
		private TextView tv_name;
	}
}
