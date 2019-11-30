package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.StuClass;
import com.qf.service.IClassService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Author Amos
 * Creat Time 2019 11 29
 */
@Controller
@RequestMapping("/class")
public class ClassController {

    @Reference
    IClassService classService;

    @RequestMapping("/list")
    public String getlist(Model model){
        List<StuClass> list = classService.getlist();
        model.addAttribute("clist",list);
        return "classList";
    }


}
