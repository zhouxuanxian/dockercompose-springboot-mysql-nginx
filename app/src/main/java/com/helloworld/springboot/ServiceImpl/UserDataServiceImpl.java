package com.helloworld.springboot.ServiceImpl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.helloworld.springboot.bean.UserData;
import com.helloworld.springboot.mapper.UserDataMapper;
import com.helloworld.springboot.requestParam.ListVo;
import com.helloworld.springboot.requestParam.UserDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserDataServiceImpl {

    @Autowired
    UserDataMapper userDataMapper;

    RSAEncrypt rsaEncrypt;

    public int insertOne(UserDataVo userDataVo) throws Exception {

        String mapJson = JSON.toJSONString(userDataVo);
        rsaEncrypt.genKeyPair();

        //加密字符串
        System.out.println("随机生成的公钥为:" + rsaEncrypt.keyMap.get(0));
        System.out.println("随机生成的私钥为:" + rsaEncrypt.keyMap.get(1));
        String messageEn = rsaEncrypt.encrypt(mapJson, rsaEncrypt.keyMap.get(0));
        System.out.println(mapJson + "\t加密后的字符串为:" + messageEn);
//        String messageDe = rsaEncrypt.decrypt(messageEn,rsaEncrypt.keyMap.get(1));
//        System.out.println("还原后的字符串为:" + messageDe);

        UserData userData = UserData.builder()
                .qq(userDataVo.getQq())
                .name(userDataVo.getName())
                .content(userDataVo.getContent())
                .userId(Integer.parseInt(userDataVo.getUserId()))
                .publicKey(rsaEncrypt.keyMap.get(0))
                .privateKey(rsaEncrypt.keyMap.get(1))
                .encrytedData(messageEn).build();

        return userDataMapper.insert(userData);
    }

    public Map<String, Object> queryAll(ListVo listVo) {


        QueryWrapper<UserData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", listVo.getUserId());

        Map<String, Object> map = new HashMap<String, Object>();
        List<UserData> userDataList = userDataMapper.selectList(queryWrapper);

        int total = userDataMapper.selectCount(queryWrapper);
        map.put("rows", userDataList);
        map.put("total", total);

        return  map;
    }

    public void deleteOne(Integer id) {
        userDataMapper.deleteById(id);
    }

}