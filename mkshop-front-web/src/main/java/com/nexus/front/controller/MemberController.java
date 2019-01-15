package com.nexus.front.controller;

import com.nexus.common.cache.TokenCache;
import com.nexus.common.model.Constant;
import com.nexus.common.model.ResponseCode;
import com.nexus.common.model.ServerResponse;
import com.nexus.common.utils.RandomUtil;
import com.nexus.front.service.MemberService;
import com.nexus.manager.pojo.TbMember;
import com.nexus.manager.pojo.TbUser;
import com.nexus.manager.service.DemoService;
import com.nexus.manager.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.server.SessionTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.tools.jstat.Token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.UUID;

/**
 * @ClassName UseController
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-14 15:41
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/member/")
@Api(value = "前台用户接口",description = "前台用户登录，注册，修改用户信息")
public class UseController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET",value = "测试demo",
            produces = "application/json;charset=UTF-8",notes = "测试接口demo 同时测试dubbo服务是否正常")
    public String hello(){
        return "hjellp "+memberService.hello("lmk");
    }


    @RequestMapping(value = "login",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "GET",value = "用户登录",
            produces = "application/json;charset=UTF-8",notes = "对于用户登录进行验证")
    public ServerResponse toLogin(@RequestParam("username") String username,
                                  @RequestParam("password") String password,
                                  HttpServletRequest request){
        if (username==null||username.equals("")||username.isEmpty()){
            return ServerResponse.createByErrorCode("参数错误", ResponseCode.ILLEGA_ARGUMENT.getCode());
        }
        ServerResponse serverResponse = memberService.loginMK(username, password);
        if(serverResponse.isSuccess()){
            HttpSession session = request.getSession();
            session.setAttribute(Constant.CURRENT_USER,serverResponse.getData());
        }
        return serverResponse;
    }


    @RequestMapping(value = "send_code",method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST",value = "发送验证码",
            produces = "application/json;charset=UTF-8",notes = "用于忘记密码之前的手机验证")
    public ServerResponse toVaildPhoneNumber(@RequestParam("phonenumber") String phonenumber){
        //给该手机发送验证码
        ServerResponse serverResponse =
                memberService.checkPhoneVaild(phonenumber);
        return serverResponse;
    }

    @RequestMapping(value = "vaild_code",method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST",value = "验证手机验证码",
            produces = "application/json;charset=UTF-8",notes = "用于忘记密码之前的用户输入的验证码")
    public ServerResponse toVaildCode(@RequestParam("token") String token,
                                      @RequestParam("Code") String code){
       return memberService.checkCodeVaild(token, code);
    }




    @RequestMapping(value = "forget_password",method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST",value = "测试demo",
            produces = "application/json;charset=UTF-8",notes = "用于忘记密码 使用手机验证码进行验证修改密码")
    public ServerResponse toForgetPassword(@RequestParam("username") String username,
                                   @RequestParam("passwordNew") String passwordNew,
                                   @RequestParam("forgetToken") String forgetToken){
        return memberService.forgetPass(username, passwordNew, forgetToken);
    }


    @RequestMapping(value = "checkSession",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "GET",value = "检查session",
            produces = "application/json;charset=UTF-8",notes = "测试接口demo 同时测试dubbo服务是否正常")
    public String checkSession(HttpSession session){
        TbMember tbMember = (TbMember) session.getAttribute(Constant.CURRENT_USER);
        if(tbMember==null){
            return "用户不存在";
        }
        return  "已登陆 sessionid="+session.getId();
    }






}
