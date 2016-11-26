package com.hyc.fas.db.entity;

import com.hyc.fas.util.TimeUtil;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/26 22:50
 */
public class BusSubs {
    private String o_s_id;

    private String b_t_i_id;

    private String inve_c_id;

    private BigDecimal amount;

    private String tx_date;

    private String create_date_time;

    private String status;

    private final static AtomicInteger atomicInteger = new AtomicInteger(100);
    private static String genOSID() {
        return String.format("%s%08d", TimeUtil.getTime16(),atomicInteger.getAndIncrement());
    }
    private static String[] statuss = new String[]{"01","02"};
    private static Random random = new Random();
    public static BusSubs build(String b_t_i_id,String inve_c_id) {
        return new BusSubs(
                genOSID(),
                b_t_i_id,
                inve_c_id,
                new BigDecimal(String.valueOf(random.nextInt(5000))),
                TimeUtil.getTime12(),
                TimeUtil.getTime12(),
                statuss[random.nextInt(statuss.length)]
        );
    }


    public BusSubs(String o_s_id, String b_t_i_id, String inve_c_id, BigDecimal amount, String tx_date, String create_date_time, String status) {
        this.o_s_id = o_s_id;
        this.b_t_i_id = b_t_i_id;
        this.inve_c_id = inve_c_id;
        this.amount = amount;
        this.tx_date = tx_date;
        this.create_date_time = create_date_time;
        this.status = status;
    }

    public String getO_s_id() {
        return o_s_id;
    }

    public void setO_s_id(String o_s_id) {
        this.o_s_id = o_s_id;
    }

    public String getB_t_i_id() {
        return b_t_i_id;
    }

    public void setB_t_i_id(String b_t_i_id) {
        this.b_t_i_id = b_t_i_id;
    }

    public String getInve_c_id() {
        return inve_c_id;
    }

    public void setInve_c_id(String inve_c_id) {
        this.inve_c_id = inve_c_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTx_date() {
        return tx_date;
    }

    public void setTx_date(String tx_date) {
        this.tx_date = tx_date;
    }

    public String getCreate_date_time() {
        return create_date_time;
    }

    public void setCreate_date_time(String create_date_time) {
        this.create_date_time = create_date_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
