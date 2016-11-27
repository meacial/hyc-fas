package com.hyc.fas.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/25 18:08
 */
public final class TimeUtil {

    private static final String date12 = "yyyyMMddHHmm";

    private static final String date19 = "yyyyMMddHHmmss";

    private static final String data16 = "yyyy/MM/dd HH:mm";

    private static final SimpleDateFormat sdf16 = new SimpleDateFormat(data16);

    private static final SimpleDateFormat sdf12 = new SimpleDateFormat(date12);


    public static String strdataftm(String dataStr) {
        if (dataStr == null) {
            throw new NullPointerException("dataStr is not null");
        }
        try {
            Date date = sdf16.parse(dataStr);
            return sdf12.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Date str2Date(String string) {
        if (null != string) {
            try {
                return sdf12.parse(string);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }




    private TimeUtil() {
    }
}
