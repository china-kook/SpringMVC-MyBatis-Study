package com.ikook.fruitsalesplatform.service.impl;

import com.ikook.fruitsalesplatform.dao.AccessoryDao;
import com.ikook.fruitsalesplatform.entity.Accessory;
import com.ikook.fruitsalesplatform.service.AccessoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Service
public class AccessoryServiceImpl implements AccessoryService {

    @Autowired
    private AccessoryDao accessoryDao;

    @Override
    public Accessory get(Serializable id) {
        return this.accessoryDao.get(id);
    }

    @Override
    public List<Accessory> find(Map map) {
        return this.accessoryDao.find(map);
    }

    @Override
    public void insert(Accessory accessory) {
        this.accessoryDao.insert(accessory);
    }

    @Override
    public void update(Accessory accessory) {
        this.accessoryDao.update(accessory);
    }

    @Override
    public void deleteById(Serializable id) {
        this.accessoryDao.deleteById(id);
    }

    @Override
    public void delete(Serializable[] ids) {
        this.accessoryDao.delete(ids);
    }

    @Override
    public int deleteByFruitId(String fruitId) {
        return this.accessoryDao.deleteByFruitId(fruitId);
    }
}
