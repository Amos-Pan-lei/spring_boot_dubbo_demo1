package com.qf.serviceImpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.dao.StuMapper;
import com.qf.entity.StuClass;
import com.qf.entity.Student;
import com.qf.service.IClassService;
import com.qf.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Author Amos
 * Creat Time 2019 11 29
 */
@Service
public class StuServiceImpl extends ServiceImpl<StuMapper,Student> implements IStuService {

    @Reference
    private IClassService classService;

    @Autowired
    StuMapper stuMapper;

    @Override
    public List<Student> getlist() {
        List<Student> studentList = stuMapper.selectList(null);
        for (Student student : studentList) {
            StuClass stuClass = classService.getClassInfo(student.getCid());
            student.setCls(stuClass);
        }


        return studentList;
    }

    @Override
    public void deleteById(Integer id) {
        stuMapper.deleteById(id);
    }

    @Override
    public void addStudent(Student student) {
        stuMapper.insert(student);
        classService.updateSnum(student.getCid());
    }

}
