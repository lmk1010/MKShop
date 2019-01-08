package com.nexus.manager.service;


import com.nexus.manager.pojo.TbUser;

import java.util.ArrayList;
import java.util.List;

public interface UserService {

    public Integer insert_user(TbUser tbUser);

    public TbUser select_user(Integer id);

    public TbUser selectUserByName(String username);

}
