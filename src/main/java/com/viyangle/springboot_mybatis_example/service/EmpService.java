package com.viyangle.springboot_mybatis_example.service;

import com.viyangle.springboot_mybatis_example.pojo.Emp;
import com.viyangle.springboot_mybatis_example.pojo.PageBean;

import java.util.List;

public interface EmpService {
    PageBean page(Integer page, Integer pageSize);

    void delete(List<Integer> ids);

    void save(Emp emp);

    Emp getById(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}
