package com.xshen.databindingguide.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xshen.databindingguide.R;
import com.xshen.databindingguide.util.ProductComponent;

public class DependencyInjectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        DataBindingUtil.setDefaultComponent(new TestComponent());
//        DataBindingUtil.setContentView(this, R.layout.activity_dependency_injection);
        DataBindingUtil.setDefaultComponent(new ProductComponent());
        DataBindingUtil.setContentView(this, R.layout.activity_dependency_injection);
    }

}
