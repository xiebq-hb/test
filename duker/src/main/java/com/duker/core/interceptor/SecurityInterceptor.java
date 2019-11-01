package com.duker.core.interceptor;

import com.duker.core.annotation.Security;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiebq
 * @create 2019/10/18 0018
 * @since 1.0.0
 */
@Component
@Slf4j
public class SecurityInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * handler保存了本次请求的controller也就是接口方法的一些信息，如类，方法，参数等
         * 如果是一次静态资源的请求则该handler不应该是HandlerMethod的实现类
         * 判断是否是一个正常的接口，如果是则进行鉴权操作，不是则直接放行
         */
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            Security security = handlerMethod.getMethod().getAnnotation(Security.class);
            if (null != security && security.value()){
                //校验逻辑
                if (hasPermisson()){
                    log.info(request.getRequestURI() + " 验证通过");
                    return true;
                }else {
                    log.info(request.getRequestURI() + " 验证不通过");
                    return false;
                }
            }
        }
        return true;
    }

    //校验方法
    private boolean hasPermisson() {
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
