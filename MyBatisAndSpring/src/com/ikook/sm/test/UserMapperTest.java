package com.ikook.sm.test;

import com.ikook.sm.mapper.UserMapper;
import com.ikook.sm.mapper.UserQueryMapper;
import com.ikook.sm.pojo.User;
import com.ikook.sm.pojo.UserExample;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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

    @Test
    public void testGeneratorInsert() throws ParseException {

        //1. 测试插入操作
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        User user = new User();
        user.setUsername("白玉静");
        user.setGender("女");
        user.setBirthday(simpleDateFormat.parse("1998-01-18"));
        user.setProvince("山东省");
        user.setCity("济南市");
        user.setEmail("baiyujing@6666.com");
        userMapper.insert(user);

        System.out.println("1. 插入了名为：" + user.getUsername() + " 的用户");

    }

    @Test
    public void testGeneratorSelect() throws ParseException {

        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // 测试查询操作（自定义查询）
        UserExample userExample = new UserExample();

        // 通过 Criteria 构造查询条件
        UserExample.Criteria criteria = userExample.createCriteria();

        // 查询条件1：username equal '白玉静'
        criteria.andUsernameEqualTo("白玉静");
        // 查询条件2：gender <> '女'
        criteria.andGenderNotEqualTo("男");
        // 查询条件3：birthday between '1992-01-01' and '1999-01-01'
        criteria.andBirthdayBetween(simpleDateFormat.parse("1992-01-01"),
                simpleDateFormat.parse("1999-01-01"));
        // 查询条件4：email is not NULL
        criteria.andEmailIsNotNull();

        // 可能返回多条记录
        List<User> list = userMapper.selectByExample(userExample);

        for (User user : list) {
            System.out.println(user.getId() + ": " + user.getUsername());
        }

        // 3. 测试查询操作（主键 id 查询）
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(" 主键查询出 id 为 1 的用户, 名为：" + user.getUsername());
    }

    @Test
    public void testGeneratorUpdate() throws ParseException {

        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");

        // 测试修改操作（对所有字段进行更新）
        // 对所有字段进行更新，需要先查询出来再更新
        User user = userMapper.selectByPrimaryKey(1);
        user.setEmail("1111@126.com");
        userMapper.updateByPrimaryKey(user);
        System.out.println("更新 id 为 " + user.getId() + " 的用户的所有信息");

        // 测试修改操作（对个别字段进行更新）
        // 只有传入字段不为空才更新，在批量更新中使用此方法，不需要先查询再更新
        User user1 = new User();
        // 只修改用户的 email 信息
        user1.setId(1);
        user1.setEmail("zhangsan@126.com");
        userMapper.updateByPrimaryKeySelective(user1);
        System.out.println("更新 id 为 " + user1.getId() + " 的用户的 email 为：" + user1.getEmail());
    }

    @Test
    public void testGeneratorDelete() throws ParseException {
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");

        // 测试删除操作
        int deleteId = 8;
        userMapper.deleteByPrimaryKey(deleteId);

        User user = userMapper.selectByPrimaryKey(deleteId);

        if (user == null) {
            System.out.println("删除 id 为：" + deleteId + " 的用户成功。");
        }

    }

}
