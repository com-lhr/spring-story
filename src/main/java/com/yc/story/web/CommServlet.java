package com.yc.story.web;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.yc.story.Biz.BizException;
import com.yc.story.Biz.CommentBiz;
import com.yc.story.bean.StComment;
import com.yc.story.bean.StUser;
import com.yc.story.vo.Result;

@Controller
public class CommServlet {
	
	@Resource
	private CommentBiz cobiz;
	
	//对评论进行提交
	@PostMapping("comment")
	@ResponseBody
	public Result Comment(@Valid StComment comm,Errors errors,@SessionAttribute(name="loginedUser",required=false) StUser user) {
		
		comm.setuId(user.getId());
		
		comm.setUser(user);
		
		comm.setCmCreatetime(new Date());
		
		if(errors.hasErrors()) {
			return new Result(-1,"评论失败",errors.getAllErrors());
		}
		
		try {
			cobiz.Comment(comm);
			return new Result(1,"评论成功",comm);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new Result(0,"业务繁忙，请稍后再试");
		}
		
	}
	
	//对回复进行提交
		@PostMapping("reply")
		@ResponseBody
		public Result reply(@Valid StComment comm,Errors errors,@SessionAttribute(name="loginedUser",required=false) StUser user,Integer otherCommid) {
			
			comm.setuId(user.getId());
			
			comm.setUser(user);			
			
			comm.setCmCreatetime(new Date());
			
			if(errors.hasErrors()) {
				return new Result(-1,"评论失败",errors.getAllErrors());
			}			
			try {
				//返回上一级的评论
				StComment maincomment = cobiz.comment(comm, otherCommid);
				maincomment.setNextuser(user);
				return new Result(1,"回复成功",maincomment);
			}catch(RuntimeException e) {
				e.printStackTrace();
				return new Result(0,"业务繁忙，请稍后再试");
			}
			
		}
	
	
}
