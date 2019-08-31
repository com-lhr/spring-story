package com.yc.story.Biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.github.pagehelper.PageHelper;
import com.yc.story.bean.StCollection;
import com.yc.story.bean.StCollectionExample;
import com.yc.story.bean.StUser;
import com.yc.story.dao.StCollectionMapper;

@Service
public class CollectionBiz {

	@Resource
	private StCollectionMapper scm;
	
	// 查询个人收藏
	public List<StCollection> query(@SessionAttribute(name="loginedUser",required=false) StUser su,int page){
		StCollectionExample sce = new StCollectionExample();
		sce.createCriteria().andUIdEqualTo(su.getId()).andCRecordEqualTo(1);
		PageHelper.startPage(page,5);
		return scm.selectByExample(sce);
	}
	
	// 查询收藏数量
	public int queryAll(@SessionAttribute(name="loginedUser",required=false) StUser su){
		int i;
		StCollectionExample sce = new StCollectionExample();
		sce.createCriteria().andUIdEqualTo(su.getId()).andCRecordEqualTo(1);
		if((int) scm.countByExample(sce)%5==0){
			i = (int) scm.countByExample(sce)/5;
		}else{
			i = (int) scm.countByExample(sce)/5 + 1;
		}
		return i;
	}
	
	//取消全部收藏书籍
	public int del(@SessionAttribute(name="loginedUser",required=false) StUser su){
		StCollectionExample sce = new StCollectionExample();
		sce.createCriteria().andUIdEqualTo(su.getId());
		StCollection sc = new StCollection();
		sc.setcRecord(0);
		
		return scm.updateByExampleSelective(sc, sce);
	}
	//取消收藏书籍
	public int del(@SessionAttribute(name="loginedUser",required=false) StUser su,int bid){
		StCollectionExample sce = new StCollectionExample();
		if(bid==0){
			sce.createCriteria().andUIdEqualTo(su.getId());
		}else{
			sce.createCriteria().andUIdEqualTo(su.getId()).andBIdEqualTo(bid);
		}
		
		
		StCollection sc = new StCollection();
		sc.setcRecord(0);
		return scm.updateByExampleSelective(sc, sce);
	}
}
