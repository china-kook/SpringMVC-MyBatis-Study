package com.ikook.mvc.controller;

import com.ikook.mvc.model.Fruits;
import com.ikook.mvc.service.FruitsService;
import com.ikook.mvc.service.FruitsServiceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/query")
public class FindControllerTest {

    private FruitsService fruitsService = new FruitsServiceImpl();

    @RequestMapping(value = "/queryFruitsByCondition")
    public String queryFruitsByCondition(Model model, Fruits fruits) {

        List<Fruits> findList;

        System.out.println(fruits.getName());
        System.out.println(fruits.getProducing_area());

        if ((fruits.getName() == null && fruits.getProducing_area() == null)) {
            // 如果 fruits 或查询条件为空，默认查询所有数据
            findList = fruitsService.queryFruitsList();
        } else if (fruits.getName() == "" && fruits.getProducing_area() == ""){
            // 如果 fruits 或查询条件为空，默认查询所有数据
            findList = fruitsService.queryFruitsList();

        } else {
            // 如果 fruits 查询条件不为空，按条件查询
            findList = fruitsService.queryFruitsByCondition(fruits);
        }

        // 将 model 数据传到页面
        model.addAttribute("fruitsList", findList);

        return "/fruits/findFruits";

    }


}
