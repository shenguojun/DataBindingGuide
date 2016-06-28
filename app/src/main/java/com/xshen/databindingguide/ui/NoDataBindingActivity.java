package com.xshen.databindingguide.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.xshen.databindingguide.R;
import com.xshen.databindingguide.data.DataManager;
import com.xshen.databindingguide.data.DataModel;

import java.util.List;

import com.xshen.databindingguide.util.VauleFormater;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 说明：这是一个XXX类，主要完成什么功能
 *
 * @author shengj E-mail: shengj@rd.netease.com
 * @version 创建时间：2016-06-26 15:11
 */
public class NoDataBindingActivity extends AppCompatActivity {
    private TextView mName;
    private TextView mCode;
    private TextView mCurrentPrice;
    private TextView mIncrease;
    private TextView mOpenningPrice;
    private TextView mClosingPrice;
    private TextView mHprice;
    private TextView mTurnover;
    private TextView mLprice;
    private TextView mTotalNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nodatabinding);
        initView();
        initData();
    }

    private void initData() {
        Call<DataModel> dataModelCall = DataManager.getInstance().getApi().getDataModel();
        dataModelCall.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                DataModel data = response.body() != null ? response.body() : null;
                DataModel.RetDataEntity retDataEntity = data == null ? null : data.getRetData();
                if (retDataEntity != null) {
                    List<DataModel.RetDataEntity.StockinfoEntity> stockinfoEntities =
                            retDataEntity.getStockinfo();
                    if (stockinfoEntities != null && stockinfoEntities.size() != 0) {
                        DataModel.RetDataEntity.StockinfoEntity entity = stockinfoEntities.get(0);
                        mName.setText(entity.getName());
                        mHprice.setText(VauleFormater.formatDouble(entity.getHPrice()));
                        mCurrentPrice.setText(VauleFormater.formatDouble(entity.getCurrentPrice()));
                        mCode.setText(entity.getCode());
                        mOpenningPrice.setText(VauleFormater.formatDouble(entity.getOpenningPrice()));
                        mIncrease.setText(String.format("%s%%", VauleFormater.formatDouble(entity.getIncrease())));
                        mLprice.setText(VauleFormater.formatDouble(entity.getLPrice()));
                        mTurnover.setText(VauleFormater.formatLong(entity.getTurnover()));
                        mTotalNumber.setText(VauleFormater.formatLong(entity.getTotalNumber()));
                        mClosingPrice.setText(VauleFormater.formatDouble(entity.getClosingPrice()));
                    }
                }
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
            }
        });
    }

    private void initView() {
        mName = (TextView) findViewById(R.id.name);
        mClosingPrice = (TextView) findViewById(R.id.closing_price);
        mCode = (TextView) findViewById(R.id.code);
        mCurrentPrice = (TextView) findViewById(R.id.current_price);
        mHprice = (TextView) findViewById(R.id.hprice);
        mLprice = (TextView) findViewById(R.id.lprice);
        mIncrease = (TextView) findViewById(R.id.increase);
        mTurnover = (TextView) findViewById(R.id.turnover);
        mTotalNumber = (TextView) findViewById(R.id.total_number);
        mOpenningPrice = (TextView) findViewById(R.id.openning_price);
    }
}
