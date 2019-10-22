package com.firstMaven.dao;

import com.firstMaven.pojo.Mapping401;
import com.firstMaven.pojo.Mapping401Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Mapping401Mapper {
    long countByExample(Mapping401Example example);

    int deleteByExample(Mapping401Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mapping401 record);

    int insertSelective(Mapping401 record);

    List<Mapping401> selectByExample(Mapping401Example example);

    Mapping401 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mapping401 record, @Param("example") Mapping401Example example);

    int updateByExample(@Param("record") Mapping401 record, @Param("example") Mapping401Example example);

    int updateByPrimaryKeySelective(Mapping401 record);

    int updateByPrimaryKey(Mapping401 record);
}