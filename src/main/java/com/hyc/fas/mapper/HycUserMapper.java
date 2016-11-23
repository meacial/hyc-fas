package com.hyc.fas.mapper;

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
    public Map getByPhone(String phone);
}
