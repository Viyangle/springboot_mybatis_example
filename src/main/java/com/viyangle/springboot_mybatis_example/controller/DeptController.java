package com.viyangle.springboot_mybatis_example.controller;

import com.viyangle.springboot_mybatis_example.pojo.Dept;
import com.viyangle.springboot_mybatis_example.pojo.Result;
import com.viyangle.springboot_mybatis_example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询全部部门信息
     * @return result
     */
    @GetMapping
    public Result list(){
        log.info("查询全部部门信息");

        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除部门信息：{}", id);

        deptService.delete(id);

        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门信息：{}", dept.getName());

        deptService.add(dept);

        return Result.success();
    }
}
