package com.nexus.front.controller;

import com.nexus.common.model.ResponseCode;
import com.nexus.common.model.ServerResponse;
import com.nexus.front.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-25 08:57
 * @Version 1.0
 **/
@RestController
@Api(value = "登陆",description = "登陆、注册")
@RequestMapping("/api/access/")
public class LoginController {

    @Autowired
    private MemberService memberService;


    @RequestMapping(value = "login",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "用户登录",
            produces = "application/json;charset=UTF-8",notes = "对于用户登录进行验证")
    public ServerResponse toLogin(@RequestParam("username") String username,
                                  @RequestParam("password") String password,
                                  HttpServletRequest request){
        if (username==null||username.equals("")||username.isEmpty()){
            return ServerResponse.createByErrorCode("参数错误", ResponseCode.ILLEGA_ARGUMENT.getCode());
        }
        ServerResponse serverResponse = memberService.loginMK(username, password);

        return serverResponse;
    }

    @RequestMapping(value = "refresh_token",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "刷新token",
            produces = "application/json;charset=UTF-8",notes = "刷新token")
    public ServerResponse refreshToken(HttpServletRequest request,
                                       @RequestParam("token") String token){

        return memberService.refreshToken(token);
    }

    @RequestMapping(value = "check_token",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "检查token是否存活",
            produces = "application/json;charset=UTF-8",notes = "检测token是否存活")
    public ServerResponse checkToken(HttpServletRequest request,
                                     @RequestParam("token") String token){

        return memberService.checkToken(token);
    }

    @RequestMapping(value = "logout",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "退出登陆",
            produces = "application/json;charset=UTF-8",notes = "退出登陆，销毁token")
    public ServerResponse logout(HttpServletRequest request,
                                 @RequestParam("token") String token){
        return memberService.logoutMK(token);
    }

    @RequestMapping(value = "register_phone",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "注册新用户-手机方式",
            produces = "application/json;charset=UTF-8",notes = "注册用户-手机方式")
    public ServerResponse registerByPhone(HttpServletRequest request,
                                          @RequestParam("register_token") String register_token){
        //todo 完善注册流程
        return null;
    }

    @RequestMapping(value = "send_code",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "发送验证码",
            produces = "application/json;charset=UTF-8",notes = "用于忘记密码之前的手机验证和注册 101忘记密码 102注册")
    public ServerResponse toVaildPhoneNumber(@RequestParam("phonenumber") String phonenumber,
                                             @RequestParam("s_mode") Integer s_mode){
        ServerResponse serverResponse;
        serverResponse = memberService.sendMessageCode(phonenumber,s_mode);
        return serverResponse;
    }

    @RequestMapping(value = "vaild_code",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "验证手机验证码",
            produces = "application/json;charset=UTF-8",notes = "用于忘记密码之前的用户输入的验证码")
    public ServerResponse toVaildCode(@RequestParam("Verify_token") String Verify_token,
                                      @RequestParam("Code") String code){
        return memberService.checkCodeVaild(Verify_token, code);
    }


    @RequestMapping(value = "forget_password",method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST",value = "修改密码",
            produces = "application/json;charset=UTF-8",notes = "用于忘记密码 使用手机验证码进行验证修改密码")
    public ServerResponse toForgetPassword(@RequestParam("username") String username,
                                           @RequestParam("passwordNew") String passwordNew,
                                           @RequestParam("forgetToken") String forgetToken){
        return memberService.forgetPass(username, passwordNew, forgetToken);
    }



}
