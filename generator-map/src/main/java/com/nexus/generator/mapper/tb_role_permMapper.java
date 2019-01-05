package com.nexus.generator.mapper;

import com.nexus.generator.pojo.tb_role_perm;

public interface tb_role_permMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(tb_role_perm record);

    int insertSelective(tb_role_perm record);

    tb_role_perm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(tb_role_perm record);

    int updateByPrimaryKey(tb_role_perm record);
}