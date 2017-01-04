package com.example.app2.adapter;


import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.app2.R;
import com.example.app2.entity.FoodData;

import java.util.List;

/**
 * 右侧主界面ListView的适配器
 * 
 * @author Administrator
 * 
 */
public class HomeAdapter extends BaseAdapter {
	private Context context;
	private List<FoodData> foodDatas;
	
	public HomeAdapter(Context context, List<FoodData> foodDatas) {
		this.context = context;
		this.foodDatas = foodDatas;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(foodDatas!=null){
			return foodDatas.size();
		}else {		
			return 10;
		}		
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
		ViewHold holder = null;
		if(arg1 == null){
			arg1 = View.inflate(context, R.layout.item_home, null);
			holder = new ViewHold();
			holder.tv_title = (TextView)arg1.findViewById(R.id.item_home_title);
			holder.tv_name = (TextView)arg1.findViewById(R.id.item_home_name);
			arg1.setTag(holder);
		}else {
			holder = (ViewHold)arg1.getTag();
		}
		holder.tv_name.setText(foodDatas.get(arg0).getName());
		holder.tv_title.setText(foodDatas.get(arg0).getTitle());
		if(arg0 == 0){
			holder.tv_title.setVisibility(View.VISIBLE);
		}else if (!TextUtils.equals(foodDatas.get(arg0).getTitle(), foodDatas.get(arg0 -1).getTitle())) {
			holder.tv_title.setVisibility(View.VISIBLE);
		}else {
			holder.tv_title.setVisibility(View.GONE);
		}
		return arg1;
	}
	private static class ViewHold{
		private TextView tv_title;
		private TextView tv_name;
	}
}
