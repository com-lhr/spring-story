package com.yc.story.dao;

import com.yc.story.bean.StRecommendation;
import com.yc.story.bean.StRecommendationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StRecommendationMapper {
    long countByExample(StRecommendationExample example);

    int deleteByExample(StRecommendationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StRecommendation record);

    int insertSelective(StRecommendation record);

    List<StRecommendation> selectByExample(StRecommendationExample example);

    StRecommendation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StRecommendation record, @Param("example") StRecommendationExample example);

    int updateByExample(@Param("record") StRecommendation record, @Param("example") StRecommendationExample example);

    int updateByPrimaryKeySelective(StRecommendation record);

    int updateByPrimaryKey(StRecommendation record);
}