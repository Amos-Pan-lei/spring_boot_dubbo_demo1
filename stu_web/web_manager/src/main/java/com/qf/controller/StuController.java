package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.StuClass;
import com.qf.entity.Student;
import com.qf.service.IClassService;
import com.qf.service.IStuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

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
    @RequestMapping("/addStu")
    public String addStu(Model model,Student student){

        stuService.addStudent(student);
        return "redirect:/stu/list";
    }
    @RequestMapping("/queryById")
    public String queryById(Model model,Integer id){
        List<StuClass> classes = classService.getlist();
        model.addAttribute("clist",classes);
        Student student = stuService.getById(id);
        model.addAttribute("s",student);
        return "updateStu";
    }


    @RequestMapping("getListByCid")
    public String getListByCid(StuClass stuClass,Model model){
        Map<String,Object> map=new HashMap<>();
        map.put("cid",stuClass.getId());
        List<Student> students = (List<Student>) stuService.listByMap(map);
        StuClass classInfo = classService.getClassInfo(stuClass.getId());
        for (Student student : students) {
            student.setCls(classInfo);
        }
        model.addAttribute("stulist",students);

        return "stulist2";
    }

    @RequestMapping("/updateStu")
    public String updateStu(Student s,Model model) {
        Student student = stuService.getById(s.getId());
        //把原来的班级人数减一
        classService.decrease(student.getCid());

        //把新的班级人数加一个
        classService.updateSnum(s.getCid());
        stuService.updateById(s);

        return "redirect:/stu/list";

    }

}
