package com.xshen.databindingguide.data;

/**
 * 说明：获取数据
 *
 * @author shengj E-mail: shengj@rd.netease.com
 * @version 创建时间：2016-06-26 16:52
 */

import com.xshen.databindingguide.util.Setting;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

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
        String source = Setting.nextSourceId();

        @GET("bins/{id}")
        Call<StockDataModel> getDataModel(@Path("id") String id);
    }

    public DataService getApi() {
        return api;
    }

    private void createApi() {
        final OkHttpClient client = new OkHttpClient.Builder().build();
        api = new Retrofit.Builder()
                .baseUrl(DataService.DATA_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DataService.class);
    }
}
