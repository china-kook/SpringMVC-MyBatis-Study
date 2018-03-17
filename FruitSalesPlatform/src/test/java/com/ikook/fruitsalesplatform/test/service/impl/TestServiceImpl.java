package com.ikook.fruitsalesplatform.test.service.impl;

import com.ikook.fruitsalesplatform.test.dao.TestDao;
import com.ikook.fruitsalesplatform.test.entity.User;
import com.ikook.fruitsalesplatform.test.service.TestService;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestDao testDao;

    public List<User> findUserByName(User user) {
        return testDao.findUserByName(user);
    }

}
