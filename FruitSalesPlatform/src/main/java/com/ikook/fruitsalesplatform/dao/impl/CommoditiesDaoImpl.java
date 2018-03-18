package com.ikook.fruitsalesplatform.dao.impl;

import com.ikook.fruitsalesplatform.dao.CommoditiesDao;
import com.ikook.fruitsalesplatform.entity.Commodities;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CommoditiesDaoImpl extends BaseDaoImpl<Commodities> implements CommoditiesDao {

    public CommoditiesDaoImpl() {
        //设置命名空间
        super.setNs("com.ikook.fruitsalesplatform.mapper.CommoditiesMapper");
    }

    @Override
    public int count(Map map) {
        return this.getSqlSession().selectOne(this.getNs() + ".count", map);
    }
}
