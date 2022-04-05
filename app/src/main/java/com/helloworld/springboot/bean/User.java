package com.helloworld.springboot.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName(value = "User")//指定表名
public class User {
    @TableId(value = "id", type = IdType.AUTO)//指定自增策略
    private Integer id;
    private String userName;
    private String password;
}