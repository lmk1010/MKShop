package com.nexus.manager.service.impl;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.nexus.common.cache.TokenCache;
import com.nexus.common.jedis.JedisOperater;
import com.nexus.common.model.Constant;
import com.nexus.common.model.ResponseCode;
import com.nexus.common.model.ServerResponse;
import com.nexus.common.utils.MessageUtil;
import com.nexus.common.utils.RandomUtil;
import com.nexus.manager.mapper.TbRoleMapper;
import com.nexus.manager.mapper.TbUserMapper;
import com.nexus.manager.mapper.TbUserRoleMapper;
import com.nexus.manager.pojo.TbRole;
import com.nexus.manager.pojo.TbUser;
import com.nexus.manager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;


import java.util.*;


@Service("userService")
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Autowired
    private JedisOperater jedisOperater;

    @Override
    public Integer insert_user(TbUser tbUser) {
        return tbUserMapper.insert(tbUser);
    }

    @Override
    public TbUser select_user(long id) {
        return tbUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public TbUser selectUserByName(String username) {
        return tbUserMapper.selectByUserName(username);
    }

    @Override
    public Integer updateUser(TbUser tbUser) {
        return tbUserMapper.updateByPrimaryKeySelective(tbUser);
    }

    @Override
    public Set<String> findAllRoles(String username) {
        Set<String> roleSet = Sets.newHashSet();
        if (jedisOperater.exists(Constant.ROLES_KEY+username)){
            String permissionJson = jedisOperater.get(Constant.ROLES_KEY+username);
            roleSet = (Set<String>) JSON.parseObject(permissionJson);
        }else{
            roleSet = tbUserMapper.selectAllRoles(username);
            jedisOperater.set(Constant.ROLES_KEY+username, JSON.toJSONString(roleSet));
            jedisOperater.expire(Constant.ROLES_KEY+username, Constant.SESSION_EXPIRE);
        }
        return roleSet;
    }

    @Override
    public Set<String> findAllPermissions(String username) {
        Set<String> permissionSet = Sets.newHashSet();
        if (jedisOperater.exists(Constant.PERMISSION_KEY+username)){
            String permissionJson = jedisOperater.get(Constant.PERMISSION_KEY+username);
            permissionSet = (Set<String>) JSON.parseObject(permissionJson);
        }else{
            permissionSet = tbUserMapper.selectAllPermission(username);
            jedisOperater.set(Constant.PERMISSION_KEY+username, JSON.toJSONString(permissionSet));
            jedisOperater.expire(Constant.PERMISSION_KEY+username, Constant.SESSION_EXPIRE);
        }
        return permissionSet;
    }



}
