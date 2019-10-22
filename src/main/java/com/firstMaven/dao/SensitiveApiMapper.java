package com.firstMaven.dao;

import com.firstMaven.pojo.SensitiveApi;
import com.firstMaven.pojo.SensitiveApiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SensitiveApiMapper {
    long countByExample(SensitiveApiExample example);

    int deleteByExample(SensitiveApiExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SensitiveApi record);

    int insertSelective(SensitiveApi record);

    List<SensitiveApi> selectSenApiId(String content);

    List<SensitiveApi> selectByExample(SensitiveApiExample example);

    SensitiveApi selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SensitiveApi record, @Param("example") SensitiveApiExample example);

    int updateByExample(@Param("record") SensitiveApi record, @Param("example") SensitiveApiExample example);

    int updateByPrimaryKeySelective(SensitiveApi record);

    int updateByPrimaryKey(SensitiveApi record);
}