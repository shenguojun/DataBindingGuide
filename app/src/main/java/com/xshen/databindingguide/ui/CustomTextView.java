package com.xshen.databindingguide.ui;

import android.content.Context;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.util.AttributeSet;
import android.widget.TextView;

import com.xshen.databindingguide.util.FontCache;

/**
 * 说明：自定义可以设置字体的TextView
 *
 * @author shengj E-mail: shengj@rd.netease.com
 * @version 创建时间：2016-07-21 22:53
 */

@BindingMethods({
        @BindingMethod(type = CustomTextView.class,
                attribute = "app:customText",
                method = "setMyCustomText")})
public class CustomTextView extends TextView {
    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setFont(String fontName) {
        this.setTypeface(FontCache.getInstance().get(fontName));
    }


    public void setMyCustomText(CharSequence text) {
        setText("Custom " + text);
    }
}
