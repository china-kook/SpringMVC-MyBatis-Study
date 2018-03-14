package com.ikook.mvc.controller;

import com.ikook.mvc.service.FruitsService;
import com.ikook.mvc.service.FruitsServiceImpl;
import com.ikook.mvc.model.Fruits;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FruitsControllerTest implements Controller {

    private FruitsService fruitsService = new FruitsServiceImpl();

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        // 模拟 Service 获取水果商品列表
        List<Fruits> fruitsList = fruitsService.queryFruitsList();

        // 返回 ModelAndView
        ModelAndView modelAndView = new ModelAndView();

        // 相当于 request 的 setAttribute，在 JSP 页面中通过 fruitsList 获取数据
        modelAndView.addObject("fruitsList", fruitsList);

        // 指定视图
        modelAndView.setViewName("/WEB-INF/jsp/fruits/fruitsList.jsp");

        return modelAndView;
    }

}

// 模拟 Service 的内部类

//class FruitsService {
//
//    public List<Fruits> queryFruitsList() {
//
//        List<Fruits> fruitsList = new ArrayList<>();
//
//        Fruits apple = new Fruits();
//        apple.setName("红富士苹果");
//        apple.setPrice(2.3);
//        apple.setProducing_area("山东");
//
//        Fruits banana = new Fruits();
//        banana.setName("香蕉");
//        banana.setPrice(9.9);
//        banana.setProducing_area("上海");
//
//        fruitsList.add(apple);
//        fruitsList.add(banana);
//
//        return fruitsList;
//    }
//
//}
