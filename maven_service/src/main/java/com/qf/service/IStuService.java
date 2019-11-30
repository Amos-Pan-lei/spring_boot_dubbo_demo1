package com.qf.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.entity.Student;

import java.util.List;

public interface IStuService extends IService<Student> {
    List<Student> getlist();

    void deleteById(Integer id);



    void addStudent(Student student);

}
