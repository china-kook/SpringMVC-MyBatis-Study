package com.ikook.fruitsalesplatform.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 泛型类，基础 DAO 接口
 * @param <T>
 */
public interface BaseDao<T> {

    public T get(Serializable id); // 只查询一个，常用于修改

    // 根据条件查询多个结果
    public List<T> find(Map map);

    // 插入，用实体作为参数
    public void insert(T entity);

    // 修改
    public void update(T entity);

    // 按 id 删除，删除一条，支持整数型和字符串类型 ID
    public void deleteById(Serializable id);

    // 批量删除，支持整数型和字符串类型 ID
    public void delete(Serializable[] ids);

}
