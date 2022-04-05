package com.helloworld.springboot;

import com.helloworld.springboot.ServiceImpl.UserDataServiceImpl;
import com.helloworld.springboot.requestParam.ListVo;
import com.helloworld.springboot.requestParam.UserDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class UserDataController {

    @Autowired
    UserDataServiceImpl userDateService;

    @PostMapping("/userData")
    public void create(@Valid UserDataVo userDataVo) throws Exception {
        userDateService.insertOne(userDataVo);
    }

    @GetMapping("/userData/list")
    public Map<String, Object> list(@Valid ListVo listVo) {

        System.out.println(listVo.toString());

        Map<String, Object> result = userDateService.queryAll(listVo);

        return result;
    }

    @RequestMapping(value="/userData/{id}", method= RequestMethod.DELETE)
    public String deleteUserData(@PathVariable Integer id) {

        userDateService.deleteOne(id);

        return "success";
    }

}
