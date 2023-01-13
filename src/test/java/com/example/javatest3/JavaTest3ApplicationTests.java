package com.example.javatest3;

import com.example.javatest3.pojo.MyAdmin;
import com.example.javatest3.service.MyAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JavaTest3ApplicationTests {

    @Autowired
    MyAdminService myAdminService;

    @Test
    void contextLoads() {
        List<MyAdmin> myAdmins = myAdminService.AllMyAdmin();
        if(myAdmins.isEmpty()){
            System.out.println("表中没有数据");
        }else{
            for(MyAdmin admin:myAdmins){
                System.out.println(admin);
            }
        }
    }

    @Test
    public void test1(){
        MyAdmin admin = new MyAdmin(1,"admin",5,"北京","yy","159");
        int i = myAdminService.addMyAdmin(admin);
        if(i>0){
            MyAdmin admin1 = myAdminService.firstMyAdmin(1);
            System.out.println(admin1);
        }else{
            System.out.println("失败");
        }
    }

    @Test
    public void test2(){
        MyAdmin admin = myAdminService.firstMyAdmin(1);
        admin.setJob("游泳");
        int i = myAdminService.updateMyAdmin(admin);
        if(i>0){
            MyAdmin admin1 = myAdminService.firstMyAdmin(1);
            System.out.println(admin1);
        }else{
            System.out.println("失败");
        }
    }

    @Test
    public void test3(){
        MyAdmin admin = myAdminService.firstMyAdmin(1);
        System.out.println(admin);
    }

}
