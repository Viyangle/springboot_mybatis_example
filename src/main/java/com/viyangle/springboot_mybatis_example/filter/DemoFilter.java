package com.viyangle.springboot_mybatis_example.filter;

import com.alibaba.fastjson.JSONObject;
import com.viyangle.springboot_mybatis_example.pojo.Result;
import com.viyangle.springboot_mybatis_example.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String url = req.getRequestURL().toString();

        if (url.contains("login")) {
            log.info("登录操作，放行");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String jwt = req.getHeader("token");

        if (jwt == null || jwt.isEmpty()){
            log.info("无token");
            Result error = Result.error("NOT_LOGIN");
            String s = JSONObject.toJSONString(error);
            res.getWriter().write(s);
            return;
        }

        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("token错误");
            Result error = Result.error("NOT_LOGIN");
            String s = JSONObject.toJSONString(error);
            res.getWriter().write(s);
            return;
        }

        log.info("令牌合法");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
