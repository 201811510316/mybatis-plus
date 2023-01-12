package com.example.javatest3.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.example.javatest3.pojo.MyAdmin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyAdminDao extends BaseMapper<MyAdmin> {

}
