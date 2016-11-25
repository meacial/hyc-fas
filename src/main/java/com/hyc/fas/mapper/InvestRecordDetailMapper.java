package com.hyc.fas.mapper;

import com.hyc.fas.entity.InvestRecordDetail;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/24 17:46
 */
@Component
public interface InvestRecordDetailMapper {

    public List<InvestRecordDetail> getDirectInvestRecordDetail(String userid,String startTime,String endTime);

    public List<InvestRecordDetail> getInDirectInvestRecordDetail(String userid,String startTime,String endTime);


}
