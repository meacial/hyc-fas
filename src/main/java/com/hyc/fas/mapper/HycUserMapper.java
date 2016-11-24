package com.hyc.fas.mapper;

import com.hyc.fas.entity.HycUser;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/22 23:54
 */
@Component
public interface HycUserMapper {

    public HycUser getHycUserByPhone(String phone);

    @Deprecated
    public Map getMapByPhone(String phone);
}
