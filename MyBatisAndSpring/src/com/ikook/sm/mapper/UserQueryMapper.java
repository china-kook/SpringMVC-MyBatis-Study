package com.ikook.sm.mapper;

import com.ikook.sm.pojo.User;

public interface UserQueryMapper {

    //根据Id查询用户信息
    public User findUserById(int id) throws Exception;

}
