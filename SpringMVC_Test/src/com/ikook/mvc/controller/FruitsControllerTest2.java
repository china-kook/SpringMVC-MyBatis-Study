package com.ikook.mvc.controller;

import com.google.gson.Gson;
import com.ikook.mvc.service.FruitsService;
import com.ikook.mvc.service.FruitsServiceImpl;
import com.ikook.mvc.model.Fruits;

import org.springframework.web.HttpRequestHandler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FruitsControllerTest2 implements HttpRequestHandler {

    private FruitsService fruitsService = new FruitsServiceImpl();

    @Override
    public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        // 模拟Service获取水果商品列表
        List<Fruits> fruitsList = fruitsService.queryFruitsList();

        // 将 fruitsList 转换为 json 串
        Gson gson = new Gson();
        String jsonInfo = gson.toJson(fruitsList);

        // 设置返回格式
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");

        //写出json串
        httpServletResponse.getWriter().write(jsonInfo);

        // 设置模型数据
        // httpServletRequest.setAttribute("fruitsList", fruitsList);
        // 设置转发视图
        // httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/fruits/fruitsList.jsp").forward(httpServletRequest, httpServletResponse);

    }
}
