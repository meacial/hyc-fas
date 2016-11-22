package com.hyc.fas.entity;

import java.io.Serializable;

/**
 * 登录用户实体类
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/22 17:59
 */
public class HycUser implements Serializable {

    private String username;
    private byte[] password;
    private String userid;


    /**
     * default construct
     */
    public HycUser() {
        // noop
    }

    /**
     * Create an instance of HycUser.
     * @param username
     * @param password
     */
    public HycUser(String username, byte[] password,String userid) {
        this();
        this.username = username;
        this.password = password;
        this.userid = userid;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
