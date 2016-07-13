package com.xshen.databindingguide.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xshen.databindingguide.R;
import com.xshen.databindingguide.data.User;
import com.xshen.databindingguide.databinding.IncludeBinding;

public class IncludeActivity extends AppCompatActivity {
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IncludeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_include);
        user = new User();
        user.setFirstName("includeFirst");
        user.setLastName("includeLast");
        binding.setUser(user);
    }
}
