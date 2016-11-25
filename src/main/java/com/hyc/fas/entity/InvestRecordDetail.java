package com.hyc.fas.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 投资记录实体类
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/22 18:08
 */
public class InvestRecordDetail implements Serializable {

    private Date investRecordDateTime;      // 投资记录创建时间

    private BigDecimal investRecordAmount;  // 投资记录金额

    private String investRecordLoanTerm;    // 投资记录投资期限

    private String investRecordLoanTermType;// 投资记录投资期限类别（按天，按月）

    private String rec_phone_v;             // 推荐人手机号

    private String rec_real_name;           // 推荐人真实姓名

    private String rec_create_date_time;    // 推荐人注册时间

    private String inv_phone_v;             // 投资人手机号

    private String inv_real_name;           // 投资人真实姓名

    private String inv_create_date_time;    // 投资人注册时间



    /**
     * default construct
     */
    public InvestRecordDetail() {
        // noop
    }

    /**
     *
     * @param investRecordDateTime
     * @param investRecordAmount
     * @param investRecordLoanTerm
     * @param investRecordLoanTermType
     * @param rec_phone_v
     * @param rec_real_name
     * @param rec_create_date_time
     * @param inv_phone_v
     * @param inv_real_name
     * @param inv_create_date_time
     */
    public InvestRecordDetail(Date investRecordDateTime, BigDecimal investRecordAmount, String investRecordLoanTerm, String investRecordLoanTermType, String rec_phone_v, String rec_real_name, String rec_create_date_time, String inv_phone_v, String inv_real_name, String inv_create_date_time) {
        this.investRecordDateTime = investRecordDateTime;
        this.investRecordAmount = investRecordAmount;
        this.investRecordLoanTerm = investRecordLoanTerm;
        this.investRecordLoanTermType = investRecordLoanTermType;
        this.rec_phone_v = rec_phone_v;
        this.rec_real_name = rec_real_name;
        this.rec_create_date_time = rec_create_date_time;
        this.inv_phone_v = inv_phone_v;
        this.inv_real_name = inv_real_name;
        this.inv_create_date_time = inv_create_date_time;
    }

    public Date getInvestRecordDateTime() {
        return investRecordDateTime;
    }

    public void setInvestRecordDateTime(Date investRecordDateTime) {
        this.investRecordDateTime = investRecordDateTime;
    }

    public BigDecimal getInvestRecordAmount() {
        return investRecordAmount;
    }

    public void setInvestRecordAmount(BigDecimal investRecordAmount) {
        this.investRecordAmount = investRecordAmount;
    }

    public String getInvestRecordLoanTerm() {
        return investRecordLoanTerm;
    }

    public void setInvestRecordLoanTerm(String investRecordLoanTerm) {
        this.investRecordLoanTerm = investRecordLoanTerm;
    }

    public String getInvestRecordLoanTermType() {
        return investRecordLoanTermType;
    }

    public void setInvestRecordLoanTermType(String investRecordLoanTermType) {
        this.investRecordLoanTermType = investRecordLoanTermType;
    }

    public String getRec_phone_v() {
        return rec_phone_v;
    }

    public void setRec_phone_v(String rec_phone_v) {
        this.rec_phone_v = rec_phone_v;
    }

    public String getRec_real_name() {
        return rec_real_name;
    }

    public void setRec_real_name(String rec_real_name) {
        this.rec_real_name = rec_real_name;
    }

    public String getRec_create_date_time() {
        return rec_create_date_time;
    }

    public void setRec_create_date_time(String rec_create_date_time) {
        this.rec_create_date_time = rec_create_date_time;
    }

    public String getInv_phone_v() {
        return inv_phone_v;
    }

    public void setInv_phone_v(String inv_phone_v) {
        this.inv_phone_v = inv_phone_v;
    }

    public String getInv_real_name() {
        return inv_real_name;
    }

    public void setInv_real_name(String inv_real_name) {
        this.inv_real_name = inv_real_name;
    }

    public String getInv_create_date_time() {
        return inv_create_date_time;
    }

    public void setInv_create_date_time(String inv_create_date_time) {
        this.inv_create_date_time = inv_create_date_time;
    }
}
