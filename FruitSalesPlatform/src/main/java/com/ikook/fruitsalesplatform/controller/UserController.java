package com.ikook.fruitsalesplatform.controller;

import com.ikook.fruitsalesplatform.entity.User;
import com.ikook.fruitsalesplatform.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    // 跳转至登录页面
    @RequestMapping("/user/toLogin.action")
    public String toLogin() {
        return "/login.jsp"; // 转向登录页面
    }

    // 跳转至注册页面
    @RequestMapping("/user/registerPage.action")
    public String toRegister() {
        return "/register.jsp"; // 转向登录页面
    }

    // 登录
    @RequestMapping("/user/login.action")
    public String login(User user, Model model, HttpServletRequest request) {

        Map<String, String> map = new HashMap<>();
        map.put("username", user.getUsername());
        map.put("password", user.getPassword());

        List<User> userList = userService.find(map);
        if (userList != null && userList.size() > 0) {
            request.getSession().setAttribute("user", userList.get(0));
            return "/home.jsp"; // 转向主页
        }

        model.addAttribute("errorMsg", "登录失败！账号或者密码错误！"); // 错误消息

        return "/login.jsp";
    }

    // 注册
    @RequestMapping("/user/register.action")
    public String register(User user, Model model, HttpServletRequest request, HttpServletResponse response) {

        // 查找账号是否已经注册
        Map<String, String> map = new HashMap<>();
        map.put("username", user.getUsername());

        List<User> userList = userService.find(map);
        if (userList != null && userList.size() > 0) {
            // 如果查询到了，说明账号已经被注册，提示用户，并转发回到注册页面
            model.addAttribute("errorMsg", "注册失败！用户名已经被占用！");
            return "/register.jsp";
        }

        user.setUserId(UUID.randomUUID().toString()); // 为用户设置 UUID 主键
        userService.insert(user);
        model.addAttribute("noticeMsg", "注册成功！请输入账号和密码"); // 注册成功消息

        return "/login.jsp";
    }



}
