package com.yc.story.web;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yc.story.Biz.BookBiz;
import com.yc.story.Biz.CategoryBiz;
import com.yc.story.Biz.UserBiz;
import com.yc.story.bean.StCategory;

@Controller
public class IndexServlet {
	
	@Resource
	private CategoryBiz cbiz;
	@Resource
	private BookBiz bbiz;
	@Resource 
	private UserBiz ubiz;
	@ModelAttribute("cList")
	public List<StCategory> init(){
		return cbiz.allCategory();
	}
	
	
	
	@RequestMapping("toindex")
	public String toIndex(Model model) {
		//编者推荐推荐
		model.addAttribute("recommendationList",bbiz.findRedisRecommendation());
		
		model.addAttribute("authorList", ubiz.redisFindAuthor());
		//首页的最新上架功能 根据时间排序找出最新的十本小说
		model.addAttribute("newbook", bbiz.newbook());
		return "index";
	}
	@RequestMapping("authorDetail")
	public String toAuthorDetail(String name,int id,Model model) {
		model.addAttribute("author", bbiz.findAuthor(id));
		model.addAttribute("bookofauthor", bbiz.findBookByAuthor(name));
		return "authordetail";		
	}
	

}
