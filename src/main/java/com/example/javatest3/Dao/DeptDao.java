package com.example.javatest3.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.javatest3.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptDao extends BaseMapper<Dept> {


}
