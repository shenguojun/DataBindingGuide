package com.xshen.databindingguide.util;

import android.widget.TextView;

/**
 * 说明：production version binding adapters
 *
 * @author shengj
 * @version 创建时间：2016-07-31 15:05
 */
public class ProdBindingAdapters extends DIBindingAdapters {
    @Override
    public void setText(TextView textView, String value) {
        textView.setText("production " + value);
    }
}
