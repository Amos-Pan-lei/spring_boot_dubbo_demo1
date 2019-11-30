package com.qf.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.ClassMapper;
import com.qf.entity.StuClass;
import com.qf.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Author Amos
 * Creat Time 2019 11 29
 */
@Service
public class ClassServiceImpl implements IClassService {
    @Autowired
    private ClassMapper classMapper;

    @Override
    public List<StuClass> getlist() {
        List<StuClass> classList = classMapper.selectList(null);
        return classList;
    }

    @Override
    public StuClass getClassInfo(Integer cid) {

        StuClass stuClass = classMapper.selectById(cid);
        return stuClass;
    }

    @Override
    public void updateSnum(Integer cid) {
        StuClass stuClass = classMapper.selectById(cid);
        stuClass.setCnum(stuClass.getCnum()+1);
        classMapper.updateById(stuClass);
    }
}
