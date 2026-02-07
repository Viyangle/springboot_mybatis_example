package com.viyangle.springboot_mybatis_example.controller;

import com.viyangle.springboot_mybatis_example.pojo.Emp;
import com.viyangle.springboot_mybatis_example.pojo.Result;
import com.viyangle.springboot_mybatis_example.service.EmpService;
import com.viyangle.springboot_mybatis_example.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登录:{}", emp);
        Emp e = empService.login(emp);

        if (e != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("name", e.getName());
            claims.put("username", e.getUsername());

            return Result.success(JwtUtils.generateJwt(claims));
        }

        return Result.error("用户名或密码错误");
    }
}
