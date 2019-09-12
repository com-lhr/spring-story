package com.yc.story.Biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.story.bean.StGoods;
import com.yc.story.bean.StGoodsExample;
import com.yc.story.dao.StGoodsMapper;

@Service
public class GoodsBiz {

	@Resource
	private StGoodsMapper sgm;
	
	// 查询商品
	public List<StGoods> query(){
		StGoodsExample age = new StGoodsExample();
		age.setOrderByClause("g_desc desc");
		return sgm.selectByExample(age);
	}
	// 添加商品
	public int add(StGoods sg){
		return sgm.insertSelective(sg);
	}
	
}

