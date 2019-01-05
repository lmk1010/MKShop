package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TbUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);
}