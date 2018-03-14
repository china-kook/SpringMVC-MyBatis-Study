package com.ikook.mvc.service;

import com.ikook.mvc.model.Fruits;

import java.util.List;

public interface FruitsService {

    public List<Fruits> queryFruitsList();

    public Fruits queryFruitById(Integer id);

    public List<Fruits> queryFruitsByCondition(Fruits fruits);

}
