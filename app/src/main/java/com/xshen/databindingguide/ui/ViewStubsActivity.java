package com.xshen.databindingguide.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;

import com.xshen.databindingguide.R;
import com.xshen.databindingguide.databinding.SubLayoutBinding;
import com.xshen.databindingguide.databinding.ViewStubsBinding;

public class ViewStubsActivity extends AppCompatActivity {
    ViewStubsBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_view_stubs);
        mBinding.viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                SubLayoutBinding binding = DataBindingUtil.bind(inflated);
                binding.setLastName("view_stub_inflated");
            }

        });
        setData();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setData();
            }
        }, 1000);
    }

    private void setData() {
        if (!mBinding.viewStub.isInflated()) {
            mBinding.viewStub.getViewStub().inflate();
        } else {
            SubLayoutBinding binding = (SubLayoutBinding) mBinding.viewStub.getBinding();
            binding.setLastName("view_sub_after_inflate");
        }
    }
}
