package com.hyc.fas.service;

import com.hyc.fas.entity.InvestRecordDetail;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/22 18:05
 */
@Component
public interface InvestStatService {
    public List<InvestRecordDetail> directUserAndInvDetail(String userid, String startTime, String endTime,int pageSize,int pageCnt);

    public List<InvestRecordDetail> inDirectUserAndInvDetail(String userid, String startTime, String endTime,int pageSize,int pageCnt);


}
