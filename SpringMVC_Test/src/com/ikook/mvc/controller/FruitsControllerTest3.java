package com.ikook.mvc.controller;

import com.ikook.mvc.service.FruitsService;
import com.ikook.mvc.service.FruitsServiceImpl;
import com.ikook.mvc.model.Fruits;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// 注解的 Handler 类
// 使用 @Controller 来标识它是一个控制器
@Controller
public class FruitsControllerTest3 {

    private FruitsService fruitsService = new FruitsServiceImpl();

    // 商品查询列表
    // @RequestMapping 实现 对 queryFruitsList 方法和 url 进行映射，一个方法对应一个 url
    // 一般建议将 url 和方法写成一样
    @RequestMapping("/queryFruitsList")
    public ModelAndView queryFruitsList() throws Exception {
        //模拟Service获取水果商品列表
        List<Fruits> fruitsList = fruitsService.queryFruitsList();

        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();

        //相当于 request 的 setAttribute，在 jsp 页面中通过 fruitsList 取数据
        modelAndView.addObject("fruitsList", fruitsList);

        // 指定视图
        modelAndView.setViewName("/fruits/fruitsList");

        return modelAndView;
    }


}
