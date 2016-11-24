package com.hyc.fas.mapper;

import com.hyc.fas.entity.HycUserDetail;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/24 15:19
 */
@Component
public interface HycUserDetailMapper {

    public List<HycUserDetail> getTgUserDetails(String userid);

    public HycUserDetail getHycUserDeatil(String userid);



}
