package com.viyangle.springboot_mybatis_example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class SpringbootMybatisExampleApplicationTests {

    @Test
    public void testGenJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "Tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "viyangle")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("viyangle")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiVG9tIiwiaWQiOjEsImV4cCI6MTc3MDQzNzg1M30.BEVd9mP83ZZggVu8Yw3DBx5uRtDOQF1FoGgLeIakFXs")
                .getBody();
        System.out.println(claims);
    }
}
