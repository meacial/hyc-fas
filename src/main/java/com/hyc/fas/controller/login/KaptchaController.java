package com.hyc.fas.controller.login;

import com.hyc.fas.annonation.NoAuthController;
import com.hyc.fas.common.HycFasDict;
import org.patchca.service.Captcha;
import org.patchca.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 验证码处理类
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/22 10:46
 */
@NoAuthController
@RequestMapping("/kaptcha")
public class KaptchaController {
    @Autowired
    private CaptchaService captchaService;

    /**
     * 生成验证码
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/gen")
    public void genKaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (null == session) {
            session = request.getSession();
        }
        Captcha captcha = captchaService.getCaptcha();
        // 将生成的图片验证码放到session中
        session.setAttribute(HycFasDict.TOKENKAPTCHA, captcha.getChallenge());
        // 将图片验证码输入到response中
        ImageIO.write(captcha.getImage(), HycFasDict.IMAGE_FOMMAT, response.getOutputStream());
        // 设置response参数
        response.setContentType("image/png");
        response.setHeader("Cache-Control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        long time = System.currentTimeMillis();
        response.setDateHeader("Last-Modified", time);
        response.setDateHeader("Date", time);
        response.setDateHeader("Expires", time);
    }


    /**
     * 图片验证码验证
     *
     * @param request
     * @param response
     * @return  验证结果，0-验证通过，1-session失效，2-输入错误
     */
    @ResponseBody
    @RequestMapping("/check")
    public String checkKaptcha(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (null != session) {
            String kaptcha = (String) session.getAttribute(HycFasDict.TOKENKAPTCHA);
            if (null != kaptcha) {
                String req_kaptcha = (String) request.getParameter(HycFasDict.CAPTCHA);
                if (!kaptcha.equalsIgnoreCase(req_kaptcha)) {
                    return "2"; // 输入错误
                } else {
                    return "0"; // 验证通过
                }
            } else {
                return "1"; // session过期，刷新验证码
            }
        } else {
            return "1"; // session过期，刷新验证码
        }
    }
}
