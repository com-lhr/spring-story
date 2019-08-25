package com.yc.story.Biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.story.bean.StCollection;
import com.yc.story.bean.StCollectionExample;
import com.yc.story.bean.StUser;
import com.yc.story.dao.StCollectionMapper;

@Service
public class CollectionBiz {

	@Resource
	private StCollectionMapper scm;
	
	// 查询个人收藏
	public List<StCollection> query(StUser su){
		StCollectionExample sce = new StCollectionExample();
		sce.createCriteria().andUIdEqualTo(su.getId());
		return scm.selectByExample(sce);
	}
	
}
