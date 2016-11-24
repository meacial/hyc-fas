package com.hyc.fas.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 推广用户信息及投资记录表
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/24 15:23
 */
public class TgUserAndInvDeatil {

    private HycUserDetail hycUserDetail;    // 用户信息

    private Map<HycUserDetail, List<InvestRecordDetail>> tgUserAndInvDetialMap;

    public TgUserAndInvDeatil(HycUserDetail hycUserDetail) {
        this.hycUserDetail = hycUserDetail;
        this.tgUserAndInvDetialMap = new HashMap<>();
    }

    public void put(HycUserDetail hycUserDetail, List<InvestRecordDetail> investRecordDetails) {
        tgUserAndInvDetialMap.put(hycUserDetail, investRecordDetails);
    }

    public HycUserDetail getHycUserDetail() {
        return hycUserDetail;
    }

    public void setHycUserDetail(HycUserDetail hycUserDetail) {
        this.hycUserDetail = hycUserDetail;
    }

    public Map<HycUserDetail, List<InvestRecordDetail>> getTgUserAndInvDetialMap() {
        return tgUserAndInvDetialMap;
    }

    public void setTgUserAndInvDetialMap(Map<HycUserDetail, List<InvestRecordDetail>> tgUserAndInvDetialMap) {
        this.tgUserAndInvDetialMap = tgUserAndInvDetialMap;
    }
}
