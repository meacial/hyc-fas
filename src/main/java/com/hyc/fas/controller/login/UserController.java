package com.hyc.fas.controller.login;

import com.hyc.fas.annonation.NoAuthController;
import com.hyc.fas.common.HycFasDict;
import com.hyc.fas.common.SecurityUtil;
import com.hyc.fas.common.StringUtils;
import com.hyc.fas.config.HycFasProperties;
import com.hyc.fas.controller.AbstractController;
import com.hyc.fas.entity.HycUser;
import com.hyc.fas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/22 16:02
 */
@NoAuthController
@RequestMapping("/user")
public class UserController extends AbstractController {

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

        // TODO 这段执行特别慢，测试的时候，暂时注掉
        // String desPhone = AppSecUtil.encryptMode(hycFasProperties.getDeskey(),userPhone,hycFasProperties.getCharset());
//        String desPhone = "pvsJr8X5TkeLLvVMzEuJpA==";
        String desPhone = "UBFJUPI2kMS4qlKmbmZwHQ==";
        HycUser hycUser = userService.getHycUserByPhone(desPhone);
        if (hycUser == null) {
            return "fail";
        }
        try {
            if (!hycUser.getPassword().equals(SecurityUtil.hashWithBase64Encoded("md5", password.getBytes("utf-8")))) {
                return "fail";
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "fail";
        }
        saveUserId2Session(request, hycUser.getUserid());
        saveUserId2Session(request, "20151222679117864644378624");

        return "success";
    }
}
