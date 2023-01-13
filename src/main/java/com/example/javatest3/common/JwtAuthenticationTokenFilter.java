package com.example.javatest3.common;

import com.example.javatest3.annotation.JwtUserLogin;
import com.example.javatest3.annotation.PassToken;
import com.example.javatest3.pojo.MyAdmin;
import com.example.javatest3.service.MyAdminService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class JwtAuthenticationTokenFilter implements HandlerInterceptor {

    @Autowired
    MyAdminService myAdminService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if(method.isAnnotationPresent(PassToken.class)){
            PassToken passToken = method.getAnnotation(PassToken.class);
            if(passToken.required()){
                return true;
            }
        }

        if(method.isAnnotationPresent(JwtUserLogin.class)){
            JwtUserLogin jwtUserLogin = method.getAnnotation(JwtUserLogin.class);
            if(jwtUserLogin.required()){
                //判断
                if(token==null){
                    throw new RuntimeException("没有token，请重新登录");
                }
                String username;
                try {
                    Claims claims = Token.parseJWT(token);
                    username=claims.getAudience();
                } catch (Exception e) {
                    throw new RuntimeException("401");
                }

                MyAdmin admin = myAdminService.firstMyAdminByName(username);
                if(admin==null){
                    throw new RuntimeException("用户不存在");
                }
                return true;
            }
        }
        return true;
    }
}
