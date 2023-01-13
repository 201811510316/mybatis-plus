package com.example.javatest3.service;



import com.example.javatest3.pojo.MyAdmin;

import java.util.List;

public interface MyAdminService {

    //增
    int addMyAdmin(MyAdmin myAdmin);

    //删
    int deleteMyAdmin(Integer id);

    //改
    int updateMyAdmin(MyAdmin myAdmin);

    //查
    MyAdmin firstMyAdmin(Integer id);

    //查
    List<MyAdmin> AllMyAdmin();

    //
    MyAdmin firstMyAdminByName(String name);
}
