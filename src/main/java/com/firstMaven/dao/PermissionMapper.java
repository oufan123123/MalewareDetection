package com.firstMaven.dao;

import com.firstMaven.pojo.Permission;
import com.firstMaven.pojo.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper {
    long countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(String name);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectPermissionAndMapping401(String apiContent);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}