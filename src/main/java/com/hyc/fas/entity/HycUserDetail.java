package com.hyc.fas.entity;

import java.util.Date;

/**
 * 注册用户信息实体类
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/22 18:08
 */
public class HycUserDetail extends HycUser {

    private String tyId;

    private String userId;      // 用户ID

    private String phonev;      // 用户手机号

    private Date registDateTime;// 用户注册时间

    private String realName;    // 用户真实姓名

    public String getTyId() {
        return tyId;
    }

    public void setTyId(String tyId) {
        this.tyId = tyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhonev() {
        return phonev;
    }

    public void setPhonev(String phonev) {
        this.phonev = phonev;
    }

    public Date getRegistDateTime() {
        return registDateTime;
    }

    public void setRegistDateTime(Date registDateTime) {
        this.registDateTime = registDateTime;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String toString() {
        return new StringBuilder("[ HycUserDetail : ")
                .append("tyId=").append(tyId).append(" , ")
                .append("userId=").append(userId).append(" , ")
                .append("phonev=").append(phonev).append(" , ")
                .append("registDateTime=").append(registDateTime).append(" , ")
                .append("realName=").append(realName)
                .append(" ] ").toString();
    }

}
