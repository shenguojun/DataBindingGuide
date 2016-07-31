package com.xshen.databindingguide.util;

/**
 * 说明：TestComponent
 *
 * @author shengj E-mail: shengj@rd.netease.com
 * @version 创建时间：2016-07-31 15:06
 */
public class ProductComponent implements android.databinding.DataBindingComponent {
    @Override
    public DIBindingAdapters getDIBindingAdapters() {
        return new ProdBindingAdapters();
    }
}
