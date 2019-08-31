package com.yc.story.Biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.story.bean.StGoods;
import com.yc.story.dao.StGoodsMapper;

@Service
public class GoodsBiz {

	@Resource
	private StGoodsMapper sgm;
	
	public List<StGoods> query(){
		return sgm.selectByExample(null);
	}
	
}

