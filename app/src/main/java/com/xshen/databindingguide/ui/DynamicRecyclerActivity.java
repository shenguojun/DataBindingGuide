package com.xshen.databindingguide.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xshen.databindingguide.R;
import com.xshen.databindingguide.databinding.RecyclerBinding;

public class DynamicRecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_dynamic);
        binding.recycler.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recycler.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new DynamicAdapter(new String[]{"test1", "test2", "test3"});
        binding.recycler.setAdapter(adapter);
    }
}
