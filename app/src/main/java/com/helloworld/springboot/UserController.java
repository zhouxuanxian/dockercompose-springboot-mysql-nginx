package com.helloworld.springboot;


import com.helloworld.springboot.ServiceImpl.UserServiceImpl;
import com.helloworld.springboot.bean.User;
import com.helloworld.springboot.requestParam.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/userList")
    public ModelAndView userList(ModelAndView modelAndView){
        modelAndView.addObject("userId", 1);
        modelAndView.setViewName("dataList");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(ModelAndView modelAndView, @Valid UserVo userVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            modelAndView.addObject("error", bindingResult.getFieldError().getDefaultMessage());
            modelAndView.setViewName("login");
            return modelAndView;
        }
        String userName = userVo.getUserName();
        String password = userVo.getPassword();

        User user = userService.login(userName, password);

        if(user == null) {
            modelAndView.addObject("error","账号或者密码错误！");
            modelAndView.setViewName("login");
            return modelAndView;
        }

        modelAndView.addObject("userId", user.getId());
        modelAndView.setViewName("dataList");
        return modelAndView;

    }

}
