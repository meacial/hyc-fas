package com.hyc.fas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/21 14:46
 */
@Controller
public class Home {
    @RequestMapping("/")
    public String index() {
        return "login";
    }
}
