package com.ikook.fruitsalesplatform.dao.impl;

import com.ikook.fruitsalesplatform.dao.ContractDao;
import com.ikook.fruitsalesplatform.entity.Contract;
import com.ikook.fruitsalesplatform.entity.ContractVo;
import com.ikook.fruitsalesplatform.entity.MiddleTab;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Repository
public class ContractDaoImpl extends BaseDaoImpl<Contract> implements ContractDao {

    public ContractDaoImpl() {
        //设置命名空间
        super.setNs("com.ikook.fruitsalesplatform.mapper.ContractMapper");
    }

    @Override
    public int count(Map map) {
        return this.getSqlSession().selectOne(this.getNs() + ".count", map);
    }

    @Override
    public List<ContractVo> findContractList(Map map) {
        return this.getSqlSession().selectList(this.getNs() + ".findContractList", map);
    }

    @Override
    public void insertMiddleTab(MiddleTab middelTab) {
        this.getSqlSession().insert(this.getNs() + ".insertMiddleTab", middelTab);
    }

    @Override
    public int deleteMiddleTab(Serializable contractId) {
        return this.getSqlSession().delete(this.getNs() + ".deleteMiddleTab", contractId);
    }

    @Override
    public String getMaxBarCode() {
        return this.getSqlSession().selectOne(this.getNs() + ".getMaxBarCode");
    }
}
