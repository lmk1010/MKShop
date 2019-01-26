package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbCategory;
import org.apache.ibatis.annotations.Param;

public interface TbCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbCategory record);

    int insertSelective(TbCategory record);

    TbCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbCategory record);

    int updateByPrimaryKey(TbCategory record);

    //通过子类ID找到父类ID
    long selectParentId(@Param("categoryId") long categoryId);
}