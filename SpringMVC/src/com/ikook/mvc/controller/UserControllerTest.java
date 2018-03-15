package com.ikook.mvc.controller;

import com.ikook.mvc.exception.UserException;
import com.ikook.mvc.model.User;
import com.ikook.mvc.validator.UserValidator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserControllerTest {

    @InitBinder
    public void initBinder(DataBinder binder) {
        binder.setValidator(new UserValidator());
    }

    @RequestMapping(value = "/toLogin")
    public String toLoginPage() {
        // 跳转到登录界面
        return "/user/login";
    }

    @RequestMapping(value = "/login")
    public String login(Model model, HttpServletRequest request, @Valid User user, BindingResult result) throws UserException{

        // 查询用户是否为黑名单用户
        boolean isBlackUser = checkBlackUser(user);
        // 如果是黑名单用户，则抛出异常，结束程序
        if (isBlackUser) {
            throw new UserException("user.not.have.power");
        }

        // 登录检测
        List<ObjectError> allErrors = null;
        if (result.hasErrors()) {
            allErrors = result.getAllErrors();
            for (ObjectError objectError : allErrors) {
                // 输出错误信息
                System.out.println("code = " + objectError.getCode() +
                        " DefaultMessage = " + objectError.getDefaultMessage());
                // 或者将错误传到页面
                model.addAttribute("allErrors", allErrors);
            }
            return "/user/login";
        } else {
            // 检测账号密码，成功即登录成功
            boolean flag = checkUser(user);
            if (flag) {
                request.getSession().setAttribute("user", user);
            } else {
                model.addAttribute("errorMsg", "账号或密码错误");
                return "/user/login";
            }
        }

        return "/user/loginSuccess";

    }

    private boolean checkBlackUser(User user) {
        String blackArray[] = {"jack", "tom", "jean"};
        for (int i = 0; i < blackArray.length; i++) {
            if (user.getUsername().equals(blackArray[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkUser(User user) {

        if (user.getUsername().equals("zhangsan") && user.getPassword().equals("qwe123")) {
            return true;
        }
        return false;
    }


}
