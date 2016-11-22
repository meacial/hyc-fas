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

    private String investRecordId;          // 投资记录ID

    private String investRecordUserId;      // 投资记录对应用户ID

    private Date investRecordDateTime;      // 投资记录创建时间

    private BigDecimal investRecordAmount;  // 投资记录金额

    private String investRecordLoanTerm;    // 投资记录投资期限

    private String investRecordLoanTermType;// 投资记录投资期限类别（按天，按月）


    /**
     * default construct
     */
    public InvestRecordDetail() {
        // noop
    }

    /**
     * create a new instance of InvestRecordDetail.
     * @param investRecordId
     * @param investRecordUserId
     * @param investRecordDateTime
     * @param investRecordAmount
     * @param investRecordLoanTerm
     * @param investRecordLoanTermType
     */
    public InvestRecordDetail(String investRecordId, String investRecordUserId, Date investRecordDateTime, BigDecimal investRecordAmount, String investRecordLoanTerm, String investRecordLoanTermType) {
        this();
        this.investRecordId = investRecordId;
        this.investRecordUserId = investRecordUserId;
        this.investRecordDateTime = investRecordDateTime;
        this.investRecordAmount = investRecordAmount;
        this.investRecordLoanTerm = investRecordLoanTerm;
        this.investRecordLoanTermType = investRecordLoanTermType;
    }

    public String getInvestRecordId() {
        return investRecordId;
    }

    public void setInvestRecordId(String investRecordId) {
        this.investRecordId = investRecordId;
    }

    public String getInvestRecordUserId() {
        return investRecordUserId;
    }

    public void setInvestRecordUserId(String investRecordUserId) {
        this.investRecordUserId = investRecordUserId;
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
}
