package com.example.javatest3.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.RandomUtil;
import com.example.javatest3.annotation.JwtUserLogin;
import com.example.javatest3.common.Token;
import com.example.javatest3.common.response;
import com.example.javatest3.pojo.MyAdmin;
import com.example.javatest3.service.MyAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.MapUtils;

import java.util.Map;

@RestController
public class loginController {

    @Autowired
    MyAdminService myAdminService;

    @GetMapping("/login")
    public response login(@RequestBody Map<String,Object> map){
        String name = MapUtil.getStr(map, "name");
        String password = MapUtil.getStr(map, "password");
        MyAdmin admin = myAdminService.firstMyAdminByName(name);
        if(admin==null){
            return response.fail("用户不存在");
        }
        if(!password.equals(admin.getPassword())){
            return response.fail("密码错误");
        }
        String uuid = RandomUtil.randomString(6);
        String token = Token.setToken(admin, null, uuid);
        return response.success(token);
    }

    @JwtUserLogin
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }

    @GetMapping("/ok")
    public String ok(){
        return "测试springboot已准备就绪";
    }

}
