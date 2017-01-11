package com.example.chengang.twolistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView lv_left;
    private Retrofit retrofit;
    private MyServers myServers;
    private ListView lv_right;
    private LvLeftAdapter adapter;
    LvRightAdapter rightAdapter;
    private List<DataBeans.DataBean.CategoriesBean> datas;

    private int currentItem;
    List<Integer> ints = new ArrayList<Integer>();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_left = (ListView) findViewById(R.id.lv_left);
        lv_right = (ListView) findViewById(R.id.lv_right);
        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.liwushuo.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myServers = retrofit.create(MyServers.class);
        initDatas();
        lv_left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //选中时改变颜色
                adapter.setSelectItem(position);
                //lv_right.smoothScrollToPosition(position);
                //定位到position位置
                lv_right.setSelection(position);
                Log.e("aaaa", "position: " + position);

            }
        });

        lv_right.setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                lv_left.setSelection(firstVisibleItem);

                if (count == firstVisibleItem) {
                    return;
                }
                count = firstVisibleItem;
                adapter.setSelectItem(firstVisibleItem);
                adapter.notifyDataSetChanged();


            }
        });

    }

    int count;


    private void initDatas() {
        Call<DataBeans> call = myServers.getDatas("http://api.liwushuo.com/v2/item_categories/tree");
        call.enqueue(new Callback<DataBeans>() {

            @Override
            public void onResponse(Call<DataBeans> call, Response<DataBeans> response) {
                datas = response.body().getData().getCategories();
                adapter = new LvLeftAdapter(datas);
                rightAdapter = new LvRightAdapter(datas);
                lv_left.setAdapter(adapter);
                lv_right.setAdapter(rightAdapter);
            }

            @Override
            public void onFailure(Call<DataBeans> call, Throwable t) {

            }
        });

    }


}
