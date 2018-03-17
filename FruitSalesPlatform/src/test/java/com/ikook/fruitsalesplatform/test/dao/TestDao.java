package com.ikook.fruitsalesplatform.test.dao;

import com.ikook.fruitsalesplatform.test.entity.User;

import java.util.List;

public interface TestDao {
    public List<User> findUserByName(User user);
}
