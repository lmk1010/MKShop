package com.nexus.front.service;

import com.nexus.common.model.ServerResponse;
import com.nexus.manager.dto.RegisterMember;

/**
 * @ClassName LoginService
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-30 14:38
 * @Version 1.0
 **/
public interface LoginService {

    /**
     *功能描述
     * @Author liumingkang
     * @Description //TODO 前台的登陆服务接口 根据loginType进行判断登陆类型 Constant类中标明了集中类型
     * @Description //
     * @Date 2019-03-21
     * @Param [username, password, loginType]
     * @Return com.nexus.common.model.ServerResponse
     */
    public ServerResponse loginMK(String loginName, String identifyCode,int loginType);



    /**
     *功能描述
     * @Author liumingkang
     * @Description //TODO 检查token的有效性的接口 返回过期时间
     * @Date 2019-03-21
     * @Param [token]
     * @Return com.nexus.common.model.ServerResponse
     */
    public ServerResponse checkToken(String token);



    /**
     *功能描述
     * @Author liumingkang
     * @Description //TODO 客户端主动刷新token的接口
     * @Date 2019-03-21
     * @Param [token]
     * @Return com.nexus.common.model.ServerResponse
     */
    public ServerResponse refreshToken(String token);



    /**
     *功能描述
     * @Author liumingkang
     * @Description //TODO 用户注销 清除redis中的token
     * @Date 2019-03-21
     * @Param [token]
     * @Return com.nexus.common.model.ServerResponse
     */
    public ServerResponse logoutMK(String token);


    /**
     *功能描述
     * @Author liumingkang
     * @Description //TODO 用户通过手机号注册 需传入RegisterToken
     * @Date 2019-03-21
     * @Param [registerMember]
     * @Return com.nexus.common.model.ServerResponse
     */
    public ServerResponse registerByPhone(RegisterMember registerMember);
    //前台忘记密码服务(验证手机号--->修改密码)

    //验证手机号发送短信,实现复用 注册和忘记密码
    public ServerResponse sendMessageCode(String phonenumber,Integer mode);
    //校验验证码的正确性
    public ServerResponse checkCodeVaild(String Verify_token,String code);
    //修改密码
    public ServerResponse forgetPass(String username,String passwordNew,String forgetToken);


}
