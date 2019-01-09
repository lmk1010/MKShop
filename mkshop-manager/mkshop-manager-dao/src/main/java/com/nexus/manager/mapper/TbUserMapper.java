package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface TbUserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);

    /** 自定义**/
    TbUser selectByUserName(@Param("username") String username);
}