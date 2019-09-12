package com.yc.story.dao;

import com.yc.story.bean.StCategory;
import com.yc.story.bean.StCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StCategoryMapper {
    long countByExample(StCategoryExample example);

    int deleteByExample(StCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StCategory record);

    int insertSelective(StCategory record);

    List<StCategory> selectByExample(StCategoryExample example);

    StCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StCategory record, @Param("example") StCategoryExample example);

    int updateByExample(@Param("record") StCategory record, @Param("example") StCategoryExample example);

    int updateByPrimaryKeySelective(StCategory record);

    int updateByPrimaryKey(StCategory record);
}