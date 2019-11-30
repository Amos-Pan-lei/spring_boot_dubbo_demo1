package com.qf.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.entity.StuClass;

import java.util.List;

public interface IClassService extends IService<StuClass> {
    List<StuClass> getlist();

    StuClass getClassInfo(Integer cid);

    void updateSnum(Integer cid);

    void decrease(Integer cid);
}
