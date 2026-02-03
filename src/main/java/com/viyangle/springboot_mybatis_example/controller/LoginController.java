package com.viyangle.springboot_mybatis_example.controller;

import com.viyangle.springboot_mybatis_example.pojo.Emp;
import com.viyangle.springboot_mybatis_example.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登录:{}", emp);
        return Result.success();
    }
}
