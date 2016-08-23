package com.xshen.databindingguide.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.xshen.databindingguide.R;
import com.xshen.databindingguide.data.DataManager;
import com.xshen.databindingguide.data.StockDataModel;
import com.xshen.databindingguide.util.Setting;
import com.xshen.databindingguide.util.ValueFormater;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 说明：没有使用databinding的例子
 *
 * @author shengj
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
        Call<StockDataModel> dataModelCall = DataManager.getInstance().getApi().getDataModel(Setting.nextSourceId());
        dataModelCall.enqueue(new Callback<StockDataModel>() {
            @Override
            public void onResponse(Call<StockDataModel> call, Response<StockDataModel> response) {
                StockDataModel data = response.body() != null ? response.body() : null;
                StockDataModel.RetDataEntity retDataEntity = data == null ? null : data.getRetData();
                if (retDataEntity != null) {
                    List<StockDataModel.RetDataEntity.StockinfoEntity> stockinfoEntities =
                            retDataEntity.getStockinfo();
                    if (stockinfoEntities != null && stockinfoEntities.size() != 0) {
                        StockDataModel.RetDataEntity.StockinfoEntity entity = stockinfoEntities.get(0);
                        mName.setText(entity.getName());
                        mHprice.setText(ValueFormater.formatDouble(entity.getHPrice()));
                        mCurrentPrice.setText(ValueFormater.formatDouble(entity.getCurrentPrice()));
                        mCode.setText(entity.getCode());
                        mOpenningPrice.setText(ValueFormater.formatDouble(entity.getOpenningPrice()));
                        mIncrease.setText(String.format("%s%%", ValueFormater.formatDouble(entity.getIncrease())));
                        mLprice.setText(ValueFormater.formatDouble(entity.getLPrice()));
                        mTurnover.setText(ValueFormater.formatLong(entity.getTurnover()));
                        mTotalNumber.setText(ValueFormater.formatLong(entity.getTotalNumber()));
                        mClosingPrice.setText(ValueFormater.formatDouble(entity.getClosingPrice()));
                    }
                }
            }

            @Override
            public void onFailure(Call<StockDataModel> call, Throwable t) {
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
