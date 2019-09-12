package com.yc.story.Biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.github.pagehelper.PageHelper;
import com.yc.story.bean.StCollection;
import com.yc.story.bean.StCollectionExample;
import com.yc.story.bean.StUser;
import com.yc.story.dao.StCollectionMapper;
import com.yc.story.dao.StUserMapper;

@Service
public class CollectionBiz {

	@Resource
	private StCollectionMapper scm;
	
	@Resource
	private StUserMapper sum;
	
	//购买收藏夹书籍
	@Transactional
	public int buy(StUser su,int id,int integral){
		if(su.getIntegral()-integral<0){
			return -1;
		}else{
			//修改收藏夹购买状态
			StCollectionExample example = new StCollectionExample();
			example.createCriteria().andUIdEqualTo(su.getId()).andBIdEqualTo(id);
			StCollection sc = new StCollection();
			sc.setcStatus(1);
			scm.updateByExampleSelective(sc, example);
			
			//扣除积分
			su.setIntegral(su.getIntegral()-integral);
			sum.updateByPrimaryKeySelective(su);
			return sum.updateByPrimaryKeySelective(su);
		}
		
	}
	
	//判断该书是否被收藏
	public List<StCollection> queryOne(StUser su,int id){
		StCollectionExample sce = new StCollectionExample();
		sce.createCriteria().andUIdEqualTo(su.getId()).andBIdEqualTo(id).andCStatusEqualTo(1);
		return scm.selectByExample(sce);
	}
	
	// 查询个人收藏
	public List<StCollection> query(StUser su,int page){
		StCollectionExample sce = new StCollectionExample();
		sce.createCriteria().andUIdEqualTo(su.getId()).andCRecordEqualTo(1);
		sce.setOrderByClause("c_time desc");
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
