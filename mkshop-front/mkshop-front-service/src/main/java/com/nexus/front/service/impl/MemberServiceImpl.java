package com.nexus.front.service.impl;

import com.alibaba.fastjson.JSON;
import com.nexus.common.cache.TokenCache;
import com.nexus.common.jedis.JedisOperater;
import com.nexus.common.model.Constant;
import com.nexus.common.model.ResponseCode;
import com.nexus.common.model.ServerResponse;
import com.nexus.common.utils.JWTUtils;
import com.nexus.common.utils.MessageUtil;
import com.nexus.common.utils.RandomUtil;
import com.nexus.front.service.MemberService;
import com.nexus.manager.dto.MemberDto;
import com.nexus.manager.dto.RegisterMember;
import com.nexus.manager.mapper.TbMemberMapper;
import com.nexus.manager.pojo.TbMember;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import sun.tools.jstat.Token;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName MemberServiceImpl
 * @Description TODO 对于jedis的exception 要单独写类捕获
 * @Author liumingkang
 * @Date 2019-01-15 09:46
 * @Version 1.0
 **/
@Service("memberService")
@Transactional
@Slf4j
@Log4j
public class MemberServiceImpl  implements MemberService {

    @Autowired
    private TbMemberMapper tbMemberMapper;

    @Autowired
    private JedisOperater jedisOperater;

    @Override
    public TbMember testSelectByUsername(String username){
        return null;
    }

    @Override
    public String hello(String words) {

        return words+" 此消息代表dubbo服务正常";
    }

    @Override
    public Integer insertMember(TbMember tbMember) {

        return tbMemberMapper.insert(tbMember);
    }

    @Override
    public TbMember selectMember(long id) {

        return tbMemberMapper.selectByPrimaryKey(id);
    }

    @Override
    public TbMember selectMemberByName(String username) {

        return tbMemberMapper.selectByUsername(username);
    }

    @Override
    public Integer updateMember(TbMember tbMember) {

        return tbMemberMapper.updateByPrimaryKeySelective(tbMember);
    }

    @Override
    public Integer deleteMember(long id) {
        return tbMemberMapper.deleteByPrimaryKey(id);
    }


    @Override
    public Integer changePwd(long id, String passwordNew) {
        String MD5Pwd = DigestUtils.md5DigestAsHex(passwordNew.getBytes());
        TbMember tbMember = tbMemberMapper.selectByPrimaryKey(id);
        if (tbMember==null){
            return 0;
        }
        //设置新密码
        tbMember.setPassword(MD5Pwd);
        //更新用户所修改的
        int updateStatus = tbMemberMapper.updateByPrimaryKeySelective(tbMember);

        return updateStatus;
    }




}
