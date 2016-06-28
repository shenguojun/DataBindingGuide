package com.xshen.databindingguide.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xshen.databindingguide.R;
import com.xshen.databindingguide.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    public void noDataBindingClicked(View view) {
        Intent intent = new Intent(this, NoDataBindingActivity.class);
        startActivity(intent);
    }

    public void basicDataBindingClicked(View view) {
        Intent intent = new Intent(this, BasicDataBindingActivity.class);
        startActivity(intent);
    }
}
