package com.xshen.databindingguide.ui;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xshen.databindingguide.R;
import com.xshen.databindingguide.databinding.ConverterBinding;

public class ConverterActivity extends AppCompatActivity {
    ObservableBoolean error = new ObservableBoolean(false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConverterBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_converter);
        binding.setError(error);
    }

    public void changeState(View view) {
        error.set(!error.get());
    }
}
