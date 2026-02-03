package com.viyangle.springboot_mybatis_example.service;

import com.viyangle.springboot_mybatis_example.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> list();

    void delete(Integer id);
}
