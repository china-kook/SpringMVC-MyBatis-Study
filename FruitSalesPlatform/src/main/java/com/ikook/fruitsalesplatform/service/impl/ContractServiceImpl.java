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
import java.util.UUID;

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
    public void insert(Contract contract, String[] commoditiesIdArrays, String[] priceArrays) {
        contractDao.insert(contract);

        // 保存中间表信息
        for (int i = 0; i < commoditiesIdArrays.length; i++) {

            MiddleTab middleTab = new MiddleTab();

            middleTab.setMiddleId(UUID.randomUUID().toString());//中间表的ID
            middleTab.setContractId(contract.getContractId());//关联的合同ID
            middleTab.setFruitId(commoditiesIdArrays[i]);//关联的货物ID

            int number = Integer.parseInt(priceArrays[i].equals("") ? "0" : priceArrays[i]);
            middleTab.setNumber(number);//货物数量
            this.insertMiddleTab(middleTab);
        }
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
        //1.删除合同基本信息
        contractDao.deleteById(contractId);
        //2.删除中间表以合同id为外键的所有货物关联信息
        contractDao.deleteMiddleTab(contractId);
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
