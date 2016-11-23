package com.hyc.fas.service.impl;

import com.hyc.fas.entity.HycUser;
import com.hyc.fas.mapper.HycUserMapper;
import com.hyc.fas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
    public HycUser user() {
        return new HycUser("meacial","meacial","11111111111111111");
    }

    @Override
    public List<HycUser> getUserByPhone(String phone) {

        System.out.println("--------------------------------------------------");
        try {
            System.out.println(hycUserMapper.getByPhone("Iq63w+w1ATP35ycdbXzIyA=="));
        } catch (Throwable throwable) {
            System.err.println(throwable);
        }

        System.out.println("--------------------------------------------------");
        return new ArrayList<>();
//        System.out.println("*******************************************************************");
//        HycUser user = hycUserMapper.getByPhone();
//        System.out.println(user.getUsername());
//        System.out.println(user.getUserid());
//        System.out.println("*******************************************************************");
//        return new HycUser("meacial","meacial".getBytes(),"2222222222222222");
    }


}
