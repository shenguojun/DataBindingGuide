package com.xshen.databindingguide.ui;

import android.databinding.DataBindingUtil;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.ViewGroup;

import com.xshen.databindingguide.R;
import com.xshen.databindingguide.databinding.TransitionBinding;

/**
 * 说明：dotabinding with animation
 *
 * @author shengj
 * @version 创建时间：2016-07-28 20:53
 */
public class TransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TransitionBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_transition);
        binding.addOnRebindCallback(new OnRebindCallback() {
            @Override
            public boolean onPreBind(ViewDataBinding binding) {
                ViewGroup sceneRoot = (ViewGroup) binding.getRoot();
                TransitionManager.beginDelayedTransition(sceneRoot);
                return true;
            }
        });
    }
}
