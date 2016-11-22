package com.hyc.fas.controller.content;

import com.hyc.fas.annonation.NeedAuthController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 投资统计
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/22 16:36
 */
@NeedAuthController
@RequestMapping("/auth")
public class InvestStatController {

    /**
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping({"/main","/"})
    public String main(HttpServletRequest request, HttpServletResponse response) {
        return "main";
    }
}
