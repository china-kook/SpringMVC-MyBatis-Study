package com.ikook.mvc.controller;

import com.ikook.mvc.model.Fruits;
import com.ikook.mvc.service.FruitsService;
import com.ikook.mvc.service.FruitsServiceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FruitsControllerTest{

    private FruitsService fruitsService = new FruitsServiceImpl();


    @RequestMapping(value = "/queryFruit/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Fruits getFruitById(Model model, @PathVariable("id") Integer fruitId) throws Exception{
        // 调用 Service 获取水果商品列表
        Fruits fruit = fruitsService.queryFruitById(fruitId);
        return fruit;
    }

}
