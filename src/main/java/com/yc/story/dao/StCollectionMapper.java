package com.yc.story.dao;

import com.yc.story.bean.StCollection;
import com.yc.story.bean.StCollectionExample;
import com.yc.story.bean.StUser;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StCollectionMapper {
	
	//查询已收藏的书籍
	List<Object> selectByUid(Integer uid);
	
	//查询收藏过的书籍
	List<Object> selectAllByUid(Integer uid);
	
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