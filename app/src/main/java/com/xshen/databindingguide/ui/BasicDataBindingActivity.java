package com.xshen.databindingguide.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xshen.databindingguide.R;
import com.xshen.databindingguide.data.DataManager;
import com.xshen.databindingguide.data.StockDataModel;
import com.xshen.databindingguide.databinding.BasicBinding;
import com.xshen.databindingguide.util.Setting;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 说明：基础使用databinding的例子
 *
 * @author shengj
 * @version 创建时间：2016-06-26 21:47
 */
public class BasicDataBindingActivity extends AppCompatActivity {
    BasicBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_basicdatabinding);
        initData();
    }

    private void initData() {
        Call<StockDataModel> dataModelCall = DataManager.getInstance().getApi().getDataModel(Setting.nextSourceId());
        dataModelCall.enqueue(new Callback<StockDataModel>() {
            @Override
            public void onResponse(Call<StockDataModel> call, Response<StockDataModel> response) {
                binding.setData(response.body());
            }

            @Override
            public void onFailure(Call<StockDataModel> call, Throwable t) {
            }
        });
    }
}