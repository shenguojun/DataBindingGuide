package com.xshen.databindingguide.util;

/**
 * 说明：设置项
 *
 * @author shengj E-mail: shengj@rd.netease.com
 * @version 创建时间：2016-06-07 14:25
 */
public class Setting {

    public static final String[] sourceId = {"3891l", "3pj41"};

    public static int currentValuePos = 0;

    public static String nextSourceId() {
        return sourceId[currentValuePos++ % sourceId.length];
    }
}
