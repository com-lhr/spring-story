package com.yc.story.Biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.story.bean.StComment;
import com.yc.story.bean.StCommentExample;
import com.yc.story.dao.StCommentMapper;

@Service
public class CommentBiz {
	
	@Resource
	private StCommentMapper scm;
	
	
	public List<StComment> findCommentByBid(Integer id){
		StCommentExample sce = new StCommentExample();
		sce.createCriteria().andBIdEqualTo(id);
		sce.setOrderByClause("cm_createtime desc");
		return scm.selectByExample(sce);
	}


}
