package com.hyc.fas.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/23 16:07
 */
@ConfigurationProperties(
        prefix = "hyc.fas"
)
public class HycFasProperties {

    private String charset;

    private String deskey;

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getDeskey() {
        return deskey;
    }

    public void setDeskey(String deskey) {
        this.deskey = deskey;
    }
}
