package com.xshen.databindingguide.data;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * 说明：用户model
 *
 * @author shengj E-mail: shengj@rd.netease.com
 * @version 创建时间：2016-07-12 22:11
 */
public class ObservableUser {
    public ObservableField<String> firstName = new ObservableField<>();
    public ObservableField<String> lastName = new ObservableField<>();
    public ObservableInt age = new ObservableInt();

}
