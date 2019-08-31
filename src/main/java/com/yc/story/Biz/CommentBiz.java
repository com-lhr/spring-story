package com.yc.story.Biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestMapping;

import com.yc.story.bean.StBook;
import com.yc.story.bean.StComment;
import com.yc.story.bean.StCommentExample;
import com.yc.story.dao.StBookMapper;
import com.yc.story.dao.StCommentMapper;

@Service
public class CommentBiz {
	
	@Resource
	private StCommentMapper scm;
	
	@Resource
	private StBookMapper sbm;
	
	//根具书的id查找相关评论
	public List<StComment> findCommentByBid(Integer id){
		StCommentExample sce = new StCommentExample();
		sce.createCriteria().andBIdEqualTo(id);
		sce.setOrderByClause("cm_createtime desc");
		return scm.selectByExample(sce);
	}
	
	//提交评论并对相应书的评论数进行加一
	public StComment Comment(StComment stcomm) {
		scm.insertSelective(stcomm);
		
		StBook book = sbm.selectByPrimaryKey(stcomm.getbId());
		book.setbCommcount((book.getbCommcount() == null ? 0 : book.getbCommcount())+1);
		
		sbm.updateByPrimaryKey(book);
		return stcomm;
	}

}