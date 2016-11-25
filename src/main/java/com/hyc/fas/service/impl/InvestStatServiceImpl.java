package com.hyc.fas.service.impl;

import com.hyc.fas.entity.InvestRecordDetail;
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
    private InvestRecordDetailMapper investRecordDetailMapper;

    @Override
    public List<InvestRecordDetail> directUserAndInvDetail(String userid) {
        return investRecordDetailMapper.getDirectInvestRecordDetail(userid);
    }

    @Override
    public List<InvestRecordDetail> inDirectUserAndInvDetail(String userid) {
        return investRecordDetailMapper.getInDirectInvestRecordDetail(userid);
    }

}
