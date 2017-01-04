package com.example.chengang.twolistview;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by chengang on 2016/12/27.
 */

public interface MyServers {
    @GET
    Call<DataBeans> getDatas(@Url String url);

}
