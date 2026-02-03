package com.viyangle.springboot_mybatis_example.mapper;

import com.viyangle.springboot_mybatis_example.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
    List<Dept> list();

    void delete(Integer id);
}
