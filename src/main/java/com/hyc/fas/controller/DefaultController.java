package com.hyc.fas.controller;

import com.hyc.fas.annonation.NoAuthController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 默认处理类
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/22 16:14
 */
@NoAuthController
@RequestMapping("/")
public class DefaultController extends AbstractController {
    @RequestMapping("")
    public String index() {
        return "login";
    }
}
