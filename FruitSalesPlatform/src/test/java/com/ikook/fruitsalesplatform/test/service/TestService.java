package com.ikook.fruitsalesplatform.test.service;

import com.ikook.fruitsalesplatform.test.entity.User;

import java.util.List;

public interface TestService {
    public List<User> findUserByName(User user);
}
