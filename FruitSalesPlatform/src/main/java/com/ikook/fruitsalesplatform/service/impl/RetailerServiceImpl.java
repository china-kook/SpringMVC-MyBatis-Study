package com.ikook.fruitsalesplatform.service.impl;

import com.ikook.fruitsalesplatform.dao.RetailerDao;
import com.ikook.fruitsalesplatform.entity.Retailer;
import com.ikook.fruitsalesplatform.service.RetailerService;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

@Service
public class RetailerServiceImpl implements RetailerService {

    @Resource
    private RetailerDao retailerDao;

    @Override
    public Retailer get(Serializable id) {
        return retailerDao.get(id);
    }

    @Override
    public List<Retailer> find(Map map) {
        return retailerDao.find(map);
    }

    @Override
    public void insert(Retailer retailer) {
        retailerDao.insert(retailer);
    }

    @Override
    public void update(Retailer retailer) {
        retailerDao.update(retailer);
    }

    @Override
    public void deleteById(Serializable id) {
        retailerDao.deleteById(id);
    }

    @Override
    public void delete(Serializable[] ids) {
        retailerDao.delete(ids);
    }

    @Override
    public int count(Map map) {
        return retailerDao.count(map);
    }
}
