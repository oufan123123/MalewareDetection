package com.firstMaven.dao;

import com.firstMaven.pojo.SenApiType;
import com.firstMaven.pojo.SenApiTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SenApiTypeMapper {
    long countByExample(SenApiTypeExample example);

    int deleteByExample(SenApiTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SenApiType record);

    int insertSelective(SenApiType record);

    List<SenApiType> selectByExample(SenApiTypeExample example);

    SenApiType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SenApiType record, @Param("example") SenApiTypeExample example);

    int updateByExample(@Param("record") SenApiType record, @Param("example") SenApiTypeExample example);

    int updateByPrimaryKeySelective(SenApiType record);

    int updateByPrimaryKey(SenApiType record);
}