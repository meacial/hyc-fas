package com.hyc.fas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/21 11:48
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String say() {
        return "HelloWorld";
    }
}
