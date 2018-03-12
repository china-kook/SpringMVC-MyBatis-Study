package com.ikook.mybatis.test;

import com.ikook.mybatis.datasource.DataConnention;
import com.ikook.mybatis.po.User;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class MyBatisTest {

    public DataConnention dataConnention = new DataConnention();

    @Test
    public void TestSelect() throws IOException {

        SqlSession sqlSession = dataConnention.getSqlSession();

        // sqlSession.selectOne 最终结果是映射文件中所匹配的 resultType 类型
        User user = sqlSession.selectOne("test.findUserById", 1);
        System.out.println("姓名:"+user.getUsername());
        System.out.println("性别:"+user.getGender());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("生日:"+simpleDateFormat.format(user.getBirthday()));
        System.out.println("所在地:"+user.getProvince()+user.getCity());

        sqlSession.close();

    }

}
