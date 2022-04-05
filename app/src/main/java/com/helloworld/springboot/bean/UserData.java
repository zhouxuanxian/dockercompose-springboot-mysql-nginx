package com.helloworld.springboot.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@TableName(value = "UserData")//指定表名
public class UserData {
    @TableId(value = "id", type = IdType.AUTO)//指定自增策略
    private Integer id;

    private Integer userId;

    private String qq;

    private String name;

    private String content;

    private String publicKey;

    private String privateKey;

    private String encrytedData;

    @TableField( fill = FieldFill.INSERT)
    private Date createdAt;
}