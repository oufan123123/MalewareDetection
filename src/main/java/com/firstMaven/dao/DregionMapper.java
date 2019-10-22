package com.firstMaven.dao;

import com.firstMaven.pojo.Dregion;
import com.firstMaven.pojo.DregionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DregionMapper {
    long countByExample(DregionExample example);

    int deleteByExample(DregionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dregion record);

    int insertSelective(Dregion record);

    List<Dregion> selectByExample(DregionExample example);

    Dregion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dregion record, @Param("example") DregionExample example);

    int updateByExample(@Param("record") Dregion record, @Param("example") DregionExample example);

    int updateByPrimaryKeySelective(Dregion record);

    int updateByPrimaryKey(Dregion record);
}