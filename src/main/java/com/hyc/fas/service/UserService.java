package com.hyc.fas.service;

import com.hyc.fas.entity.HycUser;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/22 18:02
 */
public interface UserService {

    public HycUser getHycUserByPhone(String phone);

}
