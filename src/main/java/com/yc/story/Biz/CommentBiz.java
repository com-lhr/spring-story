package com.yc.story.Biz;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestMapping;

import com.yc.story.bean.StBook;
import com.yc.story.bean.StCc;
import com.yc.story.bean.StComment;
import com.yc.story.bean.StCommentExample;
import com.yc.story.dao.StBookMapper;
import com.yc.story.dao.StCcMapper;
import com.yc.story.dao.StCommentMapper;

@Service
public class CommentBiz {
	
	@Resource
	private StCommentMapper scm;
	
	@Resource StCcMapper sccm;
	
	@Resource
	private StBookMapper sbm;
	
	//根具书的id查找相关评论
	public List<StComment> findCommentByBid(Integer id){
		StCommentExample sce = new StCommentExample();
		sce.createCriteria().andBIdEqualTo(id);
		sce.setOrderByClause("cm_createtime desc");
		return scm.selectByExample(sce);
	}
	
	//根据评论id查找该条评论
	public StComment findOneComment(Integer id) {
		return scm.selectByPrimaryKey(id);
	}
	
	//提交评论并对相应书的评论数进行加一
	public StComment Comment(StComment stcomm) {
		scm.insertSelective(stcomm);
		
		StBook book = sbm.selectByPrimaryKey(stcomm.getbId());
		book.setbCommcount((book.getbCommcount() == null ? 0 : book.getbCommcount())+1);
		
		sbm.updateByPrimaryKey(book);
		return stcomm;
	}
	
	//回复对一条评论进行回复并对相应书的评论数进行加一
	public StComment comment(StComment comm,Integer miancommid) {
		scm.insertSelective(comm);
		
		StCc cc = new StCc();
		cc.setMyCommid(miancommid);
		cc.setOtherCommid(comm.getId());
		
		//创建一个中间信息
		sccm.insert(cc);
		
		List<StComment> sList = new ArrayList<StComment>();
		StComment miancomment = scm.selectByPrimaryKey(miancommid);
		sList.add(comm);
		miancomment.setsList(sList);
		
		
		StBook book = sbm.selectByPrimaryKey(comm.getbId());
		book.setbCommcount((book.getbCommcount() == null ? 0 : book.getbCommcount())+1);
		
		sbm.updateByPrimaryKey(book);
		return miancomment;
	}
	

}