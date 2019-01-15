package com.nexus.manager.controller;


import com.nexus.common.model.ServerResponse;
import com.nexus.manager.pojo.TbUser;
import com.nexus.manager.service.DemoService;
import com.nexus.manager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.zookeeper.data.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/mkshop/manager/user/")
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
    public ServerResponse toLogin(@RequestParam("username") String username,
                                  @RequestParam("password") String password,
                                  HttpSession session){
        //从安全管理器拿到subject
        Subject subject = SecurityUtils.getSubject();
        //对密码进行MD5加密
        String passMD5 = DigestUtils.md5DigestAsHex(password.getBytes());
        //创建token
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,passMD5);
        //进行登陆
        try{
            subject.login(usernamePasswordToken);
            return ServerResponse.createBySuccessMsg("登陆成功");
        }catch (UnauthenticatedException e){
            return ServerResponse.createByErrorMsg("密码错误");
        }catch (UnknownAccountException e){
            return ServerResponse.createByErrorMsg("账户不存在");
        }catch (Exception e){
            e.printStackTrace();
            return ServerResponse.createByErrorMsg("认证失败");
        }
    }

    @RequestMapping(value = "logout",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Integer> toLogout(HttpSession session){
        Map<String,Integer> result = new HashMap<>();
        session.invalidate();
        result.put("注销成功", 200);
        return result;
    }

    @RequestMapping(value = "shirologout",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Integer> toShiroLogout(){
        Map<String,Integer> result = new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        result.put("注销成功", 200);
        return result;
    }

    @RequestMapping(value = "getOnlineStatus",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> getStatus(HttpServletRequest request){
        Map<String,String> result = new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        Session session1 = subject.getSession();
        result.put("sessionid", session1.getId().toString());
        boolean authenticated = subject.isAuthenticated();
        if (authenticated==true){
            result.put("loginStatus", "已登陆");
        }else{
            result.put("loginStatus", "未登陆");
        }
        return result;
    }




}
