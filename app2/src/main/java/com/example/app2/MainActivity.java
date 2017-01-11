package com.example.app2;

import java.util.ArrayList;
import java.util.List;

import android.widget.AbsListView.OnScrollListener;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.app2.adapter.HomeAdapter;
import com.example.app2.adapter.MenuAdapter;
import com.example.app2.entity.FoodData;

/**
 * 防饿了的ListView联动的Demo
 * 有BUG
 * @author Administrator
 *
 */
public class MainActivity extends Activity {
	/**左侧菜单*/
	private ListView lv_menu;
	/**右侧主菜*/
	private ListView lv_home;
	private TextView tv_title;
	
	private MenuAdapter menuAdapter;
	private HomeAdapter homeAdapter;
	private int currentItem;
	/**
	 * 数据源
	 */
	private List<FoodData> foodDatas;
	private String data[] = {"热销榜","新品套餐","便当套餐","单点菜品","饮料类","水果罐头","米饭"};
	/**
	 * 里面存放右边ListView需要显示标题的条目position
	 */
	private ArrayList<Integer> showTitle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		setView();
		setData();
	}

	private void setView() {
		// TODO Auto-generated method stub
		lv_menu = (ListView)findViewById(R.id.lv_menu);
		tv_title = (TextView)findViewById(R.id.tv_titile);
		lv_home = (ListView)findViewById(R.id.lv_home);
		
		foodDatas = new ArrayList<FoodData>();
		for(int i =0;i < data.length; i++){
			foodDatas.add(new FoodData(i, data[0] + i, data[0]));
		}
		for(int i =0;i < data.length -1; i++){
			foodDatas.add(new FoodData(i, data[1] + i, data[1]));
		}
		for(int i =0;i < data.length-2; i++){
			foodDatas.add(new FoodData(i, data[2] + i, data[2]));
		}
		for(int i =0;i < data.length-3; i++){
			foodDatas.add(new FoodData(i, data[3] + i, data[3]));
		}
		for(int i =0;i < data.length-4; i++){
			foodDatas.add(new FoodData(i, data[4] + i, data[4]));
		}
		for(int i =0;i < data.length-3; i++){
			foodDatas.add(new FoodData(i, data[5] + i, data[5]));
		}
		for(int i =0;i < 6; i++){
			foodDatas.add(new FoodData(i, data[6] + i, data[6]));
		}
		showTitle = new ArrayList<Integer>();
		for(int i = 0; i < foodDatas.size(); i++){
			if( i ==0){
				showTitle.add(i );
				System.out.println(i + "dd");
			}else if (!TextUtils.equals(foodDatas.get(i).getTitle(), foodDatas.get(i - 1).getTitle())) {
				showTitle.add(i );
				System.out.println(i + "dd");
			}
		}
	}

	private void setData() {
		// TODO Auto-generated method stub
		tv_title.setText(foodDatas.get(0).getTitle());
		menuAdapter = new MenuAdapter(this);
		homeAdapter = new HomeAdapter(this, foodDatas);
		lv_menu.setAdapter(menuAdapter);
		lv_home.setAdapter(homeAdapter);
		lv_menu.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				menuAdapter.setSelectItem(arg2);
				menuAdapter.notifyDataSetInvalidated();
				lv_home.setSelection(showTitle.get(arg2));
								
				//tv_title.setText(data[arg2]);
				
			}
		});
		lv_home.setOnScrollListener(new OnScrollListener() {
			private int scrollState;
			
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				// TODO Auto-generated method stub
				//System.out.println("onScrollStateChanged" + "   scrollState" + scrollState);
				this.scrollState = scrollState;
			}
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				// TODO Auto-generated method stub
				if (scrollState == OnScrollListener.SCROLL_STATE_IDLE) {
                    return;  
                } 
				Log.d("jiejie", "onScroll" + "  firstVisibleItem" + firstVisibleItem
						+"  visibleItemCount" + visibleItemCount + "  totalItemCount" + totalItemCount);
				int current =showTitle.indexOf(firstVisibleItem );
				System.out.println(current + "dd"  +  firstVisibleItem);
//				lv_home.setSelection(current);
				if(currentItem != current && current >=0){
					currentItem = current;
					//tv_title.setText(data[current]);
					menuAdapter.setSelectItem(currentItem);
					menuAdapter.notifyDataSetInvalidated();
				}
			}
		});
	}



}
