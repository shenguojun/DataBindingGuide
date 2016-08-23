package com.xshen.databindingguide.ui;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * 说明：这是一个XXX类，主要完成什么功能
 *
 * @author shengj
 * @version 创建时间：2016-07-12 23:05
 */
public class Presenter {

    public void onViewClicked(View view, Context ct, String gender, String name) {
        Toast.makeText(ct, name + ":" + gender, Toast.LENGTH_SHORT).show();
    }

    public void onViewClicked(View view) {
        Toast.makeText(view.getContext(), "gender", Toast.LENGTH_SHORT).show();
    }
}
