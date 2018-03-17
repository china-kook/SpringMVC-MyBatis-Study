package com.ikook.fruitsalesplatform.dao;

import com.ikook.fruitsalesplatform.entity.Retailer;

import java.util.Map;

public interface RetailerDao extends BaseDao<Retailer>{

    //我们这里可以直接使用继承的 BaseDao 的增删改查方法
    //添加新的方法定义
    public int count(Map map); // 根据条件统计结果集数量

}
