package com.nexus.manager.service.impl;


import com.nexus.manager.mapper.TbUserMapper;
import com.nexus.manager.pojo.TbUser;
import com.nexus.manager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
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
    public TbUser select_user(Integer id) {
        return tbUserMapper.selectByPrimaryKey(id);
    }


}
