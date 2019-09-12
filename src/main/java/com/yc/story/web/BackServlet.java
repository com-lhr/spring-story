package com.yc.story.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yc.story.Biz.CategoryBiz;

@Controller
public class BackServlet {
	@GetMapping("touser1")		
	public String touser1() {
		return "back/user1";
	}	
	@GetMapping("user_tail")
	public String user_tail() {
		return "back/user_tail";
	}
	
	@GetMapping("user_password")
	public String user_password() {
		return "back/user_password";
	}	
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
	@GetMapping("toanalysis")
	public String toanalysis(){
		return "back/analysis";
	}
	
	@GetMapping("tohome")
	public String tohome(){
		return "back/home";
	}
/*	
	@GetMapping("toAddBookRecommend")
	public String toAddBookRecommend(Model model){
		return "back/AddBookRecommend";
	}*/
}
