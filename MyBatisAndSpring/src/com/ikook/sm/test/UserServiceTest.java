package com.ikook.sm.test;

import com.ikook.sm.dao.UserDao;
import com.ikook.sm.pojo.User;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {

    private ApplicationContext applicationContext;

    // 在执行测试方法之前首先获 Spring 配置文件对象
    // 注解 Before 是在执行本类所有测试方法之前先调用这个方法
    @Before
    public void setup() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    }

    @Test
    public void testFindUserById() throws Exception {

        //通过配置资源对象获取 userDao 对象
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");

        // 调用 UserDao 的方法
        User user = userDao.findUserById(1);

        // 输出用户信息
        System.out.println(user.getId() + ": " + user.getUsername());
    }
}
