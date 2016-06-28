package com.xshen.databindingguide.util;

import java.util.Locale;

/**
 * 说明：这是一个XXX类，主要完成什么功能
 *
 * @author shengj E-mail: shengj@rd.netease.com
 * @version 创建时间：2016-06-26 21:50
 */
public class VauleFormater {

    public static String formatDouble(double d) {
        return String.format(Locale.CHINA, "%.2f", d);
    }

    public static String formatLong(long l) {
        return String.format(Locale.CHINA, "%d亿", l / 100000000);
    }
}
