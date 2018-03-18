package com.ikook.fruitsalesplatform.dao;

import com.ikook.fruitsalesplatform.entity.Contract;
import com.ikook.fruitsalesplatform.entity.ContractVo;
import com.ikook.fruitsalesplatform.entity.MiddleTab;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ContractDao extends BaseDao<Contract> {

    public int count(Map map);  //  根据条件统计结果集数量

    public List<ContractVo> findContractList(Map map);    // 根据条件查询多个结果

    public void insertMiddleTab(MiddleTab middelTab);     // 插入合同与货物关联信息

    public int deleteMiddleTab(Serializable contractId);  // 删除合同下所有货物信息

    public String getMaxBarCode();  // 获取最大编号

}
