package com.helloworld.springboot.requestParam;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class UserDataVo {
    @NotEmpty(message="qq不能为空！")
    private String qq;

    @NotEmpty(message="名称不能为空！")
    private String name;

    @NotEmpty(message="内容不能为空！")
    private String content;

    @NotEmpty(message="userId不能为空！")
    private String userId;

}
