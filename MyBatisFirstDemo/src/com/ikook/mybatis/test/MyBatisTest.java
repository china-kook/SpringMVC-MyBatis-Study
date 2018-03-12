package com.ikook.mybatis.test;

import com.ikook.mybatis.datasource.DataConnention;
import com.ikook.mybatis.po.User;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
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

}
