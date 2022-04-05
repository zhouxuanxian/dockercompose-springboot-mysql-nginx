package com.helloworld.springboot.requestParam;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@Data
public class UserVo {

    @NotEmpty(message="用户名不能为空！")
    private String userName;

    @Size(min=6,max=10,message = "密码长度必须6到10位")
    private String password;

}
