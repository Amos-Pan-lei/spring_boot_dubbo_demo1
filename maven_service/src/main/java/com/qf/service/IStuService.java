package com.qf.service;

import com.qf.entity.Student;

import java.util.List;

public interface IStuService {
    List<Student> getlist();

    void deleteById(Integer id);

    void addStudent(Student student);
}
