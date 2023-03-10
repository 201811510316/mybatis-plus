package com.example.javatest3;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.example.javatest3.pojo.MyAdmin;
import com.example.javatest3.service.MyAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

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

    @Test
    public void test5(){
        //2018-02-18 20:53:45
        DateTime parse = DateUtil.parse("2024/12/29 00:00:00");
        System.out.println(parse);


        List<String> str = new ArrayList<>();
        str.add("aaa");
        if(CollectionUtil.isNotEmpty(str)){
            System.out.println("不为空");
        }else{
            System.out.println("为空");
        }

    }


    @Test
    public void test6(){
        Date date = new Date();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.WEEK_OF_YEAR,-6);
        Date time = calendar.getTime();
        System.out.println(time.toLocaleString());
    }

    @Test
    public void test7(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR)+"年");
        System.out.println(calendar.get(Calendar.MONTH)+"月");
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH)+"日（这月）");
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR)+"日（这年）");
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)+"日（这周）");
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH)+"这月第几周");
        calendar.add(Calendar.YEAR,+2);
        System.out.println(calendar.getTime());

    }

    @Test
    public void test8(){
        Date date = new Date();
        long time = date.getTime();

        System.out.println(time);
    }

}
