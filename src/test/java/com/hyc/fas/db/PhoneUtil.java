package com.hyc.fas.db;

import com.hyc.fas.common.AppSecUtil;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/26 19:42
 */
public class PhoneUtil {
    private final static AtomicInteger atomicInteger = new AtomicInteger(1);
    public static String[] genPhone(String basePhone) {
        String phone = String.format("%s%0"+(11-basePhone.length())+"d", basePhone,atomicInteger.getAndIncrement());
        String phone_v = phone.substring(0, 3) + "****" + phone.substring(7);
        String desPhone = AppSecUtil.encryptMode("0123456789",phone,"utf-8");;
        return new String[]{phone_v,desPhone};
    }

    public static void main(String[] args) {
        for (int i =0 ;i < 10 ; i++) {
            System.out.println(genPhone("182"));
        }
    }
}
