package com.xshen.databindingguide.util;

import android.widget.TextView;

/**
 * 说明：测试环境下的binding adapters
 *
 * @author shengj
 * @version 创建时间：2016-07-31 14:56
 */
public class TestDIBindingAdapters extends DIBindingAdapters {
    @Override
    public void setText(TextView textView, String value) {
        textView.setText("test " + value);
    }
}
