package com.ikook.mybatis.test;

import com.ikook.mybatis.datasource.DataConnention;
import com.ikook.mybatis.po.User;
import com.ikook.mybatis.po.UserInstance;
import com.ikook.mybatis.po.UserQueryInfo;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class MyBatisTest {

    public DataConnention dataConnention = new DataConnention();

    @Test
    public void TestSelect() throws IOException {

        SqlSession sqlSession = dataConnention.getSqlSession();

        // sqlSession.selectOne 最终结果是映射文件中所匹配的 resultType 类型
        User user = sqlSession.selectOne("test.findUserById", 1);
        System.out.println(user);

        sqlSession.close();

    }

    @Test
    public void TestFuzzySearch() throws IOException {
        SqlSession sqlSession = dataConnention.getSqlSession();

        List<User> userList = sqlSession.selectList("test.findUserByUsername", "丽");

        for (int i = 0; i < userList.size(); i++) {
            User u = userList.get(i);
            System.out.println(u);
        }

        sqlSession.close();
    }

    @Test
    public void TestInsert() throws Exception {

        SqlSession sqlSession = dataConnention.getSqlSession();

        User user = new User();
        user.setUsername("孙佳佳");
        user.setGender("男");
        user.setPassword("5555");
        user.setEmail("5555@126.com");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long date = sdf.parse("1991-02-16").getTime();
        user.setBirthday(new Date(date));
        user.setProvince("湖北省");
        user.setCity("武汉市");

        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();

        System.out.println("用户'孙佳佳'的 ID 为：" + user.getId()); // 获取新增用户在数据表中的 ID
        sqlSession.close();
    }

    @Test
    public void TestDelete() throws Exception {
        SqlSession sqlSession = dataConnention.getSqlSession();

        sqlSession.delete("test.deleteUser", 7);
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void TestUpdate() throws Exception {
        SqlSession sqlSession = dataConnention.getSqlSession();

        User user = new User();
        user.setId(4);
        user.setUsername("孙丽");

        sqlSession.update("test.updateUserName", user);
        sqlSession.commit();

        sqlSession.close();
    }

    //用户信息综合查询
    @Test
    public void testFindUserList() throws Exception {

        SqlSession sqlSession = dataConnention.getSqlSession();

        // 创建包装对象，设置查询条件
        UserQueryInfo userQueryInfo = new UserQueryInfo();

        UserInstance userInstance = new UserInstance();

        userInstance.setGender("男");
        userInstance.setUsername("张三");
        userQueryInfo.setUserInstance(userInstance);

        //调用 userMapper 的方法
        List<UserInstance> userList = sqlSession.selectList("test.findUserList", userQueryInfo);

        for (int i = 0; i < userList.size(); i++) {
            UserInstance user = (UserInstance) userList.get(i);
            System.out.println(user.getId() + ":" + user.getUsername());
        }
        sqlSession.close();
    }

}
