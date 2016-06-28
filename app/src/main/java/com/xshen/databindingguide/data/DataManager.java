package com.xshen.databindingguide.data;

/**
 * 说明：这是一个XXX类，主要完成什么功能
 *
 * @author shengj E-mail: shengj@rd.netease.com
 * @version 创建时间：2016-06-26 16:52
 */

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class DataManager {
    private DataService api;
    private static volatile DataManager singleton;

    public static DataManager getInstance() {
        if (singleton == null) {
            synchronized (DataManager.class) {
                singleton = new DataManager();
            }
        }
        return singleton;
    }

    DataManager() {
        createApi();
    }

    public interface DataService {
        String DATA_URL = "https://api.myjson.com/";

        @GET("bins/3pj41")
        Call<DataModel> getDataModel();
    }

    public DataService getApi() {
        return api;
    }

    private void createApi() {
        final OkHttpClient client = new OkHttpClient.Builder()
                .build();
        api = new Retrofit.Builder()
                .baseUrl(DataService.DATA_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DataService.class);
    }
}
