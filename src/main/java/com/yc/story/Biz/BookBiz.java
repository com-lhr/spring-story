package com.yc.story.Biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yc.story.bean.StBook;
import com.yc.story.bean.StBookExample;
import com.yc.story.bean.StRecommendation;
import com.yc.story.bean.StRecommendationExample;
import com.yc.story.dao.StBookMapper;
import com.yc.story.dao.StRecommendationMapper;

@Service
public class BookBiz {

	@Resource
	private StBookMapper bookMapper;
	
	@Resource
	private StRecommendationMapper recommendationMapper;
	//查出最新上架的小说
	public List<StBook> newbook(){
		StBookExample bookExample = new StBookExample();
		bookExample.setOrderByClause("b_time desc");
		PageHelper.startPage(1, 10);
		return bookMapper.selectByExample(bookExample);
	}
	
	//根据类别和时间排序找出十本小说
	public List<StBook> findByCategoryAndTime(Integer bCategory){
		StBookExample bookExample = new StBookExample();
		bookExample.createCriteria().andBCategoryEqualTo(bCategory);
		bookExample.setOrderByClause("b_time desc");
		PageHelper.startPage(1,10);
		return bookMapper.selectByExample(bookExample);
	}
	
	/*public List<StBook> findByCateforyAndOrderbReadCnt(Integer bCategory){
		StBookExample bookExample = new StBookExample();
		
	}*/
	
	//根据id一本书的详情
	public StBook findDetail(Integer id){	
		return bookMapper.selectByPrimaryKey(id);		
	}
	
	//编者推荐
	public List<StRecommendation> findRecommendation(){
		StRecommendationExample example = new StRecommendationExample();
		example.setOrderByClause("recomTime desc");
		PageHelper.startPage(1,10);
		return recommendationMapper.selectByExample(example);
	}
}
