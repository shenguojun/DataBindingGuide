package com.xshen.databindingguide.util;

import android.databinding.BindingAdapter;
import android.widget.TextView;

/**
 * 说明：Dependency injection component
 *
 * @author shengj
 * @version 创建时间：2016-07-31 14:51
 */
public abstract class DIBindingAdapters {
    @BindingAdapter("app:ditext")
    public abstract void setText(TextView textView, String value);
}
