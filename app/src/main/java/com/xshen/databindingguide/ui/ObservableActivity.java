package com.xshen.databindingguide.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;

import com.xshen.databindingguide.R;
import com.xshen.databindingguide.data.DataManager;
import com.xshen.databindingguide.data.StockDataModel;
import com.xshen.databindingguide.databinding.ActivityObservableBinding;
import com.xshen.databindingguide.util.Setting;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 说明：Observable 例子
 *
 * @author shengj E-mail: shengj@rd.netease.com
 * @version 创建时间：2016-07-03 14:58
 */
public class ObservableActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    ActivityObservableBinding binding;
    StockDataModel stockDataModel = new StockDataModel();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_observable);
        binding.refreshLayout.setOnRefreshListener(this);
        stockDataModel.setRetData(new StockDataModel.RetDataEntity());
        binding.setData(stockDataModel);
        initData();
    }

    private void initData() {
        Call<StockDataModel> dataModelCall = DataManager.getInstance().getApi().getDataModel(Setting.nextSourceId());
        dataModelCall.enqueue(new Callback<StockDataModel>() {
            @Override
            public void onResponse(Call<StockDataModel> call, Response<StockDataModel> response) {
                StockDataModel tmp = response.body();
                stockDataModel.getRetData().getStockinfo().get(0).setCode(tmp.getRetData().getStockinfo().get(0).getCode());
                binding.refreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<StockDataModel> call, Throwable t) {
                binding.refreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void onRefresh() {
        initData();
    }
}
