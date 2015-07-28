package com.example.chenhongyuan.Module;

import retrofit.RestAdapter;

/**
 * Created by chenhongyuan on 15/7/28.
 */
public class RetrofitService {
    public static AllService retrofit() {
        AllService service;
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://news-at.zhihu.com").build();
        service = adapter.create(AllService.class);
        return service;
    }
}
