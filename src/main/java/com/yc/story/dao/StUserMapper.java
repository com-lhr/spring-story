package com.yc.story.dao;

import com.yc.story.bean.StUser;
import com.yc.story.bean.StUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StUserMapper {
    long countByExample(StUserExample example);

    int deleteByExample(StUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StUser record);

    int insertSelective(StUser record);

    List<StUser> selectByExample(StUserExample example);

    StUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StUser record, @Param("example") StUserExample example);

    int updateByExample(@Param("record") StUser record, @Param("example") StUserExample example);

    int updateByPrimaryKeySelective(StUser record);

    int updateByPrimaryKey(StUser record);
}