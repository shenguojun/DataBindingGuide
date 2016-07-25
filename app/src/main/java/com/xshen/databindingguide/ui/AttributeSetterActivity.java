package com.xshen.databindingguide.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xshen.databindingguide.R;
import com.xshen.databindingguide.databinding.AttributeSetterBinding;
import com.xshen.databindingguide.util.FontCache;

public class AttributeSetterActivity extends AppCompatActivity {
    AttributeSetterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FontCache.getInstance().addFont("alegreya_bold", "Alegreya-Bold.ttf");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_attribute_setter);
    }
}
