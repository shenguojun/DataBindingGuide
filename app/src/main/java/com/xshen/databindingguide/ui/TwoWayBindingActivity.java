package com.xshen.databindingguide.ui;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;

import com.xshen.databindingguide.R;
import com.xshen.databindingguide.data.User;
import com.xshen.databindingguide.databinding.TwoWayBinding;

public class TwoWayBindingActivity extends AppCompatActivity {
    private TwoWayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_two_way_binding);
        final User user = new User("Leon", "Li", 35);
        binding.setUser(user);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(binding.userDisplayNameEdit, 0);
        binding.userDisplayNameEdit.requestFocus();
    }
}
