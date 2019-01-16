package com.nexus.front.service;


import com.nexus.common.model.ServerResponse;
import com.nexus.manager.pojo.TbMember;

public interface MemberService {

    public TbMember testSelectByUsername(String username);

    public String hello(String words);

    public Integer insertMember(TbMember tbMember);

    public TbMember selectMember(long id);

    public TbMember selectMemberByName(String username);

    public Integer updateMember(TbMember tbMember);
    //前台商城的登陆服务
    public ServerResponse loginMK(String username, String password);
    //检查Token的有效性
    public ServerResponse checkToken(String token);
    //刷新token
    public ServerResponse refreshToken(String token);
    //退出登陆
    public ServerResponse logoutMK(String token);
    //注册--手机方式
    public ServerResponse registerByPhone(String register_token);
    //前台忘记密码服务(验证手机号--->修改密码)
    //验证手机号发送短信,实现复用 注册和忘记密码
    public ServerResponse sendMessageCode(String phonenumber,Integer mode);
    //校验验证码的正确性
    public ServerResponse checkCodeVaild(String Verify_token,String code);
    //修改密码
    public ServerResponse forgetPass(String username,String passwordNew,String forgetToken);



}
