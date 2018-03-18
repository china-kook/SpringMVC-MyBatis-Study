package com.ikook.fruitsalesplatform.controller;

import com.ikook.fruitsalesplatform.entity.ContractVo;
import com.ikook.fruitsalesplatform.service.ContractService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class ContractController {

    @Resource
    private ContractService contractService;

    //跳转至列表页面
    @RequestMapping("/contract/list.action")
    public String list(Model model, ContractVo contractVo) {
        return "/contract/contractHome.jsp"; 
    }

}
