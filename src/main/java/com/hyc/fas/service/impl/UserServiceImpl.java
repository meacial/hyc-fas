package com.hyc.fas.service.impl;

import com.hyc.fas.entity.HycUser;
import com.hyc.fas.service.UserService;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/22 18:03
 */
public class UserServiceImpl implements UserService {

    @Override
    public HycUser user() {
        return new HycUser("meacial","meacial".getBytes(),"11111111111111111");
    }


}
