package com.nexus.manager.service;


import com.nexus.common.model.ServerResponse;
import com.nexus.manager.pojo.TbUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface UserService {

    public Integer insert_user(TbUser tbUser);

    public TbUser select_user(long id);

    public TbUser selectUserByName(String username);

    public Integer updateUser(TbUser tbUser);

    public Set<String> findAllRoles(String username);

    public Set<String> findAllPermissions(String username);

}
