package com.xshen.databindingguide.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xshen.databindingguide.R;
import com.xshen.databindingguide.data.User;
import com.xshen.databindingguide.databinding.ActivityExpressionBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpressionActivity extends AppCompatActivity {
    ActivityExpressionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_expression);
        User user = new User();
        user.setAge(20);
        user.setGender("male");
        user.setFirstName("Leon");
        user.setLastName("Chen");
        List<String> favoriteFood = new ArrayList<>();
        favoriteFood.add("apple");
        favoriteFood.add("pear");
        Map<String, String> relation = new HashMap<>();
        relation.put("Girlfriend1", "Lily");
        relation.put("Girlfriend2", "Kity");
        relation.put("Girlfriend3", "Lucy");
        binding.setUser(user);
        binding.setRelationship(relation);
        binding.setFavoriteFood(favoriteFood);
        binding.setPresenter(new Presenter());
    }
}
