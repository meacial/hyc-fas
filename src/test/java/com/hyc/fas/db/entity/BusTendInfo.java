package com.hyc.fas.db.entity;

import com.hyc.fas.util.TimeUtil;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/26 22:10
 */
public class BusTendInfo {

    private String b_t_i_id;

    private String prod_limit;

    private String trem_util;

    private final static AtomicInteger atomicInteger = new AtomicInteger(100);
    private static String genBTIID() {
        return String.format("%s%08d", TimeUtil.getTime16(),atomicInteger.getAndIncrement());
    }

    private static String[] Y_prodLimit = new String[]{"01","02","03","04","05","06"
    ,"07","08","09","10","11","12"};

    private static String[] T_prodLimit = new String[]{"7","30","60","90"};

    private static String[] trenutils = new String[]{"01","02"};

    private static Random random = new Random();

    public static BusTendInfo build() {
        String b_t_i_id = genBTIID();
        String tremutil = trenutils[random.nextInt(trenutils.length)];
        String prod_limit = null;
        if (tremutil.equals("01")) {
            prod_limit = Y_prodLimit[random.nextInt(Y_prodLimit.length)];
        } else {
            prod_limit = T_prodLimit[random.nextInt(T_prodLimit.length)];
        }
        return new BusTendInfo(b_t_i_id,prod_limit,tremutil);
    }

    public BusTendInfo(String b_t_i_id, String prod_limit, String trem_util) {
        this.b_t_i_id = b_t_i_id;
        this.prod_limit = prod_limit;
        this.trem_util = trem_util;
    }

    public String getB_t_i_id() {
        return b_t_i_id;
    }

    public void setB_t_i_id(String b_t_i_id) {
        this.b_t_i_id = b_t_i_id;
    }

    public String getProd_limit() {
        return prod_limit;
    }

    public void setProd_limit(String prod_limit) {
        this.prod_limit = prod_limit;
    }

    public String getTrem_util() {
        return trem_util;
    }

    public void setTrem_util(String trem_util) {
        this.trem_util = trem_util;
    }
}
