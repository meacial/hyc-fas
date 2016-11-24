package com.hyc.fas.service.impl;

import com.hyc.fas.entity.HycUser;
import com.hyc.fas.mapper.HycUserMapper;
import com.hyc.fas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/22 18:03
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private HycUserMapper hycUserMapper;


    @Override
    public HycUser getHycUserByPhone(String phone) {
        return hycUserMapper.getHycUserByPhone(phone);
    }

}
