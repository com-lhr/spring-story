package com.yc.story.dao;

import com.yc.story.bean.StOrder;
import com.yc.story.bean.StOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StOrderMapper {
    long countByExample(StOrderExample example);

    int deleteByExample(StOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StOrder record);

    int insertSelective(StOrder record);

    int insertMyOrder(StOrder record);
    
    List<StOrder> selectByExample(StOrderExample example);

    StOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StOrder record, @Param("example") StOrderExample example);

    int updateByExample(@Param("record") StOrder record, @Param("example") StOrderExample example);

    int updateByPrimaryKeySelective(StOrder record);

    int updateByPrimaryKey(StOrder record);
}