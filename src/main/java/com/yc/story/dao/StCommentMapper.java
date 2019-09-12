package com.yc.story.dao;

import com.yc.story.bean.StComment;
import com.yc.story.bean.StCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StCommentMapper {
    long countByExample(StCommentExample example);

    int deleteByExample(StCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StComment record);

    int insertSelective(StComment record);

    List<StComment> selectByExample(StCommentExample example);

    StComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StComment record, @Param("example") StCommentExample example);

    int updateByExample(@Param("record") StComment record, @Param("example") StCommentExample example);

    int updateByPrimaryKeySelective(StComment record);

    int updateByPrimaryKey(StComment record);
}