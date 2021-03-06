package com.nexus.front.service.impl;

import com.alibaba.fastjson.JSON;
import com.nexus.common.cache.TokenCache;
import com.nexus.common.jedis.JedisOperater;
import com.nexus.common.model.Constant;
import com.nexus.common.model.ResponseCode;
import com.nexus.common.model.ServerResponse;
import com.nexus.common.utils.MessageUtil;
import com.nexus.common.utils.RandomUtil;
import com.nexus.front.service.LoginService;
import com.nexus.manager.dto.MemberDto;
import com.nexus.manager.dto.RegisterMember;
import com.nexus.manager.mapper.TbMemberMapper;
import com.nexus.manager.pojo.TbMember;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName LoginServiceImpl
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-30 14:39
 * @Version 1.0
 **/
@Service("loginService")
@Transactional
@Log4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private TbMemberMapper tbMemberMapper;

    @Autowired
    private JedisOperater jedisOperater;


    @Override
    public ServerResponse loginMK(String username, String password) {

        if (username==null){
            return ServerResponse.createByErrorCode("参数错误", ResponseCode.ILLEGA_ARGUMENT.getCode());
        }
        TbMember loginMember = tbMemberMapper.selectByUsername(username);
        if (loginMember==null){
            return ServerResponse.createByErrorMsg("无此用户");
        }
        String MD5Pass = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!loginMember.getPassword().equals(MD5Pass)){
            return ServerResponse.createByErrorMsg("密码错误");
        }
        MemberDto memberDto = ConvertMember(loginMember);
        String token = UUID.randomUUID().toString();
        //设置token
        memberDto.setToken(token);
        //将token缓存到redis中
        jedisOperater.set(Constant.TOKEN_PREFIX+token, JSON.toJSONString(memberDto));
        //设置token过期时间
        jedisOperater.expire(Constant.TOKEN_PREFIX+token, Constant.TOKEN_EXPIRE);
        //返回给客户端token及用户信息
        return ServerResponse.createBySuccess(memberDto, "登陆成功");
    }

    @Override
    public ServerResponse checkToken(String token) {
        //token未过期 延长消失时间
        if (jedisOperater.exists(Constant.TOKEN_PREFIX+token)){
            jedisOperater.expire(Constant.TOKEN_PREFIX+token, Constant.TOKEN_EXPIRE);
            return ServerResponse.createBySuccessMsg("token未过期");
        }
        //token过期
        return ServerResponse.createByErrorCode("token过期,需要重新登陆", ResponseCode.NEED_LOGIN.getCode());
    }

    @Override
    public ServerResponse refreshToken(String token) {
        //强制刷新token
        String jsonMember = jedisOperater.get(token);
        if(jsonMember.isEmpty()||jsonMember==null){
            return ServerResponse.createByErrorCode("token过期,需要重新登陆", ResponseCode.NEED_LOGIN.getCode());
        }
        MemberDto memberDto = (MemberDto) JSON.parse(jsonMember);
        String newToken = UUID.randomUUID().toString();
        memberDto.setToken(newToken);
        //todo 先删除key 在set 为了避免get到第一次的缓存 目前还没找到直接修改value 两次读写 效率有所低
        jedisOperater.del(Constant.TOKEN_PREFIX+token);
        jedisOperater.set(Constant.TOKEN_PREFIX+newToken,JSON.toJSONString(memberDto));
        jedisOperater.expire(Constant.TOKEN_PREFIX+newToken, Constant.TOKEN_EXPIRE);
        return ServerResponse.createBySuccess(memberDto, "成功刷新token");
    }

    @Override
    public ServerResponse logoutMK(String token) {
        jedisOperater.del(Constant.TOKEN_PREFIX + token);
        return ServerResponse.createBySuccessMsg("已退出");
    }

    @Override
    public ServerResponse registerByPhone(RegisterMember registerMember) {
        if (registerMember==null){
            return ServerResponse.createByErrorMsg("参数错误");
        }
        if (StringUtils.isBlank(registerMember.getRegisterToken())){
            return ServerResponse.createByErrorMsg("Token无效!");
        }
        String registerToken = TokenCache.getKey(TokenCache.TOKEN_PREFIX);
        if (registerToken==null){
            return ServerResponse.createByErrorMsg("Token过期,请重新刷新页面");
        }
        if (!StringUtils.equals(registerToken,registerMember.getRegisterToken())){
            return ServerResponse.createByErrorMsg("Token不符合");
        }
        TbMember tbMember = this.ConvertFromRegister(registerMember);
        int insertStatus = tbMemberMapper.insert(tbMember);
        if (insertStatus==0){
            return ServerResponse.createByErrorMsg("用户信息增加失败");
        }
        return ServerResponse.createBySuccessMsg("用户增加成功");
    }

    @Override
    public ServerResponse sendMessageCode(String phonenumber,Integer mode) {
        // todo mode为判断为修改密码还是忘记密码 后期进行重构 减少代码 增加复用
        if (mode.equals(Constant.SendSMSMode.FORGET_MODE.getCode())){
            //生成6为验证码
            String RandomCode = RandomUtil.getRandom();
            if (phonenumber==null||phonenumber.isEmpty()){
                return ServerResponse.createByErrorCode("参数错误", ResponseCode.ILLEGA_ARGUMENT.getCode());
            }
            TbMember byPhone = tbMemberMapper.selectByPhone(phonenumber);
            if (byPhone==null){
                return ServerResponse.createByErrorCode("此手机号未注册", ResponseCode.NO_USER.getCode());
            }
            Integer result = MessageUtil.mobileQuery(phonenumber, RandomCode,MessageUtil.M_FORGET_ID);
            if (result!=200){
                return ServerResponse.createByErrorCode("发送失败", ResponseCode.ERROR.getCode());
            }
            String token = UUID.randomUUID()+phonenumber;
            //发送成功 缓存验证码token
            TokenCache.setKey(token, RandomCode);
            System.err.println("usersevice"+token);
            return ServerResponse.createBySuccess(token,"发送成功");
        }
        if (mode.equals(Constant.SendSMSMode.REGISTER_MODE.getCode())){
            Map<String,String> res = new HashMap<>();
            TbMember tbMember = tbMemberMapper.selectByPhone(phonenumber);
            if (tbMember!=null){
                return ServerResponse.createByErrorCode(ResponseCode.EXIST_USER.getStatus(),
                        ResponseCode.EXIST_USER.getCode());
            }
            if(checkPhoneFormatVaild(phonenumber)!=1){
                return ServerResponse.createByErrorMsg("手机号不合法");
            }
            String messageCode = RandomUtil.getRandom();
            Integer result = MessageUtil.mobileQuery(phonenumber, messageCode, MessageUtil.M_REGISTER_ID);
            if (result!=200){
                return ServerResponse.createByErrorMsg("发送失败!请稍后再试");
            }
            //缓存验证码
            String codeKey = UUID.randomUUID().toString()+phonenumber;
            //guavacache缓存时间设置为1分钟
            TokenCache.setKey(codeKey, messageCode);
            //将key发给前端 前端带token来验证验证码的正确
            res.put(Constant.CODE_TAG,codeKey);
            return ServerResponse.createBySuccess(res, "发送成功");
        }

        return ServerResponse.createByErrorMsg("参数错误！");
    }

    @Override
    public ServerResponse checkCodeVaild(String Verify_token, String code) {
        Map<String,String> returnMap = new HashMap<>();
        //从guavacache里读取验证码
        String randomCacheCode = TokenCache.getKey(Verify_token);
        if (randomCacheCode==null){
            return ServerResponse.createByErrorMsg("token无效或者过期");
        }
        if (!StringUtils.equals(randomCacheCode,code)){
            return ServerResponse.createByErrorMsg("验证码错误");
        }
        //清除验证码的缓存
        TokenCache.remove(Verify_token);
        //设置❤新的token 用于修改密码
        String forgetToken = UUID.randomUUID().toString();
        TokenCache.setKey(TokenCache.TOKEN_PREFIX, forgetToken);
        returnMap.put("Token", forgetToken);
        return ServerResponse.createBySuccess(returnMap,"验证成功！");
    }

    @Override
    public ServerResponse forgetPass(String username, String passwordNew, String forgetToken) {
        if (username==null||forgetToken==null){
            return ServerResponse.createByErrorCode("参数错误", ResponseCode.ILLEGA_ARGUMENT.getCode());
        }
        String cacheToken = TokenCache.getKey(TokenCache.TOKEN_PREFIX);
        if (cacheToken==null||cacheToken.isEmpty()){
            return ServerResponse.createByErrorMsg("token无效或者过期");
        }
        if (!StringUtils.equals(cacheToken, forgetToken)){
            return ServerResponse.createByErrorMsg("token不匹配");
        }
        TbMember forgetMember = tbMemberMapper.selectByUsername(username);
        if (forgetMember==null){
            return ServerResponse.createByErrorCode("无法找到此用户",ResponseCode.NO_USER.getCode());
        }
        forgetMember.setPassword(DigestUtils.md5DigestAsHex(passwordNew.getBytes()));
        int result = tbMemberMapper.updateByPrimaryKeySelective(forgetMember);
        return (result==1)?ServerResponse.createBySuccessMsg("修改密码成功"):ServerResponse.createByErrorCode("修改密码失败", ResponseCode.ERROR.getCode());
    }

    /*
     *功能描述
     * @Author liumingkang
     * @Description //TODO 将pojo转换为dto给前端
     * @Date 2019-01-15
     * @Param [tbMember]
     * @Return com.nexus.manager.dto.MemberDto
     */
    private MemberDto ConvertMember(TbMember tbMember){

        MemberDto memberDto = new MemberDto();

        memberDto.setId(tbMember.getId());
        memberDto.setUsername(tbMember.getUsername());
        memberDto.setNickname(tbMember.getNickname());
        memberDto.setPhonenumber(tbMember.getPhonenumber());
        memberDto.setDescription(tbMember.getDescription());
        memberDto.setAddress(tbMember.getAddress());
        memberDto.setImgurl(tbMember.getImgurl());
        memberDto.setSex(tbMember.getSex());

        return memberDto;
    }

    private Map<String,Object> ConvertMap(TbMember tbMember){
        Map<String,Object> member = new HashMap<>();

        member.put("id", tbMember.getId());
        member.put("username", tbMember.getUsername());
        member.put("nickname", tbMember.getNickname());
        member.put("phonenumber", tbMember.getPhonenumber());
        member.put("description", tbMember.getDescription());
        member.put("address", tbMember.getAddress());
        member.put("imgurl", tbMember.getImgurl());
        member.put("sex", tbMember.getSex());

        return member;

    }
    /*
     *功能描述
     * @Author liumingkang
     * @Description //TODO 注册页面的model转换为Tbmember
     * @Date 2019-01-27
     * @Param [registerMember]
     * @Return com.nexus.manager.pojo.TbMember
     */
    private TbMember ConvertFromRegister(RegisterMember registerMember){

        TbMember tbMember = new TbMember();

        tbMember.setUsername(registerMember.getUsername());
        //MD5加密
        tbMember.setPassword(DigestUtils.md5DigestAsHex(registerMember.getPassword().getBytes()));
        tbMember.setNickname(registerMember.getNickname());
        tbMember.setEmail(registerMember.getEmail());
        tbMember.setPhonenumber(registerMember.getPhonenumber());
        tbMember.setSex(registerMember.getSex());
        tbMember.setAddress(registerMember.getAddress());
        tbMember.setDescription(registerMember.getDescription());
        tbMember.setImgurl(registerMember.getImgurl());

        return tbMember;
    }


    /**
     *功能描述
     * @Author liumingkang
     * @Description //TODO检验手机号的有效性 18905526118
     * @Date 2019-01-15
     * @Param []
     * @Return java.lang.Integer
     */
    private Integer checkPhoneFormatVaild(String phonenumber){
        if (phonenumber.length()!=11){
            return 0;
        }
        return 1;
    }

}
