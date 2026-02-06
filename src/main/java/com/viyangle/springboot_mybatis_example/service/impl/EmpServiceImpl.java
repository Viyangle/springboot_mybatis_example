package com.viyangle.springboot_mybatis_example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.viyangle.springboot_mybatis_example.mapper.EmpMapper;
import com.viyangle.springboot_mybatis_example.pojo.Emp;
import com.viyangle.springboot_mybatis_example.pojo.PageBean;
import com.viyangle.springboot_mybatis_example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize) {
//        Long count = empMapper.count();
//
//        Integer start = (page - 1) * pageSize;
//        List<Emp> empList = empMapper.page(start, pageSize);
        PageHelper.startPage(page, pageSize);

        List<Emp> empList = empMapper.list();
        Page<Emp> p = (Page<Emp>) empList;

        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }
}
