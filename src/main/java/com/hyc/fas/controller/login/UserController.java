package com.hyc.fas.controller.login;

import com.hyc.fas.annonation.NoAuthController;
import com.hyc.fas.common.HycFasDict;
import com.hyc.fas.common.StringUtils;
import com.hyc.fas.config.HycFasProperties;
import com.hyc.fas.entity.HycUser;
import com.hyc.fas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/22 16:02
 */
@NoAuthController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private HycFasProperties hycFasProperties;

    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String imageCode = StringUtils.trim(request.getParameter(HycFasDict.IMAGECODE));
        String userPhone = StringUtils.trim(request.getParameter(HycFasDict.USERNAME));
        String password = StringUtils.trim(request.getParameter(HycFasDict.PASSWORD));
        String userToken = StringUtils.trim(request.getSession().getAttribute(HycFasDict.TOKENKAPTCHA));
        if (StringUtils.isEmpty(userPhone) || StringUtils.isEmpty(password) || StringUtils.isEmpty(imageCode) || StringUtils.isEmpty(userToken) || !imageCode.equalsIgnoreCase(userToken)) {
            return "fail";
        }

        // String desPhone = AppSecUtil.encryptMode(hycFasProperties.getDeskey(),userPhone,hycFasProperties.getCharset());
        String desPhone = "Iq63w+w1ATP35ycdbXzIyA==";

        List<HycUser> hycUsers = userService.getUserByPhone(desPhone);
        HycUser hycUser = null;
        if (hycUsers != null && hycUsers.size() == 1) {
            hycUser = hycUsers.get(0);
        }

        if (hycUser == null) {
            return "fail";
        }
        /*if (!Arrays.equals(hycUser.getPassword(), password.getBytes())) {
            return "fail";
        }*/
        request.getSession().setAttribute(HycFasDict.USERTOKEN, "user_i_d");
        return "success";
    }
}
