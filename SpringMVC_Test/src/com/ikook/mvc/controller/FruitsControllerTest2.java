package com.ikook.mvc.controller;

import com.ikook.mvc.model.Fruits;

import org.springframework.web.HttpRequestHandler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FruitsControllerTest2 implements HttpRequestHandler {

    private FruitsService fruitsService = new FruitsService();

    @Override
    public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        // 模拟Service获取水果商品列表
        List<Fruits> fruitsList = fruitsService.queryFruitsList();

        // 设置模型数据
        httpServletRequest.setAttribute("fruitsList", fruitsList);

        // 设置转发视图
        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/fruits/fruitsList.jsp")
                .forward(httpServletRequest, httpServletResponse);

    }
}
