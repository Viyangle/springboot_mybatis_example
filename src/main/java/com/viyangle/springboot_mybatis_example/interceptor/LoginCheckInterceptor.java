package com.viyangle.springboot_mybatis_example.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.viyangle.springboot_mybatis_example.pojo.Result;
import com.viyangle.springboot_mybatis_example.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
//        String url = req.getRequestURL().toString();
//
//        if (url.contains("login")) {
//            log.info("登录操作，放行");
//            return true;
//        }

        String jwt = req.getHeader("token");

        if (jwt == null || jwt.isEmpty()){
            log.info("无token");
            Result error = Result.error("NOT_LOGIN");
            String s = JSONObject.toJSONString(error);
            res.getWriter().write(s);
            return false;
        }

        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("token错误");
            Result error = Result.error("NOT_LOGIN");
            String s = JSONObject.toJSONString(error);
            res.getWriter().write(s);
            return true;
        }

        log.info("令牌合法");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("complete");
    }
}
