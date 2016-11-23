package com.hyc.fas.service;

import com.hyc.fas.entity.HycUser;

import java.util.List;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/22 18:02
 */
public interface UserService {

    public HycUser user();

    public List<HycUser> getUserByPhone(String phone);

}
