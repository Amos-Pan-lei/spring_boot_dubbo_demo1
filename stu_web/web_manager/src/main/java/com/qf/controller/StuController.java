package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.StuClass;
import com.qf.entity.Student;
import com.qf.service.IClassService;
import com.qf.service.IStuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Author Amos
 * Creat Time 2019 11 29
 */
@Controller
@RequestMapping("/stu")
public class StuController {

    @Reference
    private IClassService classService;

    @Reference
    private IStuService stuService;

    @RequestMapping("/list")
    public String stulist(Model model){
        List<Student> list = stuService.getlist();
        model.addAttribute("slist",list);
        return "stulist";
    }
    @RequestMapping("/deleteById")
        public String deleteById(Model model,Integer id){
            stuService.deleteById(id);
            return "redirect:/stu/list";
        }
    @RequestMapping("/add")
    public String add(Model model){
        List<StuClass> classes = classService.getlist();
        model.addAttribute("clist",classes);
        return "add";
    }

}
