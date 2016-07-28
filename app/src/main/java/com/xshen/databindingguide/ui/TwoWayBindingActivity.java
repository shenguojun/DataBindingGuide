package com.xshen.databindingguide.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xshen.databindingguide.R;
import com.xshen.databindingguide.data.User;
import com.xshen.databindingguide.databinding.TwoWayBinding;

/**
 * 说明：Two way databinding 例子
 *
 * @author gzshenguojun E-mail: shengj@rd.netease.com
 * @version 创建时间：2016-07-28 20:53
 */
public class TwoWayBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwoWayBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_two_way_binding);
        final User user = new User("Leon", "Li", 35);
        binding.setUser(user);
    }
}
