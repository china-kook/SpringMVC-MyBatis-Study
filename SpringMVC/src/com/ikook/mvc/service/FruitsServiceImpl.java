package com.ikook.mvc.service;

import com.ikook.mvc.model.Fruits;

import java.util.ArrayList;
import java.util.List;

public class FruitsServiceImpl implements FruitsService {

    public List<Fruits> fruitsList = null;

    public List<Fruits> init() {
        if (fruitsList == null) {
            //初始化数据
            fruitsList = new ArrayList<>();

            Fruits apple = new Fruits();
            apple.setId(1);
            apple.setName("红富士苹果");
            apple.setPrice(2.3);
            apple.setProducing_area("山东");

            Fruits Banana = new Fruits();
            Banana.setId(2);
            Banana.setName("香蕉");
            Banana.setPrice(1.5);
            Banana.setProducing_area("上海");

            fruitsList.add(apple);
            fruitsList.add(Banana);
            return fruitsList;
        } else {
            return fruitsList;
        }
    }

    public List<Fruits> queryFruitsList() {
        init();
        return fruitsList;
    }

    public Fruits queryFruitById(Integer id) {
        init();
        for (Fruits fruits : fruitsList) {
            if (fruits.getId() == id) {
                return fruits;
            }
        }
        return null;
    }

    public List<Fruits> queryFruitsByCondition(Fruits fruits) {
        init();
        String name = fruits.getName();
        String area = fruits.getProducing_area();
        List<Fruits> queryList = new ArrayList<>();
        for (Fruits f : fruitsList) {
            //有一项符合条件就返回
            if ((!name.equals("") && f.getName().contains(name)) ||
                    (!area.equals("") && f.getProducing_area().contains(area))) {
                queryList.add(f);
            }
        }
        return queryList;
    }
}
