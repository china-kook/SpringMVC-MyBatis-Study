package com.ikook.fruitsalesplatform.dao.impl;

import com.ikook.fruitsalesplatform.dao.AccessoryDao;
import com.ikook.fruitsalesplatform.entity.Accessory;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class AccessoryDaoImpl extends BaseDaoImpl<Accessory> implements AccessoryDao {

    public AccessoryDaoImpl() {
        //设置命名空间
        super.setNs("com.ikook.fruitsalesplatform.mapper.AccessoryMapper");
    }

    @Override
    public int count(Map map) {
        return this.getSqlSession().selectOne(this.getNs() + ".count", map);
    }

    @Override
    public int deleteByFruitId(String fruitId) {
        return this.getSqlSession().delete(this.getNs() + ".deleteByFruitId", fruitId);
    }
}
