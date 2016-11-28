package com.hyc.fas.config;

import com.hyc.fas.common.HycFasDict;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 注册连接器config
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/22 17:07
 */
@Configuration
public class HycFasInterceptorsConfig extends WebMvcConfigurerAdapter {
    /**
     * {@inheritDoc}
     * <p>This implementation is empty.
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                boolean past = false;
                HttpSession session = request.getSession(false);
                if (null == session) {
                    past = false;
                } else {
                    past = session.getAttribute(HycFasDict.USERTOKEN) == null ? false : true;
                }
                if (past == false) {
                    // throw new AuthCheckException(handler.toString());
                    response.sendRedirect(request.getContextPath()+"/login");
                }
                return past;
            }

            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
                // noop
            }

            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
                // noop
            }
        }).excludePathPatterns("/","","/kaptcha/gen","/user/login","/user/logout");
    }

}
