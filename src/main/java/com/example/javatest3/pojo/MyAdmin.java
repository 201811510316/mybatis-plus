package com.example.javatest3.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("my_admin")
public class MyAdmin {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;

    @TableField(value="admin_name")
    private String AdminName;
    @TableField(value="admin_age")
    private Integer AdminAge=0;
    private String address;
    private String job;

    public MyAdmin() {
    }

    public MyAdmin(Integer id, String adminName, Integer adminAge, String address, String job) {
        this.id = id;
        AdminName = adminName;
        AdminAge = adminAge;
        this.address = address;
        this.job = job;
    }
}
