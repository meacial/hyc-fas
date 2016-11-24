package com.hyc.fas.service.impl;

import com.hyc.fas.entity.HycUserDetail;
import com.hyc.fas.entity.TgUserAndInvDeatil;
import com.hyc.fas.mapper.HycUserDetailMapper;
import com.hyc.fas.mapper.InvestRecordDetailMapper;
import com.hyc.fas.service.InvestStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/22 18:22
 */
@Service
public class InvestStatServiceImpl implements InvestStatService {
    @Autowired
    private HycUserDetailMapper hycUserDetailMapper;
    @Autowired
    private InvestRecordDetailMapper investRecordDetailMapper;
    @Override
    public TgUserAndInvDeatil userAndInvDetail(String userid) {

        TgUserAndInvDeatil tgUserAndInvDeatil = null;

        try {
            HycUserDetail hycUserDetail = hycUserDetailMapper.getHycUserDeatil(userid);

            // 获取当前用户直接推荐的用户
            List<HycUserDetail> list = hycUserDetailMapper.getTgUserDetails(userid);

            tgUserAndInvDeatil = new TgUserAndInvDeatil(hycUserDetail);

            for (int i = 0; i < list.size(); i++) {
                tgUserAndInvDeatil.put(list.get(i), investRecordDetailMapper.getInvestRecordDetail(list.get(i).getUserid()));
            }
        } catch (Throwable throwable) {
            System.out.println(" Err--->"+throwable);
        }

        return tgUserAndInvDeatil;
    }
}
