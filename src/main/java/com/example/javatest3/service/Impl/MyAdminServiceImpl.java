package com.example.javatest3.service.Impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.javatest3.Dao.MyAdminDao;
import com.example.javatest3.pojo.MyAdmin;
import com.example.javatest3.service.MyAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyAdminServiceImpl implements MyAdminService {
    @Autowired
    MyAdminDao myAdminDao;


    @Override
    public int addMyAdmin(MyAdmin myAdmin) {
        int insert = myAdminDao.insert(myAdmin);
        return insert;
    }

    @Override
    public int deleteMyAdmin(Integer id) {
        return myAdminDao.deleteById(id);
    }

    @Override
    public int updateMyAdmin(MyAdmin myAdmin) {
        return myAdminDao.update(myAdmin,null);
    }

    @Override
    public MyAdmin firstMyAdmin(Integer id) {
        QueryWrapper<MyAdmin> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        return myAdminDao.selectOne(wrapper);
    }

    @Override
    public List<MyAdmin> AllMyAdmin() {
        return myAdminDao.selectList(null);
    }

    @Override
    public MyAdmin firstMyAdminByName(String name) {
        QueryWrapper<MyAdmin> wrapper = new QueryWrapper<>();
        wrapper.eq("admin_name",name);
        return myAdminDao.selectOne(wrapper);
    }
}
