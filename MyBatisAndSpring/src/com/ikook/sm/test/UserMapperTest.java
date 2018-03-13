package com.ikook.sm.test;

import com.ikook.sm.mapper.UserQueryMapper;
import com.ikook.sm.pojo.User;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMapperTest {

    private ApplicationContext applicationContext;

    //在执行测试方法之前首先获Spring配置文件对象
    //注解Before是在执行本类所有测试方法之前先调用这个方法
    @Before
    public void setup() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    }

    @Test
    public void testFindUserById() throws Exception {

        //通过配置资源对象获取 userQueryMapper 对象
        UserQueryMapper userQueryMapper=(UserQueryMapper)applicationContext.getBean("userQueryMapper");

        User user = userQueryMapper.findUserById(1);

        System.out.println(user.getId() + ":" + user.getUsername());
    }

}
