package com.hyc.fas.controller;

import com.hyc.fas.common.HycFasDict;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/24 14:31
 */
public abstract class AbstractController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     *
     * @param request
     */
    protected void saveUserId2Session(HttpServletRequest request,String userid) {
        request.getSession().setAttribute(HycFasDict.USERTOKEN, userid);
    }

    protected String getUserIdFromSession(HttpServletRequest request) {
        return (String) request.getSession().getAttribute(HycFasDict.USERTOKEN);
    }
}
