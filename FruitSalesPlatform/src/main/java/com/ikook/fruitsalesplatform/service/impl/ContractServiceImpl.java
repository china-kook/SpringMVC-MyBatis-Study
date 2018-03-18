package com.ikook.fruitsalesplatform.service.impl;

import com.ikook.fruitsalesplatform.dao.ContractDao;
import com.ikook.fruitsalesplatform.entity.Contract;
import com.ikook.fruitsalesplatform.entity.ContractVo;
import com.ikook.fruitsalesplatform.entity.MiddleTab;
import com.ikook.fruitsalesplatform.service.ContractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractDao contractDao;

    @Override
    public Contract get(Serializable id) {
        return contractDao.get(id);
    }

    @Override
    public List<ContractVo> findContractList(Map map) {
        return contractDao.findContractList(map);
    }

    @Override
    public void insert(Contract contract) {
        contractDao.insert(contract);
    }

    @Override
    public void insertMiddleTab(MiddleTab middelTab) {
        contractDao.insertMiddleTab(middelTab);
    }

    @Override
    public void update(Contract contract) {
        contractDao.update(contract);
    }

    @Override
    public void deleteById(Serializable contractId) {
        contractDao.deleteById(contractId);
    }

    @Override
    public void deleteMiddleTab(Serializable contractId) {
        contractDao.deleteMiddleTab(contractId);
    }

    @Override
    public int count(Map map) {
        return contractDao.count(map);
    }

    @Override
    public String getMaxBarCode() {
        return contractDao.getMaxBarCode();
    }
}
