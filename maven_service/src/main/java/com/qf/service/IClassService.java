package com.qf.service;

import com.qf.entity.StuClass;

import java.util.List;

public interface IClassService {
    List<StuClass> getlist();

    StuClass getClassInfo(Integer cid);

}
