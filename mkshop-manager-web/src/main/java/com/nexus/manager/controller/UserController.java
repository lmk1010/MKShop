package com.nexus.manager.controller;


import com.nexus.manager.pojo.TbUser;
import com.nexus.manager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user/")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *功能描述
     * @Author liumingkang
     * @Description //TODO
     * @Date 2019-01-07
     * @Param []
     * @Return java.lang.String
     */
    @RequestMapping(value = "getdemo",method = RequestMethod.GET)
    @ResponseBody
    public String getDemo(){
        return "hello springMVC";
    }

    /**
     *功能描述
     * @Author liumingkang
     * @Description //TODO 登陆测试demo类
     * @Date 2019-01-08
     * @Param [username, password]
     * @Return java.util.Map<java.lang.String,java.lang.Integer>
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Integer> toLogin(@RequestParam("username") String username,
                                       @RequestParam("password") String password,
                                       HttpSession session){
        Map<String,Integer> result = new HashMap<>();
        String auth = "lmk";
        String pass = "1010";

        TbUser tbUser = userService.selectUserByName(username);
        result.put("成功", 200);
        /*
        if (!username.equals(auth)){
            result.put("无此用户", 301);
        }

        if (!password.equals(password)){
            result.put("密码错误",302);
        }else{
            result.put("登陆成功", 200);
            session.setAttribute("currentUser", username);
        }*/
        return result;

    }

    @RequestMapping(value = "logout",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Integer> toLogout(HttpSession session){
        Map<String,Integer> result = new HashMap<>();
        session.invalidate();
        result.put("注销成功", 200);
        return result;
    }


}
