package com.helloworld.springboot.requestParam;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class ListVo {

    @NotEmpty(message="请登录！")
    private String userId;

    private String offset;

    private String limit;
}
