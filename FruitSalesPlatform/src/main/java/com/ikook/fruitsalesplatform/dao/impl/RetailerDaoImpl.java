package com.ikook.fruitsalesplatform.dao.impl;

import com.ikook.fruitsalesplatform.dao.RetailerDao;
import com.ikook.fruitsalesplatform.entity.Retailer;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RetailerDaoImpl extends BaseDaoImpl<Retailer> implements RetailerDao {

    public RetailerDaoImpl(){
        //设置命名空间
        super.setNs("com.ikook.fruitsalesplatform.mapper.RetailerMapper");
    }

    @Override
    public int count(Map map) {
        return this.getSqlSession().selectOne(this.getNs() + ".count", map);
    }
}
