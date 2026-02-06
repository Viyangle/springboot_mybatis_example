package com.viyangle.springboot_mybatis_example.mapper;

import com.viyangle.springboot_mybatis_example.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {

    Long count();

    List<Emp> page(Integer start, Integer pageSize);

    List<Emp> list();

    void delete(List<Integer> ids);

    void insert(Emp emp);

    Emp getById(Integer id);

    void update(Emp emp);
}
