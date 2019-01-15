package com.nexus.manager.service.impl;


import com.nexus.common.cache.TokenCache;
import com.nexus.common.model.ResponseCode;
import com.nexus.common.model.ServerResponse;
import com.nexus.common.utils.MessageUtil;
import com.nexus.common.utils.RandomUtil;
import com.nexus.manager.mapper.TbUserMapper;
import com.nexus.manager.pojo.TbUser;
import com.nexus.manager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Service("userService")
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper tbUserMapper;

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



}
