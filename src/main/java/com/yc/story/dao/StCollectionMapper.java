package com.yc.story.dao;

import com.yc.story.bean.StCollection;
import com.yc.story.bean.StCollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StCollectionMapper {
    long countByExample(StCollectionExample example);

    int deleteByExample(StCollectionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StCollection record);

    int insertSelective(StCollection record);

    List<StCollection> selectByExample(StCollectionExample example);

    StCollection selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StCollection record, @Param("example") StCollectionExample example);

    int updateByExample(@Param("record") StCollection record, @Param("example") StCollectionExample example);

    int updateByPrimaryKeySelective(StCollection record);

    int updateByPrimaryKey(StCollection record);
}