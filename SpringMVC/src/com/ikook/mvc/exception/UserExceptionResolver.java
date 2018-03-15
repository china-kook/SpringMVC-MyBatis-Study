package com.ikook.mvc.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse, Object o, Exception e) {

        // 解析出异常类型
        UserException userException = null;
        if (e instanceof UserException) {
            // 如果该异常类型是系统自定义的异常，直接取出异常信息，子啊错误页面显示
            userException = (UserException) e;
        } else {
            // 如果该异常类型不是系统自定义的异常，构造一个自定义的异常类型（信息为"未知异常"）
            userException = new UserException("未知异常");
        }

        // 错误信息
        String message = userException.getMessage();

        ModelAndView  modelAndView = new ModelAndView();
        modelAndView.addObject("message", message);
        modelAndView.setViewName("/errorPage/userError");

        return modelAndView;
    }
}
