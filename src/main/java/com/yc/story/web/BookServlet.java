package com.yc.story.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.story.Biz.BookBiz;
import com.yc.story.Biz.CategoryBiz;
import com.yc.story.Biz.CommentBiz;
import com.yc.story.bean.StCategory;

@Controller
public class BookServlet {
	
	@Resource
	private CategoryBiz cbiz;
	@Resource
	private BookBiz bbiz;

	
	@Resource
	private CommentBiz cobiz;

	
	@ModelAttribute("cList")
	public List<StCategory> init(){
		return cbiz.allCategory();
	}
	
	@RequestMapping("artCategory")
	public String ArticleCategory(Model model,String id,@RequestParam(defaultValue="1")int page) {
		//分类页面右边的新书上架功能 根据该类别和时间排序找出十本小说
		Integer aid = Integer.valueOf(id);
		model.addAttribute("category_pagebooks", bbiz.findByCategory(aid, page));
		model.addAttribute("category_newbooks", bbiz.findByCategoryAndTime(aid));
		return "index_article";
	}
	
	
	@RequestMapping("detail")
	public String Detail(Integer id,Model model) {
		model.addAttribute("detailBook", bbiz.findDetail(id));

		model.addAttribute("comments", cobiz.findCommentByBid(id));
		

		return "detail";
	}
	
	@RequestMapping("pagecount")
	@ResponseBody
	public String pageCount(int id) {
		int count = 1;
		if(bbiz.bookcount(id) > 25) {
		count = bbiz.bookcount(id)%25==0 ? bbiz.bookcount(id)/25 :
				(bbiz.bookcount(id)%25) + 1;
		}				
		return count+"";
	}
	

}
