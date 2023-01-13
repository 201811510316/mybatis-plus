package com.example.javatest3.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Collection;

@Data
@TableName("my_admin")
public class MyAdmin{
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;

    @TableField(value="admin_name")
    private String adminName;
    @TableField(value="admin_age")
    private Integer adminAge=0;
    private String address;
    private String job;
    private String password;

    public MyAdmin() {
    }

    public MyAdmin(Integer id, String adminName, Integer adminAge, String address, String job, String password) {
        this.id = id;
        this.adminName = adminName;
        this.adminAge = adminAge;
        this.address = address;
        this.job = job;
        this.password=password;
    }
}
