package com.hyc.fas.common;

/**
 * 字符串工具类
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/22 18:26
 */
public final class StringUtils {

    private static final String EMPTYSTR = "";

    public static final boolean isEmpty(String string) {
        if (null == string) {
            return true;
        }
        if (EMPTYSTR.equals(string.trim())) {
            return true;
        }
        return false;
    }

    public static final String trim(Object object) {
        if (null == object) {
            return EMPTYSTR;
        }
        return object.toString().trim();
    }


    private StringUtils() {
        // noop
    }
}
