package com.hyc.fas.config;

import org.patchca.service.CaptchaService;
import org.patchca.service.ConfigurableCaptchaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/22 22:26
 */
@Configuration
public class HycFasBeansConfig {

    @Bean
    public CaptchaService captchaService() {
        return new ConfigurableCaptchaService();
    }
}
