package com.yc.story.dao;

import com.yc.story.bean.StCc;
import com.yc.story.bean.StCcExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StCcMapper {
    long countByExample(StCcExample example);

    int deleteByExample(StCcExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StCc record);

    int insertSelective(StCc record);

    List<StCc> selectByExample(StCcExample example);

    StCc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StCc record, @Param("example") StCcExample example);

    int updateByExample(@Param("record") StCc record, @Param("example") StCcExample example);

    int updateByPrimaryKeySelective(StCc record);

    int updateByPrimaryKey(StCc record);
}