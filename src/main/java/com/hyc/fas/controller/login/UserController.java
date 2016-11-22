package com.hyc.fas.controller.login;

import com.hyc.fas.annonation.NoAuthController;
import com.hyc.fas.common.HycFasDict;
import com.hyc.fas.common.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/22 16:02
 */
@NoAuthController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String imageCode = StringUtils.trim(request.getParameter(HycFasDict.IMAGECODE));
        String userToken = StringUtils.trim(request.getSession().getAttribute(HycFasDict.TOKENKAPTCHA));
        if (StringUtils.isEmpty(imageCode) || StringUtils.isEmpty(userToken) || !imageCode.equalsIgnoreCase(userToken)) {
            return "fail";
        }
        return "success";
    }
}
