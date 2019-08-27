package com.yc.story.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.yc.story.Biz.CommentBiz;
import com.yc.story.bean.StComment;

@Controller
public class CommServlet {
	
	@Resource
	private CommentBiz cbiz;
	
//	public List<StComment> findBookComments(){
//		
//	}

}
