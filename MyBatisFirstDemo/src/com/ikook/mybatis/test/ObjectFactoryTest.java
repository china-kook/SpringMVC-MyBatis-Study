package com.ikook.mybatis.test;

import com.ikook.mybatis.datasource.DataConnention;
import com.ikook.mybatis.po.ShoppingCart;

import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ObjectFactoryTest {

    public static DataConnention dataConn = new DataConnention();


    public static void main(String[] args) throws IOException {

        SqlSession sqlSession = dataConn.getSqlSession();

        CartObjectFactory e = new CartObjectFactory();

        // 设置参数类型 List 和参数值 List
        List constructorArgTypes = new ArrayList();

        constructorArgTypes.add(int.class);
        constructorArgTypes.add(String.class);
        constructorArgTypes.add(int.class);
        constructorArgTypes.add(double.class);
        constructorArgTypes.add(double.class);

        List constructorArgs = new ArrayList();

        constructorArgs.add(1);//productId
        constructorArgs.add("牙刷");//productName
        constructorArgs.add(12);//number
        constructorArgs.add(5.0);//price
        constructorArgs.add(0.0);//totalAmount

        ShoppingCart sCart = e.create(ShoppingCart.class, constructorArgTypes, constructorArgs);

        System.out.println(sCart.getTotalAmount());
    }
}
