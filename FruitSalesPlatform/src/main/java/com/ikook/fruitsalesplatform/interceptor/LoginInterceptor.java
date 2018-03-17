package com.ikook.fruitsalesplatform.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String uri = httpServletRequest.getRequestURI();
        //判断当前请求地址是否是登录地址
        if (!(uri.contains("Login") || uri.contains("login") || uri.contains("register"))) {
            //非登录请求
            if (httpServletRequest.getSession().getAttribute("user") != null) {
                //说明已经登录过，放行
                return true;
            } else {
                if (uri.contains("css") || uri.contains("js") || uri.contains("images")) {
                    //如果是静态资源请求，放行
                    return true;
                } else {
                    //没有登录,跳转到登录界面
                    httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/user/toLogin.action");
                }
            }
        } else {
            //登录请求，直接放行
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
