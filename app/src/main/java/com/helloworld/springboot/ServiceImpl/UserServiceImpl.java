package com.helloworld.springboot.ServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.helloworld.springboot.bean.User;
import com.helloworld.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl {

    @Autowired
    UserMapper userMapper;
    //查询全部
    public List<User> queryAll() {
        return userMapper.selectList(null);
    }

    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    public User login(String userName, String password) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("user_name", userName);
        userQueryWrapper.eq("password", password);
        return userMapper.selectOne(userQueryWrapper);
    }

}