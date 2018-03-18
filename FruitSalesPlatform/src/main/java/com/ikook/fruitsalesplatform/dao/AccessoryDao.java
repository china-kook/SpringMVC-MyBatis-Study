package com.ikook.fruitsalesplatform.dao;

import com.ikook.fruitsalesplatform.entity.Accessory;

import java.util.Map;

public interface AccessoryDao extends BaseDao<Accessory> {

    public int count(Map map);//根据条件统计结果集数量

    public int deleteByFruitId(String fruitId);//根据条件统计结果集数量

}
