package com.yc.story.dao;

import com.yc.story.bean.StBook;
import com.yc.story.bean.StBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StBookMapper {
    long countByExample(StBookExample example);

    int deleteByExample(StBookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StBook record);

    int insertSelective(StBook record);

    List<StBook> selectByExample(StBookExample example);

    StBook selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StBook record, @Param("example") StBookExample example);

    int updateByExample(@Param("record") StBook record, @Param("example") StBookExample example);

    int updateByPrimaryKeySelective(StBook record);

    int updateByPrimaryKey(StBook record);

    
    List<StBook> findByCategoryAndTime(@Param("caName") String caName);

}