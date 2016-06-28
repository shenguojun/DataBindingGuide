package com.xshen.databindingguide.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.xshen.databindingguide.R;
import com.xshen.databindingguide.data.DataManager;
import com.xshen.databindingguide.data.DataModel;
import com.xshen.databindingguide.databinding.ActivityBasicdatabindingBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 说明：这是一个XXX类，主要完成什么功能
 *
 * @author shengj E-mail: shengj@rd.netease.com
 * @version 创建时间：2016-06-26 21:47
 */
public class BasicDataBindingActivity extends AppCompatActivity {
    ActivityBasicdatabindingBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_basicdatabinding);
        initData();
    }

    private void initData() {
        Call<DataModel> dataModelCall = DataManager.getInstance().getApi().getDataModel();
        dataModelCall.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                binding.setData(response.body());
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
            }
        });
    }
}