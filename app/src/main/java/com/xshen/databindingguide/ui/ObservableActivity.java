package com.xshen.databindingguide.ui;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableArrayMap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;

import com.xshen.databindingguide.R;
import com.xshen.databindingguide.data.ObservableUser;
import com.xshen.databindingguide.data.User;
import com.xshen.databindingguide.databinding.ActivityObservableBinding;

/**
 * 说明：Observable 例子
 *
 * @author shengj E-mail: shengj@rd.netease.com
 * @version 创建时间：2016-07-03 14:58
 */
public class ObservableActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    ActivityObservableBinding binding;
    User user = new User();
    ObservableUser observableUser = new ObservableUser();
    ObservableArrayMap<String, Object> userMap = new ObservableArrayMap<>();
    ObservableArrayList<Object> userList = new ObservableArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_observable);
        binding.refreshLayout.setOnRefreshListener(this);
        binding.setUser(user);
        binding.setObservableUser(observableUser);
        binding.setUserList(userList);
        binding.setUserMap(userMap);
        user.setFirstName("Leon");
        user.setLastName("Li");
        user.setAge(22);
        observableUser.firstName.set("Leon");
        observableUser.lastName.set("Li");
        observableUser.age.set(22);
        userMap.put("firstName", "Leon");
        userMap.put("lastName", "Li");
        userMap.put("age", 22);
        userList.add("Leon");
        userList.add("Li");
        userList.add(22);
    }

    private void refresh() {
        user.setFirstName("Jacky");
        user.setLastName("Wang");
        user.setAge(25);
        observableUser.firstName.set("Jacky");
        observableUser.lastName.set("Wang");
        observableUser.age.set(25);
        userMap.put("firstName", "Jacky");
        userMap.put("lastName", "Wang");
        userMap.put("age", 25);
        userList.set(0, "Jacky");
        userList.set(1, "Wang");
        userList.set(2, 25);
        binding.refreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        refresh();
    }
}
