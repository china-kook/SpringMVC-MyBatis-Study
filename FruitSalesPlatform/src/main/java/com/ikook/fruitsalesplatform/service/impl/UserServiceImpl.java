package com.ikook.fruitsalesplatform.service.impl;

import com.ikook.fruitsalesplatform.dao.UserDao;
import com.ikook.fruitsalesplatform.entity.User;
import com.ikook.fruitsalesplatform.service.UserService;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User get(Serializable id) {
        return userDao.get(id);
    }

    @Override
    public List<User> find(Map map) {
        return userDao.find(map);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteById(Serializable id) {
        userDao.deleteById(id);
    }

    @Override
    public void delete(Serializable[] ids) {
        userDao.delete(ids);
    }
}
