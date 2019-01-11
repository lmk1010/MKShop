package com.nexus.manager.controller;


import com.nexus.manager.pojo.TbUser;
import com.nexus.manager.service.DemoService;
import com.nexus.manager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
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

    @Autowired
    private DemoService demoService;

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
        return demoService.hello("hello springmvc");
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

        Subject subject = SecurityUtils.getSubject();

        String passMD5 = DigestUtils.md5DigestAsHex(password.getBytes());

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,passMD5);

        try{
            subject.login(usernamePasswordToken);
            result.put("登陆成功", 200);
        }catch (UnauthenticatedException e){
            result.put("密码错误",401);
        }catch (UnknownAccountException e){
            result.put("未知账户",402);
        }catch (Exception e){
            result.put("认证失败",403);
        }

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
