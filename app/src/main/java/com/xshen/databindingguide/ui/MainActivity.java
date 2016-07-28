package com.xshen.databindingguide.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    public void observableClicked(View view) {
        Intent intent = new Intent(this, ObservableActivity.class);
        startActivity(intent);
    }

    public void expressionClicked(View view) {
        Intent intent = new Intent(this, ExpressionActivity.class);
        startActivity(intent);
    }

    public void includeClicked(View view) {
        Intent intent = new Intent(this, IncludeActivity.class);
        startActivity(intent);
    }

    public void viewStubsClicked(View view) {
        Intent intent = new Intent(this, ViewStubsActivity.class);
        startActivity(intent);
    }

    public void attributeSetClicked(View view) {
        Intent intent = new Intent(this, AttributeSetterActivity.class);
        startActivity(intent);
    }

    public void recyclerClicked(View view) {
        Intent intent = new Intent(this, DynamicRecyclerActivity.class);
        startActivity(intent);
    }

    public void converterClicked(View view) {
        Intent intent = new Intent(this, ConverterActivity.class);
        startActivity(intent);

    }

    public void twoWayClicked(View view) {
        Intent intent = new Intent(this, TwoWayBindingActivity.class);
        startActivity(intent);
    }
}
