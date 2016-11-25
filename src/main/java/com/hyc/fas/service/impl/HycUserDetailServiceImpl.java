package com.hyc.fas.service.impl;

import com.hyc.fas.entity.HycUserDetail;
import com.hyc.fas.mapper.HycUserDetailMapper;
import com.hyc.fas.service.HycUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/25 10:31
 */
@Service
public class HycUserDetailServiceImpl implements HycUserDetailService {

    @Autowired
    private HycUserDetailMapper hycUserDetailMapper;
    @Override
    public HycUserDetail hycUserDetail(String userid) {
        return hycUserDetailMapper.getHycUserDeatil(userid);
    }
}
