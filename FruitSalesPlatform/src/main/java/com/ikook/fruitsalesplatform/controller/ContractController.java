package com.ikook.fruitsalesplatform.controller;

import com.alibaba.fastjson.JSONObject;
import com.ikook.fruitsalesplatform.entity.ContractVo;
import com.ikook.fruitsalesplatform.entity.Retailer;
import com.ikook.fruitsalesplatform.service.ContractService;
import com.ikook.fruitsalesplatform.service.RetailerService;
import com.mysql.jdbc.StringUtils;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

@Controller
public class ContractController {

    @Resource
    private ContractService contractService;

    @Resource
    private RetailerService retailerService;

    //跳转至列表页面
    @RequestMapping("/contract/list.action")
    public String list(Model model, ContractVo contractVo) {
        return "/contract/contractHome.jsp";
    }

    @RequestMapping("/contract/toAddPage.action")
    public String toAddPage() {
        return "/contract/addContract.jsp";
    }

    @RequestMapping("/contract/getAllRetailer.action")
    public @ResponseBody
    List<Retailer> getAllRetailer(@RequestBody String json) {

        Map<String, Object> param = new HashMap<>();

        param.put("status", 1);//选择启用的零售商

        if (!StringUtils.isNullOrEmpty(json)) {
            String name = JSONObject.parseObject(json).getString("name");
            if (!StringUtils.isNullOrEmpty(name)) {
                param.put("name", "%" + name + "%");//零售商姓名
            }
        }

        List<Retailer> retailerList = retailerService.find(param);
        return retailerList;
    }

}
