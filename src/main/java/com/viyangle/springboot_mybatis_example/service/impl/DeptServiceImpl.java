package com.viyangle.springboot_mybatis_example.service.impl;

import com.viyangle.springboot_mybatis_example.mapper.DeptMapper;
import com.viyangle.springboot_mybatis_example.pojo.Dept;
import com.viyangle.springboot_mybatis_example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    public void delete(Integer id) {
        deptMapper.delete(id);
    }
}
