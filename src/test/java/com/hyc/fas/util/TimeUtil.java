package com.hyc.fas.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/26 19:21
 */
public class TimeUtil {


    private static final SimpleDateFormat SDF16 = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    private static final SimpleDateFormat SDF12 = new SimpleDateFormat("yyyyMMddHHmm");
    public static String getTime16() {
        return SDF16.format(Calendar.getInstance().getTime());
    }

    public static String getTime12() {
        return SDF12.format(Calendar.getInstance().getTime());
    }
}
