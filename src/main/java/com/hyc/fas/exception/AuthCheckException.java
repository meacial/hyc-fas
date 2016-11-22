package com.hyc.fas.exception;

/**
 * 权限检查异常
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/22 17:40
 */
public class AuthCheckException extends RuntimeException {
    public String source;

    public AuthCheckException() {
        this(null, null, null);
    }

    public AuthCheckException(String source) {
        this(source, null, null);
    }

    public AuthCheckException(String source, String message) {
        this(source, message, null);
    }

    public AuthCheckException(String source, String message, Throwable throwable) {
        super(message, throwable);
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Source :　[" + source + "]" + super.toString();
    }
}
