package com.yc.story.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yc.story.Biz.CategoryBiz;

@Controller
public class BackServlet {
	
	@Resource 
	private CategoryBiz cbiz;
	@GetMapping("toback")
	public String toback(){
		return "back/index";
	}
	
	@GetMapping("toorder")
	public String toorder(){
		return "back/order";
	}
	
	@GetMapping("togoods")
	public String togoods(){
		return "back/goods";
	}
	
	@GetMapping("tolog")
	public String tolog(){
		return "back/log";
	}
	
	@GetMapping("toadd")
	public String toadd(){
		return "back/log_add";
	}
	
	@GetMapping("toupload")
	public String toupload(){
		return "back/storyupload";
	}
	@GetMapping("toBookRecommend")
	public String toBookRecommend(Model model){
		model.addAttribute("categorys", cbiz.allRedisCategory());
		return "back/bookRecommend";
	}
/*	
	@GetMapping("toAddBookRecommend")
	public String toAddBookRecommend(Model model){
		return "back/AddBookRecommend";
	}*/
}
