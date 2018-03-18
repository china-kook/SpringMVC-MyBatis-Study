package com.ikook.fruitsalesplatform.service.impl;

import com.ikook.fruitsalesplatform.dao.CommoditiesDao;
import com.ikook.fruitsalesplatform.entity.Commodities;
import com.ikook.fruitsalesplatform.service.CommoditiesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Service
public class CommoditiesServiceImpl implements CommoditiesService {

    @Autowired
    private CommoditiesDao commoditiesDao;

    @Override
    public Commodities get(Serializable id) {
        return this.commoditiesDao.get(id);
    }

    @Override
    public List<Commodities> find(Map map) {
        return this.commoditiesDao.find(map);
    }

    @Override
    public void insert(Commodities commodties) {
        this.commoditiesDao.insert(commodties);
    }

    @Override
    public void update(Commodities commodties) {
        this.commoditiesDao.update(commodties);
    }

    @Override
    public void deleteById(Serializable id) {
        this.commoditiesDao.deleteById(id);
    }

    @Override
    public void delete(Serializable[] ids) {
        this.commoditiesDao.delete(ids);
    }

    @Override
    public int count(Map map) {
        return this.commoditiesDao.count(map);
    }
}
