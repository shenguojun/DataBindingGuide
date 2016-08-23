package com.xshen.databindingguide.util;

/**
 * 说明：TestComponent
 *
 * @author shengj
 * @version 创建时间：2016-07-31 15:06
 */
public class TestComponent implements android.databinding.DataBindingComponent {
    @Override
    public DIBindingAdapters getDIBindingAdapters() {
        return new TestDIBindingAdapters();
    }
}
