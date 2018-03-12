package com.ikook.mybatis.test;

import com.ikook.mybatis.po.ShoppingCart;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;

public class CartObjectFactory extends DefaultObjectFactory {

    @Override
    public <T> T create(Class<T> type) {
        return super.create(type);
    }

    // DefaultObjectFactory 的 create(Class type) 方法会调用此方法
    // 所以，只需要在此方法中添加逻辑即可。
    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {

        T ret = super.create(type, constructorArgTypes, constructorArgs);

        //判断加载的类的类型，然后执行init方法。
        if (ShoppingCart.class.isAssignableFrom(type)) {
            ShoppingCart entity = (ShoppingCart) ret;
            entity.init();
        }
        return ret;
    }
}
