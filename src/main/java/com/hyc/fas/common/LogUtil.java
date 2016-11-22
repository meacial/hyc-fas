package com.hyc.fas.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/22 14:23
 */
public final class LogUtil {
    private static final ThreadLocal<LogUtil> logThread = new ThreadLocal<LogUtil>();
    private String sessionId;
    private Logger logger;

    private LogUtil(String sessionId) {
        this.sessionId = sessionId;
        this.logger = LoggerFactory.getLogger(LogUtil.class);
    }

    public static void setSessionId(String sessionId) {
        if (null == logThread.get()) {
            logThread.set(new LogUtil(sessionId));
        } else if (!logThread.get().sessionId.equals(sessionId)) {
            logThread.get().sessionId = sessionId;
        }
    }
    public static void info(Object log) {
        logThread.get().logger.info(String.format("[%s] %s",logThread.get().sessionId, log));
    }
}
