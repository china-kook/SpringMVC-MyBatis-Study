package com.ikook.mvc.controller;

import com.ikook.mvc.model.Fruits;
import com.ikook.mvc.model.ListQryModel;
import com.ikook.mvc.model.MapQryModel;
import com.ikook.mvc.service.FruitsService;
import com.ikook.mvc.service.FruitsServiceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

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


    @RequestMapping("fruitsArrayTest")
    public void FruitsArray(Model model,int[] fids){
        for (int i = 0; i < fids.length; i++) {
            System.out.println("fids["+i+"]="+fids[i]);
        }
    }

    @RequestMapping("fruitsListTest")
    public void FruitsList(Model model,ListQryModel listQryModel){
        List<Fruits> fruitList=listQryModel.getFruitList();
        for (int i = 0; i < fruitList.size(); i++) {
            System.out.println("fruitList["+i+"].name="+fruitList.get(i).getName());
        }
    }

    @RequestMapping("fruitsMapTest")
    public void FruitsMap(Model model,MapQryModel MapQryModel){
        Map<String,Object> fruitMap=MapQryModel.getFruitMap();
        for(String key:fruitMap.keySet()){
            System.out.println("fruitMap["+key+"]="+fruitMap.get(key));
        }
    }


}
