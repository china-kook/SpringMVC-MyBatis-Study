package com.ikook.fruitsalesplatform.dao;

import com.ikook.fruitsalesplatform.entity.Commodities;

import java.util.Map;

public interface CommoditiesDao extends BaseDao<Commodities> {

    public int count(Map map);//根据条件统计结果集数量

}
