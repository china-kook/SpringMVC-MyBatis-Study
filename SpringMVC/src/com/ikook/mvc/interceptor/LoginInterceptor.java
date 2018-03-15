package com.ikook.mvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String uri = httpServletRequest.getRequestURI();
        // 判断当前请求地址是否是登录地址
        if (!(uri.contains("Login") || uri.contains("login"))) {
            // 非登录请求
            if (httpServletRequest.getSession().getAttribute("user") != null) {
                // 说明已经登陆过，放行
                return true;
            } else {
                // 没有登录，跳转到登录页面
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/user/toLogin.action");
            }
        } else {
            // 登录请求，直接放行
            return true;
        }

        return false; // 默认拦截
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
