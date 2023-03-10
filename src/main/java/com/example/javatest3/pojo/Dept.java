package com.example.javatest3.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("dept")
public class Dept {

    @TableId(value = "deptno",type = IdType.AUTO)
    private Integer deptNo;

    @TableField(value="dname")
    private String dName;

    @TableField(value = "db_source")
    private String dbSource;
}
